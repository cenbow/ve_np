package test.order;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ve.tradecenter.core.exception.TradeException;
import com.ve.tradecenter.core.manager.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserManagerTest {

	@Resource
	private UserManager userManager;

	@Test
	public void test()throws TradeException{
		String address = this.userManager.getUserAddress(11L,11L);
		System.out.println(address);
	}
}
