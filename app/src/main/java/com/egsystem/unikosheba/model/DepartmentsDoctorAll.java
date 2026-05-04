package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DepartmentsDoctorAll {

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


    public class Doctor {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("email")
        @Expose
        private String email;
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
        @SerializedName("department_id")
        @Expose
        private Integer departmentId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("specialist")
        @Expose
        private String specialist;
        @SerializedName("designation")
        @Expose
        private String designation;
        @SerializedName("degree")
        @Expose
        private String degree;
        @SerializedName("bmdc_no")
        @Expose
        private String bmdcNo;
        @SerializedName("experiences")
        @Expose
        private String experiences;
        @SerializedName("appointment_fees")
        @Expose
        private String appointmentFees;
        @SerializedName("appointment_plan")
        @Expose
        private String appointmentPlan;
        @SerializedName("chamber_address")
        @Expose
        private String chamberAddress;
        @SerializedName("hospital_name")
        @Expose
        private String hospitalName;
        @SerializedName("available_times")
        @Expose
        private String availableTimes;
        @SerializedName("available_days")
        @Expose
        private List<String> availableDays;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSpecialist() {
            return specialist;
        }

        public void setSpecialist(String specialist) {
            this.specialist = specialist;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getBmdcNo() {
            return bmdcNo;
        }

        public void setBmdcNo(String bmdcNo) {
            this.bmdcNo = bmdcNo;
        }

        public String getExperiences() {
            return experiences;
        }

        public void setExperiences(String experiences) {
            this.experiences = experiences;
        }

        public String getAppointmentFees() {
            return appointmentFees;
        }

        public void setAppointmentFees(String appointmentFees) {
            this.appointmentFees = appointmentFees;
        }

        public String getAppointmentPlan() {
            return appointmentPlan;
        }

        public void setAppointmentPlan(String appointmentPlan) {
            this.appointmentPlan = appointmentPlan;
        }

        public String getChamberAddress() {
            return chamberAddress;
        }

        public void setChamberAddress(String chamberAddress) {
            this.chamberAddress = chamberAddress;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getAvailableTimes() {
            return availableTimes;
        }

        public void setAvailableTimes(String availableTimes) {
            this.availableTimes = availableTimes;
        }

        public List<String> getAvailableDays() {
            return availableDays;
        }

        public void setAvailableDays(List<String> availableDays) {
            this.availableDays = availableDays;
        }

    }


    public class Result {

        @SerializedName("doctors")
        @Expose
        private List<Doctor> doctors;

        public List<Doctor> getDoctors() {
            return doctors;
        }

        public void setDoctors(List<Doctor> doctors) {
            this.doctors = doctors;
        }

    }

}