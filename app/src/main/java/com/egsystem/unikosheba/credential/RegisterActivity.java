package com.egsystem.unikosheba.credential;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.egsystem.unikosheba.MainActivity;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.model.RegisterModel;
import com.egsystem.unikosheba.model.error.ErrorResponseRegistration;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity {

    boolean passwordVissible;
    private ConstraintLayout lay_pass;
    private ImageView iv_hi;
    private TextView tv_Terms_conditions, tv_sign_in, tv_register, tv_forgot_password, tv_select_dob, tv_dob;
    private EditText etName, etPhone, etPhoneNumber, etPassword, etConfirmPassword, etEmail, etAddress;
    String gender = "";
    String date_of_birth = "";

    private boolean nameIsEmpty = true;
    private boolean phoneIsEmpty = true;
    private boolean emailIsEmpty = true;
    private boolean passwordIsEmpty = true;
    private LottieAnimationView animationView;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    List<String> gender_list;
    ArrayAdapter<String> dataAdapter;
    Spinner spinner_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initStatusBar();
        initComponents();
        checkSharedPrefData();

//        Log.d("tag11111",  "response.code(): " + "5555");

//        spinner_gender();
//        loadCalender_dob();
    }


//    private void spinner_gender() {
//        gender_list = new ArrayList<String>();
//        gender_list.add("Select Gender");
//        gender_list.add("Male");
//        gender_list.add("Female");
////        gender_list.add("Other");
//
//        dataAdapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.simple_spinner_item, gender_list);
//        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//        spinner_gender.setAdapter(dataAdapter);
//
//        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
//                String item = parent.getItemAtPosition(position).toString();
//                if (!item.isEmpty() && item != null) {
////                    medical_college_id = medicalCollegeIdMap.get(item);
//                    gender = item;
//                } else {
//                }
//                Log.d("tag4", "gender : " + gender);
//
////                if (position == 0) {
////                    ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorHint));
////                } else {
////                    ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
////                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//
//            }
//        });
//    }


    private void loadCalender_dob() {

        tv_select_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    cal = Calendar.getInstance();
                }
                int year = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    year = cal.get(Calendar.YEAR);
                }
                int month = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    month = cal.get(Calendar.MONTH);
                }
                int day = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    day = cal.get(Calendar.DAY_OF_MONTH);
                }

                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("tag4", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tv_dob.setText(date);
                date_of_birth = date;
            }
        };

    }


    private void checkSharedPrefData() {
        if (SharedData.getMOBILE(this) == null || SharedData.getMOBILE(this).isEmpty()) {

        } else {
            etPhone.setText(SharedData.getMOBILE(this));
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initComponents() {

        animationView = findViewById(R.id.animationView);
        lay_pass = findViewById(R.id.lay_pass);

        tv_sign_in = findViewById(R.id.tv_sign_in);
        tv_register = findViewById(R.id.tv_register);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        tv_Terms_conditions = findViewById(R.id.tv_Terms_conditions);
//        tv_select_dob = findViewById(R.id.tv_select_dob);
        tv_dob = findViewById(R.id.tv_dob);

        iv_hi = findViewById(R.id.iv_hi);

//        spinner_gender = findViewById(R.id.spinner_gender);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
//        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
//        etEmail = findViewById(R.id.etEmail);
//        etAddress = findViewById(R.id.etAddress);


        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {
                    etPhone.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                    etPhone.setPadding(45, 40, 45, 40);
                    phoneIsEmpty = false;
                    checkSignupButtonActive();
                } else {
                    etPhone.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                    etPhone.setPadding(45, 40, 45, 40);
                    phoneIsEmpty = true;
                    checkSignupButtonActive();
                }

            }
        });


        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {
                    lay_pass.setBackground(getResources().getDrawable(R.drawable.rounded_corner4));
                    etPassword.setPadding(45, 40, 45, 40);
                    passwordIsEmpty = false;
                    checkSignupButtonActive();
                } else {
                    lay_pass.setBackground(getResources().getDrawable(R.drawable.rounded_corner3));
                    etPassword.setPadding(45, 40, 45, 40);
                    passwordIsEmpty = true;
                    checkSignupButtonActive();
                }

            }
        });


        tv_sign_in.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


        tv_register.setOnClickListener(view -> {
            hideKeyboard();

            if (!phoneIsEmpty && !passwordIsEmpty) {
                registerApi();
            } else {
                Toast.makeText(this, "Please fill up all the fields correctly", Toast.LENGTH_SHORT).show();
            }

        });


        tv_forgot_password.setOnClickListener(view -> {
//            Intent intent = new Intent(RegisterActivity.this, ForgetPasswordActivity.class);
//            startActivity(intent);
        });

        iv_hi.setOnClickListener(view -> {

        });
