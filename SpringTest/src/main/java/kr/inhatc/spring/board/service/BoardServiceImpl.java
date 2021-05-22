package kr.inhatc.spring.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.board.entity.Board;
import kr.inhatc.spring.board.repository.BoardRepository;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

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
			return board;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void saveBoard(Board board) {
		boardRepository.save(board);
		
	}
	
}
