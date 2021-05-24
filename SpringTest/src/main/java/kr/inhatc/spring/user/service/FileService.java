package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.inhatc.spring.user.entity.FileDto;

public interface FileService {

	List<FileDto> fileDetail(String id);

}
