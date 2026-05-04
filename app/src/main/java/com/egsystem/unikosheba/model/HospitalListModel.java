package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HospitalListModel {

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


    public class DoctorDepartment {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name_en")
        @Expose
        private String nameEn;
        @SerializedName("name_bn")
        @Expose
        private Object nameBn;
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

        public Object getNameBn() {
            return nameBn;
        }

        public void setNameBn(Object nameBn) {
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

        @SerializedName("hospitals")
        @Expose
        private List<Hospital> hospitals;

        public List<Hospital> getHospitals() {
            return hospitals;
        }

        public void setHospitals(List<Hospital> hospitals) {
            this.hospitals = hospitals;
        }

    }

}


//public class HospitalListModel {
//
//    @SerializedName("success")
//    @Expose
//    private Boolean success;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("result")
//    @Expose
//    private Result result;
//
//    public Boolean getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Boolean success) {
//        this.success = success;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Result getResult() {
//        return result;
//    }
//
//    public void setResult(Result result) {
//        this.result = result;
//    }
//
//
//
//
//public class DoctorDepartment {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name_en")
//    @Expose
//    private String nameEn;
//    @SerializedName("name_bn")
//    @Expose
//    private Object nameBn;
//    @SerializedName("description")
//    @Expose
//    private Object description;
//    @SerializedName("thumbnail_image")
//    @Expose
//    private String thumbnailImage;
//    @SerializedName("doctor_details")
//    @Expose
//    private List<DoctorDetail> doctorDetails;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNameEn() {
//        return nameEn;
//    }
//
//    public void setNameEn(String nameEn) {
//        this.nameEn = nameEn;
//    }
//
//    public Object getNameBn() {
//        return nameBn;
//    }
//
//    public void setNameBn(Object nameBn) {
//        this.nameBn = nameBn;
//    }
//
//    public Object getDescription() {
//        return description;
//    }
//
//    public void setDescription(Object description) {
//        this.description = description;
//    }
//
//    public String getThumbnailImage() {
//        return thumbnailImage;
//    }
//
//    public void setThumbnailImage(String thumbnailImage) {
//        this.thumbnailImage = thumbnailImage;
//    }
//
//    public List<DoctorDetail> getDoctorDetails() {
//        return doctorDetails;
//    }
//
//    public void setDoctorDetails(List<DoctorDetail> doctorDetails) {
//        this.doctorDetails = doctorDetails;
//    }
//
//}
//
//public class DoctorDetail {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("mobile_number")
//    @Expose
//    private String mobileNumber;
//    @SerializedName("email")
//    @Expose
//    private String email;
//    @SerializedName("gender")
//    @Expose
//    private String gender;
//    @SerializedName("date_of_birth")
//    @Expose
//    private String dateOfBirth;
//    @SerializedName("address")
//    @Expose
//    private String address;
//    @SerializedName("nid_no")
//    @Expose
//    private String nidNo;
//    @SerializedName("profile_image")
//    @Expose
//    private String profileImage;
//    @SerializedName("department_id")
//    @Expose
//    private Integer departmentId;
//    @SerializedName("department")
//    @Expose
//    private String department;
//    @SerializedName("specialist")
//    @Expose
//    private String specialist;
//    @SerializedName("chamber_address")
//    @Expose
//    private String chamberAddress;
//    @SerializedName("available_times")
//    @Expose
//    private String availableTimes;
//    @SerializedName("available_days")
//    @Expose
//    private List<String> availableDays;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getNidNo() {
//        return nidNo;
//    }
//
//    public void setNidNo(String nidNo) {
//        this.nidNo = nidNo;
//    }
//
//    public String getProfileImage() {
//        return profileImage;
//    }
//
//    public void setProfileImage(String profileImage) {
//        this.profileImage = profileImage;
//    }
//
//    public Integer getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Integer departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getSpecialist() {
//        return specialist;
//    }
//
//    public void setSpecialist(String specialist) {
//        this.specialist = specialist;
//    }
//
//    public String getChamberAddress() {
//        return chamberAddress;
//    }
//
//    public void setChamberAddress(String chamberAddress) {
//        this.chamberAddress = chamberAddress;
//    }
//
//    public String getAvailableTimes() {
//        return availableTimes;
//    }
//
//    public void setAvailableTimes(String availableTimes) {
//        this.availableTimes = availableTimes;
//    }
//
//    public List<String> getAvailableDays() {
//        return availableDays;
//    }
//
//    public void setAvailableDays(List<String> availableDays) {
//        this.availableDays = availableDays;
//    }
//
//}
//
//public class Hospital {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("code")
//    @Expose
//    private String code;
//    @SerializedName("contact_number_a")
//    @Expose
//    private String contactNumberA;
//    @SerializedName("contact_number_b")
//    @Expose
//    private String contactNumberB;
//    @SerializedName("contact_number_c")
//    @Expose
//    private String contactNumberC;
//    @SerializedName("email")
//    @Expose
//    private String email;
//    @SerializedName("website")
//    @Expose
//    private String website;
//    @SerializedName("address")
//    @Expose
//    private String address;
//    @SerializedName("latitude")
//    @Expose
//    private String latitude;
//    @SerializedName("longitude")
//    @Expose
//    private String longitude;
//    @SerializedName("logo_image")
//    @Expose
//    private String logoImage;
//    @SerializedName("description")
//    @Expose
//    private String description;
//    @SerializedName("doctor_departments")
//    @Expose
//    private List<DoctorDepartment> doctorDepartments;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getContactNumberA() {
//        return contactNumberA;
//    }
//
//    public void setContactNumberA(String contactNumberA) {
//        this.contactNumberA = contactNumberA;
//    }
//
//    public String getContactNumberB() {
//        return contactNumberB;
//    }
//
//    public void setContactNumberB(String contactNumberB) {
//        this.contactNumberB = contactNumberB;
//    }
//
//    public String getContactNumberC() {
//        return contactNumberC;
//    }
//
//    public void setContactNumberC(String contactNumberC) {
//        this.contactNumberC = contactNumberC;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getWebsite() {
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getLogoImage() {
//        return logoImage;
//    }
//
//    public void setLogoImage(String logoImage) {
//        this.logoImage = logoImage;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public List<DoctorDepartment> getDoctorDepartments() {
//        return doctorDepartments;
//    }
//
//    public void setDoctorDepartments(List<DoctorDepartment> doctorDepartments) {
//        this.doctorDepartments = doctorDepartments;
//    }
//
//}
//
//
//
//public class Result {
//
//    @SerializedName("hospitals")
//    @Expose
//    private List<Hospital> hospitals;
//
//    public List<Hospital> getHospitals() {
//        return hospitals;
//    }
//
//    public void setHospitals(List<Hospital> hospitals) {
//        this.hospitals = hospitals;
//    }
//
//}
//
//}