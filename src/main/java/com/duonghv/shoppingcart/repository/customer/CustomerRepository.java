package com.duonghv.shoppingcart.repository.customer;

import com.duonghv.shoppingcart.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: CustomerRepository
 * Author: DuongHV
 * Created: 12/05/2019 00:49
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
}
