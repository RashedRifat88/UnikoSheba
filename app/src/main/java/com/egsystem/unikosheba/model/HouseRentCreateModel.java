package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HouseRentCreateModel {

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


    public class Area {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

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

    }


    public class Result {

        @SerializedName("house_rent_data")
        @Expose
        private Object houseRentData;
        @SerializedName("asset_status")
        @Expose
        private List<String> assetStatus;
        @SerializedName("status")
        @Expose
        private List<String> status;
        @SerializedName("areas")
        @Expose
        private List<Area> areas;

        public Object getHouseRentData() {
            return houseRentData;
        }

        public void setHouseRentData(Object houseRentData) {
            this.houseRentData = houseRentData;
        }

        public List<String> getAssetStatus() {
            return assetStatus;
        }

        public void setAssetStatus(List<String> assetStatus) {
            this.assetStatus = assetStatus;
        }

        public List<String> getStatus() {
            return status;
        }

        public void setStatus(List<String> status) {
            this.status = status;
        }

        public List<Area> getAreas() {
            return areas;
        }

        public void setAreas(List<Area> areas) {
            this.areas = areas;
        }

    }

}