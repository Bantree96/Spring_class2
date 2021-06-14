package kr.inhatc.spring.datasetBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.datasetBoard.entity.datasetBoard;
import kr.inhatc.spring.datasetBoard.repository.DatasetBoardRepository;

@Service
public class DatasetBoardServiceImpl implements DatasetBoardService{

	@Autowired
	DatasetBoardRepository datasetBoardRepository;
	
	@Override
	public List<datasetBoard> boardList() {
		List<datasetBoard> list = datasetBoardRepository.findAllByOrderByBoardIdxDesc();
		return list;
	}

}
