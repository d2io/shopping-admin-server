package com.duonghv.shoppingcart.service;

import com.duonghv.shoppingcart.model.Picture;
import com.duonghv.shoppingcart.model.PictureType;
import com.duonghv.shoppingcart.payload.PictureRequest;
import com.duonghv.shoppingcart.repository.PictureRepository;
import com.duonghv.shoppingcart.repository.PictureTypeRepository;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class: PictureService
 * Author: DuongHV
 * Created: 31/03/2019 17:19
 */

@Service
public class PictureService {

    private final String ROOT_FOLDER = System.getProperty("user.dir") + "/";
    private final PictureTypeRepository pictureTypeRepository;
    private final PictureRepository pictureRepository;
    private Picture picture = new Picture();
    @Value("${app.file.uploaded}")
    private String rootPictureFolder;

    @Value("${app.file.uploaded.origin}")
    private String originFolder;

    @Value("${app.file.uploaded.thumbnail}")
    private String thumbnailFolder;

    @Value("${app.file.thumbnail.width}")
    private int thumbnailWidth;

    public PictureService(PictureTypeRepository pictureTypeRepository,
                          PictureRepository pictureRepository) {
        this.pictureTypeRepository = pictureTypeRepository;
        this.pictureRepository = pictureRepository;
    }


    public synchronized boolean savePicture(PictureRequest request) {
        String originalPath = ROOT_FOLDER + rootPictureFolder + originFolder;
        String thumbnailPath = ROOT_FOLDER + rootPictureFolder + thumbnailFolder;

        MultipartFile file = request.getFile();

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

            picture.setFileName(originalPath);
            picture.setName(request.getName());
            picture.setAlt(request.getAlt());
            picture.setLink(request.getLink());
            picture.setSummary(request.getSummary());
            PictureType pictureType = pictureTypeRepository.findById(request.getTypeId()).orElse(null);
            picture.setPictureType(pictureType);
            picture.setSize(file.getSize());

            pictureRepository.save(picture);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
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
