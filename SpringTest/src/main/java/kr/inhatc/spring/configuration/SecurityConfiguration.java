package kr.inhatc.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// WebSecurityConfigurerAdapter는 추상클래스
// 추상메소드를 불러와 사용한다.
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/", "/user/userWrite", "/user/userInsert").permitAll(); 	// 누구나 접근 가능
		security.authorizeRequests().antMatchers("/user/**", "/board/**", "/datasetBoard/**", "/diy/**").hasRole("ADMIN"); 				// ADMIN 접근 가능
		security.authorizeRequests().antMatchers("/board/**", "/datasetBoard/**", "/diy/**").hasAnyRole("ADMIN","MEMBER"); 				// ADMIN,MEMBER 접근 가능
		
		// RESTfull 을 사용하기 위해서는 비활성화 (중요함!!) 
		security.csrf().disable(); 
				
		// 시스템이 만든 로그인 페이지
		//security.formLogin();
		
		// .loginPage : 내가 만든 로그인 페이지로 접속
		// .defaultSuccessUrl : 로그인 성공시 원하는 URL접속
		security.formLogin().loginPage("/login/login").defaultSuccessUrl("/", true);
		
		// 접근하지 못할 때 
		security.exceptionHandling().accessDeniedPage("/login/accessDenied");
		
		// 로그아웃
		security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		
	}
	
	// 비밀번호 암호화
	// 개요 : 패스워드에 암호화 처리
	// 처리내용 : 암호화 처리
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
