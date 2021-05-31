package kr.inhatc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.inhatc.spring.board.entity.Board;
import kr.inhatc.spring.board.service.BoardService;
import kr.inhatc.spring.user.entity.Users;

@Controller
public class BoardController {

	// logger
	// private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;

//	@GetMapping("/board/boardList")
//	public String boardList(Model model) {
//		List<Board> list = boardService.boardList();
//		model.addAttribute("list", list);
//		return "board/boardList";
//	}
	@GetMapping("/board/boardList")
	public void boardList(Model model,
			@PageableDefault(size=1)Pageable pageable,								// 페이징 초기값 2 지정
			@RequestParam(required = false, defaultValue = "") String searchText){ 	// 검색 초기값 "" 지정
		Page<Board> list = boardService.boardPageList(pageable, searchText);
		
		int startPage = Math.max(1, list.getPageable().getPageNumber() - 4);
		int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber() + 4);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);

		//return "board/boardList";
	}

	// boardInsert
	@RequestMapping("/board/boardWrite")
	public String boardWrite(Model model) {
		return "board/boardWrite";
	}

	@RequestMapping(value = "/board/boardInsert", method=RequestMethod.POST)
	public String boardInsert(Board board) {
		System.out.println("================>"+board);
		boardService.saveBoard(board);
		return "redirect:/board/boardList";
	}
	
	// boardDetail
	@RequestMapping(value = "/board/boardDetail/{boardidx}", method = RequestMethod.GET)
	// @PathVariable : 경로로 넘어온것을 변수로 사용하고싶을때 사용한다.
	public String userDetail(@PathVariable("boardidx") Integer boardIdx, Model model) {
		Board board = boardService.boardDetail(boardIdx);
		model.addAttribute("board", board);
		System.out.println("================>" + board);
		return "board/boardDetail";
	}
	
	@RequestMapping(value = "/board/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(Board board) {
		boardService.saveBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardDelete/{boardIdx}", method=RequestMethod.GET)
	public String boardDelete(@PathVariable("boardIdx") Integer boardIdx) {
		boardService.boardDelete(boardIdx);
		return "redirect:/board/boardList";
	}
}
