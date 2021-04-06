package kr.inhatc.spring.board.service;

import java.util.List;

import kr.inhatc.spring.board.dto.BoardDto;

public interface BoardService {

	// 게시판 리스트 Dto
	List<BoardDto> boardList();
	
	// 게시글 작성 Dto
	void boardInsert(BoardDto board);

}
