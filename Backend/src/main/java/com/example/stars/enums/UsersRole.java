package com.example.stars.enums;

public enum UsersRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String role;

    UsersRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
