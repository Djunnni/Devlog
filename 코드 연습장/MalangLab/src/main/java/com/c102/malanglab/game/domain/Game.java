package com.c102.malanglab.game.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "games")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private Long id;
    private String title;
    private GameMode mode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GAME_ID")
    private List<Round> rounds = new ArrayList<>();

    public Game(Long id, String title, GameMode mode) {
        this.id = id;
        this.title = title;
        this.mode = mode;
    }

    public void addRound(Round round) {
        if(!rounds.contains(round)) {
            rounds.add(round);
        }
    }

}
