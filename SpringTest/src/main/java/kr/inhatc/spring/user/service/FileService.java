package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.inhatc.spring.user.entity.FileDto;

public interface FileService {
	FileDto fileDetail(String id);

	void fileDelete(FileDto file);

	List<FileDto> fileList();

}
