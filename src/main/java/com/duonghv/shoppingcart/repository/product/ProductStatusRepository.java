package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStatusRepository extends JpaRepository<ProductStatus, Long> {
    Optional<ProductStatus> findById(Long id);
}
