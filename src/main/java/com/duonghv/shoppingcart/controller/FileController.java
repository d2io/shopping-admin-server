package com.duonghv.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class: FileController
 * Author: DuongHV
 * Created: 28/03/2019 00:45
 */

@RestController
public class FileController {

    @Value("${app.file.uploaded}")
    private String rootPictureFolder;

    @PostMapping(value = "/uploadMultiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileMultipleUploader(@RequestParam("file") MultipartFile[] files) throws IOException {
        String path = System.getProperty("user.dir") + "/" + rootPictureFolder;

        for (MultipartFile file : files) {
            File convertFile = new File(path + file.getOriginalFilename());
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
        }

        return "File is upload successfully!";
    }
}
