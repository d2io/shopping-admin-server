package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.ProductLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductLabelRepository extends JpaRepository<ProductLabel, Long> {
    Optional<ProductLabel> findById(Long id);
}
