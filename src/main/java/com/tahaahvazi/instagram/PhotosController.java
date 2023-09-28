package com.tahaahvazi.instagram;

import jakarta.validation.Valid;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotosController {

    private Map<String, Photos> dataBase = new HashMap<>(){{
        put("1", new Photos("1","TahaAhvazi.png"));
        put("2", new Photos("2","AlirezaAhvazi.png"));
        put("3", new Photos("3","HosseinMoradi.png"));
        put("4", new Photos("4","MahsaBeyranvand.png"));

    }};
    @GetMapping("/")
    public String checkWorking(){
        return "Working fine on PORT : 8080";
    }

    @GetMapping("/photos")
    public Collection<Photos> AllPhotos(){
        if(dataBase.values().isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
           return dataBase.values();
        }
    }
    @GetMapping("/photos/{id}")
    public Photos getPhoto(@PathVariable String id){
        Photos photos = dataBase.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photos;
    }
    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id){
        Photos photo = dataBase.get(id);
        if (photo == null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        dataBase.remove(id);
    }
    @PostMapping("/photos")
    public Photos create(@Valid Photos photos){
        photos.setId(UUID.randomUUID().toString());
        dataBase.put(photos.getId(), photos);
        return photos;
    }
}
