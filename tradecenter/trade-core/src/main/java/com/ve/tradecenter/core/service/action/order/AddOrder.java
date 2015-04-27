package com.ve.tradecenter.core.service.action.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ve.tradecenter.common.api.Request;
import com.ve.tradecenter.common.api.TradeResponse;
import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.common.domain.FavorableInfoDTO;
import com.ve.tradecenter.common.domain.ItemDTO;
import com.ve.tradecenter.common.domain.ItemSkuDTO;
import com.ve.tradecenter.common.domain.ItemSkuQTO;
import com.ve.tradecenter.common.domain.MarketingItemDTO;
import com.ve.tradecenter.common.domain.OrderDTO;
import com.ve.tradecenter.common.domain.OrderItemDTO;
import com.ve.tradecenter.common.domain.PromotionItemDTO;
import com.ve.tradecenter.core.constants.TradeConstants;
import com.ve.tradecenter.core.domain.OrderDO;
import com.ve.tradecenter.core.domain.OrderItemDO;
import com.ve.tradecenter.core.domain.PaymentDO;
import com.ve.tradecenter.core.domain.PaymentNoticeDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.DeliveryManager;
import com.ve.tradecenter.core.manager.ItemPlatformManager;
import com.ve.tradecenter.core.manager.OrderItemManager;
import com.ve.tradecenter.core.manager.OrderManager;
import com.ve.tradecenter.core.manager.OrderSeqManager;
import com.ve.tradecenter.core.manager.PaymentManager;
import com.ve.tradecenter.core.manager.PaymentNoticeManager;
import com.ve.tradecenter.core.manager.PromotionPlatformManager;
import com.ve.tradecenter.core.manager.SellerOrderManager;
import com.ve.tradecenter.core.manager.UserCartItemManager;
import com.ve.tradecenter.core.manager.UserManager;
import com.ve.tradecenter.core.service.RequestContext;
import com.ve.tradecenter.core.service.ResponseUtils;
import com.ve.tradecenter.core.service.action.Action;
import com.ve.tradecenter.core.service.action.ActionEnum;
import com.ve.tradecenter.core.util.TradeUtils;

/**
 * 下单处理类
 * 1 赠品、优惠、商品价格都是以下单最新的价格为准 而不是购物车的价格         【确认过】
 * 2 按照供应商拆单、 由发货系统时候来拆单发货
 * 
 * 
 * 疑问：
 * 入驻和自营是一种类型、代发货也需要按照单独的拆单 跟真正的直发不一样
 * 部分商品缺货时候需要手动拆单 按照有货商品和无货商品来手动拆
 * 提供手动拆单的接口 按照商品(部分缺货部分有货来拆单）
 * 
 * 
 * 运费逻辑：
 * 全局包邮则包邮
 * 如果是部分包邮，全局不包邮则不包邮
 * @author cwr
 */
public class AddOrder implements Action{
	
	private static final Logger log = LoggerFactory.getLogger(AddOrder.class);
	
	private static final String SEPERATOR = "-";
	
	@Resource 
	private OrderSeqManager orderSeqManager;

	@Resource
	private OrderManager orderManager;
	
	@Resource
	private UserCartItemManager userCartItemManager;
	
	@Resource 
	private ItemPlatformManager itemPlatformManager; 
	
	@Resource 
	private PaymentManager paymentManager; 
	
//	@Resource
//	private TradeSysParamManager tradeSysParamManager;
	
	@Resource
	private UserManager userManager;
	
	@Resource 
	private PromotionPlatformManager promotionManager;
	
	@Resource
	private SellerOrderManager sellerOrderManager;
	
	@Resource
	private PaymentNoticeManager paymentNoticeManager;
	
	@Resource
	private OrderItemManager orderItemManager;
	
	@Resource
	private DeliveryManager deliveryManager;
	
