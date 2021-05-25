package kr.inhatc.spring.user.service;

import java.util.List;
import java.util.Optional;

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
		System.out.println("================>2 : "+UserId);
		Optional<FileDto> optional = fileRepository.findByUserId(UserId);
		System.out.println("================>3 : "+optional);
		if(optional.isPresent()) {
			FileDto file = optional.get();
			System.out.println("================>4 : "+file);
			return file;
		} else {
			throw new NullPointerException();
		}
	}

}
