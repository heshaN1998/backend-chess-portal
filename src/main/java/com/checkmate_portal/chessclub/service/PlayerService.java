package com.checkmate_portal.chessclub.service;

import com.checkmate_portal.chessclub.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }
}
