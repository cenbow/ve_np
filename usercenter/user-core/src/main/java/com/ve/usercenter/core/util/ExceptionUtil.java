package com.ve.usercenter.core.util;

import com.ve.usercenter.common.api.Response;
import com.ve.usercenter.common.api.UserResponse;
import com.ve.usercenter.common.constant.ErrorCode;
import com.ve.usercenter.core.domain.UserDO;

public class ExceptionUtil {
	
	/**
	 * 获得指定用户名不存在情况下的异常
	 * */
	public static Response userNotExistException(UserDO usreDo){
		if(usreDo==null){
			UserResponse response = new UserResponse(false);
			return response;
		}
		return null;
	}
}
