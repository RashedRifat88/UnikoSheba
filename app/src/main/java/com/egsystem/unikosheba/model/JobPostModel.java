package com.egsystem.unikosheba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobPostModel {

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


    public class CreatedUser {

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

    public class JobPost {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("posted_on")
        @Expose
        private String postedOn;
        @SerializedName("created_by_id")
        @Expose
        private Integer createdById;
        @SerializedName("created_user")
        @Expose
        private CreatedUser createdUser;
        @SerializedName("job_post_category")
        @Expose
        private JobPostCategory jobPostCategory;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("company_email")
        @Expose
        private String companyEmail;
        @SerializedName("company_website")
        @Expose
        private String companyWebsite;
        @SerializedName("company_contact_number_a")
        @Expose
        private String companyContactNumberA;
        @SerializedName("company_contact_number_b")
        @Expose
        private String companyContactNumberB;
        @SerializedName("company_logo")
        @Expose
        private String companyLogo;
        @SerializedName("company_information")
        @Expose
        private String companyInformation;
        @SerializedName("vacancy")
        @Expose
        private String vacancy;
        @SerializedName("employment_status")
        @Expose
        private String employmentStatus;
        @SerializedName("workplace")
        @Expose
        private String workplace;
        @SerializedName("experience")
        @Expose
        private String experience;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("job_location")
        @Expose
        private String jobLocation;
        @SerializedName("salary")
        @Expose
        private String salary;
        @SerializedName("application_deadline")
        @Expose
        private String applicationDeadline;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("status")
        @Expose
        private String status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPostedOn() {
            return postedOn;
        }

        public void setPostedOn(String postedOn) {
            this.postedOn = postedOn;
        }

        public Integer getCreatedById() {
            return createdById;
        }

        public void setCreatedById(Integer createdById) {
            this.createdById = createdById;
        }

        public CreatedUser getCreatedUser() {
            return createdUser;
        }

        public void setCreatedUser(CreatedUser createdUser) {
            this.createdUser = createdUser;
        }

        public JobPostCategory getJobPostCategory() {
            return jobPostCategory;
        }

        public void setJobPostCategory(JobPostCategory jobPostCategory) {
            this.jobPostCategory = jobPostCategory;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyEmail() {
            return companyEmail;
        }

        public void setCompanyEmail(String companyEmail) {
            this.companyEmail = companyEmail;
        }

        public String getCompanyWebsite() {
            return companyWebsite;
        }

        public void setCompanyWebsite(String companyWebsite) {
            this.companyWebsite = companyWebsite;
        }

        public String getCompanyContactNumberA() {
            return companyContactNumberA;
        }

        public void setCompanyContactNumberA(String companyContactNumberA) {
            this.companyContactNumberA = companyContactNumberA;
        }

        public String getCompanyContactNumberB() {
            return companyContactNumberB;
        }

        public void setCompanyContactNumberB(String companyContactNumberB) {
            this.companyContactNumberB = companyContactNumberB;
        }

        public String getCompanyLogo() {
            return companyLogo;
        }

        public void setCompanyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
        }

        public String getCompanyInformation() {
            return companyInformation;
        }

        public void setCompanyInformation(String companyInformation) {
            this.companyInformation = companyInformation;
        }

        public String getVacancy() {
            return vacancy;
        }

        public void setVacancy(String vacancy) {
            this.vacancy = vacancy;
        }

        public String getEmploymentStatus() {
            return employmentStatus;
        }

        public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
        }

        public String getWorkplace() {
            return workplace;
        }

        public void setWorkplace(String workplace) {
            this.workplace = workplace;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getJobLocation() {
            return jobLocation;
        }

        public void setJobLocation(String jobLocation) {
            this.jobLocation = jobLocation;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getApplicationDeadline() {
            return applicationDeadline;
        }

        public void setApplicationDeadline(String applicationDeadline) {
            this.applicationDeadline = applicationDeadline;
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

    }


    public class JobPostCategory {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("thumbnail_image")
        @Expose
        private String thumbnailImage;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbnailImage() {
            return thumbnailImage;
        }

        public void setThumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public class Result {

        @SerializedName("job_post")
        @Expose
        private JobPost jobPost;

        public JobPost getJobPost() {
            return jobPost;
        }

        public void setJobPost(JobPost jobPost) {
            this.jobPost = jobPost;
        }

    }

}
