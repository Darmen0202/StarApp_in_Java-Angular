package com.example.stars.dto;

public class StarDTO {

    private String name;

    private String dec;

    private String ra;

    private String color;

    private String astronomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAstronomer() {
        return astronomer;
    }

    public void setAstronomer(String astronomer) {
        this.astronomer = astronomer;
    }

}
