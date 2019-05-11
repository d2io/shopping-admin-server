package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.InfoReceiverGroup;
import com.duonghv.shoppingcart.repository.system.InfoReceiverGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: InfoReceiverGroupController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/info-receiver-group")
public class InfoReceiverGroupController {
    @Autowired
    InfoReceiverGroupRepository infoReceiverGroupRepository;

    @GetMapping
    public ResponseEntity<?> getAllInfoReceiverGroup() {
        List<InfoReceiverGroup> infoReceiverGroups = infoReceiverGroupRepository.findAll();
        return new ResponseEntity<>(infoReceiverGroups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInfoReceiverGroup(@PathVariable Long id) {
        InfoReceiverGroup infoReceiverGroup = infoReceiverGroupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InfoReceiverGroup", "id", id));
        return new ResponseEntity<>(infoReceiverGroup, HttpStatus.OK);
    }
}
