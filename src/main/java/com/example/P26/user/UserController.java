package com.example.P26.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody UserSignupRequest request) {
        User newUser = request.toEntity();
        userRepository.save(newUser);
        return "회원가입이 완료되었습니다!";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        // 1. DB에서 해당 아이디의 유저가 있는지 확인
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> user.getPassword().equals(request.getPassword())) // 2. 비밀번호 일치 확인
                .map(user -> "로그인 성공! 환영합니다, " + user.getUsername() + "님.")
                .orElse("로그인 실패: 아이디 또는 비밀번호가 틀렸습니다.");
    }
}