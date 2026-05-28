package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.dtos.PlayerRequestDTO;
import com.checkmate_portal.chessclub.dtos.PlayerResponseDTO;
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
    public PlayerResponseDTO createPlayer(@RequestBody PlayerRequestDTO requestDTO){
        return playerService.createPlayer(requestDTO);
    }

    @GetMapping
    public List<PlayerResponseDTO> getAllPlayer(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerResponseDTO getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayer(@PathVariable Long id,@RequestBody PlayerRequestDTO requestDTO){
        return playerService.updatePlayer(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return "Player delete successfully";
    }

}
