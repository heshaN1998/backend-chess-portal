package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.dtos.PlayerRequestDTO;
import com.checkmate_portal.chessclub.dtos.PlayerResponseDTO;
import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.enums.Level;
import com.checkmate_portal.chessclub.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
@Tag(name = "Chess Players Management System",description ="for Rating up ELO")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }
    @Operation(summary = "SAVE NEW PLAYER")
    @PostMapping
    public PlayerResponseDTO createPlayer(@Valid @RequestBody PlayerRequestDTO requestDTO){
        return playerService.createPlayer(requestDTO);
    }
    @Operation(summary = "GET ALL PLAYERS")
    @GetMapping
    public List<PlayerResponseDTO> getAllPlayer(){
        return playerService.getAllPlayers();
    }
    @Operation(summary = "GET PLAYER BY ID")
    @GetMapping("/{id}")
    public PlayerResponseDTO getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }
    @Operation(summary = "UPDATE PLAYER")
    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayer(@Valid @PathVariable Long id,@RequestBody PlayerRequestDTO requestDTO){
        return playerService.updatePlayer(id,requestDTO);
    }
    @Operation(summary = "DELETE PLAYER")
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return "Player delete successfully";
    }
    @Operation(summary = "GET LIST ACCORDING TO COUNTRY")
    @GetMapping("country/{country}")
    public List<PlayerResponseDTO> getPlayerByCountry(@PathVariable String country){
        return playerService.getPlayerByCountry(country);

    }
    @Operation(summary = "GET LIST ACCORDING TO LEVEL")
    @GetMapping("/level/{level}")
    public  List<PlayerResponseDTO> getPlayerByLevel(@PathVariable Level level){
        return playerService.getPlayerByLevel(level);
    }
    @Operation(summary = "GET LIST ACCORDING TO RATING")
    @GetMapping("/rating/{rating}")
    public List<PlayerResponseDTO> getStrongPlayers(@PathVariable Integer rating){
        return playerService.findByGreaterFideRating(rating);
    }
    @Operation(summary = "GET LIST ASCENDING ORDER")
    @GetMapping("/paged")
    public Page<PlayerResponseDTO> getPlayers(Pageable pageable){
        return playerService.getPlayers(pageable);
    }


}
