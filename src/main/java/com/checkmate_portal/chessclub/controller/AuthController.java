package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.entity.User;
import com.checkmate_portal.chessclub.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @GetMapping("/security/register")
    public String register(@RequestBody User user){
        return authService.register(user);
    }

    @GetMapping
    public String login(@RequestBody User user){
        return authService.login(user.getUserName(),user.getPassword());
    }
}
