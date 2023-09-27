package com.tahaahvazi.instagram;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotosController {

    private Map<String, Photos> dataBase = new HashMap<>(){{
        put("1", new Photos("1","TahaAhvazi.png"));
    }};
    private List<Photos> db = List.of(new Photos("1", "TahaAhvazi.jpg"));
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/photos")
    public List<Photos> AllPhotos(){
        return db;
    }
    @GetMapping("/photos/{id}")
    public Photos getPhoto(@PathVariable String id){
        Photos photos = dataBase.get(id);
        if (photos == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photos;
    }
}
