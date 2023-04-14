package com.example.orderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.example.orderservice.product.ProductSteps.상품등록요청_생성;
import static com.example.orderservice.product.ProductSteps.상품수정요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        productService.addProduct(상품등록요청_생성());

        final Long productId = 1L;
        final UpdateProductRequest request = 상품수정요청_생성();

        productService.updateProduct(productId, request);

        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse product = response.getBody();
        assertThat(product.name()).isEqualTo("상품 수정");
        assertThat(product.price()).isEqualTo(2000);
    }



}
