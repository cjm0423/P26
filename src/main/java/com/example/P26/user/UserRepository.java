package com.example.P26.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 아이디(username)로 유저를 찾는 메서드 정의 (JPA가 알아서 쿼리를 만들어줍니다!)
    Optional<User> findByUsername(String username);
}