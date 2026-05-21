package com.checkmate_portal.chessclub.repository;

import com.checkmate_portal.chessclub.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

}
