package com.tahaahvazi.instagram.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotoTest {
    private Photos photos;

    @BeforeEach
    public void setUp(){
         photos = new Photos();
    }

    @Test
    public void TestGetterAndSetterTest(){
        //Arrange
        photos.setId(1);
        photos.setFileName("TahaAhvazi.png");
        photos.setContentType("image/png");
        byte[] testData = new byte[]{1,2,3};
        photos.setData(testData);

        //Act
        int id = photos.getId();
        String filename = photos.getFileName();
        String contentType = photos.getContentType();
        byte[] data = photos.getData();

        //Assert
        assertEquals(1,id);
        assertEquals("TahaAhvazi.png",filename);
        assertEquals("image/png", contentType);
        assertEquals(testData,data);

    }

}
