package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorAllDepartmentsModel {

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

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }

    }


    public class Result {

        @SerializedName("doctor_departments")
        @Expose
        private List<DoctorDepartment> doctorDepartments;

        public List<DoctorDepartment> getDoctorDepartments() {
            return doctorDepartments;
        }

        public void setDoctorDepartments(List<DoctorDepartment> doctorDepartments) {
            this.doctorDepartments = doctorDepartments;
        }

    }
}