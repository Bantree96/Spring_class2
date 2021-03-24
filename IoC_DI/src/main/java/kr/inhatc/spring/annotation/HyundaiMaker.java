package kr.inhatc.spring.annotation;

import org.springframework.stereotype.Component;

@Component("hyundai")
public class HyundaiMaker implements CarMaker {
	
	@Override
	public Car sell(Money money) {
		System.out.println("현대자동차.sell : 돈 받음 - " + money.getAmount());
		Car car = new Car("�Ÿ");
		System.out.println("현대자동차.sell : 작업 - " + car.getName());
		System.out.println("현대자동차.sell : 판매 - " + car.getName());
		return car;
	}
}
