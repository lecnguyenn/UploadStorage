package productmanagement.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import productmanagement.productmanagement.service.StorageService;

import java.io.IOException;


@RestController
public class ImageController {

    @Autowired
    private StorageService service;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
      byte[] imageDate =  service.downloadImage(fileName);
      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageDate);
    }
}
