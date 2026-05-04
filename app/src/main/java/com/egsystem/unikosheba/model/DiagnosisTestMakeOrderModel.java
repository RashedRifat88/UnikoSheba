package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiagnosisTestMakeOrderModel {

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


    public class DiagnosisTest {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("hospital")
        @Expose
        private Hospital hospital;

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

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Hospital getHospital() {
            return hospital;
        }

        public void setHospital(Hospital hospital) {
            this.hospital = hospital;
        }

    }


    public class DiagnosisTestOrderData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("reference_no")
        @Expose
        private String referenceNo;
        @SerializedName("type")
        @Expose
        private String type;
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
        @SerializedName("relation")
        @Expose
        private String relation;
        @SerializedName("patient_phone")
        @Expose
        private String patientPhone;
        @SerializedName("total_discount")
        @Expose
        private String totalDiscount;
        @SerializedName("final_amount")
        @Expose
        private Integer finalAmount;
        @SerializedName("paid_amount")
        @Expose
        private String paidAmount;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("prescription_image")
        @Expose
        private String prescriptionImage;
        @SerializedName("diagnosis_tests")
        @Expose
        private List<DiagnosisTest> diagnosisTests;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(String totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        public Integer getFinalAmount() {
            return finalAmount;
        }

        public void setFinalAmount(Integer finalAmount) {
            this.finalAmount = finalAmount;
        }

        public String getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(String paidAmount) {
            this.paidAmount = paidAmount;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
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

        public List<DiagnosisTest> getDiagnosisTests() {
            return diagnosisTests;
        }

        public void setDiagnosisTests(List<DiagnosisTest> diagnosisTests) {
            this.diagnosisTests = diagnosisTests;
        }

    }

    public class Hospital {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("contact_number")
        @Expose
        private String contactNumber;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("image")
        @Expose
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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
