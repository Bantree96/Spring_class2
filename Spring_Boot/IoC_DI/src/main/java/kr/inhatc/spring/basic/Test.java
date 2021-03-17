package kr.inhatc.spring.basic;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BenzMaker b = new BenzMaker();
		HyundaiMaker b = new HyundaiMaker();
		
		// setter나 생성자를 가지고 DI를 주입가능
		OrderManager manager = new OrderManager(b);
		manager.order();
	}

}
