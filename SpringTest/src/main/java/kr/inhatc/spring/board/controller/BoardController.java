package kr.inhatc.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;

// 컨트롤러라고 적어줘야 컨트롤러를 등록함
// 웹페이지에는 Controller

@Controller
//@RestController // 결과물을 바로 받아올땐 RestController
public class BoardController {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 게시판 서비스
	@Autowired
	private BoardService boardService;
	
	
	// 요구가 들어올때 어떻게 맵핑할건가?
	// 기본적으로 html파일을 찾아감
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	// board 리스트
	@RequestMapping("/board/boardList")
	// model은 컨트롤러에서 html로 값을 넘길때 
	public String boardList(Model model) {
		// 서비스 로직
		List<BoardDto> list = boardService.boardList();
		
		// logger를 활용한 로그 찍기
		log.debug("============>"+list.size());
		
		// 콘솔화면에 일반 로그 찍기
		//System.out.println("============>"+list.size());
		//System.out.println("============>"+list.get(0));
		
		// 모델 = data
		// 모델이 웹페이지로 갈때 가져감
		// java자료구조 = key:value = map형태라고함
		model.addAttribute("list",list);
		model.addAttribute("name","홍길동");

		// 뷰어로 이동 -> 웹페이지를 찾아감
		return "board/boardList";
	}
	
	// board 글쓰기
	@RequestMapping("/board/boardWriteForm")
	public String boardWriteForm(Model model) {
		return "board/boardWriteForm";
	}
	
	// board 글 작성 내용 DB insert
	@RequestMapping("/board/boardInsert")
	public String boardInsert(BoardDto board) {
		boardService.boardInsert(board);
		// insert가 끝나면 컨트롤러 내부에서 redirect함
		// redirect는 내부 컨트롤러에 있는 주소를 찾아감 -> 다시 찾아간다 라고 생각하면됨
		return "redirect:/board/boardList";
	}
	
	// board 상세
	@RequestMapping("/board/boardDetail")
	// 하나만 넘겨올때는 @RequestsParam으로 받아옴
	public String boardDetail(@RequestParam int boardIdx, Model model) {
		BoardDto board = boardService.boardDetail(boardIdx);
		//System.out.println("=========> boardIdx : "+ boardIdx);
		System.out.println(board);
		
		// 뷰에서 보여주기위해 model에 추가
		model.addAttribute("board",board);
		
		return "board/boardDetail";
	}
	
	// board 수정
	@RequestMapping("/board/boardUpdate")
	public String boardUpdate(BoardDto board) {
		boardService.boardUpdate(board);
//		System.out.println("=========> boardIdx : "+ board.getBoardIdx());
//		System.out.println("=========> boardTitle : "+ board.getTitle());
		return "redirect:/board/boardList";
	}
	

	// board 삭제
	@RequestMapping("/board/boardDelete")
	// @RequestsParam("name명시") name이 같으면 명시해주지 않아도됨
	public String boardDelete(@RequestParam("boardIdx") int boardIdx) {
		boardService.boardDelete(boardIdx);
		return "redirect:/board/boardList";
	}
}