package kr.inhatc.spring.xml;

public class OrderManager {
	
	// private HyundaiMaker maker;
	private CarMaker maker;

	// xml Property사용을 위해 만들어줌
	public OrderManager() {
		
	}
	
	// OrderManager가 만들어지면
	public OrderManager(CarMaker maker) {
		super();
		// maker = new HyundaiMaker(); 
		this.maker = maker; 
		
	}
	
	// xml을 통한 주입
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}



	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager.order : - "+ money.getAmount());
		System.out.println("OrderManager.order : - "+ money.getAmount());

		Car car = maker.sell(money);
		System.out.println("OrderManager.order : - " + car.getName());
	}
}
