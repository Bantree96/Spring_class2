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

import kr.inhatc.spring.user.entity.FileDto;


@Component
public class FileUtils {
	public List<FileDto> parseFileInfo(String userId, MultipartHttpServletRequest multipartHttpServletRequest){
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		List<FileDto> fileList = new ArrayList<FileDto>();
		
		// 파일이 업로드될 폴더 생성
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now(); // 현재날짜를 current로 가져옴
		String path = "images/" + current.format(format); // images/현재날짜 폴더경로 정해줌
		
		File file = new File(path); // 정해준 폴더 경로에 파일 생성
		
		// 폴더가 없으면 폴더 생성
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		
		// 원래 확장자
		String originalFileExtension = null;
		
		// 원소가 있을때 까지 불러옴
		while(iter.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iter.next());
			
			for(MultipartFile multipartFile : list) {
				// 파일이 있다면
				if(multipartFile.isEmpty() == false) {
					
					// 확장자로 인한 처리를 하고 싶어서 만든 부분
					String contentType = multipartFile.getContentType(); // 타입을 가져옴
					
					// 확장자가 없다면
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					
					//확장자 정보 생성
					} else {
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}
					
					// 새 파일 이름
					String newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					
					// DB에 저장할 정보들
					FileDto userFile = new FileDto();
					userFile.setUserId(userId);
					userFile.setFileSize(multipartFile.getSize());
					userFile.setOriginalFileName(multipartFile.getOriginalFilename());
					userFile.setStoredFilePath(path + "/" + newFileName);
					fileList.add(userFile);
					
					file = new File(path + "/" + newFileName);
					
					// 파일 예외처리
					try {
						multipartFile.transferTo(file); // 실제 파일 만들어 저장 ( 가장중요 )
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
			}
		}
		return fileList;
		
	}
}
