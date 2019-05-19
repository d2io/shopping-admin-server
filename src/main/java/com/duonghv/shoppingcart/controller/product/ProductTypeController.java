package com.duonghv.shoppingcart.controller.product;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.product.ProductType;
import com.duonghv.shoppingcart.repository.product.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/product-type")
public class ProductTypeController {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping
    public List<ProductType> getProductTypes() {
        List<ProductType> productTypeList = productTypeRepository.findAll();
        return productTypeList;
    }

    @GetMapping("/{id}")
    public ProductType getProductType(@PathVariable Long id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ProductType", "id", id));
        return productType;
    }
}
