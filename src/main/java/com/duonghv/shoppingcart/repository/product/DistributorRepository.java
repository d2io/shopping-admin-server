package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    Optional<Distributor> findById(Long id);
}
