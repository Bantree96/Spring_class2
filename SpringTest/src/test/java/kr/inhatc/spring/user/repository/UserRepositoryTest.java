package kr.inhatc.spring.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.inhatc.spring.user.entitiy.Users;

@SpringBootTest		// 필수로 넣어 줘야한다.
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void insertTest() {
		// Users user = new Users(null, null, null, null, null, null, null);
		Users user = Users.builder()
				.id("abc")
				.pw("111")
				.email("abc@naver.com")
				.role("ROLE_ADMIN")
				.build();
		
		userRepository.save(user);
	}
	
	@Test
	void findAllByOrderByIdDescTest() {
		List<Users> list = userRepository.findAllByOrderByIdDesc();
		for(Users user : list) {
			System.out.println();
		}
	}

}
