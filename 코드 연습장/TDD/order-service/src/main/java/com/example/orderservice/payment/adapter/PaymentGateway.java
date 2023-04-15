package com.example.orderservice.payment.adapter;

import com.example.orderservice.payment.domain.Payment;

interface PaymentGateway {
    public void execute(Payment payment);
    public void execute(int totalPrice, String cardNumber);
}
