package com.duonghv.shoppingcart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class: FileConfig
 * Author: DuongHV
 * Created: 28/03/2019 10:09
 */

@Configuration
public class FileConfig {
    private final String ROOT_FOLDER = System.getProperty("user.dir");

    @Value("${app.file.uploaded}")
    private String rootPictureFolder;

    @Value("${app.file.uploaded.origin}")
    private String originFolder;

    @Value("${app.file.uploaded.thumbnail}")
    private String thumbnailFolder;

    @Bean
    public void createFolderIfNotExist() {
        String originalPath = ROOT_FOLDER + rootPictureFolder + originFolder;
        String thumbnailPath = ROOT_FOLDER + rootPictureFolder + thumbnailFolder;
        ;

        if (!Files.exists(Paths.get(originalPath)))
            new File(originalPath).mkdirs();

        if (!Files.exists(Paths.get(thumbnailPath)))
            new File(thumbnailPath).mkdirs();

    }
}
