package test.order;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.tradecenter.common.constant.ResponseCode;
import com.ve.tradecenter.core.domain.OrderSeqDO;
import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.OrderSeqManager;
import com.ve.tradecenter.core.service.action.order.AddOrder;
import com.ve.tradecenter.core.util.TradeUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class OrderSeqManagerTest {

	@Resource
	private OrderSeqManager orderSeqManager;
	
	@Resource
	private AddOrder addOrder;
	
	@Test
	public void test()throws TradeException{
		/*System.out.println("begin");
		OrderSeqDO o = null;
		int i =0;
		try{
//			i = orderSeqManager.updateOrderSeq();
		}catch(Exception e){
			e.printStackTrace();
		}
		String orderSn = addOrder.getOrderSn(1);
		System.out.println(orderSn);
		System.out.println("end");
		*/
		/*System.out.println("begin");
		int affectedRow = 0;
		try{
			affectedRow  = orderSeqManager.updateOrderSeq();
		}catch(Exception e){
			throw new TradeException(ResponseCode.SYS_E_DATABASE_ERROR,e);
		}
		OrderSeqDO daySeq=null;
		if(affectedRow > 0){
			daySeq = orderSeqManager.getOrderSeq();
		}else{
			OrderSeqDO orderSeqDO = new OrderSeqDO();
			orderSeqDO.setSeq(1);
			daySeq = orderSeqManager.addOrderSeq(orderSeqDO);
		}
		String orderSn =  1 + daySeq.getDay().toString() + daySeq.getSeq();
		System.out.println("end");
		System.out.println(orderSn);*/
		
		String orderSn = this.orderSeqManager.getOrderSn(1);
		System.out.println(orderSn);
	}
}
