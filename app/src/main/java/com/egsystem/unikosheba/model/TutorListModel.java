package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class TutorListModel implements Serializable {

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


    public class Result implements Serializable {

        @SerializedName("teachers")
        @Expose
        private List<Teacher> teachers;

        public List<Teacher> getTeachers() {
            return teachers;
        }

        public void setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
        }

    }

    public class Teacher implements Serializable {

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
        @SerializedName("note")
        @Expose
        private String note;
        @SerializedName("class")
        @Expose
        private String _class;
        @SerializedName("subject")
        @Expose
        private String subject;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("preferable_classes")
        @Expose
        private String preferableClasses;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("institute_a")
        @Expose
        private String instituteA;
        @SerializedName("institute_b")
        @Expose
        private String instituteB;
        @SerializedName("education_completion_year")
        @Expose
        private String educationCompletionYear;
        @SerializedName("degree")
        @Expose
        private String degree;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("present_address")
        @Expose
        private String presentAddress;
        @SerializedName("permanent_address")
        @Expose
        private String permanentAddress;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;

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

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getClass_() {
            return _class;
        }

        public void setClass_(String _class) {
            this._class = _class;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getPreferableClasses() {
            return preferableClasses;
        }

        public void setPreferableClasses(String preferableClasses) {
            this.preferableClasses = preferableClasses;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getInstituteA() {
            return instituteA;
        }

        public void setInstituteA(String instituteA) {
            this.instituteA = instituteA;
        }

        public String getInstituteB() {
            return instituteB;
        }

        public void setInstituteB(String instituteB) {
            this.instituteB = instituteB;
        }

        public String getEducationCompletionYear() {
            return educationCompletionYear;
        }

        public void setEducationCompletionYear(String educationCompletionYear) {
            this.educationCompletionYear = educationCompletionYear;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPresentAddress() {
            return presentAddress;
        }

        public void setPresentAddress(String presentAddress) {
            this.presentAddress = presentAddress;
        }

        public String getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

    }


}