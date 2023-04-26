package com.c102.malanglab.game.application;

import com.c102.malanglab.game.domain.GameMode;
import com.c102.malanglab.game.domain.Round;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateRequest {
    private String title;
    private GameMode mode;
    private List<Round> rounds = new ArrayList<>();

    public CreateRequest(String title, GameMode mode, List<Round> rounds) {
        this.title = title;
        this.mode = mode;
        this.rounds = rounds;
    }
}
