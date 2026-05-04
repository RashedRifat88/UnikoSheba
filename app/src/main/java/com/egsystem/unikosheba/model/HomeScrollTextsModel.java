package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HomeScrollTextsModel {

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
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("badge_label")
        @Expose
        private String badgeLabel;
        @SerializedName("badge_color")
        @Expose
        private String badgeColor;
        @SerializedName("priority")
        @Expose
        private Integer priority;
        @SerializedName("priority_label")
        @Expose
        private String priorityLabel;
        @SerializedName("is_active")
        @Expose
        private Boolean isActive;
        @SerializedName("is_expired")
        @Expose
        private Boolean isExpired;
        @SerializedName("expire_at")
        @Expose
        private String expireAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getBadgeLabel() {
            return badgeLabel;
        }

        public void setBadgeLabel(String badgeLabel) {
            this.badgeLabel = badgeLabel;
        }

        public String getBadgeColor() {
            return badgeColor;
        }

        public void setBadgeColor(String badgeColor) {
            this.badgeColor = badgeColor;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public String getPriorityLabel() {
            return priorityLabel;
        }

        public void setPriorityLabel(String priorityLabel) {
            this.priorityLabel = priorityLabel;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getIsExpired() {
            return isExpired;
        }

        public void setIsExpired(Boolean isExpired) {
            this.isExpired = isExpired;
        }

        public String getExpireAt() {
            return expireAt;
        }

        public void setExpireAt(String expireAt) {
            this.expireAt = expireAt;
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

    }

}