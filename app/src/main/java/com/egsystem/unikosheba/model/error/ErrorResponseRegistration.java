package com.egsystem.unikosheba.model.error;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ErrorResponseRegistration {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errors")
    @Expose
    private Errors errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }


    public class Errors {

        @SerializedName("name")
        @Expose
        private List<String> name;
        @SerializedName("mobile_number")
        @Expose
        private List<String> mobileNumber;
        @SerializedName("email")
        @Expose
        private List<String> email;
        @SerializedName("password")
        @Expose
        private List<String> password;
        @SerializedName("gender")
        @Expose
        private List<String> gender;
        @SerializedName("date_of_birth")
        @Expose
        private List<String> dateOfBirth;
        @SerializedName("address")
        @Expose
        private List<String> address;

        public List<String> getName() {
            return name;
        }

        public void setName(List<String> name) {
            this.name = name;
        }

        public List<String> getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(List<String> mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public List<String> getEmail() {
            return email;
        }

        public void setEmail(List<String> email) {
            this.email = email;
        }

        public List<String> getPassword() {
            return password;
        }

        public void setPassword(List<String> password) {
            this.password = password;
        }

        public List<String> getGender() {
            return gender;
        }

        public void setGender(List<String> gender) {
            this.gender = gender;
        }

        public List<String> getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(List<String> dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public List<String> getAddress() {
            return address;
        }

        public void setAddress(List<String> address) {
            this.address = address;
        }

    }

}