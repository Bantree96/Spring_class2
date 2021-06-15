package kr.inhatc.spring.datasetBoard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.datasetBoard.entity.ThumbFileDto;

public interface DatasetThumbRepository extends JpaRepository<ThumbFileDto, Integer> {

	List<ThumbFileDto> findAllByOrderByDatasetIdxDesc();

}
