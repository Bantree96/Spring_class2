package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.user.entity.Users;

public interface UserService {

	List<Users> userList();

	void saveUsers(Users user, MultipartHttpServletRequest multipartHttpServletRequest);

	Users userDetail(String id);

	void userDelete(String id);

	Page<Users> userPageList(Pageable pageable, String searchText);
}
