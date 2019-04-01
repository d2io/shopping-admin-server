package com.duonghv.shoppingcart.payload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

/**
 * Class: PictureRequest
 * Author: DuongHV
 * Created: 28/03/2019 13:15
 */

@Data
public class PictureRequest {

    @NotBlank
    private String name;

    private Long typeId;

    private String alt;

    private String summary;

    private String link;

    @NotBlank
    private MultipartFile file;

    public PictureRequest(@NotBlank String name, String alt, String summary, String link, @NotBlank MultipartFile file) {
        this.name = name;
        this.typeId = 18L;
        this.alt = alt;
        this.summary = summary;
        this.link = link;
        this.file = file;
    }
}
