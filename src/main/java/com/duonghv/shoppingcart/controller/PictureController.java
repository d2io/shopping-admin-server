package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.Picture;
import com.duonghv.shoppingcart.model.PictureType;
import com.duonghv.shoppingcart.model.Test;
import com.duonghv.shoppingcart.payload.PictureRequest;
import com.duonghv.shoppingcart.repository.PictureRepository;
import com.duonghv.shoppingcart.repository.PictureTypeRepository;
import com.duonghv.shoppingcart.repository.TestRepository;
import com.duonghv.shoppingcart.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Class: PictureController
 * Author: DuongHV
 * Created: 31/03/2019 17:16
 */

@RestController
@RequestMapping("/api/v1/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @Autowired
    PictureTypeRepository pictureTypeRepository;

    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    TestRepository testRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addNewPicture(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                                           @RequestParam("link") String link, @RequestParam("summary") String summary,
                                           @RequestParam("alt") String alt) {
        pictureService.savePicture(new PictureRequest(name, alt, summary, link, file));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/add/test")
    public ResponseEntity<?> addNewPictureTest(@RequestBody Test test) {
        testRepository.save(test);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/types")
    public List<PictureType> getPictureTypes() {
        List<PictureType> pictureTypeList = pictureTypeRepository.findAll();
        return pictureTypeList;
    }

    @GetMapping("/type/{id}")
    public PictureType getPictureTypes(@PathVariable Long id) {
        PictureType pictureType = pictureTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PictureType", "id", id));
        return pictureType;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPicture(@PathVariable Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Picture", "id", id));
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }
}
