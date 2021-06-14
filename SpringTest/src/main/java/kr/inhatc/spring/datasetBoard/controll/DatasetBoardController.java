package kr.inhatc.spring.datasetBoard.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.inhatc.spring.datasetBoard.entity.datasetBoard;
import kr.inhatc.spring.datasetBoard.service.DatasetBoardService;


@Controller
public class DatasetBoardController {

	@Autowired
	private DatasetBoardService datasetBoardService; 
	
	@GetMapping("/datasetBoard/datasetBoardList")
	public void datasetBoardList(Model model) {
		List<datasetBoard> list = datasetBoardService.boardList();
	}
}
