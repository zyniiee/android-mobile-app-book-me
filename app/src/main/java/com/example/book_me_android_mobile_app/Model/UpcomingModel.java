package com.example.book_me_android_mobile_app.Model;

public class UpcomingModel {
    private String title;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getPicResId() {
        return picResId;
    }

    public void setPicResId(int picResId) {
        this.picResId = picResId;
    }

    private String location;
    private String status;
    private String reference;
    private int picResId;

    public UpcomingModel(String title, String date, String location, String status, String reference, int picResId) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.status = status;
        this.reference = reference;
        this.picResId = picResId;
    }
}
