package com.egsystem.unikosheba.retrofit;

import com.egsystem.unikosheba.model.AdvocateModel;
import com.egsystem.unikosheba.model.AllNotificationModel;
import com.egsystem.unikosheba.model.AllTestModel;
import com.egsystem.unikosheba.model.AmbulanceListModel;
import com.egsystem.unikosheba.model.AmbulanceRequestModel;
import com.egsystem.unikosheba.model.AppHomeModel;
import com.egsystem.unikosheba.model.ApplyDiscountModel;
import com.egsystem.unikosheba.model.AppointmentHistoryModel;
import com.egsystem.unikosheba.model.BloodDonorListModel;
import com.egsystem.unikosheba.model.BusTrainDetailsModel;
import com.egsystem.unikosheba.model.BusTrainListModel;
import com.egsystem.unikosheba.model.CategoryModel;
import com.egsystem.unikosheba.model.ClientHouseRentPostModel;
import com.egsystem.unikosheba.model.CreateApplicationModel;
import com.egsystem.unikosheba.model.DepartmentsDoctorAll;
import com.egsystem.unikosheba.model.DiagnosisTestMakeOrderModel;
import com.egsystem.unikosheba.model.DiagnosisTestMakeOrderWithImageModel;
import com.egsystem.unikosheba.model.DiagnosisTestMakeOrderWithTextModel;
import com.egsystem.unikosheba.model.DiagnosisTestOrderHistoryListModel;
import com.egsystem.unikosheba.model.DiagnosticTestListModel;
import com.egsystem.unikosheba.model.DoctorAllDepartmentsModel;
import com.egsystem.unikosheba.model.DoctorAppointmentListModel;
import com.egsystem.unikosheba.model.DoctorDepartmentModel;
import com.egsystem.unikosheba.model.DoctorDetailsModel;
import com.egsystem.unikosheba.model.DoctorListModel;
import com.egsystem.unikosheba.model.EventListModel;
import com.egsystem.unikosheba.model.FireServicesModel;
import com.egsystem.unikosheba.model.HealthCardModel;
import com.egsystem.unikosheba.model.HomeScrollTextsModel;
import com.egsystem.unikosheba.model.HomeSliderImageModel;
import com.egsystem.unikosheba.model.HomeSliderModel;
import com.egsystem.unikosheba.model.HospitalListModel;
import com.egsystem.unikosheba.model.HouseRentCreateModel;
import com.egsystem.unikosheba.model.HouseRentPostListModel;
import com.egsystem.unikosheba.model.InstituteDetailsModel;
import com.egsystem.unikosheba.model.InstituteListModel;
import com.egsystem.unikosheba.model.JobPostModel;
import com.egsystem.unikosheba.model.JobPostsCreateModel;
import com.egsystem.unikosheba.model.JournalistModel;
import com.egsystem.unikosheba.model.LoginModel;
import com.egsystem.unikosheba.model.MakeAppointmentModel;
import com.egsystem.unikosheba.model.MyAccountImageUpdateModel;
import com.egsystem.unikosheba.model.NotificationMarkAsReadModel;
import com.egsystem.unikosheba.model.NursePackageListModel;
import com.egsystem.unikosheba.model.NursePackagePurchaseHistoryModel;
import com.egsystem.unikosheba.model.NursePackagePurchaseModel;
import com.egsystem.unikosheba.model.NursePackageServiceModel;
import com.egsystem.unikosheba.model.OrderList;
import com.egsystem.unikosheba.model.PathologyHospitalListModel;
import com.egsystem.unikosheba.model.PostOrder;
import com.egsystem.unikosheba.model.PrescriptionImageUploadModel;
import com.egsystem.unikosheba.model.PublicResultModel;
import com.egsystem.unikosheba.model.QuizListModel;
import com.egsystem.unikosheba.model.QuizQuestionFileModel;
import com.egsystem.unikosheba.model.QuizResultModel;
import com.egsystem.unikosheba.model.RegisterModel;
import com.egsystem.unikosheba.model.SellPostListModel;
import com.egsystem.unikosheba.model.SellPostModel;
import com.egsystem.unikosheba.model.SellPostsCategoryListModel;
import com.egsystem.unikosheba.model.ServiceModel;
import com.egsystem.unikosheba.model.SetFcmTokenModel;
import com.egsystem.unikosheba.model.SingleCategoryModel;
import com.egsystem.unikosheba.model.SingleSubCategoryModel;
import com.egsystem.unikosheba.model.SubCategoryModel;
import com.egsystem.unikosheba.model.SubmitQuizAnswerModel;
import com.egsystem.unikosheba.model.TechnicianModel;
import com.egsystem.unikosheba.model.TouristPlaceDetailsModel;
import com.egsystem.unikosheba.model.TouristPlaceListModel;
import com.egsystem.unikosheba.model.TutorListModel;
import com.egsystem.unikosheba.model.TutorProfileCreateUpdateModel;
import com.egsystem.unikosheba.model.TutorProfileModel;
import com.egsystem.unikosheba.model.TutorRequestListModel;
import com.egsystem.unikosheba.model.TutorRequestPostModel;
import com.egsystem.unikosheba.model.UpdateUserAccountModel;
import com.egsystem.unikosheba.model.UploadTestOrderModel;
import com.egsystem.unikosheba.model.UserAccountModel;
import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST(Api.join)
//    Observable<Response<JoinModel>> join(@Header("authorization") String authorization,
//                                         @Header("Accept") String accept,
//                                         @Field("username") String username
//    );
//
//
//    @FormUrlEncoded
//    @POST(Api.auth_confirm)
//    Observable<Response<AuthConfirmModel>> auth_confirm(@Header("authorization") String authorization,
//                                                        @Header("Accept") String accept,
//                                                        @Field("username") String username,
//                                                        @Field("code") String code
//    );
//
//
//    @FormUrlEncoded
//    @POST(Api.auth_reset)
//    Observable<Response<AuthResetModel>> auth_reset_password(@Header("authorization") String authorization,
//                                                             @Header("Accept") String accept,
//                                                             @Field("username") String username,
//                                                             @Field("password") String password,
//                                                             @Field("token") String token
//    );
//
//
//    @FormUrlEncoded
//    @POST(Api.auth_forgot)
//    Observable<Response<AuthForgetPasswordModel>> auth_forgot(@Header("authorization") String authorization,
//                                                              @Header("Accept") String accept,
//                                                              @Field("username") String username
//    );


