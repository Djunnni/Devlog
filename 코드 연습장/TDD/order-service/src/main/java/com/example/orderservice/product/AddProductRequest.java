package com.example.orderservice.product;

import org.springframework.util.Assert;

record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    AddProductRequest {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합나디ㅏ.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }

}
