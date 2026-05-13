package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AllNotificationModel {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    public class Result {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("is_read")
        @Expose
        private Boolean isRead;
        @SerializedName("related_job_id")
        @Expose
        private Object relatedJobId;
        @SerializedName("related_bill_id")
        @Expose
        private Object relatedBillId;
        @SerializedName("sent_at")
        @Expose
        private String sentAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getIsRead() {
            return isRead;
        }

        public void setIsRead(Boolean isRead) {
            this.isRead = isRead;
        }

        public Object getRelatedJobId() {
            return relatedJobId;
        }

        public void setRelatedJobId(Object relatedJobId) {
            this.relatedJobId = relatedJobId;
        }

        public Object getRelatedBillId() {
            return relatedBillId;
        }

        public void setRelatedBillId(Object relatedBillId) {
            this.relatedBillId = relatedBillId;
        }

        public String getSentAt() {
            return sentAt;
        }

        public void setSentAt(String sentAt) {
            this.sentAt = sentAt;
        }

    }

}