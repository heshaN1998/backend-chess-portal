package com.checkmate_portal.chessclub.repository;

import com.checkmate_portal.chessclub.entity.Player;
import com.checkmate_portal.chessclub.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
List<Player> findByCountry(String country);
List<Player> findByLevel(Level level);
List<Player> findByGreaterFideRating(Integer rating);

@Query("select x FROM Player x WHERE x.fideRating >:rating")
List<Player> strongPlayer(Integer rating);
}
