package kr.inhatc.spring.datasetBoard.controll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.datasetBoard.entity.DatasetBoard;
import kr.inhatc.spring.datasetBoard.entity.DatasetFileDto;
import kr.inhatc.spring.datasetBoard.service.DatasetBoardService;


@Controller
public class DatasetBoardController {

	@Autowired
	private DatasetBoardService datasetBoardService; 
	
	@Autowired
	private DatasetBoardService dataset;
	
	@GetMapping("/datasetBoard/datasetBoardList")
	public void datasetBoardList(Model model,
			@PageableDefault(size=5)Pageable pageable,								// 페이징 초기값 2 지정
			@RequestParam(required = false, defaultValue = "") String searchText){ 	// 검색 초기값 "" 지정
		Page<DatasetBoard> list = datasetBoardService.boardPageList(pageable, searchText);
		
		int startPage = Math.max(1, list.getPageable().getPageNumber() - 4);
		int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber() + 4);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		List<DatasetFileDto> file = dataset.fileList();
		System.out.println("===============>"+file);
		model.addAttribute("file", file);
	}
	
	@GetMapping("/datasetBoard/datasetBoardWrite")
	public void datasetBoardList(Model model) {
	}
	
	@PostMapping("/datasetBoard/datasetBoardInsert")
	public String datasetBoardInsert(DatasetBoard dataset, MultipartHttpServletRequest multipartHttpServletRequest) {
		
		datasetBoardService.saveDataset(dataset, multipartHttpServletRequest);
		return "redirect:/datasetBoard/datasetBoardList";
	}
	
	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> fileDownload(@PathVariable("fileId") int fileId) throws IOException {
	    DatasetFileDto file = dataset.getFile(fileId);
	    Path path = Paths.get(file.getStoredFilePath());
	    Resource resource = new InputStreamResource(Files.newInputStream(path));
	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFileName() + "\"")
	            .body(resource);
	}
}
