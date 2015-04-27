package com.ve.marketingcenter.common.domain.qto;

import java.io.Serializable;


public class MarketingScopeQTO extends BaseQTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2513477914036268896L;

	private Long actId;

    private Integer cludeType;

    private Integer marketType;

    private Long cludeId;
    
    private Integer couponFlag;
//    private MarketingScopeDTO activity;
//
//	public MarketingScopeDTO getActivity() {
//		return activity;
//	}
//
//	public void setActivity(MarketingScopeDTO activity) {
//		this.activity = activity;
//	}

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Integer getCouponFlag() {
		return couponFlag;
	}

	public void setCouponFlag(Integer couponFlag) {
		this.couponFlag = couponFlag;
	}

	public Integer getCludeType() {
        return cludeType;
    }

    public void setCludeType(Integer cludeType) {
        this.cludeType = cludeType;
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
    }

    public Long getCludeId() {
        return cludeId;
    }

    public void setCludeId(Long cludeId) {
        this.cludeId = cludeId;
    }
    
    
}