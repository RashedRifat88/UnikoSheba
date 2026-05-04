package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class NursePackageListModel implements Serializable {

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


    public class NursePackage implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("total_nurse")
        @Expose
        private String totalNurse;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("offer")
        @Expose
        private String offer;
        @SerializedName("package_code")
        @Expose
        private String packageCode;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;
        @SerializedName("status")
        @Expose
        private String status;

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

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getTotalNurse() {
            return totalNurse;
        }

        public void setTotalNurse(String totalNurse) {
            this.totalNurse = totalNurse;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getOffer() {
            return offer;
        }

        public void setOffer(String offer) {
            this.offer = offer;
        }

        public String getPackageCode() {
            return packageCode;
        }

        public void setPackageCode(String packageCode) {
            this.packageCode = packageCode;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public class Result implements Serializable {

        @SerializedName("nurse_packages")
        @Expose
        private List<NursePackage> nursePackages;

        public List<NursePackage> getNursePackages() {
            return nursePackages;
        }

        public void setNursePackages(List<NursePackage> nursePackages) {
            this.nursePackages = nursePackages;
        }

    }

}