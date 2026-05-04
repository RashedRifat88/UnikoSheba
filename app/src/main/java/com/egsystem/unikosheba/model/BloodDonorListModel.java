package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BloodDonorListModel {

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


    public class BloodDonor {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("user_image")
        @Expose
        private String userImage;
        @SerializedName("user")
        @Expose
        private String user;
        @SerializedName("organization_id")
        @Expose
        private String organizationId;
        @SerializedName("organization")
        @Expose
        private String organization;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("blood_group")
        @Expose
        private String bloodGroup;
        @SerializedName("total_donation")
        @Expose
        private String totalDonation;
        @SerializedName("hemoglobin")
        @Expose
        private String hemoglobin;
        @SerializedName("last_donation_date")
        @Expose
        private String lastDonationDate;
        @SerializedName("contact_number_a")
        @Expose
        private String contactNumberA;
        @SerializedName("contact_number_b")
        @Expose
        private String contactNumberB;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("available_for_donations")
        @Expose
        private String availableForDonations;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public String getTotalDonation() {
            return totalDonation;
        }

        public void setTotalDonation(String totalDonation) {
            this.totalDonation = totalDonation;
        }

        public String getHemoglobin() {
            return hemoglobin;
        }

        public void setHemoglobin(String hemoglobin) {
            this.hemoglobin = hemoglobin;
        }

        public String getLastDonationDate() {
            return lastDonationDate;
        }

        public void setLastDonationDate(String lastDonationDate) {
            this.lastDonationDate = lastDonationDate;
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getAvailableForDonations() {
            return availableForDonations;
        }

        public void setAvailableForDonations(String availableForDonations) {
            this.availableForDonations = availableForDonations;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }


    public class Result {

        @SerializedName("blood_donors")
        @Expose
        private List<BloodDonor> bloodDonors;

        public List<BloodDonor> getBloodDonors() {
            return bloodDonors;
        }

        public void setBloodDonors(List<BloodDonor> bloodDonors) {
            this.bloodDonors = bloodDonors;
        }

    }

}