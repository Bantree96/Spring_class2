package kr.inhatc.spring.board.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// lombok사용 어노테이션
@Setter
@Getter
@Data
public class BoardDto {
	
	// DB컬럼명과 이름이 같아야함
	// 스네이크랑 카멜케이스 자동변경됨
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createId;
	private Date createDate;
}
