package com.example.orderservice.product;

import org.springframework.stereotype.Component;

interface ProductPort {
    void save(final Product product);
}
