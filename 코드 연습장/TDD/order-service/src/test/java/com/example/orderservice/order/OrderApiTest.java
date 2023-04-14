package com.example.orderservice.order;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import com.example.orderservice.ApiTest;
import org.springframework.http.HttpStatus;

import static com.example.orderservice.order.OrderSteps.상품주문요청;
import static com.example.orderservice.order.OrderSteps.상품주문요청_생성;
import static com.example.orderservice.product.ProductSteps.상품등록요청;
import static com.example.orderservice.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderApiTest extends ApiTest {

    @Test
    void 상품주문() {
        상품등록요청(상품등록요청_생성());

        final CreateOrderRequest request = 상품주문요청_생성();

        final ExtractableResponse<Response> response = 상품주문요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
