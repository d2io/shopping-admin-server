package com.duonghv.shoppingcart.controller.product;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.product.Manufacturer;
import com.duonghv.shoppingcart.repository.product.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ManufacturerController
 * Author: DuongHV
 * Created: 11/05/2019 17:02
 */

@RestController
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping
    public ResponseEntity<?> getAllDistributors() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistributor(@PathVariable Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distributor", "id", id));
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }
}
