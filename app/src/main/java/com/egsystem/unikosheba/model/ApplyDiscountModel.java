package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ApplyDiscountModel {

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


    public class ClientHospitalDiscount {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("client")
        @Expose
        private Client client;
        @SerializedName("hospital")
        @Expose
        private Hospital hospital;
        @SerializedName("discount_code")
        @Expose
        private String discountCode;
        @SerializedName("accepted_at")
        @Expose
        private String acceptedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public Hospital getHospital() {
            return hospital;
        }

        public void setHospital(Hospital hospital) {
            this.hospital = hospital;
        }

        public String getDiscountCode() {
            return discountCode;
        }

        public void setDiscountCode(String discountCode) {
            this.discountCode = discountCode;
        }

        public String getAcceptedAt() {
            return acceptedAt;
        }

        public void setAcceptedAt(String acceptedAt) {
            this.acceptedAt = acceptedAt;
        }

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


    public class DoctorDepartment {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name_en")
        @Expose
        private String nameEn;
        @SerializedName("name_bn")
        @Expose
        private String nameBn;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;
        @SerializedName("doctor_details")
        @Expose
        private List<DoctorDetail> doctorDetails;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNameEn() {
            return nameEn;
        }

        public void setNameEn(String nameEn) {
            this.nameEn = nameEn;
        }

        public String getNameBn() {
            return nameBn;
        }

        public void setNameBn(String nameBn) {
            this.nameBn = nameBn;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }

        public List<DoctorDetail> getDoctorDetails() {
            return doctorDetails;
        }

        public void setDoctorDetails(List<DoctorDetail> doctorDetails) {
            this.doctorDetails = doctorDetails;
        }

    }

    public class DoctorDetail {

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
        private String departmentId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("specialist")
        @Expose
        private String specialist;
        @SerializedName("chamber_address")
        @Expose
        private String chamberAddress;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
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

        public String getChamberAddress() {
            return chamberAddress;
        }

        public void setChamberAddress(String chamberAddress) {
            this.chamberAddress = chamberAddress;
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

    public class Hospital {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("contact_number_a")
        @Expose
        private String contactNumberA;
        @SerializedName("contact_number_b")
        @Expose
        private String contactNumberB;
        @SerializedName("contact_number_c")
        @Expose
        private String contactNumberC;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("website")
        @Expose
        private String website;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("logo_image")
        @Expose
        private String logoImage;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("diagnosis_test_discount")
        @Expose
        private String diagnosisTestDiscount;
        @SerializedName("doctor_departments")
        @Expose
        private List<DoctorDepartment> doctorDepartments;

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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public String getContactNumberC() {
            return contactNumberC;
        }

        public void setContactNumberC(String contactNumberC) {
            this.contactNumberC = contactNumberC;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getLogoImage() {
            return logoImage;
        }

        public void setLogoImage(String logoImage) {
            this.logoImage = logoImage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDiagnosisTestDiscount() {
            return diagnosisTestDiscount;
        }

        public void setDiagnosisTestDiscount(String diagnosisTestDiscount) {
            this.diagnosisTestDiscount = diagnosisTestDiscount;
        }

        public List<DoctorDepartment> getDoctorDepartments() {
            return doctorDepartments;
        }

        public void setDoctorDepartments(List<DoctorDepartment> doctorDepartments) {
            this.doctorDepartments = doctorDepartments;
        }

    }

    public class Result {

        @SerializedName("client_hospital_discount")
        @Expose
        private ClientHospitalDiscount clientHospitalDiscount;

        public ClientHospitalDiscount getClientHospitalDiscount() {
            return clientHospitalDiscount;
        }

        public void setClientHospitalDiscount(ClientHospitalDiscount clientHospitalDiscount) {
            this.clientHospitalDiscount = clientHospitalDiscount;
        }

    }

}