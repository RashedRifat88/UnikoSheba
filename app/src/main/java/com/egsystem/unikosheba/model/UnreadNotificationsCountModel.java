package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnreadNotificationsCountModel {

    @SerializedName("unread_count")
    @Expose
    private Integer unreadCount;

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

}