package com.duonghv.shoppingcart.controller.product;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.product.ProductAttribute;
import com.duonghv.shoppingcart.repository.product.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ProductVariantController
 * Author: DuongHV
 * Created: 11/05/2019 17:44
 */

@RestController
@RequestMapping("/api/v1/product-attribute")
public class ProductAttributeController {

    @Autowired
    ProductAttributeRepository productAttributeRepository;

    @GetMapping
    public ResponseEntity<?> getAllProductVariants() {
        List<ProductAttribute> productAttributes = productAttributeRepository.findAll();
        return new ResponseEntity<>(productAttributes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductVariant(@PathVariable Long id) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distributor", "id", id));
        return new ResponseEntity<>(productAttribute, HttpStatus.OK);
    }
}
