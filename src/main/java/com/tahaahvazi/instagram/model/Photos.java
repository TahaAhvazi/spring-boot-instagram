package com.tahaahvazi.instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photos {
    private String id;
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
    public Photos(String id, String fileName){
        this.id = id;
        this.fileName = fileName;
    }
    //These are the Raw data !
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
