package com.blogapplication.BlogApplication.sevices;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    String uploadImages(String path, MultipartFile file) throws IOException;

    InputStream getResource(String path,String fileName) throws FileNotFoundException;
}
