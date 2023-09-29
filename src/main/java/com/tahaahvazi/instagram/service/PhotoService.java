package com.tahaahvazi.instagram.service;

import com.tahaahvazi.instagram.model.Photos;
import com.tahaahvazi.instagram.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }
//TODO: I should change the type of function if faced an error
    public Collection<Photos> get() {
        return (Collection<Photos>) photoRepository.findAll();
    }

    public Photos get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photos save(String fileName, String contentType, byte[] data) {
        Photos photos = new Photos();
        photos.setContentType(contentType);
        photos.setFileName(fileName);
        photos.setData(data);
        photoRepository.save(photos);
        return photos;
    }
}
