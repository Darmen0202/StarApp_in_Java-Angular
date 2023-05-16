package com.example.stars.models;


public class Astronomers{

    private Long id;

    private String fullname;

    public Astronomers() {
    }

    public Astronomers(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
