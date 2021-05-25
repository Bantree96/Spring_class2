package kr.inhatc.spring.user.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.inhatc.spring.user.entity.FileDto;

public interface FileRepository extends JpaRepository<FileDto, Integer> {

	Optional<FileDto> findByUserId(String userId);

	void deleteByUserId(String userId);

	List<FileDto> findAllByOrderByUserIdDesc();
	
	
}