	@Override
	public TradeResponse<OrderDTO> execute(RequestContext context) throws TradeException {
		Request request = context.getRequest();
		TradeResponse<OrderDTO> response = null;
		if(request.getParam("orderDTO") == null){
			log.error("orderDTO is null");
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,"orderDTO is null");
		}
		OrderDTO orderDTO = (OrderDTO)request.getParam("orderDTO");
		// 字段验证
		String errorMsg = this.orderManager.validateFields4Add(orderDTO);
		if(StringUtils.isEmpty(errorMsg)){
			log.error(errorMsg);
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg);
		}
		
		// 必要的参数
		long userId = orderDTO.getUserId(); // 用户id
		int deliveryId = orderDTO.getDeliveryId(); // 配送方式
		long addressId = orderDTO.getAddressId();  // 用户地址id
 		int source = orderDTO.getSource(); // 渠道来源 pc android ios h5
		int paymentId = orderDTO.getPaymentId(); // 支付方式
		boolean isCod = orderDTO.getIsCod();  // 是否或到付款
		boolean isCoupon = orderDTO.getIsCoupon(); //是否使用优惠券 
		Long couponId = null;
		if(orderDTO.getIsCoupon()){
			couponId = orderDTO.getCouponId();
		}
		List<OrderItemDTO> toBuyItems = orderDTO.getOrderItems();  // 顾客可以选择性下单的商品列表 
		String memo = orderDTO.getUserMemo();
		
		//TODO 总单暂时归于ve下
		long supplierId = this.userManager.getVeSupplierId();
		String address = null;
		
		// 按照供应商将商品分组 用于商品平台查询商品信息
		Map<Long,List<Long>> supplierItemsMap = new HashMap<Long,List<Long>>();
		
		// 存储单品是不是包邮，只要本次下单的商品有非包邮的产品该订单就不能包邮
		Map<String,Boolean> itemFreeDeliveryMap = new HashMap<String,Boolean>();
		
		// 将购物车的商品按照供应商id分组
		for(OrderItemDTO orderItem : toBuyItems){
			Long skuId = orderItem.getItemSkuId();
			if(supplierItemsMap.get(orderItem.getSupplierId()) == null){
				List<Long> supplierItems = new ArrayList<Long>();
				supplierItems.add(skuId);
				supplierItemsMap.put(orderItem.getSupplierId(), supplierItems);
			}else{
				supplierItemsMap.get(orderItem.getSupplierId()).add(skuId);
			}
			
			String key = skuId + SEPERATOR + orderItem.getSupplierId();
			itemFreeDeliveryMap.put(key, false); // 初始化为不包邮  后续参考活动是否包邮
			/*ItemSkuQTO itemSku = new ItemSkuQTO();
			itemSku.setId(orderItem.getItemSkuId()); // 商品sku id 
			itemSku.setSupplierId(orderItem.getSupplierId());  // 商品的供应商id
			itemSku.setNumber(orderItem.getNumber());
			itemQueryCondition.add(itemSku);*/
		}
		
		Iterator<Entry<Long,List<Long>>> it = supplierItemsMap.entrySet().iterator();
		List<ItemSkuDTO> itemSkuList = new ArrayList<ItemSkuDTO>(),itemSkus;
		List<ItemDTO> itemList = new ArrayList<ItemDTO>(),items;
		int count=0;
		// TODO 后续考虑使用并发的方式
		while(it.hasNext()){
			Entry<Long,List<Long>> entry = it.next();
			Long supplierId2 = entry.getKey();
			List<Long> supplierSkuIdList= entry.getValue();
			itemSkus = this.itemPlatformManager.getItemSkus(supplierSkuIdList, supplierId2);
			// 根据itemSkuList列表和supplierId来查询
			if(itemSkus == null || itemSkus.size() == 0){
				log.error("itemSku is null : " +supplierSkuIdList + "," + supplierId);
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_RECORD_NOT_EXIST,"itemSku doesn't exist");
			}
			itemSkuList.addAll(itemSkus);
			List<Long> itemIdList = new ArrayList<Long>();
			for(ItemSkuDTO itemSku:itemSkuList){
				itemIdList.add(itemSku.getItemId());
			}
			items = this.itemPlatformManager.getItems(itemIdList, supplierId2);
			if(items == null || items.size() == 0){
				log.error("Item is null" + itemIdList + " " + supplierId);
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_NOT_EXIST,"item doesn't exist");
			}
			itemList.addAll(items);
			//List<ItemSkuDTO> returnItemsList = this.itemPlatformManager.getItemSkus(items, supplierId);
			//itemSkuList.addAll(returnItemsList);
		}
		
		
		
		/*try{
			itemSkuList = this.itemManager.getItemSkus(itemQueryCondition);
		}catch(TradeException e){
			log.error("getItemsInfo error",e);
			return ResponseUtils.getFailResponse(ResponseCode.PARAM_E_PARAM_MISSING,errorMsg);
		}*/
		
		// 将商品平台查询返回的商品信息封装为 Map 方便处理
		Map<String,ItemSkuDTO> itemSkuMap = new HashMap<String,ItemSkuDTO>();
		Map<String,ItemDTO> itemMap = new HashMap<String,ItemDTO>();
		for(ItemSkuDTO item : itemSkuList){
			String key = item.getId() + SEPERATOR + item.getSellerId();
			itemSkuMap.put(key,item);
			for(ItemDTO item2 : itemList){
				if(item2.getId().equals(item.getItemId())){
					if(itemMap.get(key) == null){
						itemMap.put(item.getId() + SEPERATOR + item.getSellerId(), item2);
					}
				}
			}
		}
		
		// 根据发货商来分组 -- 自营和入驻的发货商都是ve 用于拆单  
		Map<String,OrderItemDO> orderItemMap = new HashMap<String,OrderItemDO>();
		List<ItemSkuQTO> promotionQueryList = new ArrayList<ItemSkuQTO>(); //构造参数列表到促销平台查询
		
		// 根据商品平台返回的商品信息验证下单商品
		boolean isCodAllowed = true;
		long thirdPartySuppier = 0,mainOrderTotalPrice = 0L; // 主单总价
		boolean itemNotExist ;
		boolean isZeroBuyExist = false;  // 判断是否有 0 元购
		
		// 商品验证：　最大、最小购买量，销售时间，库存验证　　
		Date now = new Date();
		
		// 构造产品列表去促销平台查询
		List<MarketingItemDTO> itemQueryCondition = new ArrayList<MarketingItemDTO>();
		long orderTotalPrice = 0L;  // 订单下的总金额
		for(OrderItemDTO orderItemDTO : toBuyItems){
			String itemSkuKey = orderItemDTO.getItemSkuId() + SEPERATOR + orderItemDTO.getSupplierId();
			ItemSkuDTO itemSkuDTO = itemSkuMap.get(itemSkuKey);
			ItemDTO itemDTO = itemMap.get(itemSkuKey);
			if(itemSkuDTO == null){ // 如果该商品在不存在
				log.error("itemSku doesn't exist : " + itemSkuKey);
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_NOT_EXIST,"itemSku doesn't exist");
			}
			if(itemDTO ==null){
				log.error("item doesn't exist" + itemSkuKey);
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_NOT_EXIST,"item doesn't exist");
			}
			if(itemDTO.getSaleMaxNum()!= null && orderItemDTO.getNumber().intValue()>itemDTO.getSaleMaxNum().intValue()){  // 购买最大量限制
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_BUY_MAX_AMOUNT);
			}else if(itemDTO.getSaleMinNum() != null && orderItemDTO.getNumber().intValue() < itemDTO.getSaleMinNum().intValue()){ // 购买最小量限制
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_BUY_MIN_AMOUNT);
			}else if(itemDTO.getSaleBegin() != null && now.before(itemDTO.getSaleBegin())){ // 销售未开始
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_SALE_NOT_START); 
			}else if(itemDTO.getSaleEnd()!= null && now.after(itemDTO.getSaleEnd())){// 销售结束
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_SALE_END);
			}else if(itemSkuDTO.getStockNum() != null && orderItemDTO.getNumber().intValue() > itemSkuDTO.getStockNum().intValue()){
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_ITEM_OUT_OF_STOCK); // 库存不足
			}
			OrderItemDO orderItemDO = this.getOrderItemDO(orderDTO, orderItemDTO, itemSkuDTO,itemDTO);
			orderTotalPrice += orderItemDO.getTotalPrice();
			orderItemMap.put(itemSkuKey, orderItemDO);// 便于后续的优惠处理
			MarketingItemDTO marketingItem = new MarketingItemDTO();
			marketingItem.setItemSkuId(orderItemDTO.getItemSkuId());
			marketingItem.setNumber(orderItemDTO.getNumber());
			marketingItem.setUnitPrice(itemSkuDTO.getPromotionPrice());
			marketingItem.setSupplierId(itemSkuDTO.getSellerId());
			itemQueryCondition.add(marketingItem);
		}
		
		/* 货到付款逻辑验证
		 * 1 有非自营商品的订单不能货到付款
		 * 2 货到付款有区域限制 暂时既是顺丰货到付款区域
		 * 3 货到付款上、下限制金额验证
		 */
		// 支付方式验证
		PaymentDO payment = this.paymentManager.getPayment(paymentId);
		if(payment == null){
			log.error("payment is not valid: "  + paymentId);
			return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_PAYMENT_TYPE_ERROR,"payment is not valid");
		}
		
		if(isCod){
			// 是否开启货到付款
			if(payment.getIsActive()){ 
				log.error("cod not supported: " + payment.getIsActive());
				return ResponseUtils.getFailResponse(ResponseCode.BIZ_E_COD_NOT_SUPPORTED);
			}
		}
		
		//TODO 查询用户信息
		try{
			address = userManager.getUserAddress(userId,addressId);
			System.out.println("address : " + address);
		}catch(TradeException e){
			log.error(e.getResponseCode().getCode(),e);
			return ResponseUtils.getFailResponse(e.getResponseCode(),"getUserInfo error");
		}
		
		/* 
		 * 下单商品的涉及的优惠活动处理
		 */
		
		List<Long> couponIds = new ArrayList<Long>();
		couponIds.add(couponId);
		
		List<FavorableInfoDTO> favorableInfoList = this.promotionManager.getPromotionItems(itemQueryCondition,userId,couponIds,source);
		List<OrderItemDO> giftItemList = new ArrayList<OrderItemDO>();
		
		if(favorableInfoList == null || favorableInfoList.size()!=0){
			//单个商品的 [itemSkuId] + "-" + [supplierId] 作为key
			Map<String,Long> itemActivitySaveMap = new HashMap<String,Long>(); // 得到单个商品在普通活动下的优惠金额
			Map<String,Long> itemcouponSaveMap = new HashMap<String,Long>(); // 得到单个商品在优惠券下的优惠金额
			long activityTotalSave = 0L;
			long couponTotalSave = 0L;
			
			// 遍历处理购买的商品涉及的活动
			for(FavorableInfoDTO favorableInfo : favorableInfoList){
				long activitySave = favorableInfo.getOfferAmount();  // 单个活动节省的总金额 ，需要根据活动下面的商品按照金额比例分享
				if(favorableInfo.getActivity().getIsCoupon()){
					couponTotalSave += activitySave;// 计算优惠券的总的节省金额
				}else{
					activityTotalSave += activitySave; // 计算非优惠券活动的总的优惠金额
				}
				long itemsTotalPrice = 0L;   // 单个活动下所有商品的总金额
				long itemTotalPrice ; // 一个商品原始总价（数量乘以单价）
					
				System.out.println("activityName " + favorableInfo.getActivity() + " save: " + favorableInfo.getOfferAmount());
				System.out.println("items: " + favorableInfo.getItemList());
				String key =null;
				OrderItemDO orderItem =null;
				long itemSaveInActivity = 0L;
				if(favorableInfo.getItemList() != null){ // 参加该活动的商品列表
					int itemCount = favorableInfo.getItemList().size(); // 一个活动下商品的总条数
					long itemsSaveSum = 0L;
					// 累计一个活动下所有的商品的所有的原始总价 用于计算单个商品总价的占比
					for(MarketingItemDTO item : favorableInfo.getItemList()){
						key = item.getItemSkuId() + "-" + item.getSupplierId();
						orderItem = orderItemMap.get(key);
						itemsTotalPrice += orderItem.getTotalPrice();
						if(favorableInfo.isNoPostage()){ // 如果该活动免邮费
							itemFreeDeliveryMap.put(key, true); // 该单品在该活动下是包邮的
						}
					}
					for(int index =0;index < itemCount;index++){
						MarketingItemDTO promotionItem = favorableInfo.getItemList().get(index);
						key = promotionItem.getItemSkuId() + "-" + promotionItem.getSupplierId();
						orderItem = orderItemMap.get(key);
						itemTotalPrice = orderItem.getTotalPrice();
						if(index == (itemCount-1)){ // 最后一个时候 用减法 避免总和不为整数
							itemSaveInActivity = activitySave - itemsSaveSum;
						}else{ // 不是最后一个需要累加 
							double percent = itemTotalPrice*1.0/itemsTotalPrice;
							itemSaveInActivity = (long)(percent * activitySave); 
							itemsSaveSum += itemSaveInActivity;
						}
						
						// 保存商品在一个非优惠券活动中的节省金额
						if(favorableInfo.getActivity().getIsCoupon()){
							if(itemActivitySaveMap.get(key) == null){
								itemActivitySaveMap.put(key, itemSaveInActivity);
							}else{
								long itemTotalSave = itemActivitySaveMap.get(key) + itemSaveInActivity;
								itemActivitySaveMap.put(key, itemTotalSave);
							}
						}else{
							// 保存商品在一个优惠券活动中的节省金额
							if(itemcouponSaveMap.get(key) == null){
								itemcouponSaveMap.put(key, itemSaveInActivity);
							}else{
								long itemTotalSave = itemcouponSaveMap.get(key) + itemSaveInActivity;
								itemcouponSaveMap.put(key, itemTotalSave);
							}
						}
					}
				}
				
				// 赠品列表的处理
				if(favorableInfo.getGiftList() != null){
					for(MarketingItemDTO promotionItem : favorableInfo.getGiftList()){
						OrderItemDO giftItem = new OrderItemDO();
						giftItem.setUserId(orderDTO.getUserId());
						giftItem.setUserName(orderDTO.getUserName());
						giftItem.setNumber(promotionItem.getNumber()); 
						giftItem.setUnitPrice(0L);
						giftItem.setTotalPrice(0L);
						giftItem.setDeliveryId(deliveryId); // 配送方式
						giftItem.setDeliveryStatus(TradeConstants.DeliveryStatus.NOT_DELIVERIED); // 发货状态 
						giftItem.setItemName(promotionItem.getItemName()); // 商品名称
//						orderItemDO.setBuyType(order); // 是否需要购买类型 ?
						giftItem.setSupplierId(promotionItem.getSupplierId());
						giftItem.setPayStatus(TradeConstants.PaymentStatus.UNPAID);
						giftItem.setIsGift(true);
						giftItem.setGmtCreated(now);
						giftItem.setGmtModified(now);
						giftItem.setItemSkuId(promotionItem.getItemSkuId());
						//giftItem.setItemId(promotionItem.getitem());		
						giftItem.setItemName(promotionItem.getItemName());
						giftItem.setSupplierId(promotionItem.getSupplierId()); // 赠品谁提供 
						giftItem.setNumber(promotionItem.getNumber());
						giftItemList.add(giftItem);
					}
				}
			}
			
			// 运费的处理
			boolean isOrderDeliveryFree = true;
			for(OrderItemDTO item : toBuyItems){
				String key = item.getItemSkuId() + SEPERATOR + item.getSupplierId();
				if(!itemFreeDeliveryMap.get(key)){ // 只要是包邮活动不能覆盖所有的商品 则不能包邮
					isOrderDeliveryFree = false;
					break;
				}
			}
			Long deliveryFee = 0L;
			if(!isOrderDeliveryFree){ //如果是不能包邮 再去查询运费
				deliveryFee = this.deliveryManager.getDeliveryFee(null, null);
				if(deliveryFee == null){ // 
					log.error("deliveryFee is null");
					return ResponseUtils.getFailResponse(ResponseCode.SYS_E_REMOTE_CALL_ERROR,"deliveryFee is null");
				}
			}
			
			// 处理完优惠活动 下单
			String orderSn = this.orderSeqManager.getOrderSn(source); // 按照订单号生成规则生成订单编号
			OrderDO orderDO = this.getOrderDO(orderDTO);  // 将DTO转为DO
			orderDO.setSupplierId(supplierId); //总单归于ve名下
			orderDO.setOrderSn(orderSn);
			orderDO.setDiscountPrice(0L);  // ? 
			orderDO.setPromotionDiscount(activityTotalSave); // 该订单活动的总的优惠金额
			orderDO.setDeliveryFee(!isOrderDeliveryFree ? deliveryFee : 0); 
			orderDO.setCouponDiscount(couponTotalSave); // 该订单优惠券的总的优惠金额
			orderDO.setTotalAmount(orderTotalPrice);
			orderDO.setPayAmount(orderTotalPrice - activityTotalSave - couponTotalSave);  // 待支付金额为 商品总价减优惠金额
			orderDO.setIsCod(orderDTO.getIsCod());
			orderDO.setUserId(orderDTO.getUserId()); // 用户ID
			orderDO.setIsActive(true); 
			orderDO.setIsDelete(false); 
			orderDO.setGmtCreated(now);
			orderDO.setGmtModified(now);
			
			long userOrderId = orderManager.addOrder(orderDO);// 写入买家订单表
			// 卖家订单表的id和买家id相同
			orderDO.setId(userOrderId);
			sellerOrderManager.addOrder(orderDO); // 写入卖家订单表 
			
			System.out.println("itemcouponSaveMap: " + itemActivitySaveMap);
			System.out.println("itemcouponSaveMap: " +  itemcouponSaveMap);
			
			Iterator<Entry<String,OrderItemDO>> it2 = (Iterator<Entry<String,OrderItemDO>>)orderItemMap.entrySet().iterator();
			while(it2.hasNext()){
				Entry<String,OrderItemDO> entry = it2.next();
				OrderItemDO  orderItem = entry.getValue();
				orderItem.setOrderId(userOrderId);
				orderItem.setOrderSn(orderSn);
				// 写入单个商品在促销活动和优惠券中的优惠金额   用于后续的拆单中
				orderItem.setPromotionDiscount(itemActivitySaveMap.get(entry.getKey()));
				orderItem.setCouponDiscount(itemcouponSaveMap.get(entry.getKey()));
				this.orderItemManager.addOrderItem(orderItem);
			}
			for(OrderItemDO giftItem : giftItemList){
				giftItem.setOrderId(userOrderId);
				giftItem.setOrderSn(orderSn);
				giftItem.setPromotionDiscount(null);
				giftItem.setCouponDiscount(null);
				this.orderItemManager.addOrderItem(giftItem);
			}
			
			PaymentNoticeDO paymentNoticeDO = new PaymentNoticeDO();
			paymentNoticeDO.setTradeNo(orderDO.getOrderSn()); 
			paymentNoticeDO.setOrderId(userOrderId);
			paymentNoticeDO.setIsPaid(false); 
			paymentNoticeDO.setSupplierId(supplierId); // 总单的支付单先归于ve下
			paymentNoticeDO.setUserId(userId);
			paymentNoticeDO.setMoney(orderDO.getPayAmount());
			paymentNoticeDO.setPaymentId(paymentId);
			paymentNoticeDO.setBankCode(orderDTO.getBankCode());
			paymentNoticeDO.setMoney(orderDO.getPayAmount());
			paymentNoticeDO.setIsDelete(false);
			long paymentNoticeId = this.paymentNoticeManager.addPaymentNotice(paymentNoticeDO);
			return ResponseUtils.getSuccessResponse(TradeUtils.convert2OrderDTO(orderDO));
			
		}else{ //TODO　如果是促销平台返回空如何处理
			return ResponseUtils.getFailResponse(null);
		}
		
		//TODO 0元购  暂时不考虑  by 老唐
	}

	@Override
	public String getName() {
		return ActionEnum.ADD_ORDER.getActionName();
	}
	
	/**
	 * 由前端传递的信息返回orderDO对象
	 * @param orderDTO
	 */
	private OrderDO getOrderDO(OrderDTO orderDTO){
		OrderDO orderDO =new OrderDO();
		orderDO.setUserId(orderDTO.getUserId()); // 用户ID
		orderDO.setType(1); //订单类型
		orderDO.setPayStatus(TradeConstants.PaymentStatus.UNPAID); // 刚下单是未支付
		orderDO.setDeliveryStatus(TradeConstants.DeliveryStatus.NOT_DELIVERIED); // 刚下单是未发货 
		orderDO.setOrderStatus(TradeConstants.PaymentStatus.UNPAID); // 刚下单时未支付
		orderDO.setAddressId(orderDTO.getAddressId());
		orderDO.setTel(orderDTO.getTel());
		orderDO.setMobile(orderDTO.getMobile());
		orderDO.setConsignee(orderDTO.getConsignee());
		orderDO.setPaymentId(orderDTO.getPaymentId());
		orderDO.setBankCode(orderDTO.getBankCode()); // 银行编码
		orderDO.setSource(orderDTO.getSource());
		orderDO.setUserMemo(orderDTO.getUserMemo());
			
		return orderDO;
		
		/*// 处理完优惠活动 下单
		OrderDO orderDO =new OrderDO();
			orderDO.setUserId(orderDTO.getUserId()); // 用户ID
			orderDO.setSupplierId(supplierId); // 供应商ID
			//orderDO.setType(orderDTO.getType()); //订单类型
			orderDO.setPayStatus(TradeConstants.PaymentStatus.UNPAID); // 刚下单是未支付
			orderDO.setDeliveryStatus(TradeConstants.DeliveryStatus.NOT_DELIVERIED); // 刚下单是未发货 
			orderDO.setOrderStatus(TradeConstants.PaymentStatus.UNPAID); // 刚下单时未支付
			orderDO.setAddress(address);
			orderDO.setAddressId(addressId);
			orderDO.setTel(orderDTO.getTel());
			orderDO.setMobile(orderDTO.getMobile());
			orderDO.setConsignee(orderDTO.getConsignee());
			orderDO.setPaymentId(paymentId);
			orderDO.setBankCode(orderDTO.getBankCode()); // 银行编码
			orderDO.setSource(orderDTO.getSource());
			orderDO.setUserMemo(memo);
 			
			String orderSn = this.orderSeqManager.getOrderSn(source);
			orderDO.setOrderSn(orderSn);
			
			// TODO 优惠计算 ?
			orderDO.setDiscountPrice(0L);  // 
			orderDO.setPromotionDiscount(activityTotalSave); // 该订单活动的总的优惠金额
			orderDO.setDeliveryFee(deliveryFee);
			orderDO.setCouponDiscount(couponTotalSave); // 该订单优惠券的总的优惠金额
			orderDO.setTotalAmount(orderTotalPrice);
			orderDO.setPayAmount(orderTotalPrice - activityTotalSave - couponTotalSave);  // 待支付金额为 商品总价减优惠金额
			
			orderDO.setIsCod(orderDTO.getIsCod());
			orderDO.setUserId(orderDTO.getUserId()); // 用户ID

			orderDO.setIsActive(true); // 默认是有效单
			orderDO.setIsDelete(false); 
			orderDO.setGmtCreated(now);
			orderDO.setGmtModified(now);*/
	}
	
	private OrderItemDO getOrderItemDO(OrderDTO orderDTO,OrderItemDTO orderItemDTO ,ItemSkuDTO itemSkuDTO,ItemDTO itemDTO){
	
		OrderItemDO orderItemDO = new OrderItemDO();
		orderItemDO.setUserId(orderDTO.getUserId());
		orderItemDO.setUserName(orderDTO.getUserName());
		int number = orderItemDTO.getNumber(); 
		orderItemDO.setNumber(number); 
		orderItemDO.setItemName(itemDTO.getItemName() + " [" + itemSkuDTO.getCodeValue() + "]");
		orderItemDO.setUnitPrice(itemSkuDTO.getPromotionPrice());
		orderItemDO.setTotalPrice(number * itemSkuDTO.getPromotionPrice());
		orderItemDO.setDeliveryId(orderDTO.getDeliveryId()); // 配送方式
		orderItemDO.setDeliveryStatus(TradeConstants.DeliveryStatus.NOT_DELIVERIED); // 发货状态 
		orderItemDO.setPayStatus(TradeConstants.PaymentStatus.UNPAID);
		orderItemDO.setIsGift(false); // 通过购买的考虑都不是赠品
		orderItemDO.setItemSkuId(itemSkuDTO.getId()); 
		orderItemDO.setItemId(itemSkuDTO.getItemId());
		
		/*
		 暂时不需要这些字段
		orderItemDO.setReturnMoney(itemSkuDTO.getReturnMoney()); // 返还现金
		orderItemDO.setReturnTotalMoney(itemSkuDTO.getReturnMoney()==null ? null :itemSkuDTO.getReturnMoney() * number); // 
		orderItemDO.setReturnPoint(itemSkuDTO.getReturnPoint());
		orderItemDO.setReturnTotalPoint(itemSkuDTO.getReturnPoint()==null ?  null : itemSkuDTO.getReturnPoint() * number );
		*/
//		orderItemDO.setBuyType(order); //  ?
		
		
		return orderItemDO;
		
		/*
		 OrderItemDO orderItemDO = new OrderItemDO();
			orderItemDO.setUserId(orderDTO.getUserId());
			orderItemDO.setUserName(orderDTO.getUserName());
			int number = orderItemDTO.getNumber(); // 数量
			orderItemDO.setNumber(number); 
			orderItemDO.setUnitPrice(itemSkuDTO.getCurrentPrice());
			orderItemDO.setTotalPrice(number * itemSkuDTO.getCurrentPrice());
			orderItemDO.setDeliveryId(deliveryId); // 配送方式
			orderItemDO.setDeliveryStatus(TradeConstants.DeliveryStatus.NOT_DELIVERIED); // 发货状态 
			orderItemDO.setItemName(itemSkuDTO.getItemName()); // 商品名称
			orderItemDO.setReturnMoney(itemSkuDTO.getReturnMoney()); // 返还现金
			orderItemDO.setReturnTotalMoney(itemSkuDTO.getReturnMoney()==null ? null :itemSkuDTO.getReturnMoney() * number); // 
			orderItemDO.setReturnPoint(itemSkuDTO.getReturnPoint());
			orderItemDO.setReturnTotalPoint(itemSkuDTO.getReturnPoint()==null ?  null : itemSkuDTO.getReturnPoint() * number );
//			orderItemDO.setBuyType(order); // 是否需要购买类型 ?
			orderItemDO.setSupplierId(supplierId);
			orderItemDO.setSupplierType(itemSkuDTO.getSupplierType());
			orderItemDO.setPayStatus(TradeConstants.PaymentStatus.UNPAID);
			orderItemDO.setIsGift(itemSkuDTO.getIsGift());
			orderItemDO.setGmtCreated(now);
			orderItemDO.setGmtModified(now);
			orderItemDO.setItemSkuId(itemSkuDTO.getId());
			orderItemDO.setItemId(itemSkuDTO.getItemId());
		  
		 */
	}
	
}
