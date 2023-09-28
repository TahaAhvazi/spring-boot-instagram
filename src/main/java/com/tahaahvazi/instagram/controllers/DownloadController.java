package com.tahaahvazi.instagram.controllers;

import com.tahaahvazi.instagram.service.PhotoService;
import com.tahaahvazi.instagram.model.Photos;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    private final PhotoService photoService;
    public DownloadController(PhotoService photoService){
        this.photoService = photoService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        Photos photos = photoService.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = photos.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photos.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photos.getFileName())
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
