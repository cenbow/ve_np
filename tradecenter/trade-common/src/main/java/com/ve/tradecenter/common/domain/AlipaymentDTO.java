package com.ve.tradecenter.common.domain;

import java.io.Serializable;

public class AlipaymentDTO  implements Serializable{
	private String toSign; // 待签名字符串
	
	private String sign;// 签名字符串
	
	private String outTradeNo; // ve交易号
	
	private String tradeNo; // 支付宝交易号
	 
	private Long totalFee; // 支付金额
	
	private String tradeStatus; // 支付宝的支付状态
	 
	private Long userId ; // 用户id
	
	public String getToSign() {
		return toSign;
	}

	public void setToSign(String toSign) {
		this.toSign = toSign;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
