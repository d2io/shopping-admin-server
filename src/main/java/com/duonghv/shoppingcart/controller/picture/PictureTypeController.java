package com.duonghv.shoppingcart.controller.picture;

import com.duonghv.shoppingcart.exception.ResourceNotFoundException;
import com.duonghv.shoppingcart.model.picture.PictureType;
import com.duonghv.shoppingcart.repository.picture.PictureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: PictureTypeController
 * Author: DuongHV
 * Created: 19/05/2019 09:55
 */

@RestController
@RequestMapping("/api/v1/picture-type")
public class PictureTypeController {

    @Autowired
    PictureTypeRepository pictureTypeRepository;

    @GetMapping("/")
    public List<PictureType> getPictureTypes() {
        List<PictureType> pictureTypeList = pictureTypeRepository.findAll();
        return pictureTypeList;
    }

    @GetMapping("/{id}")
    public PictureType getPictureTypes(@PathVariable Long id) {
        PictureType pictureType = pictureTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("PictureType", "id", id));
        return pictureType;
    }

}