//    @FormUrlEncoded
//    @POST(Api.user_registration)
//    Observable<Response<RegisterModel>> user_registration(@Header("authorization") String authorization,
//                                                          @Header("Accept") String accept,
//                                                          @Field("name") String name,
//                                                          @Field("phone") String phone,
//                                                          @Field("password") String password,
//                                                          @Field("device_name") String device_name
//

//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST(Api.user_registration)
//    Observable<Response<RegisterModel>> user_registration(@Header("Accept") String accept,
//                                                          @Field("name") String name,
//                                                          @Field("mobile_number") String mobile_number,
//                                                          @Field("email") String email,
//                                                          @Field("password") String password,
//                                                          @Field("password_confirmation") String password_confirmation,
//                                                          @Field("gender") String gender,
//                                                          @Field("date_of_birth") String date_of_birth,
//                                                          @Field("address") String address
//
//    );


    @Headers("Content-Type: application/json")
    @POST(Api.user_registration)
    Observable<Response<RegisterModel>> user_registration(@Header("Accept") String accept,
                                                          @Body String body);


//    @FormUrlEncoded
//    @POST(Api.user_login)
//    Observable<Response<LoginModel>> user_login(

    /// /                                                @Header("authorization") String authorization,
    /// /                                                @Header("Accept") String accept,
    /// /                                                @Field("device_name") String device_name,
//                                                @Field("email_or_mobile_number") String email_or_phone,
//                                                @Field("password") String password
//
//    );
    @Headers("Content-Type: application/json")
    @POST(Api.user_login)
    Observable<Response<LoginModel>> user_login(@Header("Accept") String accept,
                                                @Body String body);


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.make_appointment)
    Observable<Response<MakeAppointmentModel>> make_appointment(@Header("authorization") String authorization,
                                                                @Header("Accept") String accept,
                                                                @Field("doctor_department_id") Integer doctor_department_id,
                                                                @Field("doctor_id") Integer doctor_id,
                                                                @Field("appointment_date") String appointment_date,
                                                                @Field("appointment_time") String appointment_time,
                                                                @Field("diseases") String diseases,
                                                                @Field("diseases_details") String diseases_details,
                                                                @Field("patient_name") String patient_name,
                                                                @Field("patient_age") String patient_age,
                                                                @Field("relation") String relation,
                                                                @Field("patient_phone") String patient_phone


    );

    @FormUrlEncoded
    @POST(Api.appointment_history)
    Observable<Response<AppointmentHistoryModel>> appointment_history(@Header("authorization") String authorization,
                                                                      @Header("Accept") String accept,
                                                                      @Field("phone") String phone
    );


