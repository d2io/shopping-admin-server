package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.model.PictureType;
import com.duonghv.shoppingcart.payload.PictureRequest;
import com.duonghv.shoppingcart.repository.PictureTypeRepository;
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
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @Autowired
    PictureTypeRepository pictureTypeRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addNewPicture(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                                           @RequestParam("link") String link, @RequestParam("summary") String summary,
                                           @RequestParam("alt") String alt) {
        pictureService.savePicture(new PictureRequest(title, alt, summary, link, file));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/type")
    public List<PictureType> getPictureTypes() {
        List<PictureType> pictureTypeList = pictureTypeRepository.findAll();
        return pictureTypeList;
    }
}
