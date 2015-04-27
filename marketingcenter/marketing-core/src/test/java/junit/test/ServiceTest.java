package junit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "../../applicationContext.xml" });
	
	public static void main(String[] args) {
		
	}
}
