package com.tahaahvazi.instagram.controllers;

import com.tahaahvazi.instagram.service.PhotoService;
import com.tahaahvazi.instagram.model.Photos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

    private final PhotoService photoService;

    public PhotosController(PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String checkWorking(){
        return "Working fine on PORT : 8080";
    }

    @GetMapping("/photos")
    public Collection<Photos> AllPhotos(){
        if(photoService.get().isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
           return photoService.get();
        }
    }
    @GetMapping("/photos/{id}")
    public Photos getPhoto(@PathVariable String id){
        Photos photos = photoService.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photos;
    }
    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id){
        Photos photo = photoService.get(id);
        if (photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        photoService.remove(id);
    }
    @PostMapping("/photos")
    public Photos create(MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
