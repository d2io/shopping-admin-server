package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
    Optional<ProductVariant> findById(Long id);
}
