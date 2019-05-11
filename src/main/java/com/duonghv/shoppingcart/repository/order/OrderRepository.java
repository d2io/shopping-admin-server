package com.duonghv.shoppingcart.repository.order;

import com.duonghv.shoppingcart.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: CustomerRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:49
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
}
