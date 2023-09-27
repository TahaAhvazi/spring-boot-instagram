package com.tahaahvazi.instagram;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotosController {

    private Map<String, Photos> dataBase = new HashMap<>(){{
        put("1", new Photos("1","TahaAhvazi.png"));
        put("2", new Photos("2","AlirezaAhvazi.png"));
        put("3", new Photos("3","HosseinMoradi.png"));
        put("4", new Photos("4","MahsaBeyranvand.png"));

    }};
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Collection<Photos> AllPhotos(){
        return dataBase.values();
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
}
