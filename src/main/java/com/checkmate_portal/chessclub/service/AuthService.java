package com.checkmate_portal.chessclub.service;

import com.checkmate_portal.chessclub.JwtUtil;
import com.checkmate_portal.chessclub.entity.User;
import com.checkmate_portal.chessclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    //Register Section
    public Map<String, String> register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUserName());
        return Map.of("message", "User Registered Success", "token", token);
    }

    //Logic Section
    public Map<String, String> login(String userName, String password) {

        User user = userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtil.generateToken(userName);
        return Map.of("message", "Login Success", "token", token);
    }
}



