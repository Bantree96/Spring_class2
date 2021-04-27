package kr.inhatc.spring.user.service;

import java.util.List;

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
		// findAll 다 땡겨온다.
//		userRepository.findAll()
		List<Users> list = userRepository.findAllByOrderByIdDesc();
		return list;
	}

}
