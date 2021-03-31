package kr.inhatc.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inhatc.spring.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> boardList();

}
