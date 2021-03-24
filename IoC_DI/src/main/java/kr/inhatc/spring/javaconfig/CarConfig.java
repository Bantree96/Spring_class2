package kr.inhatc.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 설정과 관련된 파트
//@Configuration
@Component
public class CarConfig {

	// CarMaker인터페이스 사용
	// Bean에는 이름을 줄 수 있고 안주면 메소드명으로 가져감
	@Bean(name="hyundai")
	public CarMaker hyundaiMaker() {
		CarMaker maker = new HyundaiMaker();
		return maker;
	}
	
	@Bean
	public CarMaker benzMaker() {
		CarMaker maker = new BenzMaker();
		return maker;
	}
	
	@Bean
	public OrderManager orderManager() {
		OrderManager manager = new OrderManager(benzMaker());
		return manager;
	}
}
