package com.checkmate_portal.chessclub.controller;

import com.checkmate_portal.chessclub.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashbord")
public class DashbordController {
    private final PlayerService playerService;
    public DashbordController(PlayerService playerService) {
        this.playerService = playerService;
    }
    
    @GetMapping("/stats")
    public Map<String,Object> getStats(){
        Map<String,Object> stats=new HashMap<>();
        stats.put("totalPlayers",playerService.getTotalPlayers());
        stats.put("averageRating",playerService.getAverageRating());
        stats.put("topPlayer",playerService.getTopPlayer());
        return stats;
    }

}
