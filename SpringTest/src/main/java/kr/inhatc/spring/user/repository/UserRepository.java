package kr.inhatc.spring.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.user.entity.Users;

@Repository
// CrudRepository보다 JpaRepository를 쓰는게 더 좋다. 
// 사용 할 수 있는게 많음
// CrudRepository<테이블명, ID의 타입값>
public interface UserRepository extends JpaRepository<Users, String> {

	List<Users> findAllByOrderByIdDesc();

	// 페이징
	Page<Users> findByIdContainingOrNameContaining(String id, String name, Pageable pageable);

}
