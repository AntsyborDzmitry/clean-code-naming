package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;

public class User {

    private boolean isAdmin;

    private String birthDate;

    private String name;

    private User[] subordinates;

    private int rating;

    public User(String name, String birthDate, User[] subordinates) {
        this.birthDate = birthDate;
        this.name = name;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "User [dateOfBirth=" + birthDate + ", name=" + name + ", isAdmin=" + isAdmin + ", subordinates="
                + Arrays.toString(subordinates) + ", rating=" + rating + "]";
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
