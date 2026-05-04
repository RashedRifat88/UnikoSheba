package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DoctorAppointmentListModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private List<Result> result;

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

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }


    public class Result {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("reference")
        @Expose
        private String reference;
        @SerializedName("client")
        @Expose
        private String client;
        @SerializedName("doctor")
        @Expose
        private String doctor;
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
        @SerializedName("doctor_mobile_number")
        @Expose
        private String doctorMobileNumber;
        @SerializedName("department_id")
        @Expose
        private Integer departmentId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("specialist")
        @Expose
        private String specialist;
        @SerializedName("chamber_address")
        @Expose
        private String chamberAddress;
        @SerializedName("appointment_date")
        @Expose
        private String appointmentDate;
        @SerializedName("appointment_time")
        @Expose
        private String appointmentTime;
        @SerializedName("appointment_serial")
        @Expose
        private String appointmentSerial;
        @SerializedName("diseases")
        @Expose
        private String diseases;
        @SerializedName("diseases_details")
        @Expose
        private String diseasesDetails;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("status")
        @Expose
        private String status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public String getDoctor() {
            return doctor;
        }

        public void setDoctor(String doctor) {
            this.doctor = doctor;
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

        public String getDoctorMobileNumber() {
            return doctorMobileNumber;
        }

        public void setDoctorMobileNumber(String doctorMobileNumber) {
            this.doctorMobileNumber = doctorMobileNumber;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSpecialist() {
            return specialist;
        }

        public void setSpecialist(String specialist) {
            this.specialist = specialist;
        }

        public String getChamberAddress() {
            return chamberAddress;
        }

        public void setChamberAddress(String chamberAddress) {
            this.chamberAddress = chamberAddress;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public String getAppointmentTime() {
            return appointmentTime;
        }

        public void setAppointmentTime(String appointmentTime) {
            this.appointmentTime = appointmentTime;
        }

        public String getAppointmentSerial() {
            return appointmentSerial;
        }

        public void setAppointmentSerial(String appointmentSerial) {
            this.appointmentSerial = appointmentSerial;
        }

        public String getDiseases() {
            return diseases;
        }

        public void setDiseases(String diseases) {
            this.diseases = diseases;
        }

        public String getDiseasesDetails() {
            return diseasesDetails;
        }

        public void setDiseasesDetails(String diseasesDetails) {
            this.diseasesDetails = diseasesDetails;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

}