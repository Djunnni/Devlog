package com.example.orderservice.product;

import com.example.orderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductApiTest extends ApiTest {


    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();

        // API 요청
        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name ="상품명";
        final int price  = 1000;
        final DiscountPolicy policy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, policy);
        return request;
    }

}
