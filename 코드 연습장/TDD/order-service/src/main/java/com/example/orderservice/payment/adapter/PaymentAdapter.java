package com.example.orderservice.payment.adapter;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.order.adapter.OrderRepository;
import com.example.orderservice.payment.application.port.PaymentPort;
import com.example.orderservice.payment.domain.Payment;

import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {

    final private PaymentGateway paymentGateway;
    final private PaymentRepository paymentRepository;

    final private OrderRepository orderRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("없는 주문입니다."));
    }

    @Override
    public void pay(Payment payment) {
        paymentGateway.execute(payment);
    }

    @Override
    public void pay(final int price, final String cardNumber) {
        paymentGateway.execute(price, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

}
