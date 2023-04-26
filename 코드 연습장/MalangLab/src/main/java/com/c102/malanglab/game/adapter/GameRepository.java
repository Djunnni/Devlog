package com.c102.malanglab.game.adapter;

import com.c102.malanglab.game.application.port.GamePort;
import com.c102.malanglab.game.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
