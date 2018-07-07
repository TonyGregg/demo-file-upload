package com.genil.spring.multipart.demofileupload.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by anton on 7/7/2018 8:18 AM
 **/
@Service
public class StorageServiceImpl implements StorageService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getStorageLocation() {
        return storageLocation;
    }

    @Value("${server.upload.loc}")
    private String storageLocation;

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {
        try {
            file.transferTo(new File(getStorageLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Stream<Path> loadAll() {
        Stream<Path> fileTree = null;
        logger.info("Inside loadAll method. Server upload location "+getStorageLocation());
        Path dir = Paths.get(getStorageLocation());
        logger.info("Absolute path "+dir.toAbsolutePath());
        try {
            fileTree = Files.walk(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileTree;

    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
