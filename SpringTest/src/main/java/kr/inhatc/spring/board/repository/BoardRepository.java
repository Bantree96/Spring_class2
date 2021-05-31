package kr.inhatc.spring.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	List<Board> findAllByOrderByBoardIdxDesc();

	Page<Board> findByTitleContainingOrContentsContaining(String searchText, String searchText2, Pageable pageable);
}
