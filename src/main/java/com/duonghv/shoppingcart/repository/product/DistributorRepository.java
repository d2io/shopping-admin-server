package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    Optional<Distributor> findById(Long id);
}
