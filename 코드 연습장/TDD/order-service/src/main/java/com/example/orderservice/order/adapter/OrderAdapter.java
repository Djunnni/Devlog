package com.example.orderservice.order.adapter;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.order.application.port.OrderPort;
import com.example.orderservice.product.domain.Product;
import com.example.orderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Product getProductById(final Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
