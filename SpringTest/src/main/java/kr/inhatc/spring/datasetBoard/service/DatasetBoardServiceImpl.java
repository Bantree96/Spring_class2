package kr.inhatc.spring.datasetBoard.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.datasetBoard.entity.DatasetBoard;
import kr.inhatc.spring.datasetBoard.entity.DatasetFileDto;
import kr.inhatc.spring.datasetBoard.repository.DatasetBoardRepository;
import kr.inhatc.spring.datasetBoard.repository.DatasetFileRepository;
import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.utils.DatasetFileUtils;
import kr.inhatc.spring.utils.FileUtils;

@Service
public class DatasetBoardServiceImpl implements DatasetBoardService{

	@Autowired
	DatasetBoardRepository datasetBoardRepository;
	
	@Autowired
	DatasetFileRepository datasetFileRepository;
	
	@Autowired
	private DatasetFileUtils fileUtils;
	
	@Override
	public List<DatasetBoard> boardList() {
		List<DatasetBoard> list = datasetBoardRepository.findAllByOrderByBoardIdxDesc();
		return list;
	}

	@Override
	public Page<DatasetBoard> boardPageList(Pageable pageable, String searchText) {
		Page<DatasetBoard> list = datasetBoardRepository.findByTitleContainingOrContentsContainingOrderByBoardIdxDesc(searchText, searchText, pageable);

		return list;
	}

	@Override
	public void saveDataset(DatasetBoard dataset, MultipartHttpServletRequest multipartHttpServletRequest) {
		System.out.println("==============>"+ multipartHttpServletRequest.getFile("dataset"));
		
		datasetBoardRepository.save(dataset);
		
		// 1. 파일 저장
		List<DatasetFileDto> list = fileUtils.parseFileInfo(dataset.getBoardIdx(), multipartHttpServletRequest.getFile("dataset"));
		// 2. DB 저장
		if(CollectionUtils.isEmpty(list) == false) {
			datasetFileRepository.saveAll(list);
		}
		
	}

	@Override
	public List<DatasetFileDto> fileList() {
		List<DatasetFileDto> list = datasetFileRepository.findAllByOrderByDatasetIdxDesc();
		return list;
	}

	@Transactional
	public DatasetFileDto getFile(int fileId) {
		Optional<DatasetFileDto> optional = datasetFileRepository.findByDatasetIdx(fileId);
		if(optional.isPresent()) {
			DatasetFileDto file = optional.get();
			return file;
		} else {
			throw new NullPointerException();
		}
	}
	

}
