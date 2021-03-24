package kr.inhatc.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// manager사용을 위한 xml연결하기
		ApplicationContext context = new ClassPathXmlApplicationContext("car_config.xml");
		
		// getBean(빈의 ID, 리턴 타입)
		OrderManager manager = context.getBean("manager", OrderManager.class);
		manager.order();
	}

}
