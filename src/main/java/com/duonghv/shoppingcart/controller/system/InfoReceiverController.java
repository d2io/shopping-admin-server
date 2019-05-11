package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.InfoReceiver;
import com.duonghv.shoppingcart.repository.system.InfoReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: InfoReceiverController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/info-receiver")
public class InfoReceiverController {
    @Autowired
    InfoReceiverRepository infoReceiverRepository;

    @GetMapping
    public ResponseEntity<?> getAllInfoReceiver() {
        List<InfoReceiver> infoReceivers = infoReceiverRepository.findAll();
        return new ResponseEntity<>(infoReceivers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoReceiver(@PathVariable Long id) {
        InfoReceiver infoReceiver = infoReceiverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfoReceiver", "id", id));
        return new ResponseEntity<>(infoReceiver, HttpStatus.OK);
    }
}
