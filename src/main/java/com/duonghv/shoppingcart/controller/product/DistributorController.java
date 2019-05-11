package com.duonghv.shoppingcart.controller.product;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.product.Distributor;
import com.duonghv.shoppingcart.repository.product.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: DistributorController
 * Author: DuongHV
 * Created: 11/05/2019 16:58
 */

@RestController
@RequestMapping("/api/v1/distributor")
public class DistributorController {

    @Autowired
    DistributorRepository distributorRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDistributors() {
        List<Distributor> distributors = distributorRepository.findAll();
        return new ResponseEntity<>(distributors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistributor(@PathVariable Long id) {
        Distributor distributor = distributorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distributor", "id", id));
        return new ResponseEntity<>(distributor, HttpStatus.OK);
    }
}
