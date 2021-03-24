package kr.inhatc.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// 클래스를 가져옴
		ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		
		OrderManager manager = context.getBean("orderManager", OrderManager.class);
		System.out.println(manager);
		
		manager.order();
		
		// 객체를 잘 불러오는지 확인해보기
		System.out.println(context.getBean("hyundai", HyundaiMaker.class));
		System.out.println(context.getBean("benzMaker", BenzMaker.class));
	
		

	}

}
