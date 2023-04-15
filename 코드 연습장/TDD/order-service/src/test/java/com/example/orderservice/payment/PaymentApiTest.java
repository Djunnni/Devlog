package com.example.orderservice.payment;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.orderservice.order.OrderSteps.상품주문요청;
import static com.example.orderservice.order.OrderSteps.상품주문요청_생성;
import static com.example.orderservice.payment.PaymentSteps.주문결제요청;
import static com.example.orderservice.payment.PaymentSteps.주문결제요청_생성;
import static com.example.orderservice.product.ProductSteps.상품등록요청;
import static com.example.orderservice.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.example.orderservice.ApiTest;

public class PaymentApiTest extends ApiTest {
    @Test
    void 상품주문() {
        상품등록요청(상품등록요청_생성());
        상품주문요청(상품주문요청_생성());

        final var request = 주문결제요청_생성();

        final var response = 주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
