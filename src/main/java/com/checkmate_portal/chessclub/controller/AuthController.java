package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.entity.User;
import com.checkmate_portal.chessclub.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/security")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return authService.login(user.getUserName(),user.getPassword());
    }
}
