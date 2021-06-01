package kr.inhatc.spring.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.FileRepository;
import kr.inhatc.spring.user.repository.UserRepository;
import kr.inhatc.spring.utils.FileUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<Users> userList() {
		// query를 알아서 만들어주는 부분
		List<Users> list = userRepository.findAllByOrderByIdDesc();
		return list;
	}

	@Override
	public void saveUsers(Users user, MultipartHttpServletRequest multipartHttpServletRequest) {
		System.out.println("=============>"+ multipartHttpServletRequest);
		userRepository.save(user);
		
		// 1. 파일 저장
		List<FileDto> list = fileUtils.parseFileInfo(user.getId(), multipartHttpServletRequest);
		// 2. DB 저장
		if(CollectionUtils.isEmpty(list) == false) {
			fileRepository.saveAll(list);
		}
	}

	@Override
	public Users userDetail(String id) {
		// id를 찾아 optional 객체로 불러옴
		// 여러개면 리스트로 받아온다.
		// return은 있거나 없거나
		Optional<Users> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			Users user = optional.get();
			return user;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void userDelete(String id) {
		userRepository.deleteById(id);
	}


	@Override
	public Page<Users> userPageList(Pageable pageable, String searchText) {
		int batch = 2;
		int startIdx = 0;
		Page<Users> list = userRepository.findByIdContainingOrNameContaining(searchText, searchText, pageable);
		
		return list;
	}


}
