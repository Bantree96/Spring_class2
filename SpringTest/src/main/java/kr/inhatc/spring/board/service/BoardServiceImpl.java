package kr.inhatc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.mapper.BoardMapper;

// 서비스쪽은 일반적으로 @Service를 적어줌
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDto> boardList() {
		return boardMapper.boardList();
	}

	@Override
	public void boardInsert(BoardDto board) {
		boardMapper.boardInsert(board);
	}

	@Override
	public BoardDto boardDetail(int boardIdx) {
		BoardDto board = boardMapper.boardDetail(boardIdx);
		// 조회수 추가기능
		boardMapper.updateHit(boardIdx);
		return board;
	}

	@Override
	public void boardUpdate(BoardDto board) {
		boardMapper.boardUpdate(board);
	}

	@Override
	public void boardDelete(int boardIdx) {
		boardMapper.boardDelete(boardIdx);
		
	}

}
