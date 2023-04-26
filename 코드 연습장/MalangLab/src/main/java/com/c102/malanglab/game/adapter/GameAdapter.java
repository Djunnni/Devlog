package com.c102.malanglab.game.adapter;

import com.c102.malanglab.game.application.port.GamePort;
import com.c102.malanglab.game.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameAdapter implements GamePort {

    private final GameRepository gameRepository;

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("요청한 ID의 게임이 존재하지 않습니다."));
    }
}
