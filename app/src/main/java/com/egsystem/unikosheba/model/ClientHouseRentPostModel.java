package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientHouseRentPostModel {

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


    public class CreatedUser {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_type")
        @Expose
        private String userType;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("email")
        @Expose
        private Object email;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("security")
        @Expose
        private String security;
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
        private Object nidNo;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("device_name")
        @Expose
        private Object deviceName;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("profile_verified_at")
        @Expose
        private Object profileVerifiedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
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

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
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

        public Object getNidNo() {
            return nidNo;
        }

        public void setNidNo(Object nidNo) {
            this.nidNo = nidNo;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public Object getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(Object deviceName) {
            this.deviceName = deviceName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getProfileVerifiedAt() {
            return profileVerifiedAt;
        }

        public void setProfileVerifiedAt(Object profileVerifiedAt) {
            this.profileVerifiedAt = profileVerifiedAt;
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

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

    }

    public class HouseRent {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("room_number")
        @Expose
        private String roomNumber;
        @SerializedName("balcony_number")
        @Expose
        private String balconyNumber;
        @SerializedName("toilet_number")
        @Expose
        private String toiletNumber;
        @SerializedName("room_description")
        @Expose
        private String roomDescription;
        @SerializedName("rent_amount")
        @Expose
        private String rentAmount;
        @SerializedName("offer")
        @Expose
        private String offer;
        @SerializedName("service_charge")
        @Expose
        private String serviceCharge;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("gas_status")
        @Expose
        private String gasStatus;
        @SerializedName("lift_status")
        @Expose
        private String liftStatus;
        @SerializedName("generator_status")
        @Expose
        private String generatorStatus;
        @SerializedName("security_guard_status")
        @Expose
        private String securityGuardStatus;
        @SerializedName("cc_camera_status")
        @Expose
        private String ccCameraStatus;
        @SerializedName("car_parking_status")
        @Expose
        private String carParkingStatus;
        @SerializedName("garden_status")
        @Expose
        private String gardenStatus;
        @SerializedName("other")
        @Expose
        private String other;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;
        @SerializedName("created_by")
        @Expose
        private Integer createdBy;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_user")
        @Expose
        private CreatedUser createdUser;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getBalconyNumber() {
            return balconyNumber;
        }

        public void setBalconyNumber(String balconyNumber) {
            this.balconyNumber = balconyNumber;
        }

        public String getToiletNumber() {
            return toiletNumber;
        }

        public void setToiletNumber(String toiletNumber) {
            this.toiletNumber = toiletNumber;
        }

        public String getRoomDescription() {
            return roomDescription;
        }

        public void setRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
        }

        public String getRentAmount() {
            return rentAmount;
        }

        public void setRentAmount(String rentAmount) {
            this.rentAmount = rentAmount;
        }

        public String getOffer() {
            return offer;
        }

        public void setOffer(String offer) {
            this.offer = offer;
        }

        public String getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(String serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGasStatus() {
            return gasStatus;
        }

        public void setGasStatus(String gasStatus) {
            this.gasStatus = gasStatus;
        }

        public String getLiftStatus() {
            return liftStatus;
        }

        public void setLiftStatus(String liftStatus) {
            this.liftStatus = liftStatus;
        }

        public String getGeneratorStatus() {
            return generatorStatus;
        }

        public void setGeneratorStatus(String generatorStatus) {
            this.generatorStatus = generatorStatus;
        }

        public String getSecurityGuardStatus() {
            return securityGuardStatus;
        }

        public void setSecurityGuardStatus(String securityGuardStatus) {
            this.securityGuardStatus = securityGuardStatus;
        }

        public String getCcCameraStatus() {
            return ccCameraStatus;
        }

        public void setCcCameraStatus(String ccCameraStatus) {
            this.ccCameraStatus = ccCameraStatus;
        }

        public String getCarParkingStatus() {
            return carParkingStatus;
        }

        public void setCarParkingStatus(String carParkingStatus) {
            this.carParkingStatus = carParkingStatus;
        }

        public String getGardenStatus() {
            return gardenStatus;
        }

        public void setGardenStatus(String gardenStatus) {
            this.gardenStatus = gardenStatus;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public CreatedUser getCreatedUser() {
            return createdUser;
        }

        public void setCreatedUser(CreatedUser createdUser) {
            this.createdUser = createdUser;
        }

    }

    public class Result {

        @SerializedName("house_rent")
        @Expose
        private HouseRent houseRent;

        public HouseRent getHouseRent() {
            return houseRent;
        }

        public void setHouseRent(HouseRent houseRent) {
            this.houseRent = houseRent;
        }

    }

}