package kr.inhatc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;

// 컨트롤러라고 적어줘야 컨트롤러를 등록함
// 웹페이지에는 Controller
@Controller
//@RestController // 결과물을 바로 받아올땐 RestController
public class BoardController {
	
	// 게시판 서비스
	@Autowired
	private BoardService boardService;
	
	
	// 요구가 들어올때 어떻게 맵핑할껀가?
	// 기본적으로 html파일을 찾아감
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/board/boardList")
	public String boardList(Model model) {
		// 서비스 로직
		List<BoardDto> list = boardService.boardList();
		System.out.println("============>"+list.size());
		System.out.println("============>"+list.get(0));

		// 모델이 웹페이지로 갈때 가져감
		model.addAttribute("list",list);
		model.addAttribute("name","홍길동");

		// 뷰어로 이동
		return "board/boardList";
	}
}