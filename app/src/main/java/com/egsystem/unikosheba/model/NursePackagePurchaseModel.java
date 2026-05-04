package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NursePackagePurchaseModel {

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




public class Client {

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
    private String email;
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
    private Object address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
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

public class NursePackage {

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
    private String price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

public class NursePackagePurchase {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nurse_package_id")
    @Expose
    private String nursePackageId;
    @SerializedName("nurse_package")
    @Expose
    private NursePackage nursePackage;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("patient_age")
    @Expose
    private String patientAge;
    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("desease_details")
    @Expose
    private String deseaseDetails;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("map_location")
    @Expose
    private String mapLocation;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nurse_package_services")
    @Expose
    private List<NursePackageService> nursePackageServices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNursePackageId() {
        return nursePackageId;
    }

    public void setNursePackageId(String nursePackageId) {
        this.nursePackageId = nursePackageId;
    }

    public NursePackage getNursePackage() {
        return nursePackage;
    }

    public void setNursePackage(NursePackage nursePackage) {
        this.nursePackage = nursePackage;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDeseaseDetails() {
        return deseaseDetails;
    }

    public void setDeseaseDetails(String deseaseDetails) {
        this.deseaseDetails = deseaseDetails;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NursePackageService> getNursePackageServices() {
        return nursePackageServices;
    }

    public void setNursePackageServices(List<NursePackageService> nursePackageServices) {
        this.nursePackageServices = nursePackageServices;
    }

}



public class NursePackageService {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

public class Result {

    @SerializedName("nurse_package_purchase")
    @Expose
    private NursePackagePurchase nursePackagePurchase;

    public NursePackagePurchase getNursePackagePurchase() {
        return nursePackagePurchase;
    }

    public void setNursePackagePurchase(NursePackagePurchase nursePackagePurchase) {
        this.nursePackagePurchase = nursePackagePurchase;
    }

}

}