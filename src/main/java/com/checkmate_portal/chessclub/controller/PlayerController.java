package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.service.PlayerService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
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

    @GetMapping
    public Optional<Player> getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @PutMapping
    public Player update(@PathVariable Long id,@RequestBody Player updatePlayer){
        return playerService.updatePlayer(id,updatePlayer);
    }

    public String deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return "Player delete successfully";
    }




}
