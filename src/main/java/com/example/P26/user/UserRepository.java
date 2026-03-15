package com.example.P26.user;

import org.springframework.data.jpa.repository.JpaRepository;

// 이 인터페이스 하나만 만들면 기본적인 DB 저장, 조회 기능이 완성됩니다.
public interface UserRepository extends JpaRepository<User, Long> {
}