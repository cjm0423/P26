package com.example.P26.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // 프론트엔드에서 POST /api/users/signup 으로 요청을 보내면 실행됨
    @PostMapping("/signup")
    public String signup(@RequestBody UserSignupRequest request) {
        User newUser = request.toEntity();
        userRepository.save(newUser);
        return "회원가입이 완료되었습니다!";
    }
}