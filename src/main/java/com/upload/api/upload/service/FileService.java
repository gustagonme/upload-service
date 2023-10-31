package com.upload.api.upload.service;

import com.upload.api.upload.helper.FileHelper;
import com.upload.api.upload.models.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    public List<FileUpload> save(MultipartFile file) {
        try {
            List<FileUpload> fileArtifact = FileHelper.fileUpload(file.getInputStream());
            System.out.println(Arrays.toString(fileArtifact.toArray()));
            return fileArtifact;
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
