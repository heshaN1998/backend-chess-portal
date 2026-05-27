package com.checkmate_portal.chessclub.EntityDtoConverter;

import com.checkmate_portal.chessclub.dtos.PlayerRequestDTO;
import com.checkmate_portal.chessclub.dtos.PlayerResponseDTO;
import com.checkmate_portal.chessclub.entity.Player;

public class PlayerConverter {
    //converting Req DTOs to Entity
    public Player rquestDtoToEntity(PlayerRequestDTO dto){
        Player player=new Player();

        player.setName(dto.getName());
        player.setCountry(dto.getCountry());
        player.setAge(dto.getAge());
        player.setFideRating(dto.getFideRating());
        player.setExperienceYears(dto.getExperienceYears());
        player.setLevel(dto.getLevel());
        return player;
    }

    //converting Entities to Response DTOs
    public PlayerResponseDTO entityToDtos(Player player){
        PlayerResponseDTO dto=new PlayerResponseDTO();

        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setAge(player.getAge());
        dto.setCountry(player.getCountry());
        dto.setFideRating(player.getFideRating());
        dto.setExperienceYears(player.getExperienceYears());
        dto.setLevel(player.getLevel());
        return dto;

    }
}
