package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findById(Long id);
}