//
//    @Multipart
//    @POST(Api.upload_test_order)
//    Observable<Response<UploadTestOrderModel>> upload_prescription(@Header("Authorization") String authorization,
//                                                                   @Header("Accept") String accept,
//                                                                   @Part MultipartBody.Part test_prescription
//
//    );


    @Multipart
    @POST(Api.upload_diagnosis_test_order)
    Observable<Response<UploadTestOrderModel>> upload_prescription(@Header("Authorization") String authorization,
                                                                   @Header("Accept") String accept,
                                                                   @Part MultipartBody.Part body,
                                                                   @Part("pat_id") String pat_id,
                                                                   @Part("pat_name") String pat_name,
                                                                   @Part("pat_mobile") String pat_mobile,
                                                                   @Part("hospital_name[]") List<String> hospital_name,
                                                                   @Part("test_list[]") List<String> test_list,
                                                                   @Part("test_price_list[]") List<String> test_price_list,
                                                                   @Part("has_prescription") String has_prescription,
                                                                   @Part("date") String date

    );

    @Multipart
    @POST(Api.upload_diagnosis_test_order)
    Observable<Response<UploadTestOrderModel>> upload_diagnosis_test_order(@Header("Authorization") String authorization,
                                                                           @Header("Accept") String accept,
                                                                           @Part MultipartBody.Part body,
                                                                           @Part("pat_id") String pat_id,
                                                                           @Part("pat_name") String pat_name,
                                                                           @Part("pat_mobile") String pat_mobile,
                                                                           @Part("hospital_name[]") List<String> hospital_name,
                                                                           @Part("test_list[]") List<String> test_list,
                                                                           @Part("test_price_list[]") List<String> test_price_list,
                                                                           @Part("has_prescription") String has_prescription,
                                                                           @Part("date") String date

    );

    @GET(Api.diagnosis_test_order_history)
    Observable<Response<DiagnosisTestOrderHistoryListModel>> diagnosis_test_order_history(@Header("Authorization") String authorization,
                                                                                          @Header("Accept") String accept

    );

    @GET(Api.diagnosis_test_order_history)
    Observable<Response<DiagnosisTestOrderHistoryListModel>> diagnosis_test_show(@Header("Authorization") String authorization,
                                                                                 @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST(Api.upload_diagnosis_test_order)
    Observable<Response<UploadTestOrderModel>> order_tests(@Header("Authorization") String authorization,
                                                           @Header("Accept") String accept,
                                                           @Field("pat_id") String pat_id,
                                                           @Field("pat_name") String pat_name,
                                                           @Field("pat_mobile") String pat_mobile,
                                                           @Field("hospital_name[]") List<String> hospital_name,
                                                           @Field("test_list[]") List<String> test_list,
                                                           @Field("test_price_list[]") List<String> test_price_list,
                                                           @Field("has_prescription") String has_prescription,
                                                           @Field("date") String date

    );


    @GET(Api.doctors)
    Observable<Response<DoctorListModel>> doctors(@Header("authorization") String authorization,
                                                  @Header("Accept") String accept,
                                                  @Query("doctor_department_id") String doctor_department_id

    );


    @GET(Api.doctors)
    Observable<Response<DoctorDepartmentModel>> departments(@Header("authorization") String authorization,
                                                            @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<DoctorDepartmentModel>> hospital_departments(@Url String urlString,
                                                                     @Header("Authorization") String authorization,
                                                                     @Header("Accept") String accept
    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<DoctorListModel>> doctorsByHospital(@Url String urlString,
                                                            @Header("Authorization") String authorization,
                                                            @Header("Accept") String accept,
                                                            @Query("hospital_name") String hospital_name
    );


//    @GET(Api.doctors_details)
//    Observable<Response<DoctorDetailsModel>> doctorDetailsById(@Header("authorization") String authorization,
//                                                               @Header("Accept") String accept,
//                                                               @Query("doctor_id") String doctor_id
//
//    );

    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<DoctorDetailsModel>> doctorDetailsById(@Url String urlString,
                                                               @Header("Authorization") String authorization,
                                                               @Header("Accept") String accept
    );


    @GET(Api.hospitals)
    Observable<Response<HospitalListModel>> hospitals(@Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );

    @GET(Api.pathology_hospitals)
    Observable<Response<PathologyHospitalListModel>> pathology_hospitals(@Header("authorization") String authorization,
                                                                         @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.diagnosis_test_names)
    Observable<Response<DiagnosticTestListModel>> diagnosis_test_names(@Header("authorization") String authorization,
                                                                       @Header("Accept") String accept,
                                                                       @Query("hospital_id") String hospital_id

    );

    @GET(Api.doctor_appointments)
    Observable<Response<DoctorAppointmentListModel>> doctor_appointments(@Header("authorization") String authorization,
                                                                         @Header("Accept") String accept

    );


    @GET(Api.all_notification)
    Observable<Response<AllNotificationModel>> all_notification(@Header("authorization") String authorization,
                                                                @Header("Accept") String accept
    );


    @GET(Api.unread_notifications)
    Observable<Response<AllNotificationModel>> unread_notifications(@Header("authorization") String authorization,
                                                                    @Header("Accept") String accept
    );


    @GET(Api.institutes)
    Observable<Response<InstituteListModel>> institutes(@Header("authorization") String authorization,
                                                        @Header("Accept") String accept,
                                                        @Query("institute_type") String institute_type
    );


    @GET(Api.bus_trains)
    Observable<Response<BusTrainListModel>> bus_trains(@Header("authorization") String authorization,
                                                       @Header("Accept") String accept,
                                                       @Query("type") String type
    );

    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<BusTrainDetailsModel>> specific_bus_trains(@Url String urlString,
                                                                   @Header("Authorization") String authorization,
                                                                   @Header("Accept") String accept
    );


    @GET(Api.technicians)
    Observable<Response<TechnicianModel>> technicians(@Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );

    @GET(Api.journalists)
    Observable<Response<JournalistModel>> journalists(@Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );

    @GET(Api.fire_services)
    Observable<Response<FireServicesModel>> fire_services(@Header("authorization") String authorization,
                                                          @Header("Accept") String accept

    );

    @GET(Api.advocates)
    Observable<Response<AdvocateModel>> advocates(@Header("authorization") String authorization,
                                                  @Header("Accept") String accept

    );


    @GET(Api.events)
    Observable<Response<EventListModel>> events(@Header("authorization") String authorization,
                                                @Header("Accept") String accept

    );


    @GET(Api.public_results)
    Observable<Response<PublicResultModel>> public_results(@Header("authorization") String authorization,
                                                           @Header("Accept") String accept

    );

    @GET(Api.doctor_all_departments)
    Observable<Response<DoctorAllDepartmentsModel>> all_departments(@Header("authorization") String authorization,
                                                                    @Header("Accept") String accept

    );

    @GET(Api.departments_doctor_all)
    Observable<Response<DepartmentsDoctorAll>> departments_doctor_all(@Header("authorization") String authorization,
                                                                      @Header("Accept") String accept,
                                                                      @Query("dipartment_name") String dipartment_name

    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<InstituteDetailsModel>> specific_institute(@Url String urlString,
                                                                   @Header("Authorization") String authorization,
                                                                   @Header("Accept") String accept
    );


    @GET(Api.tourist_places)
    Observable<Response<TouristPlaceListModel>> tourist_places(@Header("authorization") String authorization,
                                                               @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<TouristPlaceDetailsModel>> specific_tourist_place(@Url String urlString,
                                                                          @Header("Authorization") String authorization,
                                                                          @Header("Accept") String accept
    );


    @GET(Api.app_home)
    Observable<Response<AppHomeModel>> appHome(@Header("authorization") String authorization,
                                               @Header("Accept") String accept

    );

//    @GET(Api.home_scroll_texts)
//    Observable<Response<HomeScrollTextsModel>> home_scroll_texts(@Header("authorization") String authorization,
//                                                                 @Header("Accept") String accept
//
//    );

    @GET(Api.home_scroll_texts)
    Observable<Response<HomeScrollTextsModel>> home_scroll_texts(
//            @Header("authorization") String authorization,
                                                                 @Header("Accept") String accept

    );

    @GET(Api.home_slider_images)
    Observable<Response<HomeSliderModel>> home_slider_images(
//            @Header("authorization") String authorization,
            @Header("Accept") String accept

    );

    @GET(Api.show_all_test)
    Observable<Response<AllTestModel>> show_all_test(@Header("authorization") String authorization,
                                                     @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.show_user_account)
    Observable<Response<UserAccountModel>> show_user_account(@Header("authorization") String authorization,
                                                             @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.health_card)
    Observable<Response<HealthCardModel>> health_card(@Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET(Api.nurse_packages)
    Observable<Response<NursePackageListModel>> nurse_packages(@Header("authorization") String authorization,
                                                               @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.nurse_package_purchases)
    Observable<Response<NursePackagePurchaseHistoryModel>> nurse_package_purchase_history(@Header("authorization") String authorization,
                                                                                          @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.ambulance_list)
    Observable<Response<AmbulanceListModel>> ambulance_list(@Header("authorization") String authorization,
                                                            @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET(Api.tutor_request_list)
    Observable<Response<TutorRequestListModel>> tutor_request_list(@Header("authorization") String authorization,
                                                                   @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.tutor_list)
    Observable<Response<TutorListModel>> tutor_list(@Header("authorization") String authorization,
                                                    @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.house_rent_posts)
    Observable<Response<HouseRentPostListModel>> house_rent_posts(@Header("authorization") String authorization,
                                                                  @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.client_house_rent_create)
    Observable<Response<HouseRentCreateModel>> client_house_rent_create(@Header("authorization") String authorization,
                                                                        @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET(Api.sell_posts)
    Observable<Response<SellPostListModel>> sell_posts(@Header("authorization") String authorization,
                                                       @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.sell_posts_categories)
    Observable<Response<SellPostsCategoryListModel>> sell_posts_categories(@Header("authorization") String authorization,
                                                                           @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET(Api.quiz_list)
    Observable<Response<QuizListModel>> quiz_list(@Header("authorization") String authorization,
                                                  @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<QuizQuestionFileModel>> getQuizQuestionFile(@Url String urlString,
                                                                    @Header("Authorization") String authorization,
                                                                    @Header("Accept") String accept
    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<QuizResultModel>> quiz_result(@Url String urlString,
                                                      @Header("authorization") String authorization,
                                                      @Header("Accept") String accept
    );

    @Headers("Content-Type: application/json")
    @POST()
    Observable<Response<SubmitQuizAnswerModel>> submitGivenQuizAnswer(@Url String urlString,
                                                                      @Header("authorization") String authorization,
                                                                      @Header("Accept") String accept,
                                                                      @Body JsonObject body);


    @Headers("Content-Type: application/json")
    @GET(Api.job_posts)
    Observable<Response<JobPostListModel>> job_posts(@Header("authorization") String authorization,
                                                     @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.job_posts_create)
    Observable<Response<JobPostsCreateModel>> job_posts_create(@Header("authorization") String authorization,
                                                               @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.blood_donors)
    Observable<Response<BloodDonorListModel>> blood_donors(@Header("authorization") String authorization,
                                                           @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.blood_donors_create)
    Observable<Response<JobPostsCreateModel>> blood_donors_create(@Header("authorization") String authorization,
                                                                  @Header("Accept") String accept

    );

    @Headers("Content-Type: application/json")
    @GET(Api.tutor_profile)
    Observable<Response<TutorProfileModel>> tutor_profile(@Header("Authorization") String authorization,
                                                          @Header("Accept") String accept


    );


    //    @Headers("Content-Type: application/json")
    @GET(Api.categories)
    Observable<Response<CategoryModel>> categories(
//            @Header("authorization") String authorization,
            @Header("Accept") String accept

    );


    //    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<SingleCategoryModel>> single_category(@Url String urlString
    );


    @Headers("Content-Type: application/json")
    @GET(Api.subcategories)
    Observable<Response<SubCategoryModel>> subcategories(@Header("authorization") String authorization,
                                                         @Header("Accept") String accept

    );


    @GET()
    Observable<Response<SingleSubCategoryModel>> single_sub_category(@Url String urlString
    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<SubCategoryModel>> single_sub_category(@Url String urlString,
                                                               @Header("authorization") String authorization,
                                                               @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET(Api.services)
    Observable<Response<ServiceModel>> services(@Header("authorization") String authorization,
                                                @Header("Accept") String accept

    );


    @Headers("Content-Type: application/json")
    @GET()
    Observable<Response<ServiceModel>> single_service(@Url String urlString,
                                                      @Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );


    @POST(Api.jobs)
    Observable<Response<PostOrder>> post_order(@Header("authorization") String authorization,
                                               @Body String body
    );

    //    @GET(Api.jobs)
    @GET()
    Observable<Response<OrderList>> order_list(@Url String urlString,
                                               @Header("authorization") String authorization,
                                               @Header("Accept") String accept
    );


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.update_user_account)
    Observable<Response<UpdateUserAccountModel>> update_user_account(@Header("authorization") String authorization,
                                                                     @Header("Accept") String accept,
                                                                     @Field("name") String name,
                                                                     @Field("mobile_number") String mobile_number,
                                                                     @Field("email") String email,
                                                                     @Field("password") String password,
                                                                     @Field("gender") String gender,
                                                                     @Field("date_of_birth") String date_of_birth,
                                                                     @Field("address") String address

    );

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.notification_mark_as_read)
    Observable<Response<NotificationMarkAsReadModel>> notification_mark_as_read(@Header("authorization") String authorization,
                                                                                @Header("Accept") String accept,
                                                                                @Field("notification_id") int notification_id
    );

    //    @Headers("Content-Type: application/x-www-form-urlencoded")
    @Headers("Content-Type: application/json")
    @Multipart
    @POST(Api.diagnosis_test_make_order)
    Observable<Response<DiagnosisTestMakeOrderWithImageModel>> diagnosis_test_make_order(@Header("Authorization") String authorization,
                                                                                         @Header("Accept") String accept,
                                                                                         @Part MultipartBody.Part prescription_image,
                                                                                         @Part("prescription_image") RequestBody filename,
                                                                                         @Part("total_amount") String total_amount,
                                                                                         @Part("total_discount") String total_discount,
                                                                                         @Part("paid_amount") String paid_amount,
                                                                                         @Part("notes") String notes,
                                                                                         @Part("type") String type,
                                                                                         @Part("patient_name") String patient_name,
                                                                                         @Part("patient_age") String patient_age,
                                                                                         @Part("patient_address") String patient_address,
                                                                                         @Part("patient_gender") String patient_gender,
                                                                                         @Part("relation") String relation,
                                                                                         @Part("patient_phone") String patient_phone
    );

//    @Headers("Content-Type: application/json")
//    @Multipart
//    @POST(Api.diagnosis_test_make_order)
//    Observable<Response<DiagnosisTestMakeOrderModel>> diagnosis_test_make_order(@Header("Authorization") String authorization,
//                                                                                @Header("Accept") String accept,
//                                                                                @Part MultipartBody.Part prescription_image,
//                                                                                @Part("total_amount") String total_amount,
//                                                                                @Part("total_discount") String total_discount,
//                                                                                @Part("paid_amount") String paid_amount,
//                                                                                @Part("notes") String notes,
//                                                                                @Part("diagnosis_test_id[]") List<Integer> diagnosis_test_id,
//                                                                                @Part("type") String type,
//                                                                                @Part("patient_name") String patient_name,
//                                                                                @Part("patient_age") String patient_age,
//                                                                                @Part("patient_address") String patient_address,
//                                                                                @Part("patient_gender") String patient_gender,
//                                                                                @Part("relation") String relation,
//                                                                                @Part("patient_phone") String patient_phone
//    );


    //    @Headers("Content-Type: application/json")
    @Multipart
    @POST(Api.my_account_image_update)
    Observable<Response<MyAccountImageUpdateModel>> my_account_image_update(@Header("Authorization") String authorization,
                                                                            @Header("Accept") String accept,
                                                                            @Part MultipartBody.Part profile_image

    );


    @Multipart
    @POST(Api.prescription_image_upload)
    Observable<Response<PrescriptionImageUploadModel>> prescription_image_upload(@Header("Authorization") String authorization,
                                                                                 @Header("Accept") String accept,
                                                                                 @Part MultipartBody.Part profile_image

    );


    //    @Headers("Content-Type: application/x-www-form-urlencoded")

    //    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST(Api.diagnosis_test_make_order)
    Observable<Response<DiagnosisTestMakeOrderModel>> diagnosis_test_make_order_without_image(@Header("Authorization") String authorization,
                                                                                              @Header("Accept") String accept,
                                                                                              @Field("total_amount") String total_amount,
                                                                                              @Field("total_discount") String total_discount,
                                                                                              @Field("paid_amount") String paid_amount,
                                                                                              @Field("notes") String notes,
                                                                                              @Field("diagnosis_test_id[]") List<String> diagnosis_test_id,
                                                                                              @Field("type") String type,
                                                                                              @Field("patient_name") String patient_name,
                                                                                              @Field("patient_age") String patient_age,
                                                                                              @Field("patient_address") String patient_address,
                                                                                              @Field("patient_gender") String patient_gender,
                                                                                              @Field("relation") String relation,
                                                                                              @Field("patient_phone") String patient_phone
    );


    @FormUrlEncoded
    @POST(Api.nurse_package_services)
    Observable<Response<NursePackageServiceModel>> nurse_package_services(@Header("Authorization") String authorization,
                                                                          @Header("Accept") String accept,
                                                                          @Field("nurse_package_id") String nurse_package_id
    );


    @FormUrlEncoded
    @POST(Api.nurse_package_purchases)
    Observable<Response<NursePackagePurchaseModel>> nurse_package_purchase(@Header("Authorization") String authorization,
                                                                           @Header("Accept") String accept,
                                                                           @Field("nurse_package_id") String nurse_package_id,
                                                                           @Field("map_location") String map_location,
                                                                           @Field("date") String date,
                                                                           @Field("time") String time,
                                                                           @Field("purpose") String purpose,
                                                                           @Field("desease_details") String desease_details,
                                                                           @Field("patient_name") String patient_name,
                                                                           @Field("patient_age") String patient_age,
                                                                           @Field("patient_address") String patient_address,
                                                                           @Field("relation") String relation,
                                                                           @Field("patient_phone") String patient_phone,
                                                                           @Field("nurse_package_service_ids   []") List<String> nurse_package_service_ids
    );

    @FormUrlEncoded
    @POST(Api.ambulance_request)
    Observable<Response<AmbulanceRequestModel>> ambulance_request(@Header("Authorization") String authorization,
                                                                  @Header("Accept") String accept,
                                                                  @Field("ambulance_id") String nurse_package_id,
                                                                  @Field("location") String location,
                                                                  @Field("date") String date,
                                                                  @Field("time") String time,
                                                                  @Field("description") String description,
                                                                  @Field("situation") String situation,
                                                                  @Field("status") String status,
                                                                  @Field("amount_range") String amount_range,
                                                                  @Field("contact_number_a") String contact_number_a,
                                                                  @Field("contact_number_b") String contact_number_b
    );


    @FormUrlEncoded
    @POST(Api.tutor_profile_create_update)
    Observable<Response<TutorProfileCreateUpdateModel>> tutor_profile_create_update(@Header("Authorization") String authorization,
                                                                                    @Header("Accept") String accept,
                                                                                    @Field("name") String name,
                                                                                    @Field("gender") String gender,
                                                                                    @Field("phone") String phone,
                                                                                    @Field("descripton") String descripton,
                                                                                    @Field("preferable_class") String preferable_class,
                                                                                    @Field("nid") String nid,
                                                                                    @Field("institute_a") String institute_a,
                                                                                    @Field("subject") String subject,
                                                                                    @Field("class") String class_,
                                                                                    @Field("year") String year,
                                                                                    @Field("current_address") String current_address,
                                                                                    @Field("permanent_address") String permanent_address,
                                                                                    @Field("medium") String medium,
                                                                                    @Field("institute_b") String institute_b,
                                                                                    @Field("edu_completion_year") String edu_completion_year,
                                                                                    @Field("edu_completion_degree") String edu_completion_degree

    );

    @FormUrlEncoded
    @POST(Api.tutor_request)
    Observable<Response<TutorRequestPostModel>> tutor_request_post(@Header("Authorization") String authorization,
                                                                   @Header("Accept") String accept,
                                                                   @Field("institute_name") String institute_name,
                                                                   @Field("class") String class_,
                                                                   @Field("subject") String subject,
                                                                   @Field("medium") String medium,
                                                                   @Field("age") String age,
                                                                   @Field("gender") String gender,
                                                                   @Field("teacher_gender") String teacher_gender,
                                                                   @Field("preferable_institute") String preferable_institute,
                                                                   @Field("guardian_mobile") String guardian_mobile,
                                                                   @Field("tution_address") String tution_address,
                                                                   @Field("description") String description,
                                                                   @Field("mobile_show_status") String mobile_show_status,
                                                                   @Field("status") String status


    );


    @FormUrlEncoded
    @POST(Api.client_house_ren_post)
    Observable<Response<ClientHouseRentPostModel>> client_house_ren_post(@Header("Authorization") String authorization,
                                                                         @Header("Accept") String accept,
                                                                         @Field("room_number") String room_number,
                                                                         @Field("balcony_number") String balcony_number,
                                                                         @Field("toilet_number") String toilet_number,
                                                                         @Field("room_description") String room_description,
                                                                         @Field("rent_amount") String rent_amount,
                                                                         @Field("offer") String offer,
                                                                         @Field("service_charge") String service_charge,
                                                                         @Field("phone_number") String phone_number,
                                                                         @Field("address") String address,
                                                                         @Field("gas_status") String gas_status,
                                                                         @Field("lift_status") String lift_status,
                                                                         @Field("generator_status") String generator_status,
                                                                         @Field("security_guard_status") String security_guard_status,
                                                                         @Field("cc_camera_status") String cc_camera_status,
                                                                         @Field("car_parking_status") String car_parking_status,
                                                                         @Field("garden_status") String garden_status,
                                                                         @Field("other") String other,
                                                                         @Field("area_id") String area_id,
                                                                         @Field("status") String status


    );

//    thumbnail_image

//    @FormUrlEncoded
//    @POST(Api.client_sell_posts)
//    Observable<Response<SellPostModel>> client_sell_post(@Header("Authorization") String authorization,
//                                                         @Header("Accept") String accept,
//                                                         @Field("sell_category_id") String sell_category_id,
//                                                         @Field("product_name") String product_name,
//                                                         @Field("condition") String condition,
//                                                         @Field("product_price") String product_price,
//                                                         @Field("product_details") String product_details,
//                                                         @Field("product_features") String product_features,
//                                                         @Field("seller_contact_number") String seller_contact_number,
//                                                         @Field("seller_address") String seller_address
//
//
// );


    @Multipart
    @POST()
    Observable<Response<SellPostModel>> client_sell_post(@Url String urlString,
                                                         @Header("Authorization") String authorization,
                                                         @Header("Accept") String accept,
                                                         @Part MultipartBody.Part product_image,
                                                         @Part("filename") RequestBody filename,
                                                         @Part("sell_category_id") RequestBody sell_category_id,
                                                         @Part("product_name") RequestBody product_name,
                                                         @Part("condition") RequestBody condition,
                                                         @Part("product_price") RequestBody product_price,
                                                         @Part("product_details") RequestBody product_details,
                                                         @Part("product_features") RequestBody product_features,
                                                         @Part("seller_contact_number") RequestBody seller_contact_number,
                                                         @Part("seller_address") RequestBody seller_address

    );


    @Multipart
    @POST()
    Observable<Response<JobPostModel>> client_job_post(@Url String urlString,
                                                       @Header("Authorization") String authorization,
                                                       @Header("Accept") String accept,
                                                       @Part MultipartBody.Part product_image,
                                                       @Part("filename") RequestBody filename,
                                                       @Part("job_post_category_id") RequestBody job_post_category_id,
                                                       @Part("title") RequestBody title,
                                                       @Part("company_name") RequestBody company_name,
                                                       @Part("company_email") RequestBody company_email,
                                                       @Part("company_website") RequestBody company_website,
                                                       @Part("company_contact_number_a") RequestBody company_contact_number_a,
                                                       @Part("company_contact_number_b") RequestBody company_contact_number_b,
                                                       @Part("company_information") RequestBody company_information,
                                                       @Part("vacancy") RequestBody vacancy,
                                                       @Part("employment_status") RequestBody employment_status,
                                                       @Part("workplace") RequestBody workplace,
                                                       @Part("experience") RequestBody experience,
                                                       @Part("age") RequestBody age,
                                                       @Part("job_location") RequestBody job_location,
                                                       @Part("salary") RequestBody salary,
                                                       @Part("application_deadline") RequestBody application_deadline,
                                                       @Part("description") RequestBody description,
                                                       @Part("status") RequestBody status
    );


    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST(Api.diagnosis_test_make_order_with_text)
    Observable<Response<DiagnosisTestMakeOrderWithTextModel>> diagnosis_test_make_order_with_text(@Header("Authorization") String authorization,
                                                                                                  @Header("Accept") String accept,
                                                                                                  @Field("total_amount") String total_amount,
                                                                                                  @Field("total_discount") String total_discount,
                                                                                                  @Field("paid_amount") String paid_amount,
                                                                                                  @Field("notes") String notes,
                                                                                                  @Field("diagnosis_test_id[]") List<String> diagnosis_test_id,
                                                                                                  @Field("type") String type,
                                                                                                  @Field("patient_name") String patient_name,
                                                                                                  @Field("patient_age") String patient_age,
                                                                                                  @Field("patient_address") String patient_address,
                                                                                                  @Field("patient_gender") String patient_gender,
                                                                                                  @Field("relation") String relation,
                                                                                                  @Field("patient_phone") String patient_phone
    );


//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST(Api.diagnosis_test_make_order)
//    Observable<Response<DiagnosisTestMakeOrderModel>> diagnosis_test_make_order_without_image(@Header("authorization") String authorization,
//                                                                                              @Header("Accept") String accept,
//                                                                                              @Field("total_amount") String total_amount,
//                                                                                              @Field("total_discount") String total_discount,
//                                                                                              @Field("paid_amount") String paid_amount,
//                                                                                              @Field("notes") String notes,
//                                                                                              @Field("test_listdiagnosis_test_id[]") List<String> test_listdiagnosis_test_id,
//                                                                                              @Field("type") String type,
//                                                                                              @Field("patient_name") String patient_name,
//                                                                                              @Field("patient_age") String patient_age,
//                                                                                              @Field("patient_address") String patient_address,
//                                                                                              @Field("patient_gender") String patient_gender,
//                                                                                              @Field("relation") String relation,
//                                                                                              @Field("patient_phone") String patient_phone
//    );


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.set_fcm_token)
    Observable<Response<SetFcmTokenModel>> set_fcm_token(@Header("authorization") String authorization,
                                                         @Header("Accept") String accept,
                                                         @Field("device_name") String device_name,
                                                         @Field("fcm_device_token") String fcm_device_token

    );


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.create_applications)
    Observable<Response<CreateApplicationModel>> create_applications(@Header("authorization") String authorization,
                                                                     @Header("Accept") String accept,
                                                                     @Field("event_id") String event_id,
                                                                     @Field("name") String name,
                                                                     @Field("session") String session,
                                                                     @Field("ssc") String ssc,
                                                                     @Field("hsc") String hsc,
                                                                     @Field("honours") String honours,
                                                                     @Field("group_name") String group_name,
                                                                     @Field("description") String description

    );

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(Api.client_hospital_discounts)
    Observable<Response<ApplyDiscountModel>> applyDiscount(@Header("Authorization") String authorization,
                                                           @Header("Accept") String accept,
                                                           @Field("hospital_id") String hospital_id
    );


}

