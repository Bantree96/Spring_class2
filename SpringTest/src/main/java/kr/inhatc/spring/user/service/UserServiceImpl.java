package kr.inhatc.spring.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.user.entity.Users;
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

	@Override
	public void saveUsers(Users user) {
		userRepository.save(user);
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



}
