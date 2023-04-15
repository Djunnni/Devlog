package com.example.orderservice.product.application.port;

import com.example.orderservice.product.domain.Product;

public interface ProductPort {
    void save(final Product product);

    Product getProduct(long productId);
}
