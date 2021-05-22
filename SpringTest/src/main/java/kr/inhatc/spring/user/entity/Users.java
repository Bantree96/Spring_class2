package kr.inhatc.spring.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 				// table을 만들고 싶을때 엔티티 객체로 생성
@Table(name = "users") 	// 테이블 명 users로 지정
@NoArgsConstructor 		// 디폴트 생성자
@AllArgsConstructor		// 전체 컬럼 생성자
//@Data 				// get,set
@Getter				
@ToString
@Builder				// 객체생성을 도와주는 도구
public class Users {
	

	@Id // 기본키
	//@GeneratedValue 			// 숫자 autoIncrease 가능
	@Column(name = "USER_ID") 	// 컬럼명 지정
	private String id;
	private String pw;
	@Column(length = 20)
	private String name;
	private String email;
	
	// date 처리
	@Temporal(TemporalType.TIMESTAMP)
	// columnDefinition : default값
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date joinDate;
	
	private String enabled;
	private String role;
}
