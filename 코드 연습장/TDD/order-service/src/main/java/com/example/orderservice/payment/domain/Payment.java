package com.example.orderservice.payment.domain;

import com.example.orderservice.order.domain.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;
    private String cardNumber;

    public Payment(Order order, String cardNumber) {
        Assert.notNull(order, "주문이 필요합니다.");
        Assert.notNull(cardNumber, "카드번호가 필요합니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
