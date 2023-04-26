package com.c102.malanglab.game.application.port;

import com.c102.malanglab.game.domain.Game;

public interface GamePort {
    Game save(Game game);

    Game findById(Long id);
}
