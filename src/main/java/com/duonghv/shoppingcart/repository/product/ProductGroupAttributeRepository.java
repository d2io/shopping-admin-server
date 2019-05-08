package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductGroupAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductGroupAttributeRepository extends JpaRepository<ProductGroupAttribute, Long> {
    Optional<ProductGroupAttribute> findById(Long id);
}
