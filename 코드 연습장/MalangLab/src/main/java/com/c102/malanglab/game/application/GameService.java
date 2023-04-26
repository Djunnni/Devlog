package com.c102.malanglab.game.application;

import com.c102.malanglab.game.application.port.GamePort;
import com.c102.malanglab.game.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameService {

    private final GamePort gamePort;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateRequest request) {
        Game game = new Game(generateRoomId(), request.getTitle(), request.getMode());
        request.getRounds().forEach(round -> game.addRound(round));
        // 게임 저장하기
        gamePort.save(game);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    public Long generateRoomId() {
        // TODO: REDIS를 통해서 랜덤 6자 생성하기 테스트
        return 1L;
    }

    public Game get(Long id) {
        return gamePort.findById(id);
    }
}
