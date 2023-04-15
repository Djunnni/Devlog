package com.example.orderservice.payment.adapter;

import com.example.orderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(Payment payment) {
        System.out.println("결제 완료");
    }

    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결제 완료");
    }
}
