package kr.inhatc.spring.basic;

// 돈을 관리하는 클래스
public class Money {
	private int amount;
	
	// 빈 생성자
	public Money() {
		super(); // super가 뭔지 다시 한번 찾아보자
	}

	public Money(int amount) {
		super();
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
