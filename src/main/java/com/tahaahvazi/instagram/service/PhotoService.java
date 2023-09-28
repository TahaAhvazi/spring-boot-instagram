package com.tahaahvazi.instagram.service;

import com.tahaahvazi.instagram.model.Photos;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {

    private Map<String, Photos> dataBase = new HashMap<>(){{
        put("1", new Photos("1","TahaAhvazi.png"));
        put("2", new Photos("2","AlirezaAhvazi.png"));
        put("3", new Photos("3","HosseinMoradi.png"));
        put("4", new Photos("4","MahsaBeyranvand.png"));

    }};

    public Collection<Photos> get() {
        return dataBase.values();
    }

    public Photos get(String id) {
        return dataBase.get(id);
    }

    public void remove(String id) {
        dataBase.remove(id);
    }

    public Photos save(String fileName, String contentType, byte[] data) {
        Photos photos = new Photos();
        photos.setContentType(contentType);
        photos.setId(UUID.randomUUID().toString());
        photos.setFileName(fileName);
        photos.setData(data);
        dataBase.put(photos.getId(),photos);
        return photos;
    }
}
