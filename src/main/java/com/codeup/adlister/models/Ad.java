package com.codeup.adlister.models;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Ad {
    private long id;
    private long userId;
    private long catId;
    private Timestamp createdAt;
    private String title;
    private String description;
    private String img;

    public Ad(long id, long userId, long catId, String title, String description,
              String img, Timestamp createdAt) {
                this.id = id;
                this.userId = userId;
                this.title = title;
                this.catId = catId;
                this.description = description;
                this.img = img;
                this.createdAt = createdAt;

    }

    public Ad(long id, long userId, long catId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.catId = catId;
        this.description = description;
        this.img = "";
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());

    }

    public Ad(long userId, long catId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.catId = catId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long id) {
        this.catId = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
