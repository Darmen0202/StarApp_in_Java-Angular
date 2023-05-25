package com.example.stars.models;

import com.example.stars.enums.StarColor;

public class Stars {

    private Long id;

    private String name;

    private String dec;

    private String ra;

    private String color;

    private String astronomer;

    public Stars() {
    }

    public Stars(String name, String dec, String ra, String color, String astronomer) {
        this.name = name;
        this.dec = dec;
        this.ra = ra;
        this.color = color;
        this.astronomer = astronomer;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stars{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dec='").append(dec).append('\'');
        sb.append(", ra='").append(ra).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", astronomer='").append(astronomer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
