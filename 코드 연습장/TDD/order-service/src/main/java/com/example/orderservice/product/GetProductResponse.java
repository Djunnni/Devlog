package com.example.orderservice.product;

import org.springframework.util.Assert;

public record GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
    public GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

    }
}