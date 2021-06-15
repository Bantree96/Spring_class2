package kr.inhatc.spring.datasetBoard.service;

import java.io.File;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.datasetBoard.entity.DatasetBoard;
import kr.inhatc.spring.datasetBoard.entity.DatasetFileDto;
import kr.inhatc.spring.datasetBoard.entity.ThumbFileDto;

public interface DatasetBoardService {

	List<DatasetBoard> boardList();

	Page<DatasetBoard> boardPageList(Pageable pageable, String searchText);

	void saveDataset(DatasetBoard dataset, MultipartHttpServletRequest multipartHttpServletRequest);

	List<DatasetFileDto> fileList();

	DatasetFileDto getFile(int fileId);

	List<ThumbFileDto> thumbList();

}
