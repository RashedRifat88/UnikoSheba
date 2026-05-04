package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TutorRequestPostModel {

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

        @SerializedName("tutor_request_post_data")
        @Expose
        private TutorRequestPostData tutorRequestPostData;

        public TutorRequestPostData getTutorRequestPostData() {
            return tutorRequestPostData;
        }

        public void setTutorRequestPostData(TutorRequestPostData tutorRequestPostData) {
            this.tutorRequestPostData = tutorRequestPostData;
        }

    }

    public class TutorRequestPostData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("institute_name")
        @Expose
        private String instituteName;
        @SerializedName("class")
        @Expose
        private String _class;
        @SerializedName("subject")
        @Expose
        private String subject;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("teacher_gender")
        @Expose
        private String teacherGender;
        @SerializedName("preferable_institute")
        @Expose
        private String preferableInstitute;
        @SerializedName("guardian_mobile")
        @Expose
        private String guardianMobile;
        @SerializedName("mobile_show_status")
        @Expose
        private String mobileShowStatus;
        @SerializedName("tution_address")
        @Expose
        private String tutionAddress;
        @SerializedName("description")
        @Expose
        private String description;
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

        public String getInstituteName() {
            return instituteName;
        }

        public void setInstituteName(String instituteName) {
            this.instituteName = instituteName;
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

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getTeacherGender() {
            return teacherGender;
        }

        public void setTeacherGender(String teacherGender) {
            this.teacherGender = teacherGender;
        }

        public String getPreferableInstitute() {
            return preferableInstitute;
        }

        public void setPreferableInstitute(String preferableInstitute) {
            this.preferableInstitute = preferableInstitute;
        }

        public String getGuardianMobile() {
            return guardianMobile;
        }

        public void setGuardianMobile(String guardianMobile) {
            this.guardianMobile = guardianMobile;
        }

        public String getMobileShowStatus() {
            return mobileShowStatus;
        }

        public void setMobileShowStatus(String mobileShowStatus) {
            this.mobileShowStatus = mobileShowStatus;
        }

        public String getTutionAddress() {
            return tutionAddress;
        }

        public void setTutionAddress(String tutionAddress) {
            this.tutionAddress = tutionAddress;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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


}