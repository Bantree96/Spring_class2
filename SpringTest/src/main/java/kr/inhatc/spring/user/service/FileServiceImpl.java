package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public List<FileDto> fileDetail(String UserId) {
		List<FileDto> list = fileRepository.findAll();
		return list;
	}

}
