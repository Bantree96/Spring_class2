package kr.inhatc.spring.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.inhatc.spring.board.entity.Board;

public interface BoardService {

	List<Board> boardList();

	Board boardDetail(Integer idx);

	void saveBoard(Board board);

	void boardDelete(Integer boardIdx);

	Page<Board> boardPageList(Pageable pageable, String searchText);

}
