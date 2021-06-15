package kr.inhatc.spring.datasetBoard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ThumbFileDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;
	
	private int datasetIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
}
