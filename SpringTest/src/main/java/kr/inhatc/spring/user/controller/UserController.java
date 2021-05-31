package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;
import kr.inhatc.spring.user.service.FileService;
import kr.inhatc.spring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
// 맵핑을 따로 해줄 수 있다.
@RequestMapping("/user")
// 필요한 객체를 올려줄 껀데 @Autowird를 안쓰면 final로 써야한다.
@RequiredArgsConstructor
public class UserController {
	
	// logger
	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Log
	//Log.info("===================> 리스트 수행중..."); 
	
	// 유저 서비스
	@Autowired
	private UserService userService;
	
	// 파일 서비스
	@Autowired
	private FileService fileService;
	
	// GET(read), POST(create), PUT(update), DELETE(delete) = restful
	// 아래 두 표현은 같다.
	// @RequestMapping(value = "/user/userList", method=RequestMethod.GET)
//	@GetMapping("/userList")
//	public void userList(Model model) {
//		List<Users> list = userService.userList(); 
//		model.addAttribute("list", list);
//		
//		List<FileDto> file = fileService.fileList();
//		System.out.println("==================> : "+file);
//		model.addAttribute("file", file);
//		//return "user/userList";
//	}
	
	@GetMapping("/userList")
	public void userList(Model model,
			@PageableDefault(size=1)Pageable pageable,								// 페이징 초기값 2 지정
			@RequestParam(required = false, defaultValue = "") String searchText){ 	// 검색 초기값 "" 지정
		Page<Users> list = userService.userPageList(pageable, searchText); 
		
		int startPage = Math.max(1, list.getPageable().getPageNumber() - 4);
		int endPage = Math.min(list.getTotalPages(), list.getPageable().getPageNumber() + 4);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		List<FileDto> file = fileService.fileList();
		System.out.println("==================> : "+file);
		model.addAttribute("file", file);
				
	}
	////////////////////////////////////////////////////////////////////
	
	// 바이패스로 이동만 할 경우 GetMapping으로 하면 편리하다. 
	@GetMapping({ "/test", "/test2" })
	public void test() {
	}
	
	// 유저 추가 페이지로 가기
	@RequestMapping(value = "/userWrite", method=RequestMethod.GET)
	public String userWrite() {
		return "/user/userWrite";
	}
	
	// 유저 추가
	@RequestMapping(value = "/userInsert", method=RequestMethod.POST)
	public String userInsert(Users user, MultipartHttpServletRequest multipartHttpServletRequest) {
		userService.saveUsers(user, multipartHttpServletRequest);
		return "redirect:/user/userList";
	}
	
	// 유저 상세보기
	@RequestMapping(value = "/userDetail/{id}", method=RequestMethod.GET)
	// @PathVariable : 경로로 넘어온것을 변수로 사용하고싶을때 사용한다.
	public String userDetail(@PathVariable("id") String id, Model model) {
		Users user = userService.userDetail(id);
		System.out.println("================>"+id);

		FileDto file = fileService.fileDetail(id);
		
		model.addAttribute("user", user);
		System.out.println("================>"+user);
		
		model.addAttribute("file", file);
		
		return "/user/userDetail";
	}
	
	// 유저 수정
	@RequestMapping(value = "/userUpdate", method=RequestMethod.POST)
	public String userUpdate(Users user, MultipartHttpServletRequest multipartHttpServletRequest) {
		userService.saveUsers(user, multipartHttpServletRequest);
		return "redirect:/user/userList";
	}
	
	// 유저 삭제
	@RequestMapping(value = "/userDelete/{id}", method=RequestMethod.GET)
	public String userDelete(@PathVariable("id") String id) {
		FileDto file = fileService.fileDetail(id);
		fileService.fileDelete(file);
		userService.userDelete(id);
		return "redirect:/user/userList";
	}
	
}
