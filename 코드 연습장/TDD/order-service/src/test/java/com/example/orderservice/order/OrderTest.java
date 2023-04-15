package com.example.orderservice.order;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.product.domain.DiscountPolicy;
import com.example.orderservice.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명",1000, DiscountPolicy.NONE), 2);

        final int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }

    @Test
    void discount_getTotalPrice() {
        Order order = new Order(new Product("상품명",1000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        final int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(0);
    }


}