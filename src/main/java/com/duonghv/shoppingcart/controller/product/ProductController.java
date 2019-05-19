package com.duonghv.shoppingcart.controller.product;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.product.Product;
import com.duonghv.shoppingcart.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ProductController
 * Author: DuongHV
 * Created: 10/05/2019 07:26
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
