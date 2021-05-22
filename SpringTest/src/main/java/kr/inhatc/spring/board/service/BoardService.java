package kr.inhatc.spring.board.service;

import java.util.List;

import kr.inhatc.spring.board.entity.Board;

public interface BoardService {

	List<Board> boardList();

	Board boardDetail(Integer idx);

	void saveBoard(Board board);

}
