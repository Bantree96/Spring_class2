package kr.inhatc.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러라고 적어줘야 컨트롤러를 등록함
@Controller
//@RestController // 결과물을 바로 받아올땐 RestController
public class BoardController {
	
	// 요구가 들어올때 어떻게 맵핑할껀가?
	// 기본적으로 html파일을 찾아감
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
}
