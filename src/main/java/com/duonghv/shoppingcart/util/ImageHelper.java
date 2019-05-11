package com.duonghv.shoppingcart.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class: ImageHelper
 * Author: DuongHV
 * Created: 28/03/2019 16:34
 */

public class ImageHelper {

    @Value("${app.file.uploaded}")
    private String rootImgPath;

    @Value("${app.file.uploaded.thumbnail}")
    private String thumbnailPath;

    @Value("${app.file.thumbnail.width}")
    private int thumbnailWidth;

    @Value("${app.file.thumbnail.height}")
    private int thumbnailHeight;

    @Bean
    public void createThumbnail(File file) throws IOException {
        String goalPath = System.getProperty("user.dir").endsWith("/") + rootImgPath + thumbnailPath + file.getName();

        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(file).getScaledInstance(thumbnailWidth, thumbnailHeight, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIO.write(img, "jpg", new File(goalPath));
    }
}
