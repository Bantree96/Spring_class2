package kr.inhatc.spring.board.service;

import java.util.List;

import kr.inhatc.spring.board.dto.BoardDto;

public interface BoardService {

	// 게시판 리스트 Dto
	List<BoardDto> boardList();
	
	// 게시글 작성 Dto
	void boardInsert(BoardDto board);

	// 게시글 상세 Dto
	BoardDto boardDetail(int boardIdx);

	// 게시글 업데이트 Dto
	void boardUpdate(BoardDto board);

	void boardDelete(int boardIdx);

}
