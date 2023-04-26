package com.c102.malanglab.game;

import com.c102.malanglab.ApiTest;
import com.c102.malanglab.game.application.CreateRequest;
import com.c102.malanglab.game.domain.GameMode;
import com.c102.malanglab.game.application.GameService;
import com.c102.malanglab.game.domain.Round;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import static com.c102.malanglab.game.GameSteps.게임생성요청;
import static com.c102.malanglab.game.GameSteps.게임생성요청_생성;
import static org.assertj.core.api.Assertions.assertThat;

public class GameApiTest extends ApiTest {

    @Test
    public void 게임생성() {
        // 게임 생성 요청
        final var request = 게임생성요청_생성();
        // 게임 생성
        final var response = 게임생성요청(request);
        // 방 정보 리턴
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
