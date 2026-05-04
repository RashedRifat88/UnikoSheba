package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AmbulanceRequestModel {

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


    public class Ambulance {

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

    public class AmbulanceRequest {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("reference_no")
        @Expose
        private String referenceNo;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("contact_number_a")
        @Expose
        private String contactNumberA;
        @SerializedName("contact_number_b")
        @Expose
        private String contactNumberB;
        @SerializedName("amount_range")
        @Expose
        private String amountRange;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("situation")
        @Expose
        private String situation;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("posted")
        @Expose
        private String posted;
        @SerializedName("completed_at")
        @Expose
        private String completedAt;
        @SerializedName("client")
        @Expose
        private Client client;
        @SerializedName("ambulance")
        @Expose
        private Ambulance ambulance;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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

        public String getAmountRange() {
            return amountRange;
        }

        public void setAmountRange(String amountRange) {
            this.amountRange = amountRange;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSituation() {
            return situation;
        }

        public void setSituation(String situation) {
            this.situation = situation;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPosted() {
            return posted;
        }

        public void setPosted(String posted) {
            this.posted = posted;
        }

        public String getCompletedAt() {
            return completedAt;
        }

        public void setCompletedAt(String completedAt) {
            this.completedAt = completedAt;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public Ambulance getAmbulance() {
            return ambulance;
        }

        public void setAmbulance(Ambulance ambulance) {
            this.ambulance = ambulance;
        }

    }


    public class Client {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("nid_no")
        @Expose
        private String nidNo;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
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

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNidNo() {
            return nidNo;
        }

        public void setNidNo(String nidNo) {
            this.nidNo = nidNo;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public class Result {

        @SerializedName("ambulance_request")
        @Expose
        private AmbulanceRequest ambulanceRequest;

        public AmbulanceRequest getAmbulanceRequest() {
            return ambulanceRequest;
        }

        public void setAmbulanceRequest(AmbulanceRequest ambulanceRequest) {
            this.ambulanceRequest = ambulanceRequest;
        }

    }

}