package com.example.orderservice.payment.application.port;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.payment.domain.Payment;

public interface PaymentPort {
    public Order getOrder(Long orderId);

    void pay(Payment payment);
    public void pay(final int price, final String cardNumber);

    void save(Payment payment);
}
