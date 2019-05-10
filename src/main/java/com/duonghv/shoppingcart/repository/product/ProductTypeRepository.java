package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    Optional<ProductType> findById(Long id);
}
