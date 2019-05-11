package com.duonghv.shoppingcart.controller.fileType;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.file.FileType;
import com.duonghv.shoppingcart.repository.file.FileTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: FileTypeController
 * Author: DuongHV
 * Created: 12/05/2019 00:56
 */

@RestController
@RequestMapping("/api/v1/file-type")
public class FileTypeController {
    @Autowired
    FileTypeRepository fileTypeRepository;

    @GetMapping
    public ResponseEntity<?> getAllFileType() {
        List<FileType> fileTypes = fileTypeRepository.findAll();
        return new ResponseEntity<>(fileTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFileType(@PathVariable Long id) {
        FileType fileType = fileTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FileType", "id", id));
        return new ResponseEntity<>(fileType, HttpStatus.OK);
    }
}
