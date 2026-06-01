package com.checkmate_portal.chessclub.service;

import com.checkmate_portal.chessclub.EntityDtoConverter.PlayerConverter;
import com.checkmate_portal.chessclub.dtos.PlayerRequestDTO;
import com.checkmate_portal.chessclub.dtos.PlayerResponseDTO;
import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.enums.Level;
import com.checkmate_portal.chessclub.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerConverter playerConverter;


    public PlayerService(PlayerRepository playerRepository, PlayerConverter playerConverter){
        this.playerRepository=playerRepository;
        this.playerConverter=playerConverter;
    }

    public PlayerResponseDTO createPlayer(PlayerRequestDTO requestDTO){
        Player player=playerConverter.rquestDtoToEntity(requestDTO);
        Player savedPlayer=playerRepository.save(player);
        return playerConverter.entityToDtos(savedPlayer);
    }
    public List<PlayerResponseDTO> getAllPlayers(){
        List<Player> players=playerRepository.findAll();
        return players.stream().map(playerConverter::entityToDtos).toList();
    }
    public PlayerResponseDTO getPlayerById(Long id){
        Player player=playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));
        return playerConverter.entityToDtos(player);
    }

    public PlayerResponseDTO updatePlayer(Long id,PlayerRequestDTO requestDTO){
        Player player=playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));

        player.setName(requestDTO.getName());
        player.setCountry(requestDTO.getCountry());
        player.setAge(requestDTO.getAge());
        player.setFideRating(requestDTO.getFideRating());
        player.setExperienceYears(requestDTO.getExperienceYears());
        player.setLevel(requestDTO.getLevel());

        Player updatedPlayer=playerRepository.save(player);

        return playerConverter.entityToDtos(updatedPlayer);
    }
    public void deletePlayer(Long id){
        playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));
        playerRepository.deleteById(id);
    }
    public  List<PlayerResponseDTO> getPlayerByCountry(String country){
        return playerRepository.findByCountry(country).stream().map(playerConverter::entityToDtos).toList();
    }
    public List<PlayerResponseDTO> getPlayerByLevel(Level level){
        return playerRepository.findByLevel(level).stream().map(playerConverter::entityToDtos).toList();
    }
    public List<PlayerResponseDTO> findByGreaterFideRating(Integer rating){
        return playerRepository.strongPlayer(rating).stream().map(playerConverter::entityToDtos).toList();
    }


}
