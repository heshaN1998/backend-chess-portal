package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.dtos.PlayerRequestDTO;
import com.checkmate_portal.chessclub.dtos.PlayerResponseDTO;
import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.enums.Level;
import com.checkmate_portal.chessclub.service.PlayerService;
import jakarta.validation.Valid;
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
    public PlayerResponseDTO createPlayer(@Valid @RequestBody PlayerRequestDTO requestDTO){
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
    public PlayerResponseDTO updatePlayer(@Valid @PathVariable Long id,@RequestBody PlayerRequestDTO requestDTO){
        return playerService.updatePlayer(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return "Player delete successfully";
    }
    @GetMapping("country/{country}")
    public List<PlayerResponseDTO> getPlayerByCountry(@PathVariable String country){
        return playerService.getPlayerByCountry(country);

    }
    @GetMapping("/level/{level}")
    public  List<PlayerResponseDTO> getPlayerByLevel(@PathVariable Level level){
        return playerService.getPlayerByLevel(level);
    }
    @GetMapping("/rating/{rating}")
    public List<PlayerResponseDTO> getStrongPlayers(@PathVariable Integer rating){
        return playerService.findByGreaterFideRating(rating);
    }


}
