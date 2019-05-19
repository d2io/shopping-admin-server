package com.duonghv.shoppingcart.controller.picture;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.picture.Picture;
import com.duonghv.shoppingcart.payload.PictureRequest;
import com.duonghv.shoppingcart.repository.picture.PictureRepository;
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
    PictureRepository pictureRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addNewPicture(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                                           @RequestParam("link") String link, @RequestParam("summary") String summary,
                                           @RequestParam("alt") String alt) {
        try {
            Picture picture = pictureService.savePicture(new PictureRequest(name, alt, summary, link, file));
            return new ResponseEntity<>(picture, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public List<Picture> getPictureTypes() {
        List<Picture> pictureList = pictureRepository.findAll();
        return pictureList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPicture(@PathVariable Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Picture", "id", id));
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }
}
