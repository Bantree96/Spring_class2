package kr.inhatc.spring.xml;

public class HyundaiMaker implements CarMaker {
	
	@Override
	public Car sell(Money money) {
		System.out.println("현대자동차.sell : 돈 받음 - " + money.getAmount());
		Car car = new Car("소나타");
		System.out.println("현대자동차.sell : 작업 - " + car.getName());
		System.out.println("현대자동차.sell : 판매 - " + car.getName());
		return car;
	}
}
