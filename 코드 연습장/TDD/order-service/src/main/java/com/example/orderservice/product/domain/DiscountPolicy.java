package com.example.orderservice.product.domain;
public enum DiscountPolicy {
    NONE {
        @Override
        public int applyDiscount(int price) {
            return price;
        }
    },
    FIX_1000_AMOUNT {
        @Override
        public int applyDiscount(int price) {
            return Math.max(0, price - 1000);
        }
    }
    ;

    abstract public int applyDiscount(final int price);
}