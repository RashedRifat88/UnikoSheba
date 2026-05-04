package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("tokens")
    @Expose
    private Tokens tokens;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public void setTokens(Tokens tokens) {
        this.tokens = tokens;
    }


    public class Tokens {

        @SerializedName("refresh")
        @Expose
        private String refresh;
        @SerializedName("access")
        @Expose
        private String access;

        public String getRefresh() {
            return refresh;
        }

        public void setRefresh(String refresh) {
            this.refresh = refresh;
        }

        public String getAccess() {
            return access;
        }

        public void setAccess(String access) {
            this.access = access;
        }

    }


    public class User {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("email")
        @Expose
        private Object email;
        @SerializedName("address")
        @Expose
        private Object address;
        @SerializedName("location_area")
        @Expose
        private String locationArea;
        @SerializedName("profile_picture")
        @Expose
        private Object profilePicture;
        @SerializedName("date_of_birth")
        @Expose
        private Object dateOfBirth;
        @SerializedName("national_id")
        @Expose
        private Object nationalId;
        @SerializedName("academic_info")
        @Expose
        private Object academicInfo;
        @SerializedName("additional_contact_name")
        @Expose
        private Object additionalContactName;
        @SerializedName("additional_contact_address")
        @Expose
        private Object additionalContactAddress;
        @SerializedName("additional_contact_phone")
        @Expose
        private Object additionalContactPhone;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("balance")
        @Expose
        private String balance;
        @SerializedName("is_active")
        @Expose
        private Boolean isActive;
        @SerializedName("is_verified")
        @Expose
        private Boolean isVerified;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getLocationArea() {
            return locationArea;
        }

        public void setLocationArea(String locationArea) {
            this.locationArea = locationArea;
        }

        public Object getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(Object profilePicture) {
            this.profilePicture = profilePicture;
        }

        public Object getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Object dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Object getNationalId() {
            return nationalId;
        }

        public void setNationalId(Object nationalId) {
            this.nationalId = nationalId;
        }

        public Object getAcademicInfo() {
            return academicInfo;
        }

        public void setAcademicInfo(Object academicInfo) {
            this.academicInfo = academicInfo;
        }

        public Object getAdditionalContactName() {
            return additionalContactName;
        }

        public void setAdditionalContactName(Object additionalContactName) {
            this.additionalContactName = additionalContactName;
        }

        public Object getAdditionalContactAddress() {
            return additionalContactAddress;
        }

        public void setAdditionalContactAddress(Object additionalContactAddress) {
            this.additionalContactAddress = additionalContactAddress;
        }

        public Object getAdditionalContactPhone() {
            return additionalContactPhone;
        }

        public void setAdditionalContactPhone(Object additionalContactPhone) {
            this.additionalContactPhone = additionalContactPhone;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getIsVerified() {
            return isVerified;
        }

        public void setIsVerified(Boolean isVerified) {
            this.isVerified = isVerified;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }


}