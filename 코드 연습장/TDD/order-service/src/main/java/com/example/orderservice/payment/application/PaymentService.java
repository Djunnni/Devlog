package com.example.orderservice.payment.application;

import com.example.orderservice.order.domain.Order;
import com.example.orderservice.payment.application.port.PaymentPort;
import com.example.orderservice.payment.domain.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    public ResponseEntity<Void> payment(@RequestBody final PaymentRequest request) {
        Order order = paymentPort.getOrder(request.orderId());

        final Payment payment = new Payment(order, request.cardNumber());
        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
