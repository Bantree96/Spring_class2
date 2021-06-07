package kr.inhatc.spring.login.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

@SpringBootTest
class SecurityUserTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testInsert() {
		Users user = new Users();
			
		user.setId("jiwon2");
		user.setPw(passwordEncoder.encode("111"));
		user.setName("지원");
		user.setEmail("jiwon2@naver.com");
		user.setRole("ROLE_ADMIN");
		user.setEnabled("사용");
		userRepo.save(user);
	}
	

}
