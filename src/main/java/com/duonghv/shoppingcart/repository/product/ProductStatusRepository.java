package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductStatusRepository extends JpaRepository<ProductStatus, Long> {
    Optional<ProductStatus> findById(Long id);
}
