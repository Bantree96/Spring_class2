package kr.inhatc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	List<Board> findAllByOrderByBoardIdxDesc();
}
