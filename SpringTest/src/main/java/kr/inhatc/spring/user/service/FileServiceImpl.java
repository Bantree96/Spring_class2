package kr.inhatc.spring.user.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public FileDto fileDetail(String UserId) {
		//System.out.println("================>2 : "+UserId);
		Optional<FileDto> optional = fileRepository.findByUserId(UserId);
		//System.out.println("================>3 : "+optional);
		if(optional.isPresent()) {
			FileDto file = optional.get();
			//System.out.println("================>4 : "+file);
			return file;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	@Transactional // Transaction에러를 잡아준다 * 필수 
	public void fileDelete(FileDto file) {
		fileRepository.deleteByUserId(file.getUserId());
		
		File deleteFile = new File("src/main/resources/static"+file.getStoredFilePath());
		//System.out.println("=============>" + deleteFile);
		deleteFile.delete();
		//System.out.println("=============> 파일삭제");
		
	}

	@Override
	public List<FileDto> fileList() {
		List<FileDto> list = fileRepository.findAllByOrderByUserIdDesc();
		return list;
	}

}
