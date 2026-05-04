package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderList {

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


    public class Item {

        @SerializedName("service")
        @Expose
        private Integer service;
        @SerializedName("service_name")
        @Expose
        private String serviceName;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("unit_price")
        @Expose
        private String unitPrice;
        @SerializedName("line_total")
        @Expose
        private String lineTotal;

        public Integer getService() {
            return service;
        }

        public void setService(Integer service) {
            this.service = service;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getLineTotal() {
            return lineTotal;
        }

        public void setLineTotal(String lineTotal) {
            this.lineTotal = lineTotal;
        }

    }


    public class Result {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("client")
        @Expose
        private Integer client;
        @SerializedName("client_name")
        @Expose
        private String clientName;
        @SerializedName("client_phone")
        @Expose
        private String clientPhone;
        @SerializedName("service")
        @Expose
        private List<Integer> service;
        @SerializedName("items")
        @Expose
        private List<Item> items;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("visiting_date")
        @Expose
        private String visitingDate;
        @SerializedName("visiting_time")
        @Expose
        private String visitingTime;
        @SerializedName("working_date")
        @Expose
        private String workingDate;
        @SerializedName("working_time")
        @Expose
        private Object workingTime;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("area_name")
        @Expose
        private String areaName;
        @SerializedName("district_name")
        @Expose
        private String districtName;
        @SerializedName("division_name")
        @Expose
        private String divisionName;
        @SerializedName("full_location")
        @Expose
        private String fullLocation;
        @SerializedName("is_serviceable")
        @Expose
        private Boolean isServiceable;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("urgency")
        @Expose
        private String urgency;
        @SerializedName("estimated_cost")
        @Expose
        private String estimatedCost;
        @SerializedName("calculated_cost")
        @Expose
        private Double calculatedCost;
        @SerializedName("current_technician")
        @Expose
        private Object currentTechnician;
        @SerializedName("created_at")
        @Expose
        private String createdAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getClient() {
            return client;
        }

        public void setClient(Integer client) {
            this.client = client;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientPhone() {
            return clientPhone;
        }

        public void setClientPhone(String clientPhone) {
            this.clientPhone = clientPhone;
        }

        public List<Integer> getService() {
            return service;
        }

        public void setService(List<Integer> service) {
            this.service = service;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getVisitingDate() {
            return visitingDate;
        }

        public void setVisitingDate(String visitingDate) {
            this.visitingDate = visitingDate;
        }

        public String getVisitingTime() {
            return visitingTime;
        }

        public void setVisitingTime(String visitingTime) {
            this.visitingTime = visitingTime;
        }

        public String getWorkingDate() {
            return workingDate;
        }

        public void setWorkingDate(String workingDate) {
            this.workingDate = workingDate;
        }

        public Object getWorkingTime() {
            return workingTime;
        }

        public void setWorkingTime(Object workingTime) {
            this.workingTime = workingTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getDivisionName() {
            return divisionName;
        }

        public void setDivisionName(String divisionName) {
            this.divisionName = divisionName;
        }

        public String getFullLocation() {
            return fullLocation;
        }

        public void setFullLocation(String fullLocation) {
            this.fullLocation = fullLocation;
        }

        public Boolean getIsServiceable() {
            return isServiceable;
        }

        public void setIsServiceable(Boolean isServiceable) {
            this.isServiceable = isServiceable;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getUrgency() {
            return urgency;
        }

        public void setUrgency(String urgency) {
            this.urgency = urgency;
        }

        public String getEstimatedCost() {
            return estimatedCost;
        }

        public void setEstimatedCost(String estimatedCost) {
            this.estimatedCost = estimatedCost;
        }

        public Double getCalculatedCost() {
            return calculatedCost;
        }

        public void setCalculatedCost(Double calculatedCost) {
            this.calculatedCost = calculatedCost;
        }

        public Object getCurrentTechnician() {
            return currentTechnician;
        }

        public void setCurrentTechnician(Object currentTechnician) {
            this.currentTechnician = currentTechnician;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

    }


}