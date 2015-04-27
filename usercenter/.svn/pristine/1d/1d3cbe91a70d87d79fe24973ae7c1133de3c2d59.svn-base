package com.ve.usercenter.client;

import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.dto.UserAuthInfoDTO;

public interface UserAuthClient {
	/**
	 * 保存用户实名认证信息
	 */
	Response<UserAuthInfoDTO> saveUserAuthInfo(UserAuthInfoDTO authInfoDto);

	/**
	 * 获取用户的实名认证信息
	 */
	Response<UserAuthInfoDTO> getAuthInfoByUserId(Long userId);

	/**
	 * 用户实名认证通过
	 */
	Response<Boolean> passUserIden(Long userId, String remark);

	/**
	 * 用户实名认证不通过
	 */
	Response<Boolean> refuseUserIden(Long UserId, String remark);
}
