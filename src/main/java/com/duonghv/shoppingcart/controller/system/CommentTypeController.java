package com.duonghv.shoppingcart.controller.system;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.system.CommentType;
import com.duonghv.shoppingcart.repository.system.CommentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: CommentTypeController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/comment-type")
public class CommentTypeController {
    @Autowired
    CommentTypeRepository commentTypeRepository;

    @GetMapping
    public ResponseEntity<?> getAllCommentType() {
        List<CommentType> comments = commentTypeRepository.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentType(@PathVariable Long id) {
        CommentType comment = commentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommentType", "id", id));
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
