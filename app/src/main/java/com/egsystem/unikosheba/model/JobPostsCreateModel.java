package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobPostsCreateModel {

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


    public class JobPostCategory {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

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

    }


    public class Result {

        @SerializedName("job_post_data")
        @Expose
        private Object jobPostData;
        @SerializedName("job_post_categories")
        @Expose
        private List<JobPostCategory> jobPostCategories;
        @SerializedName("status")
        @Expose
        private List<String> status;

        public Object getJobPostData() {
            return jobPostData;
        }

        public void setJobPostData(Object jobPostData) {
            this.jobPostData = jobPostData;
        }

        public List<JobPostCategory> getJobPostCategories() {
            return jobPostCategories;
        }

        public void setJobPostCategories(List<JobPostCategory> jobPostCategories) {
            this.jobPostCategories = jobPostCategories;
        }

        public List<String> getStatus() {
            return status;
        }

        public void setStatus(List<String> status) {
            this.status = status;
        }

    }
}