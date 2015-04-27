package com.ve.tradecenter.common.domain;

import java.io.Serializable;
import java.util.List;

public class FavorableInfoDTO implements Serializable{

	public MarketingActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(MarketingActivityDTO activity) {
		this.activity = activity;
	}

	public List<PromotionItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<PromotionItemDTO> itemList) {
		this.itemList = itemList;
	}

	public List<PromotionItemDTO> getGiftList() {
		return giftList;
	}

	public void setGiftList(List<PromotionItemDTO> giftList) {
		this.giftList = giftList;
	}

	public boolean isNoPostage() {
		return noPostage;
	}

	public void setNoPostage(boolean noPostage) {
		this.noPostage = noPostage;
	}

	public long getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(long offerAmount) {
		this.offerAmount = offerAmount;
	}

	private MarketingActivityDTO activity; //活动对象
	
	private List<PromotionItemDTO> itemList; //活动的商品列表
	
	private List<PromotionItemDTO> giftList; //活动的赠品列表
	
	private boolean noPostage; //是否免邮
	
	private long offerAmount; //优惠额
	
//	private List<CouponDto> coupons;	
	
}
