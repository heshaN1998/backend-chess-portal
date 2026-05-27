package com.checkmate_portal.chessclub.service;

import com.checkmate_portal.chessclub.EntityDtoConverter.PlayerConverter;
import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerConverter playerConverter;

    public PlayerService(PlayerRepository playerRepository, PlayerConverter playerConverter){
        this.playerRepository=playerRepository;
        this.playerConverter=playerConverter;
    }

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    public Optional<Player> getPlayerById(Long id){
        return playerRepository.findById(id);
    }

    public Player updatePlayer(Long id,Player updatePlayer){
        Player player=playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));

        player.setName(updatePlayer.getName());
        player.setCountry(updatePlayer.getCountry());
        player.setAge(updatePlayer.getAge());
        player.setFideRating(updatePlayer.getFideRating());
        player.setExperienceYears(updatePlayer.getExperienceYears());
        player.setLevel(updatePlayer.getLevel());

        return playerRepository.save(player);
    }
    public void deletePlayer(Long id){
        playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));
        playerRepository.deleteById(id);
    }

}
