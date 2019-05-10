package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductGroupAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductGroupAttributeRepository extends JpaRepository<ProductGroupAttribute, Long> {
    Optional<ProductGroupAttribute> findById(Long id);
}
