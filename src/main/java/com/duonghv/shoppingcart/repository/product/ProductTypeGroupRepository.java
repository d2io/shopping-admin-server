package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductTypeGroupRepository extends JpaRepository<ProductTypeGroup, Long> {
    Optional<ProductTypeGroup> findById(Long id);
}
