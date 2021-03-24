package kr.inhatc.spring.javaconfig;

// 자동차 종류를 관리하는 클래스
public class Car {
	private String name;

	// alt + shift + s 누르면 단축키 나옴
	
	// 생성자, generate construct using fields
	public Car(String name) {
		super();
		this.name = name;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
