package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.SupportType;
import com.duonghv.shoppingcart.repository.system.SupportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: SupportTypeController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/support-type")
public class SupportTypeController {
    @Autowired
    SupportTypeRepository supportTypeRepository;

    @GetMapping
    public ResponseEntity<?> getAllSupportType() {
        List<SupportType> supportTypes = supportTypeRepository.findAll();
        return new ResponseEntity<>(supportTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupportType(@PathVariable Long id) {
        SupportType supportType = supportTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SupportType", "id", id));
        return new ResponseEntity<>(supportType, HttpStatus.OK);
    }
}
