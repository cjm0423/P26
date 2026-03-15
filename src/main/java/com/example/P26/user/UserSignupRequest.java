package com.example.P26.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupRequest {
    private String username;
    private String password;
    private String email;

    // 전달받은 데이터를 DB에 넣을 User 엔티티로 변환
    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}