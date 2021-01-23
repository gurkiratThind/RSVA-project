package com.example.finalproject2;

import android.graphics.Bitmap;

public class Mechanics {
    String firstName;
    String lastName;
    float rating;
    byte[] thumbnail;

    public Mechanics(String firstName, String lastName, float rating, byte[] thumbnail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}
