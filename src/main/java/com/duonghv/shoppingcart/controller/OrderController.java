package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.order.Order;
import com.duonghv.shoppingcart.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: OrderController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<?> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
