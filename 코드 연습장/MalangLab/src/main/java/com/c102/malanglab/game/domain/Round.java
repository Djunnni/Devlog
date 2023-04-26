package com.c102.malanglab.game.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Entity
@ToString
@Table(name = "rounds")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Round {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ROUND_ID")
        private Long id;
        private String keyword;
        private String hidden;
        private Integer time;

        public Round(String keyword, String hidden, Integer time) {
                this.keyword = keyword;
                this.hidden = hidden;
                this.time = time;
        }
}
