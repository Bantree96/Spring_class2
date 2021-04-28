package kr.inhatc.spring.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.user.entitiy.Users;
import kr.inhatc.spring.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Users> userList() {
		// findAll : List로 다 잡아온다.
		// userRepository.findAll()
		
		// findById : 특정 ID로 잡아온다. -> ID의 기준은 무엇?
		/*
		Optional<Users> result = userRepository.findById("");
		if(result.isPresent()) {
			Users user = result.get();
			user.getEmail();
		}
		*/
		
		// query를 알아서 만들어주는 부분
		List<Users> list = userRepository.findAllByOrderByIdDesc();
		return list;
	}

}
