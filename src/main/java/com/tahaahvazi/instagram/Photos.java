package com.tahaahvazi.instagram;

public class Photos {
    private String id;
    private String fileName;

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
}
