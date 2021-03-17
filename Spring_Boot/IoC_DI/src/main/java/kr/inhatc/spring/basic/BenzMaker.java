package kr.inhatc.spring.basic;

public class BenzMaker implements CarMaker{

	@Override
	public Car sell(Money money) {
		System.out.println("º¥Ã÷.sell : µ· ¹ÞÀ½  " + money.getAmount());
		Car car = new Car("E220");
		System.out.println("º¥Ã÷.sell : ÀÛ¾÷ - " + car.getName());
		System.out.println("º¥Ã÷.sell : ÆÇ¸Å - " + car.getName());
		return car;
	}
}
