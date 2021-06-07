package kr.inhatc.spring.login.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.inhatc.spring.user.entity.Users;

public class SecurityUser extends User {

	// 유저 초기화 하기위해 멤버로 만든다.
	private Users user;
	
	// 최소한의 유저정보
	public SecurityUser(Users user) {
		// 암호화 처리 전까지는 패스워드 앞에 {noop} 추가해야한다.
		//super(user.getId(), "{noop}"+user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));
		
		// AuthorityUtils : 권한 리스트를 만들어준다. 
		super(user.getId(), user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));
	
		// 생성자 부분 다 채우고 this로 내 자신을 초기화
		this.user = user;
	} 

}
