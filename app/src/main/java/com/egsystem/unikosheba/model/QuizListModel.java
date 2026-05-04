package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuizListModel implements Serializable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("exams")
    @Expose
    private List<Exam> exams;

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

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    public class Exam implements Serializable{

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("started_date_and_time")
        @Expose
        private String startedDateAndTime;
        @SerializedName("expired_date_and_time")
        @Expose
        private String expiredDateAndTime;
        @SerializedName("result_publish_time")
        @Expose
        private String resultPublishTime;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("total_mark")
        @Expose
        private String totalMark;
        @SerializedName("per_question_mark")
        @Expose
        private String perQuestionMark;
        @SerializedName("per_question_negative_mark")
        @Expose
        private String perQuestionNegativeMark;
        @SerializedName("exam_entry_description")
        @Expose
        private String examEntryDescription;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("subject")
        @Expose
        private Subject subject;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStartedDateAndTime() {
            return startedDateAndTime;
        }

        public void setStartedDateAndTime(String startedDateAndTime) {
            this.startedDateAndTime = startedDateAndTime;
        }

        public String getExpiredDateAndTime() {
            return expiredDateAndTime;
        }

        public void setExpiredDateAndTime(String expiredDateAndTime) {
            this.expiredDateAndTime = expiredDateAndTime;
        }

        public String getResultPublishTime() {
            return resultPublishTime;
        }

        public void setResultPublishTime(String resultPublishTime) {
            this.resultPublishTime = resultPublishTime;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getTotalMark() {
            return totalMark;
        }

        public void setTotalMark(String totalMark) {
            this.totalMark = totalMark;
        }

        public String getPerQuestionMark() {
            return perQuestionMark;
        }

        public void setPerQuestionMark(String perQuestionMark) {
            this.perQuestionMark = perQuestionMark;
        }

        public String getPerQuestionNegativeMark() {
            return perQuestionNegativeMark;
        }

        public void setPerQuestionNegativeMark(String perQuestionNegativeMark) {
            this.perQuestionNegativeMark = perQuestionNegativeMark;
        }

        public String getExamEntryDescription() {
            return examEntryDescription;
        }

        public void setExamEntryDescription(String examEntryDescription) {
            this.examEntryDescription = examEntryDescription;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }

    }


    public class Subject implements Serializable{

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("total_mark")
        @Expose
        private String totalMark;
        @SerializedName("total_credit")
        @Expose
        private String totalCredit;
        @SerializedName("status")
        @Expose
        private String status;
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

        public String getTotalMark() {
            return totalMark;
        }

        public void setTotalMark(String totalMark) {
            this.totalMark = totalMark;
        }

        public String getTotalCredit() {
            return totalCredit;
        }

        public void setTotalCredit(String totalCredit) {
            this.totalCredit = totalCredit;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

}