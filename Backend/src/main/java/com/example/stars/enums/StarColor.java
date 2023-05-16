package com.example.stars.enums;

public enum StarColor {
    BLUE("голубая"),
    BLUE_WHITE("бело-голубая"),
    WHITE("белая"),
    YELLOW_WHITE("желто-белая"),
    YELLOW("желтая"),
    ORANGE("оранжевая"),
    RED("красная");

    private final String color;

    StarColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
