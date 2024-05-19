package com.ghavio.myapplication;

public class NewsItem {
    private String title;
    private String description;
    private int imageResourceId;
    private OnNewsItemClickListener clickListener; // Added click listener interface

    public NewsItem(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setOnNewsItemClickListener(OnNewsItemClickListener listener) {
        this.clickListener = listener;
    }

    // Interface for handling click events on NewsItem objects
    public interface OnNewsItemClickListener {
        void onNewsItemClicked(NewsItem newsItem);
    }
}
