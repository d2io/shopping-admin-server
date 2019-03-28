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

    @Value("${app.file.uploaded}")
    private String rootPictureFolder;

    @Bean
    public void createFolderIfNotExist() {
        String path = System.getProperty("user.dir") + "/" + rootPictureFolder;

        if (!Files.exists(Paths.get(path)))
            new File(path).mkdirs();
    }
}
