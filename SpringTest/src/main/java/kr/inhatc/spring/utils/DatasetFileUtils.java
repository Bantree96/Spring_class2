package kr.inhatc.spring.utils;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.datasetBoard.entity.DatasetFileDto;
import kr.inhatc.spring.user.entity.FileDto;


@Component
public class DatasetFileUtils {
	public List<DatasetFileDto> parseFileInfo(int datasetIdx, MultipartFile multipartFile2){
		if(ObjectUtils.isEmpty(multipartFile2)) {
			return null;
		}
		
		List<DatasetFileDto> fileList = new ArrayList<DatasetFileDto>();
		
		// 파일이 업로드될 폴더 생성
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now(); 									// 현재날짜를 current로 가져옴
		String path = "src/main/resources/static/dataset/" + current.format(format); 	// images/현재날짜 폴더경로 정해줌
		String savePath = "/dataset/"+ current.format(format); 							// 이미지를 불러올 DB에 저장될 경로
		File file = new File(path); 													// 정해준 폴더 경로에 파일 생성
		
		// 폴더가 없으면 폴더 생성
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		
		// 원래 확장자
		String originalFileExtension = null;
		
		
		// 새 파일 이름
		String newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
		
		// DB에 저장할 정보들
		DatasetFileDto dataset = new DatasetFileDto();
		dataset.setDatasetIdx(datasetIdx);
		dataset.setFileSize(multipartFile2.getSize());
		dataset.setOriginalFileName(multipartFile2.getOriginalFilename());
		dataset.setStoredFilePath(path+"/" + multipartFile2.getOriginalFilename());
		fileList.add(dataset);
		
		file = new File(path + "/" + multipartFile2.getOriginalFilename());
		
		// 파일 예외처리
		try {
			multipartFile2.transferTo(file); // 실제 파일 만들어 저장 ( 가장중요 )
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
					
		
	
		return fileList;
		
	}

	
}
