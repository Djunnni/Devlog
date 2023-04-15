package com.example.orderservice.product;

import com.example.orderservice.product.domain.DiscountPolicy;
import com.example.orderservice.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("상품명", 3000, DiscountPolicy.NONE);

        product.update("상품수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    void none_discounted_product() {
        final Product product = new Product("상품명", 3000, DiscountPolicy.NONE);

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(3000);
    }

    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("상품명", 3000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(2000);
    }

    @Test
    void fix_1000_under_discounted_product() {
        final Product product = new Product("상품명", 500, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(0);
    }
}