package com.egsystem.unikosheba.model;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSliderModel {

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
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("subtitle")
        @Expose
        private String subtitle;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("mobile_image_url")
        @Expose
        private String mobileImageUrl;
        @SerializedName("button_text")
        @Expose
        private String buttonText;
        @SerializedName("button_link")
        @Expose
        private String buttonLink;
        @SerializedName("button_target")
        @Expose
        private String buttonTarget;
        @SerializedName("text_align")
        @Expose
        private String textAlign;
        @SerializedName("overlay_opacity")
        @Expose
        private Double overlayOpacity;
        @SerializedName("order")
        @Expose
        private Integer order;
        @SerializedName("is_active")
        @Expose
        private Boolean isActive;
        @SerializedName("has_button")
        @Expose
        private Boolean hasButton;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMobileImageUrl() {
            return mobileImageUrl;
        }

        public void setMobileImageUrl(String mobileImageUrl) {
            this.mobileImageUrl = mobileImageUrl;
        }

        public String getButtonText() {
            return buttonText;
        }

        public void setButtonText(String buttonText) {
            this.buttonText = buttonText;
        }

        public String getButtonLink() {
            return buttonLink;
        }

        public void setButtonLink(String buttonLink) {
            this.buttonLink = buttonLink;
        }

        public String getButtonTarget() {
            return buttonTarget;
        }

        public void setButtonTarget(String buttonTarget) {
            this.buttonTarget = buttonTarget;
        }

        public String getTextAlign() {
            return textAlign;
        }

        public void setTextAlign(String textAlign) {
            this.textAlign = textAlign;
        }

        public Double getOverlayOpacity() {
            return overlayOpacity;
        }

        public void setOverlayOpacity(Double overlayOpacity) {
            this.overlayOpacity = overlayOpacity;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getHasButton() {
            return hasButton;
        }

        public void setHasButton(Boolean hasButton) {
            this.hasButton = hasButton;
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
