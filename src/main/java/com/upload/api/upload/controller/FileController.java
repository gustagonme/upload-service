package com.upload.api.upload.controller;

import com.upload.api.upload.helper.FileHelper;
import com.upload.api.upload.models.FileUpload;
import com.upload.api.upload.models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.upload.api.upload.service.FileService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FileController {

   @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<List<FileUpload>> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        List<FileUpload> responseFile;

        if (FileHelper.hasCSVFormat(file)) {
            try {
                responseFile = fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(responseFile);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