//        iv_hi.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_shake));


    }


    private void hideKeyboard() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) this.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isAcceptingText()) {
            inputMethodManager.hideSoftInputFromWindow(
                    this.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    public void showHidePass(View view) {

        if (view.getId() == R.id.show_pass_btn) {
            if (etPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.ic_show2);
                //Show Password
                etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                ((ImageView) (view)).setImageResource(R.drawable.ic_show);
                //Hide Password
                etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }

        if (view.getId() == R.id.show_pass_btn2) {
            if (etConfirmPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                ((ImageView) (view)).setImageResource(R.drawable.ic_show2);
                //Show Password
                etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                ((ImageView) (view)).setImageResource(R.drawable.ic_show);
                //Hide Password
                etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }


    }


    private void checkSignupButtonActive() {
        if (!phoneIsEmpty && !passwordIsEmpty) {
            tv_register.setBackground(getResources().getDrawable(R.drawable.rounded_corner1));
            tv_register.setPadding(45, 45, 45, 45);

//            tv_register.setOnClickListener(view -> {
//                Intent intent = new Intent(RegisterActivity.this, FavouriteTopicPickActivity.class);
//                startActivity(intent);
//            });

        } else {
            tv_register.setBackground(getResources().getDrawable(R.drawable.rounded_corner5));
            tv_register.setPadding(45, 45, 45, 45);
        }
    }


    public String buildPostJson() {
        try {
            JSONObject obj = new JSONObject();
            JSONArray itemsArray = new JSONArray();

            obj.put("name", etName.getText().toString().trim());
            obj.put("phone", etPhone.getText().toString().trim());
            obj.put("password", etPassword.getText().toString().trim());
            obj.put("confirm_password", etPassword.getText().toString().trim());

            return obj.toString(2);

        } catch (Exception e) {
            Log.e("Checkout", "JSON build error: " + e.getMessage());
            return "{}";
        }
    }



    @SuppressLint("CheckResult")
    private void registerApi() {

        String postJson = buildPostJson();
        Log.d("tag444", "postJson: " + postJson);

        showProgressDialog();

        String phone = etPhone.getText().toString();
        String deviceModel = Build.MODEL;
        String deviceManufacturer = Build.MANUFACTURER;
        String deviceProduct = Build.PRODUCT;
        int sdkVersion = Build.VERSION.SDK_INT;
        String deviceName = deviceManufacturer + " " + deviceModel + " android_sdk: " + sdkVersion;
        String token = "";
        String authorization = "Bearer" + " ";
        String accept = "application/json";

//        String name = etName.getText().toString();
//        String mobile_number = etPhone.getText().toString();
//        String email = etEmail.getText().toString();
//        String password = etPassword.getText().toString();
//        String password_confirmation = etPassword.getText().toString();
//        String gender = "";
//        String date_of_birth = "";
//        String address = etAddress.getText().toString();



//        RetrofitApiClient.getApiInterface().user_registration(accept, name, mobile_number, email, password,
//                        password_confirmation, gender, date_of_birth, address)





        Log.d("tag444", "authorization: " + authorization);

        RetrofitApiClient.getApiInterface()
                .user_registration(accept, postJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            closeProgressDialog();

                            Log.d("tag3344", response.toString());
                            Log.d("tag3344", response.message().toString());
                            Log.d("tag3344", String.valueOf(response.code()));
//                            Log.d("tag3344", "response.body(): " + response.body().toString());


//                            if (response.isSuccessful()) {
//                                Log.d("tag3344", "response.isSuccessful()");
//                                response.body();
//
//                            } else {
//                                Log.d("tag3344", "response.isSuccessful() is not");
//                                response.errorBody();
//
//                            }


                            if (response.isSuccessful()) {


                                RegisterModel regModel = response.body();
                                String message = regModel.getMessage();

                                Log.d("tag3344", "message: " + message);


                                String responseString = response.message();
                                Log.d("tag3344", "Response String:" + responseString);

//                                Response<AccountVerificationModel> regModel1 = response;

                                String userToken = regModel.getTokens().getAccess();
                                String user_phone = regModel.getUser().getPhone();
                                String user_id = regModel.getUser().getId().toString();
                                String user_name = regModel.getUser().getName();
//                                String user_email = regModel.getUser().getEmail();
//                                String usera_password = regModel.getUser().getPassword();
//                                String message = regModel.getMessage();


                                Log.d("tag3344", "userToken in onClickVerify: ");


//                                customProgress.showProgress(RegisterActivity.this, "Verifying... Please wait...", true);

                                if (response.code() == 201) {

                                    SharedData.saveTOKEN(RegisterActivity.this, userToken);
                                    SharedData.saveUSER_MOBILE(RegisterActivity.this, user_phone);
                                    SharedData.saveUSER_NAME(RegisterActivity.this, user_name);
                                    SharedData.saveUSER_ID(RegisterActivity.this, user_id);
//                                    SharedData.saveEMAIL(RegisterActivity.this, user_email);
//                                    SharedData.savePASSWORD(RegisterActivity.this, usera_password);


                                    SharedData.saveIS_USER_REGISTERED(this, true);
                                    SharedData.saveIS_USER_LOGGED_IN(this, true);

                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
//


                            } else {
                                Gson gson = new Gson();
                                ErrorResponseRegistration errorResponse = gson.fromJson(
                                        response.errorBody().string(),
                                        ErrorResponseRegistration.class);

//                                List<String> errorList = errorResponse.getValidationError();
                                ErrorResponseRegistration.Errors error = errorResponse.getErrors();
                                List<String> name_error_list = error.getName();
                                List<String> passwd_error_list = error.getPassword();
                                List<String> email_error_list = error.getEmail();
                                List<String> address_error_list = error.getAddress();
                                List<String> gender_error_list = error.getGender();
                                List<String> dateOfBirth_error_list = error.getDateOfBirth();
                                List<String> mobile_error_list = error.getMobileNumber();

//                                String errorNames = "";
//                                for (int i = 0; i < name_error_list.size(); i++) {
//                                    int j = i + 2;
//                                    errorNames = errorNames
//                                            + name_error_list.get(i);
//                                    if (i != name_error_list.size() - 1) {
//                                        errorNames = errorNames + "\n\n" + j + ". ";
//                                    }
//
//                                }


                                String totalErrors = "" ;


                                if (mobile_error_list != null){

                                    totalErrors = mobile_error_list + "\n" ;

                                }
                                else if (passwd_error_list == null){

                                    totalErrors =  "\n" + passwd_error_list  ;


                                }else if (email_error_list == null){

                                    totalErrors =  email_error_list +"\n"  ;


                                }else if (address_error_list == null){

                                    totalErrors = "\n" + address_error_list;


                                }else if (gender_error_list == null){

                                    totalErrors = "\n" + gender_error_list;


                                }else if (dateOfBirth_error_list == null){

                                    totalErrors = "\n" + dateOfBirth_error_list ;


                                }

                                
//                                String totalErrors = mobile_error_list + "\n" + passwd_error_list + "\n" + passwd_error_list + "\n" + email_error_list +
//                                        "\n" + address_error_list + "\n" + gender_error_list + "\n" + dateOfBirth_error_list ;
                                Log.d("tag3344", " totalErrors: " + totalErrors);

                                new MaterialDialog.Builder(RegisterActivity.this)
                                        .title("Registration Status")
                                        .content(totalErrors)
                                        .positiveText("")
                                        .negativeText("Ok")
                                        .show();

                            }
                        },
                        error -> {
                            Log.d("tag3344","Error: "+  error.getMessage().toString());

                        },
                        () -> {
//                            Log.d("tag3344", "onComplete");
                        }
                );


    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.background, this.getTheme()));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.background));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }



    ProgressDialog progressDialog;

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait ....");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }





}