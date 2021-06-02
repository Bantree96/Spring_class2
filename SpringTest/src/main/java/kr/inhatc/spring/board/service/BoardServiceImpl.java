package kr.inhatc.spring.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.board.entity.Board;
import kr.inhatc.spring.board.repository.BoardRepository;
import kr.inhatc.spring.user.entity.Users;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public List<Board> boardList() {
		List<Board> list = boardRepository.findAllByOrderByBoardIdxDesc();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Board boardDetail(Integer boardIdx) {
		Optional<Board> optional = boardRepository.findById(boardIdx);
		if(optional.isPresent()) {
			Board board = optional.get();
			// 조회수 +1
			board.setHitCnt(board.getHitCnt()+1);
			boardRepository.save(board);
			return board;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void saveBoard(Board board) {
		boardRepository.save(board);
		
	}

	@Override
	public void boardDelete(Integer boardIdx) {
		boardRepository.deleteById(boardIdx);
	}

	@Override
	public Page<Board> boardPageList(Pageable pageable, String searchText) {
		Page<Board> list = boardRepository.findByTitleContainingOrContentsContainingOrderByBoardIdxDesc(searchText, searchText, pageable);
		
		return list;
	}
	
}
