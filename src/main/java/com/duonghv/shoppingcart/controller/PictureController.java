package com.duonghv.shoppingcart.controller;

import com.duonghv.shoppingcart.payload.PictureRequest;
import com.duonghv.shoppingcart.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class: PictureController
 * Author: DuongHV
 * Created: 31/03/2019 17:16
 */

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewPicture(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
                                           @RequestParam("link") String link, @RequestParam("summary") String summary,
                                           @RequestParam("alt") String alt) {

//        System.out.println(request);
//        for (PictureRequest request: requests) {
        pictureService.savePicture(new PictureRequest(title, alt, summary, link, file));
//        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
