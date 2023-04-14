package com.example.orderservice.order;

import com.example.orderservice.product.Product;

public interface OrderPort {
    public Product getProductById(final Long productId);

    public void save(Order order);
}
