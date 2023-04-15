package com.example.orderservice.product;

import com.example.orderservice.product.domain.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DiscountPolicyTest {

    @Test
    void applyDiscount() {
        final int price = 1000;
        final int discountPrice = DiscountPolicy.NONE.applyDiscount(price);

        assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    void name() {
        final int price = 2000;
        final int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountPrice).isEqualTo(1000);
    }
}