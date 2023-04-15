package com.example.orderservice.order.application.port;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.product.domain.Product;

public interface OrderPort {
    public Product getProductById(final Long productId);

    public void save(Order order);
}
