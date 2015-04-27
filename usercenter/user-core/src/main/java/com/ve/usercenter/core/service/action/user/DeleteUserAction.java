package com.ve.usercenter.core.service.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ve.usercenter.common.action.ActionEnum;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.constant.ResponseCode;
import com.ve.usercenter.common.dto.UserAuthInfoDTO;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.ConsigneeManager;
import com.ve.usercenter.core.manager.SupplierExtraInfoManager;
import com.ve.usercenter.core.manager.UserAuthInfoManager;
import com.ve.usercenter.core.manager.UserBabyInfoManager;
import com.ve.usercenter.core.manager.UserExtraInfoManage;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.service.RequestContext;
import com.ve.usercenter.core.service.UserRequest;
import com.ve.usercenter.core.service.action.TransAction;

/**
 * 逻辑删除用户:改删除不用户不能恢复，因此要删除该用户相关联的其他表内的所有记录， 要慎重操作
 * */
@Service
public class DeleteUserAction extends TransAction {

	@Resource
	private UserManager userManager;

	@Resource
	private SupplierExtraInfoManager supplierExtraManager;

	@Resource
	private UserBabyInfoManager userBabyInfoManager;

	@Resource
	private ConsigneeManager consigneeManager;

	@Resource
	private UserAuthInfoManager userAuthInfoManager;

	@Resource
	private UserExtraInfoManage userExtraInfoManage;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ActionEnum.DELETE_USER.getActionName();
	}

	@Override
	protected UserResponse doTransaction(RequestContext context)
			throws UserException {

		// TODO Auto-generated method stub

		UserRequest request = context.getRequest();
		Long userId = (Long) request.getParam("userId");

		// 根据用户id，获取用户
		UserDTO userDto = userManager.getUserById(userId);

		if (null == userDto) {
			throw new UserException(ResponseCode.B_SELECT_ERROR,
					"user not exist");
		}

		// 如果用户为卖家，则逻辑删除卖家的扩展信息
		if (userDto.getRole() == 2) {

			int result = supplierExtraManager
					.delSupplierExtraInfoByUserId(userId);
		}

		// 逻辑删除指定用户买家账号的扩展信息
		int result = userExtraInfoManage.delUserExtraInfoByUserId(userId);

		// 逻辑删除指定用户的baby的信息
		int babyCount = userBabyInfoManager.getBabyCountByUserId(userId);
		if (babyCount > 0) {
			// 如果被删除的宝宝数和宝宝总数不相同，则删除失败
			if (babyCount != userBabyInfoManager.deleteUserAllBaby(userId)) {
				throw new UserException(ResponseCode.B_DELETE_ERROR,
						"delete userBaby error");
			}
		}

		// 删除指定用户的收货地址信息
		int consigneeCount = consigneeManager.getConsigneeCountByUserId(userId);
		if (consigneeCount > 0) {
			// 如果被删除的收货地址数和收货地址总数不相同，则删除失败
			if (consigneeCount != consigneeManager.deleteUserConsignee(userId)) {
				throw new UserException(ResponseCode.B_DELETE_ERROR,
						"delete configneeInfo error");
			}
		}

		// 删除用户的实名认证消息,存在则逻辑删除
		UserAuthInfoDTO userAuthInfoDto = userAuthInfoManager
				.getAuthInfoByUserId(userId);
		if (userAuthInfoDto != null) {
			if (userAuthInfoManager.deleteUserAuth(userId) != 1) {
				throw new UserException(ResponseCode.B_DELETE_ERROR,
						"delete userAuthInfoDto error");
			}
		}

		// 删除用户
		userManager.deleteUser(userId);

		return new UserResponse(true);

	}

}
