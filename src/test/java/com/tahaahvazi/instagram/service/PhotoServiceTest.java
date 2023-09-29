package com.tahaahvazi.instagram.service;


import com.tahaahvazi.instagram.model.Photos;
import com.tahaahvazi.instagram.repository.PhotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class PhotoServiceTest {
    @InjectMocks
    private PhotoService photoService;
    @Mock
    private PhotoRepository photoRepository;

    @BeforeEach
    public void SetUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GetAllPhotosTest(){
        List<Photos> samplePhotos = new ArrayList<>();
        samplePhotos.add(new Photos(1, "photo1.jpg", "image/jpeg", new byte[]{1, 2, 3}));
        samplePhotos.add(new Photos(2, "photo2.jpg", "image/jpeg", new byte[]{4, 5, 6}));

        when(photoRepository.findAll()).thenReturn(samplePhotos);
        Collection<Photos> photos = photoService.get();
        assertEquals(samplePhotos, photos);
    }

    @Test
    public void GetPhotoById(){
        Photos samplePhoto = new Photos(1, "TahaAhvazi.png", "Image/png", new byte[]{1,2,3});
        when(photoRepository.findById(1)).thenReturn(Optional.of(samplePhoto));
        Photos photo = photoService.get(1);
        assertEquals(photo,samplePhoto);
    }

    @Test
    public void testRemovePhoto(){
        photoService.remove(1);
        verify(photoRepository, times(1)).deleteById(1);
    }

    @Test
    public void SavePhotoTest() {
        // Create sample data for a new photo
        String fileName = "newphoto.jpg";
        String contentType = "image/jpeg";
        byte[] data = new byte[]{7, 8, 9};

        // Create a new photo with the sample data
        Photos newPhoto = new Photos();
        newPhoto.setFileName(fileName);
        newPhoto.setContentType(contentType);
        newPhoto.setData(data);

        // Mock the behavior of photoRepository.save() to return the new photo
        when(photoRepository.save(newPhoto)).thenReturn(newPhoto);

        // Call the save method of PhotoService
        Photos savedPhoto = photoService.save(fileName, contentType, data);

        // Verify that the method returned the new photo
        assertEquals(newPhoto, savedPhoto);
    }
}
