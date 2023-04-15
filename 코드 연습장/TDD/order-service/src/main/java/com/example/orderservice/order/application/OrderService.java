package com.example.orderservice.order.application;

import com.example.orderservice.order.application.port.OrderPort;
import com.example.orderservice.order.domain.Order;
import com.example.orderservice.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public
class OrderService {
    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        final Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());
        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
