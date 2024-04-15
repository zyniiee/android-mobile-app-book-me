package com.example.book_me_android_mobile_app.Model;

public class DealsModel {
    private String title;
    private String rating;
    private String bestBetween;
    private String saves;
    private String spaces;
    private double price;
    private int picResId;

    public DealsModel(String title, String rating, String bestBetween, String saves, String spaces, double price, int picResId) {
        this.title = title;
        this.rating = rating;
        this.bestBetween = bestBetween;
        this.saves = saves;
        this.spaces = spaces;
        this.price = price;
        this.picResId = picResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBestBetween() {
        return bestBetween;
    }

    public void setBestBetween(String bestBetween) {
        this.bestBetween = bestBetween;
    }

    public String getSaves() {
        return saves;
    }

    public void setSaves(String saves) {
        this.saves = saves;
    }

    public String getSpaces() {
        return spaces;
    }

    public void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPicResId() {
        return picResId;
    }

    public void setPicResId(int picResId) {
        this.picResId = picResId;
    }
}
