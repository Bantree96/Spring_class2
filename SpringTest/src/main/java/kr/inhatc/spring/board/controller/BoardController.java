package kr.inhatc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.board.entity.Board;
import kr.inhatc.spring.board.service.BoardService;

@Controller
public class BoardController {

	// logger
	// private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;

	@RequestMapping("/board/boardList")
	public String boardList(Model model) {
		List<Board> list = boardService.boardList();
		model.addAttribute("list", list);
		return "board/boardList";
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
