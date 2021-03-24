package kr.inhatc.spring.basic;

public class BenzMaker implements CarMaker{

	@Override
	public Car sell(Money money) {
		System.out.println("벤츠.sell : 돈 받음 -" + money.getAmount());
		Car car = new Car("E220");
		System.out.println("벤츠.sell : 작업 - " + car.getName());
		System.out.println("벤츠.sell : 판매 - " + car.getName());
		return car;
	}
}
