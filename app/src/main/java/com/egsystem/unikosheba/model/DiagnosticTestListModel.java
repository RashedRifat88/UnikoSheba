package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DiagnosticTestListModel implements Serializable {

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


    public class DiagnosisTest implements Serializable {

        @SerializedName("sl")
        @Expose
        private Integer sl;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("hospital_id")
        @Expose
        private String hospitalId;
        @SerializedName("hospital_name")
        @Expose
        private String hospitalName;

        public Integer getSl() {
            return sl;
        }

        public void setSl(Integer sl) {
            this.sl = sl;
        }

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
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

        public String getHospitalId() {
            return hospitalId;
        }

        public void setHospitalId(String hospitalId) {
            this.hospitalId = hospitalId;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

    }


    public class Result implements Serializable {

        @SerializedName("diagnosis_test_order_data")
        @Expose
        private Object diagnosisTestOrderData;
        @SerializedName("diagnosis_tests")
        @Expose
        private List<DiagnosisTest> diagnosisTests;

        public Object getDiagnosisTestOrderData() {
            return diagnosisTestOrderData;
        }

        public void setDiagnosisTestOrderData(Object diagnosisTestOrderData) {
            this.diagnosisTestOrderData = diagnosisTestOrderData;
        }

        public List<DiagnosisTest> getDiagnosisTests() {
            return diagnosisTests;
        }

        public void setDiagnosisTests(List<DiagnosisTest> diagnosisTests) {
            this.diagnosisTests = diagnosisTests;
        }

    }

}


//public class DiagnosticTestListModel implements Serializable {
//
//    @SerializedName("success")
//    @Expose
//    private Boolean success;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("result")
//    @Expose
//    private Result result;
//
//    public Boolean getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Boolean success) {
//        this.success = success;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Result getResult() {
//        return result;
//    }
//
//    public void setResult(Result result) {
//        this.result = result;
//    }
//
//
//    public class DiagnosisTest implements Serializable {
//
//        @SerializedName("sl")
//        @Expose
//        private Integer sl;
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("price")
//        @Expose
//        private Integer price;
//        @SerializedName("discount")
//        @Expose
//        private Integer discount;
//        @SerializedName("description")
//        @Expose
//        private String description;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("hospital_id")
//        @Expose
//        private Integer hospitalId;
//        @SerializedName("hospital_name")
//        @Expose
//        private String hospitalName;
//
//        public Integer getSl() {
//            return sl;
//        }
//
//        public void setSl(Integer sl) {
//            this.sl = sl;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Integer getPrice() {
//            return price;
//        }
//
//        public void setPrice(Integer price) {
//            this.price = price;
//        }
//
//        public Integer getDiscount() {
//            return discount;
//        }
//
//        public void setDiscount(Integer discount) {
//            this.discount = discount;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public Integer getHospitalId() {
//            return hospitalId;
//        }
//
//        public void setHospitalId(Integer hospitalId) {
//            this.hospitalId = hospitalId;
//        }
//
//        public String getHospitalName() {
//            return hospitalName;
//        }
//
//        public void setHospitalName(String hospitalName) {
//            this.hospitalName = hospitalName;
//        }
//
//    }
//
//
//    public class Result implements Serializable {
//
//        @SerializedName("diagnosis_test_order_data")
//        @Expose
//        private List<Object> diagnosisTestOrderData;
//        @SerializedName("diagnosis_tests")
//        @Expose
//        private List<DiagnosisTest> diagnosisTests;
//
//        public List<Object> getDiagnosisTestOrderData() {
//            return diagnosisTestOrderData;
//        }
//
//        public void setDiagnosisTestOrderData(List<Object> diagnosisTestOrderData) {
//            this.diagnosisTestOrderData = diagnosisTestOrderData;
//        }
//
//        public List<DiagnosisTest> getDiagnosisTests() {
//            return diagnosisTests;
//        }
//
//        public void setDiagnosisTests(List<DiagnosisTest> diagnosisTests) {
//            this.diagnosisTests = diagnosisTests;
//        }
//
//    }
//
//
//}