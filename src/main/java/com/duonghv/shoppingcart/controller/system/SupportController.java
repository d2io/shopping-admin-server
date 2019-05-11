package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.Support;
import com.duonghv.shoppingcart.repository.system.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: SupportController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/support")
public class SupportController {
    @Autowired
    SupportRepository supportRepository;

    @GetMapping
    public ResponseEntity<?> getAllSupport() {
        List<Support> supports = supportRepository.findAll();
        return new ResponseEntity<>(supports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupport(@PathVariable Long id) {
        Support support = supportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Support", "id", id));
        return new ResponseEntity<>(support, HttpStatus.OK);
    }
}
