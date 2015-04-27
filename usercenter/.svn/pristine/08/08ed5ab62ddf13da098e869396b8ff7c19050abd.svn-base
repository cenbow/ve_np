package com.ve.usercenter.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ve.deliverycenter.client.FeeClient;
import com.ve.usercenter.common.constant.ResponseCode;
import com.ve.usercenter.common.dto.ConsigneeDTO;
import com.ve.usercenter.common.dto.UserDTO;
import com.ve.usercenter.core.dao.ConsigneeDao;
import com.ve.usercenter.core.domain.ConsigneeDO;
import com.ve.usercenter.core.exception.UserException;
import com.ve.usercenter.core.manager.ConsigneeManager;
import com.ve.usercenter.core.manager.UserManager;
import com.ve.usercenter.core.manager.remote.AddressCheckManager;
import com.ve.usercenter.core.util.UserUtil;

@Service
public class ConsigneeManagerImpl implements ConsigneeManager {

	@Resource
	private UserManager userManager;

	@Resource
	private ConsigneeDao consigneeDao;

	@Resource
	private FeeClient feeClient;

	@Resource
	private AddressCheckManager addressCheckManager;

	@Override
	public ConsigneeDTO addConsignee(ConsigneeDTO consigneeDto)
			throws UserException {

		addressCheckManager.addressCheck(consigneeDto);

		// 详细地址验证
		if (null == consigneeDto.getAddress()) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"address is null");
		}

		// 收件人手机号码验证
		UserUtil.checkMobile(consigneeDto.getMobileNo());

		// 座机号码验证
		if (null != consigneeDto.getPhoneNo()) {
			UserUtil.checkPhoneNo(consigneeDto.getPhoneNo());
		}

		// 收货人姓名不能为空
		if (null == consigneeDto.getConsignee()) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consignee no format is null");
		}
		// 将dto转换为do
		ConsigneeDO consigneeDo = new ConsigneeDO();
		BeanUtils.copyProperties(consigneeDto, consigneeDo);

		// 添加收货地址
		Long id = consigneeDao.addConsigee(consigneeDo);

		return getConsigneeById(consigneeDo.getUserId(), id);
	}

	@Override
	public int deleteConsignee(Long userId, Long consigneeId)
			throws UserException {
		if (null == consigneeId) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consigneeId is null");
		}

		int result = consigneeDao.deleteConsignee(userId, consigneeId);

		if (result != 1) {
			throw new UserException(ResponseCode.B_DELETE_ERROR, "delete error");
		}

		return result;
	}

	@Override
	public int updateConsignee(ConsigneeDTO consigneeDto) throws UserException {

		// 收货地址验证
		addressCheckManager.addressCheck(consigneeDto);

		// id验证
		if (null == consigneeDto.getId()) {
			throw new UserException(ResponseCode.P_PARAM_NULL, "id is null");
		}

		// 详细地址验证
		if (null == consigneeDto.getAddress()) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"address is null");
		}

		// 收件人手机号码验证
		UserUtil.checkMobile(consigneeDto.getMobileNo());

		// 座机号码验证
		if (null != consigneeDto.getPhoneNo()) {
			UserUtil.checkPhoneNo(consigneeDto.getPhoneNo());
		}

		// 验证收货人姓名
		if (null == consigneeDto.getConsignee()) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consignee no format is null");
		}

		ConsigneeDO consigneeDo = new ConsigneeDO();
		BeanUtils.copyProperties(consigneeDto, consigneeDo);

		int result = consigneeDao.updateConsigee(consigneeDo);

		if (result != 1) {
			throw new UserException(ResponseCode.B_DELETE_ERROR, "update error");
		}

		return result;
	}

	@Override
	public int setDefConsignee(Long userId, Long consigneeId)
			throws UserException {

		int result = consigneeDao.setDefConsignee(userId, consigneeId);
		if (result != 1) {
			throw new UserException(ResponseCode.B_UPDATE_ERROR, "update error");
		}

		return result;
	}

	@Override
	public int updateUserDefaultConsignee(Long userId) throws UserException {

		int result = consigneeDao.updateUserDefaultConsignee(userId);

		if (result <= 0) {
			throw new UserException(ResponseCode.B_DELETE_ERROR, "update error");
		}

		return result;
	}

	@Override
	public int getConsigneeCountByUserId(Long userId) throws UserException {

		int result = consigneeDao.getConsigneeCountByUserId(userId);

		return result;
	}

	@Override
	public List<ConsigneeDTO> queryConsignee(Long userId) throws UserException {

		UserDTO userDto = userManager.getUserById(userId);
		if (null == userDto) {
			throw new UserException(ResponseCode.B_SELECT_ERROR,
					"user is not exist");
		}

		List<ConsigneeDTO> consigneeDtos = new ArrayList<ConsigneeDTO>();

		List<ConsigneeDO> consigneeDos = consigneeDao.queryConsignee(userId);

		// 将查询的do列表转换为dto
		for (ConsigneeDO consignee : consigneeDos) {
			ConsigneeDTO consigneeDto = new ConsigneeDTO();
			BeanUtils.copyProperties(consignee, consigneeDto);
			consigneeDtos.add(consigneeDto);
		}

		return consigneeDtos;
	}

	@Override
	public int deleteUserConsignee(Long userId) throws UserException {
		// TODO Auto-generated method stub

		UserDTO userDto = userManager.getUserById(userId);
		if (null == userDto) {
			throw new UserException(ResponseCode.B_SELECT_ERROR,
					"user is not exist");
		}

		int result = consigneeDao.deleteUserConsignee(userId);

		return result;
	}

	@Override
	public int restoreUserConsignee(Long userId) throws UserException {
		// TODO Auto-generated method stub

		int result = consigneeDao.restoreUserConsignee(userId);

		return result;
	}

	@Override
	public ConsigneeDTO getConsigneeById(Long userId, Long consigneeId)
			throws UserException {
		// TODO Auto-generated method stub
		if (null == consigneeId) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consigneeId is null");
		}
		if (consigneeId < 0) {
			throw new UserException(ResponseCode.P_PARAM_NULL,
					"consigneeId is error");
		}

		ConsigneeDO consigneeDo = consigneeDao.getConsigneeById(userId,
				consigneeId);

		ConsigneeDTO consigneeDto = null;

		if (consigneeDo != null) {
			consigneeDto = new ConsigneeDTO();
			BeanUtils.copyProperties(consigneeDo, consigneeDto);
		}

		return consigneeDto;
	}
}
