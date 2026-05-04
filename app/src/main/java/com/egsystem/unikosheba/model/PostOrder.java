package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostOrder {

    @SerializedName("client")
    @Expose
    private Integer client;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("visiting_date")
    @Expose
    private String visitingDate;
    @SerializedName("visiting_time")
    @Expose
    private String visitingTime;
    @SerializedName("visiting_duration")
    @Expose
    private Integer visitingDuration;
    @SerializedName("working_date")
    @Expose
    private String workingDate;
    @SerializedName("working_time")
    @Expose
    private Object workingTime;
    @SerializedName("working_duration")
    @Expose
    private Integer workingDuration;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("service_area")
    @Expose
    private Integer serviceArea;
    @SerializedName("division")
    @Expose
    private Integer division;
    @SerializedName("district")
    @Expose
    private Integer district;
    @SerializedName("upazila")
    @Expose
    private Integer upazila;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("estimated_cost")
    @Expose
    private String estimatedCost;
    @SerializedName("urgency")
    @Expose
    private String urgency;
    @SerializedName("is_posted_by_admin")
    @Expose
    private Boolean isPostedByAdmin;
    @SerializedName("admin_user")
    @Expose
    private Object adminUser;
    @SerializedName("notes")
    @Expose
    private Object notes;

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(String visitingDate) {
        this.visitingDate = visitingDate;
    }

    public String getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(String visitingTime) {
        this.visitingTime = visitingTime;
    }

    public Integer getVisitingDuration() {
        return visitingDuration;
    }

    public void setVisitingDuration(Integer visitingDuration) {
        this.visitingDuration = visitingDuration;
    }

    public String getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(String workingDate) {
        this.workingDate = workingDate;
    }

    public Object getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Object workingTime) {
        this.workingTime = workingTime;
    }

    public Integer getWorkingDuration() {
        return workingDuration;
    }

    public void setWorkingDuration(Integer workingDuration) {
        this.workingDuration = workingDuration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getUpazila() {
        return upazila;
    }

    public void setUpazila(Integer upazila) {
        this.upazila = upazila;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Boolean getIsPostedByAdmin() {
        return isPostedByAdmin;
    }

    public void setIsPostedByAdmin(Boolean isPostedByAdmin) {
        this.isPostedByAdmin = isPostedByAdmin;
    }

    public Object getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(Object adminUser) {
        this.adminUser = adminUser;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

}