package kr.inhatc.spring.board.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// lombok사용 어노테이션
//@Setter
//@Getter
@Data
public class BoardDto {
	
	// DB컬럼명과 이름이 같아야함
	// 스네이크랑 카멜케이스 자동변경됨
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createId;
	private String createDate;
	
	// 파일 보여주기 위해 파일리스트 만들어줌
	private List<FileDto> fileList;
}
