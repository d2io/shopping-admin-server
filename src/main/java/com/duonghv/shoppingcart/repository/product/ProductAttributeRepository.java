package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    Optional<ProductAttribute> findById(Long id);
}
