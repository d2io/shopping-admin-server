package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeGroupRepository extends JpaRepository<ProductTypeGroup, Long> {
    Optional<ProductTypeGroup> findById(Long id);
}
