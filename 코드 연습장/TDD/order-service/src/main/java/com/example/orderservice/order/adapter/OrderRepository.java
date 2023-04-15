package com.example.orderservice.order.adapter;

import com.example.orderservice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface OrderRepository extends JpaRepository<Order, Long> {
}
