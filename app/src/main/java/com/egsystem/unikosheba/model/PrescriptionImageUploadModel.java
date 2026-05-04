package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrescriptionImageUploadModel {

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


    public class Client {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("nid_no")
        @Expose
        private String nidNo;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("status")
        @Expose
        private String status;

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

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNidNo() {
            return nidNo;
        }

        public void setNidNo(String nidNo) {
            this.nidNo = nidNo;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public class DiagnosisTestOrderData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("reference_no")
        @Expose
        private String referenceNo;
        @SerializedName("home_collection_type")
        @Expose
        private String homeCollectionType;
        @SerializedName("client_id")
        @Expose
        private Integer clientId;
        @SerializedName("client")
        @Expose
        private Client client;
        @SerializedName("patient_name")
        @Expose
        private String patientName;
        @SerializedName("patient_age")
        @Expose
        private String patientAge;
        @SerializedName("patient_gender")
        @Expose
        private String patientGender;
        @SerializedName("patient_address")
        @Expose
        private String patientAddress;
        @SerializedName("relation")
        @Expose
        private String relation;
        @SerializedName("patient_phone")
        @Expose
        private String patientPhone;
        @SerializedName("total_discount")
        @Expose
        private Integer totalDiscount;
        @SerializedName("final_amount")
        @Expose
        private Integer finalAmount;
        @SerializedName("paid_amount")
        @Expose
        private Integer paidAmount;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("order_date")
        @Expose
        private String orderDate;
        @SerializedName("order_time")
        @Expose
        private String orderTime;
        @SerializedName("order_at")
        @Expose
        private String orderAt;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("prescription_image")
        @Expose
        private String prescriptionImage;
        @SerializedName("diagnosis_tests")
        @Expose
        private List<Object> diagnosisTests;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
        }

        public String getHomeCollectionType() {
            return homeCollectionType;
        }

        public void setHomeCollectionType(String homeCollectionType) {
            this.homeCollectionType = homeCollectionType;
        }

        public Integer getClientId() {
            return clientId;
        }

        public void setClientId(Integer clientId) {
            this.clientId = clientId;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public String getPatientAge() {
            return patientAge;
        }

        public void setPatientAge(String patientAge) {
            this.patientAge = patientAge;
        }

        public String getPatientGender() {
            return patientGender;
        }

        public void setPatientGender(String patientGender) {
            this.patientGender = patientGender;
        }

        public String getPatientAddress() {
            return patientAddress;
        }

        public void setPatientAddress(String patientAddress) {
            this.patientAddress = patientAddress;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getPatientPhone() {
            return patientPhone;
        }

        public void setPatientPhone(String patientPhone) {
            this.patientPhone = patientPhone;
        }

        public Integer getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(Integer totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        public Integer getFinalAmount() {
            return finalAmount;
        }

        public void setFinalAmount(Integer finalAmount) {
            this.finalAmount = finalAmount;
        }

        public Integer getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(Integer paidAmount) {
            this.paidAmount = paidAmount;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getOrderAt() {
            return orderAt;
        }

        public void setOrderAt(String orderAt) {
            this.orderAt = orderAt;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getPrescriptionImage() {
            return prescriptionImage;
        }

        public void setPrescriptionImage(String prescriptionImage) {
            this.prescriptionImage = prescriptionImage;
        }

        public List<Object> getDiagnosisTests() {
            return diagnosisTests;
        }

        public void setDiagnosisTests(List<Object> diagnosisTests) {
            this.diagnosisTests = diagnosisTests;
        }

    }


    public class Result {

        @SerializedName("diagnosis_test_order_data")
        @Expose
        private DiagnosisTestOrderData diagnosisTestOrderData;

        public DiagnosisTestOrderData getDiagnosisTestOrderData() {
            return diagnosisTestOrderData;
        }

        public void setDiagnosisTestOrderData(DiagnosisTestOrderData diagnosisTestOrderData) {
            this.diagnosisTestOrderData = diagnosisTestOrderData;
        }

    }

}