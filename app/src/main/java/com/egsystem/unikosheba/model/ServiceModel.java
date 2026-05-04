package com.egsystem.unikosheba.model;


import java.util.List;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ServiceModel {

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
        @SerializedName("subcategory")
        @Expose
        private Integer subcategory;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("subcategory_name")
        @Expose
        private String subcategoryName;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("short_description")
        @Expose
        private String shortDescription;
        @SerializedName("price_type")
        @Expose
        private String priceType;
        @SerializedName("base_price")
        @Expose
        private String basePrice;
        @SerializedName("discount_type")
        @Expose
        private String discountType;
        @SerializedName("discount_value")
        @Expose
        private String discountValue;
        @SerializedName("discount_amount")
        @Expose
        private String discountAmount;
        @SerializedName("final_price")
        @Expose
        private String finalPrice;
        @SerializedName("is_discount_active")
        @Expose
        private Boolean isDiscountActive;
        @SerializedName("estimated_duration")
        @Expose
        private String estimatedDuration;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("is_active")
        @Expose
        private Boolean isActive;
        @SerializedName("is_featured")
        @Expose
        private Boolean isFeatured;
        @SerializedName("views_count")
        @Expose
        private Integer viewsCount;
        @SerializedName("booking_count")
        @Expose
        private Integer bookingCount;
        @SerializedName("created_by_name")
        @Expose
        private String createdByName;
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

        public Integer getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(Integer subcategory) {
            this.subcategory = subcategory;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSubcategoryName() {
            return subcategoryName;
        }

        public void setSubcategoryName(String subcategoryName) {
            this.subcategoryName = subcategoryName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public String getPriceType() {
            return priceType;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }

        public String getBasePrice() {
            return basePrice;
        }

        public void setBasePrice(String basePrice) {
            this.basePrice = basePrice;
        }

        public String getDiscountType() {
            return discountType;
        }

        public void setDiscountType(String discountType) {
            this.discountType = discountType;
        }

        public String getDiscountValue() {
            return discountValue;
        }

        public void setDiscountValue(String discountValue) {
            this.discountValue = discountValue;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public Boolean getIsDiscountActive() {
            return isDiscountActive;
        }

        public void setIsDiscountActive(Boolean isDiscountActive) {
            this.isDiscountActive = isDiscountActive;
        }

        public String getEstimatedDuration() {
            return estimatedDuration;
        }

        public void setEstimatedDuration(String estimatedDuration) {
            this.estimatedDuration = estimatedDuration;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getIsFeatured() {
            return isFeatured;
        }

        public void setIsFeatured(Boolean isFeatured) {
            this.isFeatured = isFeatured;
        }

        public Integer getViewsCount() {
            return viewsCount;
        }

        public void setViewsCount(Integer viewsCount) {
            this.viewsCount = viewsCount;
        }

        public Integer getBookingCount() {
            return bookingCount;
        }

        public void setBookingCount(Integer bookingCount) {
            this.bookingCount = bookingCount;
        }

        public String getCreatedByName() {
            return createdByName;
        }

        public void setCreatedByName(String createdByName) {
            this.createdByName = createdByName;
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