package com.duonghv.shoppingcart.controller;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class: FileController
 * Author: DuongHV
 * Created: 28/03/2019 00:45
 */

@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    private final String ROOT_FOLDER = System.getProperty("user.dir");

    @Value("${app.file.uploaded}")
    private String rootPictureFolder;

    @Value("${app.file.uploaded.origin}")
    private String originFolder;

    @Value("${app.file.uploaded.thumbnail}")
    private String thumbnailFolder;

    @Value("${app.file.thumbnail.width}")
    private int thumbnailWidth;

    @PostMapping(value = "/uploadMultiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileMultipleUploader(@RequestParam("file") MultipartFile[] files) throws IOException {
        System.out.println(files);
        String originalPath = ROOT_FOLDER + rootPictureFolder + originFolder;
        String thumbnailPath = ROOT_FOLDER + rootPictureFolder + thumbnailFolder;
        ;

        for (MultipartFile file : files) {
            File originalImageFile = new File(originalPath + file.getOriginalFilename());
            File thumbnailImageFile = new File(thumbnailPath + file.getOriginalFilename());

            try {
                originalImageFile.createNewFile();
                thumbnailImageFile.createNewFile();

                FileOutputStream foutOrigin = new FileOutputStream(originalImageFile);
                FileOutputStream foutThumbnail = new FileOutputStream(thumbnailImageFile);

                foutOrigin.write(file.getBytes());
                foutOrigin.close();

                foutThumbnail.write(createThumbnail(file, thumbnailWidth).toByteArray());
                foutThumbnail.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "File is upload successfully!";
    }

    private ByteArrayOutputStream createThumbnail(MultipartFile orginalFile, Integer width) throws IOException {
        ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
        BufferedImage thumbImg = null;
        BufferedImage img = ImageIO.read(orginalFile.getInputStream());
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumbImg, orginalFile.getContentType().split("/")[1], thumbOutput);
        return thumbOutput;
    }
}
