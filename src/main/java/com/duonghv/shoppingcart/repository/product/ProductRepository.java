package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class: ProductRepository
 * Author: DuongHV
 * Created: 11/05/2019 16:16
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
