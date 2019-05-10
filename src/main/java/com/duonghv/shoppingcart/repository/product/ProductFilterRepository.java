package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductFilterRepository extends JpaRepository<ProductFilter, Long> {
    Optional<ProductFilter> findById(Long id);
}
