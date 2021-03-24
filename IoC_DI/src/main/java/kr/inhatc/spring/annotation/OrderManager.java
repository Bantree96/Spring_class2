package kr.inhatc.spring.annotation;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Service용 (이름줄수도있음)
@Service
public class OrderManager {
	
	// 주입용 -> maker에 Named의 값을 주입
	@Inject
	@Named("hyundai")
	private CarMaker maker;

	// OrderManager가 만들어지면
	// Autowired : 자동으로 메모리에 올려줌
	// Qualifier : 이런 식별자를 가지고있는애를 넣어준다?
	@Autowired
	public OrderManager(@Qualifier("hyundai") CarMaker maker) {
		super();
		this.maker = maker; 
		System.out.println("OrderManager() 호출됨");
		
	}
	
	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager.order : ���� - "+ money.getAmount());
		System.out.println("OrderManager.order : ���� - "+ money.getAmount());

		Car car = maker.sell(money);
		System.out.println("OrderManager.order : �� ���� - " + car.getName());
	}
	
	public void init() {
		System.out.println("OrderManager.init() 호출");
	}
}
