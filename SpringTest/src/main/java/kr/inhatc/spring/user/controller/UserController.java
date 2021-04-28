package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.user.entitiy.Users;
import kr.inhatc.spring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
// 맵핑을 따로 해줄 수 있다.
@RequestMapping("/user")
// 필요한 객체를 올려줄 껀데 @Autowird를 안쓰면 final로 써야한다.
@RequiredArgsConstructor
public class UserController {
	
	// logger
	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Log
	//Log.info("===================> 리스트 수행중..."); 
	
	// 유저 서비스
	private final UserService userService;
	
	
	// GET(read), POST(create), PUT(update), DELETE(delete) = restful
	// 아래 두 표현은 같다.
	// @RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	@GetMapping("/userList")
	public void userList(Model model) {
		List<Users> list = userService.userList(); 
		//System.out.println("============> 크기" + list.size());
		model.addAttribute("list", list);
		//return "user/userList";
	}
	
	////////////////////////////////////////////////////////////////////
	
	
	// 바이패스로 이동만 할 경우 GetMapping으로 하면 편리하다. 
	@GetMapping({ "/test", "/test2" })
	public void test() {
		
	}
	
	/*
	 * GetMapping을 쓰면 간단하게 쓸 수 있다.
	@RequestMapping("/test")
	public String test2() {
		return "/user/test2";
	}
	*/
}
