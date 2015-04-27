package com.ve.usercenter.common.qto;

import java.io.Serializable;

public class UserQTO extends QueryPage implements Serializable {

	private String name;
	private String email;
	private String mPhoneNo;
	private Long recommenderId;
	private Long inviterId;
	private Integer integralId;
	private Byte role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRecommenderId() {
		return recommenderId;
	}

	public void setRecommenderId(Long recommenderId) {
		this.recommenderId = recommenderId;
	}

	public Long getInviterId() {
		return inviterId;
	}

	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}

	public Byte getRole() {
		return role;
	}

	public void setRole(Byte role) {
		this.role = role;
	}

	public String getmPhoneNo() {
		return mPhoneNo;
	}

	public void setmPhoneNo(String mPhoneNo) {
		this.mPhoneNo = mPhoneNo;
	}

	public Integer getIntegralId() {
		return integralId;
	}

	public void setIntegralId(Integer integralId) {
		this.integralId = integralId;
	}

}
