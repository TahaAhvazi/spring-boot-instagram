package com.tahaahvazi.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Arrays;
import java.util.Objects;

@Table("PHOTOS")
public class Photos {
    @Id
    private Integer id;
    @NotEmpty
    private String fileName;
    private String ContentType;
    @JsonIgnore
    private byte[] data;

    //Create the constructor for the class
     // Default Constructor
    public Photos(){

    };
    // The parameterized Constructor
    public Photos(Integer id, String fileName, String contentType, byte[] data){
        this.id = id;
        this.fileName = fileName;
        this.ContentType = contentType;
        this.data = data;
    }
    //These are the Raw data !
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photos photos = (Photos) o;
        return Objects.equals(id, photos.id) &&
                Objects.equals(fileName, photos.fileName) &&
                Objects.equals(ContentType, photos.ContentType) &&
                Arrays.equals(data, photos.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, fileName, ContentType);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
