package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FireServicesModel {

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


    public class FireService {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("phone_number_a")
        @Expose
        private String phoneNumberA;
        @SerializedName("phone_number_b")
        @Expose
        private String phoneNumberB;
        @SerializedName("description")
        @Expose
        private String description;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumberA() {
            return phoneNumberA;
        }

        public void setPhoneNumberA(String phoneNumberA) {
            this.phoneNumberA = phoneNumberA;
        }

        public String getPhoneNumberB() {
            return phoneNumberB;
        }

        public void setPhoneNumberB(String phoneNumberB) {
            this.phoneNumberB = phoneNumberB;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public class Result {

        @SerializedName("fire_services")
        @Expose
        private List<FireService> fireServices;

        public List<FireService> getFireServices() {
            return fireServices;
        }

        public void setFireServices(List<FireService> fireServices) {
            this.fireServices = fireServices;
        }

    }

}