package com.ve.tradecenter.core.manager.impl;

import javax.annotation.Resource;

import com.ve.deliverycenter.client.FeeClient;
import com.ve.deliverycenter.common.api.Response;
import com.ve.deliverycenter.common.qto.fee.DeliveryFeeQTO;
import com.ve.tradecenter.core.manager.DeliveryManager;

public class DeliveryManagerImpl implements DeliveryManager{

	@Override
	public long getDeliveryFee(Long addressId, Long weight){
		long result =0;
		DeliveryFeeQTO d = new DeliveryFeeQTO ();
		d.setRegionId(addressId);
		d.setWeight(weight);
		Response<Long>  resp = this.feeClient.queryDeliveryFee(d);
		System.out.println("deliveryFee :" + resp.getModule());
		return result;
	}
	
//	@Resource
	private FeeClient feeClient;

	@Override
	public boolean isCodSupported(long regionId) {
		return true;	
	}

}
