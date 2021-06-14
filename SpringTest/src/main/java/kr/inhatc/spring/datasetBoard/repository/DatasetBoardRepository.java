package kr.inhatc.spring.datasetBoard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.datasetBoard.entity.DatasetBoard;

public interface DatasetBoardRepository extends JpaRepository<DatasetBoard, Integer> {
	
	List<DatasetBoard> findAllByOrderByBoardIdxDesc();

	Page<DatasetBoard> findByTitleContainingOrContentsContainingOrderByBoardIdxDesc(String searchText,
			String searchText2, Pageable pageable);
}
