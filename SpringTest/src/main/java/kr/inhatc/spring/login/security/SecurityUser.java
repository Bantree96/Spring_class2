package kr.inhatc.spring.login.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.inhatc.spring.user.entity.Users;

public class SecurityUser extends User {

	private Users user;
	
	// 최소한의 유저정보
	public SecurityUser(Users user) {
		// 암호화 처리 전까지는 패스워드 앞에 {noop} 추가해야한다.
		super(user.getId(), user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));
		this.user = user;
	} 

}
