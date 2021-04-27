package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.user.entitiy.Users;
import kr.inhatc.spring.user.service.UserService;

@Controller
public class UserController {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 게시판 서비스
	@Autowired
	private UserService userService;
	
	// GET(read), POST(create), PUT(update), DELETE(delete) = restful
	@RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	public String userList(Model model) {
		List<Users> list = userService.userList(); 
		//System.out.println("============> 크기" + list.size());
		model.addAttribute("list", list);
		return "user/userList";
	}
}
