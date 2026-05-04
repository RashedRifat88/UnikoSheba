package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SellPostListModel {

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


    public class ProductImage {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("size")
        @Expose
        private String size;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

    }

    public class Result {

        @SerializedName("sell_posts")
        @Expose
        private List<SellPost> sellPosts;

        public List<SellPost> getSellPosts() {
            return sellPosts;
        }

        public void setSellPosts(List<SellPost> sellPosts) {
            this.sellPosts = sellPosts;
        }

    }

    public class SellPost {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("client")
        @Expose
        private String client;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("condition")
        @Expose
        private String condition;
        @SerializedName("product_price")
        @Expose
        private Integer productPrice;
        @SerializedName("product_features")
        @Expose
        private String productFeatures;
        @SerializedName("product_details")
        @Expose
        private String productDetails;
        @SerializedName("product_image")
        @Expose
        private String productImage;
        @SerializedName("seller_contact_number")
        @Expose
        private String sellerContactNumber;
        @SerializedName("seller_address")
        @Expose
        private String sellerAddress;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("product_images")
        @Expose
        private List<ProductImage> productImages;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public Integer getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(Integer productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductFeatures() {
            return productFeatures;
        }

        public void setProductFeatures(String productFeatures) {
            this.productFeatures = productFeatures;
        }

        public String getProductDetails() {
            return productDetails;
        }

        public void setProductDetails(String productDetails) {
            this.productDetails = productDetails;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public String getSellerContactNumber() {
            return sellerContactNumber;
        }

        public void setSellerContactNumber(String sellerContactNumber) {
            this.sellerContactNumber = sellerContactNumber;
        }

        public String getSellerAddress() {
            return sellerAddress;
        }

        public void setSellerAddress(String sellerAddress) {
            this.sellerAddress = sellerAddress;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<ProductImage> getProductImages() {
            return productImages;
        }

        public void setProductImages(List<ProductImage> productImages) {
            this.productImages = productImages;
        }

    }


}

