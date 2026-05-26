package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.service.PlayerService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id,@RequestBody Player updatePlayer){
        return playerService.updatePlayer(id,updatePlayer);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return "Player delete successfully";
    }

}
