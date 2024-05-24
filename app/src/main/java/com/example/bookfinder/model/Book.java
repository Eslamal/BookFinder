package com.example.bookfinder.model;
import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private VolumeInfo volumeInfo;

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public static class VolumeInfo implements Serializable {
        private String title;
        private String[] authors;
        private String description;
        private ImageLinks imageLinks;

        public String getTitle() {
            return title;
        }

        public String[] getAuthors() {
            return authors;
        }

        public String getDescription() {
            return description;
        }

        public ImageLinks getImageLinks() {
            return imageLinks;
        }
    }

    public static class ImageLinks implements Serializable {
        private String thumbnail;

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
