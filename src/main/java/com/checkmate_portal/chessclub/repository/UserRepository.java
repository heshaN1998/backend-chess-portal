package com.checkmate_portal.chessclub.repository;

import com.checkmate_portal.chessclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
    Optional<User> findByUserName(String username);
}
