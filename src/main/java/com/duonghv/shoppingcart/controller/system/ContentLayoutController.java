package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.ContentLayout;
import com.duonghv.shoppingcart.repository.system.ContentLayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: ContentLayoutController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/content-layout")
public class ContentLayoutController {
    @Autowired
    ContentLayoutRepository contentLayoutRepository;

    @GetMapping
    public ResponseEntity<?> getAllContentLayout() {
        List<ContentLayout> contentLayouts = contentLayoutRepository.findAll();
        return new ResponseEntity<>(contentLayouts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContentLayout(@PathVariable Long id) {
        ContentLayout contentLayout = contentLayoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContentLayout", "id", id));
        return new ResponseEntity<>(contentLayout, HttpStatus.OK);
    }
}
