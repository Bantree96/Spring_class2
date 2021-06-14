package kr.inhatc.spring.datasetBoard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.datasetBoard.entity.datasetBoard;

public interface DatasetBoardRepository extends JpaRepository<datasetBoard, Integer> {
	
	List<datasetBoard> findAllByOrderByBoardIdxDesc();
}
