package com.checkmate_portal.chessclub.service;

import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
}
