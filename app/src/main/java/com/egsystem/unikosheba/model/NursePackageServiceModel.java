package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NursePackageServiceModel implements Serializable{

    @SerializedName("nurse_package_services")
    @Expose
    private List<NursePackageService> nursePackageServices;

    public List<NursePackageService> getNursePackageServices() {
        return nursePackageServices;
    }

    public void setNursePackageServices(List<NursePackageService> nursePackageServices) {
        this.nursePackageServices = nursePackageServices;
    }


    public class NursePackageService implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("price")
        @Expose
        private String price;

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

    }


}

