/**
 * DB에 있는 유저 정보로 로그인 하기위해 필요
 */
package kr.inhatc.spring.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.login.security.SecurityUser;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

@Service
public class SecurityUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optional = userRepository.findById(username); // 여기서 username은 우리가 만든 사용자id
		// isPresent : 존재한다면(값을 가져왔다면)
		if(optional.isPresent()) {
			Users user = optional.get();
			return new SecurityUser(user);
		} else {
			throw new UsernameNotFoundException(username + "사용자 없음!!");
		}
	}
}
