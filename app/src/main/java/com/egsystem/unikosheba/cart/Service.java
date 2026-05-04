package com.egsystem.unikosheba.cart;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("photo")
    @Expose
    private String photo;


    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Service(String title, Drawable productImage, String description,
                   double price) {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


//        public class Product {
//
//            public String title;
//            public Drawable productImage;
//            public String description;
//            public double price;
//            public boolean selected;
//
//            public Product(String title, Drawable productImage, String description,
//                           double price) {
//                this.title = title;
//                this.productImage = productImage;
//                this.description = description;
//                this.price = price;
//            }
//
//        }



}
