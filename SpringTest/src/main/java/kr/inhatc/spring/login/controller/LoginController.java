package kr.inhatc.spring.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
	
	// Login에서 URL이동하는 부분은 SecurityConfiguration에 있다.
	
	@GetMapping("/login/login")
	public void login() {
		log.info("로그인 진행중...");
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied() {
		log.info("접근 거부...");
	}
	
	@GetMapping("/login/logout")
	public void logout() {
		log.info("로그아웃...");
	}
	
}
