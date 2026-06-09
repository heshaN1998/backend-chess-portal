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

    List<Player> findByFideRatingGreaterThan(Integer fideRating);

    @Query("select x FROM Player x WHERE x.fideRating >:rating")
    List<Player> strongPlayer(Integer fideRating);

    //DASHBORD SECTION
    @Query("SELECT COUNT(x) FROM Player x")
    Long totalPlayers();

    @Query("SELECT AVG(x.fideRating) FROM Player x")
    Double averageRating();

    @Query("SELECT x FROM Player x ORDER BY x.fideRating DESC LIMIT 1")
    Player topPlayer();
}

