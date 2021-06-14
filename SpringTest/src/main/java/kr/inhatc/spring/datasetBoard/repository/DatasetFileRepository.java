package kr.inhatc.spring.datasetBoard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.datasetBoard.entity.DatasetFileDto;

public interface DatasetFileRepository extends JpaRepository<DatasetFileDto, Integer>{

	List<DatasetFileDto> findAllByOrderByDatasetIdxDesc();

	Optional<DatasetFileDto> findByDatasetIdx(int fileId);


}
