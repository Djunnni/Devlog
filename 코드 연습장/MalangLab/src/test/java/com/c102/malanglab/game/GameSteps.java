package com.c102.malanglab.game;

import com.c102.malanglab.game.application.CreateRequest;
import com.c102.malanglab.game.domain.GameMode;
import com.c102.malanglab.game.domain.Round;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.List;

public class GameSteps {
    public static ExtractableResponse<Response> 게임생성요청(CreateRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/game")
                .then().log().all().extract();
    }

    public static CreateRequest 게임생성요청_생성() {
        return new CreateRequest(
                "게임 생성 테스트",
                GameMode.SOLO,
                List.of(
                        new Round("GOOGLE", "갓태민", Integer.valueOf(30)),
                        new Round("삼성", "갓여진", Integer.valueOf(60)),
                        new Round("신한은행", "갓동준", Integer.valueOf(90))
                ));
    }
}
