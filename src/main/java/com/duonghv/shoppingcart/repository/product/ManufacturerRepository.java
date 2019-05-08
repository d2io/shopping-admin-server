package com.duonghv.shoppingcart.repository.product;

import com.duonghv.shoppingcart.model.product.Distributor;
import com.duonghv.shoppingcart.model.product.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findById(Long id);
}
