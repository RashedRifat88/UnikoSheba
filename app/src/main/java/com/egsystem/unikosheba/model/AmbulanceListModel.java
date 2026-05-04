package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AmbulanceListModel implements Serializable{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private Result result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


    public class Ambulance implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("ambulance_no")
        @Expose
        private String ambulanceNo;
        @SerializedName("cc")
        @Expose
        private String cc;
        @SerializedName("rent_price")
        @Expose
        private String rentPrice;
        @SerializedName("contact_number_a")
        @Expose
        private String contactNumberA;
        @SerializedName("contact_number_b")
        @Expose
        private String contactNumberB;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;

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

        public String getAmbulanceNo() {
            return ambulanceNo;
        }

        public void setAmbulanceNo(String ambulanceNo) {
            this.ambulanceNo = ambulanceNo;
        }

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }

        public String getRentPrice() {
            return rentPrice;
        }

        public void setRentPrice(String rentPrice) {
            this.rentPrice = rentPrice;
        }

        public String getContactNumberA() {
            return contactNumberA;
        }

        public void setContactNumberA(String contactNumberA) {
            this.contactNumberA = contactNumberA;
        }

        public String getContactNumberB() {
            return contactNumberB;
        }

        public void setContactNumberB(String contactNumberB) {
            this.contactNumberB = contactNumberB;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }

    }


    public class Result implements Serializable{

        @SerializedName("ambulances")
        @Expose
        private List<Ambulance> ambulances;

        public List<Ambulance> getAmbulances() {
            return ambulances;
        }

        public void setAmbulances(List<Ambulance> ambulances) {
            this.ambulances = ambulances;
        }

    }

}