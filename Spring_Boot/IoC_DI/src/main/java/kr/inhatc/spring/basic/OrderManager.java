package kr.inhatc.spring.basic;

public class OrderManager {
	
	// private HyundaiMaker maker;
	private CarMaker maker;

	// OrderManager가 만들어지면
	public OrderManager(CarMaker maker) {
		super();
		// maker = new HyundaiMaker(); 
		this.maker = maker; 
		
	}
	
	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager.order : 현금 - "+ money.getAmount());
		System.out.println("OrderManager.order : 지불 - "+ money.getAmount());

		Car car = maker.sell(money);
		System.out.println("OrderManager.order : 차 받음 - " + car.getName());
	}
}
