package com.egsystem.unikosheba.model;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Services implements Serializable {



//    public String name;
//    public String description;
//    public int image;
//
//    public Services(String name, int image) {
//        this.name = name;
//        this.description = description;
//        this.image = image;
//    }


//    @SerializedName("id")
//    @Expose
//    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("photo")
    @Expose
    private String photo;


    public String id;
    public String title;
//    public Drawable productImage;
    public String image;
    public String description;
    public double price;
    public boolean selected;

    public Services(String id,String title, String image, String description,
                   double price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
