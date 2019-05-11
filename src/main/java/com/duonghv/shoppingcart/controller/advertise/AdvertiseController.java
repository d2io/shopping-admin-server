package com.duonghv.shoppingcart.controller.advertise;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.advertise.Advertise;
import com.duonghv.shoppingcart.repository.advertise.AdvertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: AdvertiseController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/advertise")
public class AdvertiseController {
    @Autowired
    AdvertiseRepository advertiseRepository;

    @GetMapping
    public ResponseEntity<?> getAllAdvertise() {
        List<Advertise> advertises = advertiseRepository.findAll();
        return new ResponseEntity<>(advertises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdvertise(@PathVariable Long id) {
        Advertise advertise = advertiseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Advertise", "id", id));
        return new ResponseEntity<>(advertise, HttpStatus.OK);
    }
}
