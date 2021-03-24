package kr.inhatc.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car_config_annotation.xml");
		// 불러올때 첫글자를 소문자로 불러와야됨
		OrderManager manager = context.getBean("orderManager", OrderManager.class);
		manager.order();
	}

}
