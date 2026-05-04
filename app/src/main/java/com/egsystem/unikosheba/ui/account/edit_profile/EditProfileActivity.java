//package com.egsystem.unikosheba.ui.account.edit_profile;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.DatePickerDialog;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.icu.util.Calendar;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//import com.airbnb.lottie.LottieAnimationView;
//import com.bumptech.glide.Glide;
//import com.egsystem.unikosheba.R;
//import com.egsystem.unikosheba.data.SharedData;
//import com.egsystem.unikosheba.databinding.ActivityEditProfileBinding;
//import com.egsystem.unikosheba.model.MyAccountImageUpdateModel;
//import com.egsystem.unikosheba.model.UpdateUserAccountModel;
//import com.egsystem.unikosheba.model.error.ErrorResponseRegistration;
//import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
//import com.google.gson.Gson;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//
//public class EditProfileActivity extends AppCompatActivity {
//
//
//    private ActivityEditProfileBinding binding;
//
//    Context context;
//    String storagepath = "Users_Profile_Cover_image/";
//    String uid;
//    ImageView set;
//    TextView profilepic, editname, editpassword;
//    ProgressDialog pd;
//    private static final int CAMERA_REQUEST = 100;
//    private static final int STORAGE_REQUEST = 200;
//    private static final int IMAGEPICK_GALLERY_REQUEST = 300;
//    private static final int IMAGE_PICKCAMERA_REQUEST = 400;
//    String cameraPermission[];
//    String storagePermission[];
//    Uri imageuri;
//    String profileOrCoverPhoto;
//
//
//    private TextView tv_Terms_conditions, tv_sign_in, tv_update, tv_forgot_password, tv_select_dob, tv_dob;
//    private EditText etName, etPhone, etPhoneNumber, etPassword, etEmail, etAddress;
//    String gender = "";
//    String date_of_birth = "";
//    private boolean nameIsEmpty = true;
//    private boolean phoneIsEmpty = true;
//    private boolean emailIsEmpty = true;
//    private boolean passwordIsEmpty = true;
//    private LottieAnimationView animationView;
//    private DatePickerDialog.OnDateSetListener mDateSetListener;
//    List<String> gender_list;
//    ArrayAdapter<String> dataAdapter;
//    Spinner spinner_gender;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_edit_profile);
//        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        initComponents();
//
//
//        initStatusBar();
//        initComponents();
//        checkSharedPrefData();
//
////        Log.d("tag11111",  "response.code(): " + "5555");
//
//        spinner_gender();
//        loadCalender_dob();
//    }
//
//
//    private void spinner_gender() {
//        gender_list = new ArrayList<String>();
//        gender_list.add("Select Gender");
//        gender_list.add("Male");
//        gender_list.add("Female");
////        gender_list.add("Other");
//
//        dataAdapter = new ArrayAdapter<String>(EditProfileActivity.this, R.layout.simple_spinner_item, gender_list);
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
//
//
//    private void loadCalender_dob() {
//
//        tv_select_dob.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = null;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    cal = Calendar.getInstance();
//                }
//                int year = 0;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    year = cal.get(Calendar.YEAR);
//                }
//                int month = 0;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    month = cal.get(Calendar.MONTH);
//                }
//                int day = 0;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    day = cal.get(Calendar.DAY_OF_MONTH);
//                }
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        EditProfileActivity.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDateSetListener,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//
//
//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//                Log.d("tag4", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
//
//                String date = month + "/" + day + "/" + year;
//                tv_dob.setText(date);
//                date_of_birth = date;
//            }
//        };
//
//
//    }
//
//
//    private void checkSharedPrefData() {
//        if (SharedData.getMOBILE(this) == null || SharedData.getMOBILE(this).isEmpty()) {
//
//        } else {
//            etPhone.setText(SharedData.getMOBILE(this));
//        }
//
//
//        if (SharedData.getEMAIL(this) == null || SharedData.getEMAIL(this).isEmpty()) {
//
//        } else {
//            etEmail.setText(SharedData.getEMAIL(this));
//        }
//
//
//        if (SharedData.getPRESENT_ADDRESS(this) == null || SharedData.getPRESENT_ADDRESS(this).isEmpty()) {
//
//        } else {
//            etAddress.setText(SharedData.getPRESENT_ADDRESS(this));
//        }
//
//
//        if (SharedData.getDOB(this) == null || SharedData.getDOB(this).isEmpty()) {
//
//        } else {
//            tv_dob.setText(SharedData.getDOB(this));
//            date_of_birth = SharedData.getDOB(this);
//        }
//
//
//        if (SharedData.getGENDER(this) == null || SharedData.getGENDER(this).isEmpty()) {
//
//        } else {
//            gender = SharedData.getGENDER(this);
//        }
//
//
//    }
//
//
//    private void initStatusBar() {
//        View decor = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
//
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
////            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
//        }
//
//    }
//
//
//    @SuppressLint("ClickableViewAccessibility")
//    private void initComponents() {
//
//        animationView = findViewById(R.id.animationView);
//
//        tv_sign_in = findViewById(R.id.tv_sign_in);
//        tv_update = findViewById(R.id.tv_update);
//        tv_forgot_password = findViewById(R.id.tv_forgot_password);
//        tv_Terms_conditions = findViewById(R.id.tv_Terms_conditions);
//        tv_select_dob = findViewById(R.id.tv_select_dob);
//        tv_dob = findViewById(R.id.tv_dob);
//
//        spinner_gender = findViewById(R.id.spinner_gender);
//
//        etName = findViewById(R.id.etName);
//        etPhone = findViewById(R.id.etPhone);
////        etPhoneNumber = findViewById(R.id.etPhoneNumber);
//        etPassword = findViewById(R.id.etPassword);
//        etEmail = findViewById(R.id.etEmail);
//        etAddress = findViewById(R.id.etAddress);
//
//
//        tv_update.setOnClickListener(view -> {
//            hideKeyboard();
//
//            updateProfileApi();
//
////            if (!phoneIsEmpty && !passwordIsEmpty) {
////                updateProfileApi();
////            } else {
////                Toast.makeText(this, "Please fill up all the fields correctly", Toast.LENGTH_SHORT).show();
////            }
//
//        });
//
//
//        binding.imgBack.setOnClickListener(view -> {
//            finish();
//        });
//
//
//        binding.tvUploadPhoto.setOnClickListener(v -> {
////            chooseProfilePicture();
//            takePictureFromGallery();
//        });
//
//
//        binding.ivProfileImage.setOnClickListener(v -> {
////            chooseProfilePicture();
//            takePictureFromGallery();
//        });
//
//
//    }
//
//
//    private void hideKeyboard() {
//        InputMethodManager inputMethodManager =
//                (InputMethodManager) this.getSystemService(
//                        Activity.INPUT_METHOD_SERVICE);
//        if (inputMethodManager.isAcceptingText()) {
//            inputMethodManager.hideSoftInputFromWindow(
//                    this.getCurrentFocus().getWindowToken(),
//                    0
//            );
//        }
//    }
//
//
//    @SuppressLint("CheckResult")
//    private void updateProfileApi() {
//
//        String deviceModel = Build.MODEL;
//        String deviceManufacturer = Build.MANUFACTURER;
//        String deviceProduct = Build.PRODUCT;
//        int sdkVersion = Build.VERSION.SDK_INT;
//        String deviceName = deviceManufacturer + " " + deviceModel + " android_sdk: " + sdkVersion;
//
//        String name = SharedData.getUSER_NAME(this);
////        String mobile_number = etPhone.getText().toString();
//        String mobile_number = SharedData.getUSER_MOBILE(this);
//        String password = SharedData.getPASSWORD(this);
//        String email = etEmail.getText().toString();
////        String gender = "";
////        String date_of_birth = "";
//        String address = etAddress.getText().toString();
//
//
//        String token = SharedData.getTOKEN(this);
//        Log.d("tag11111", " token: " + token);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//
//
//        Log.d("tag3344", "name : " + name);
//        Log.d("tag3344", "mobile_number : " + mobile_number);
//        Log.d("tag3344", "email : " + email);
//        Log.d("tag3344", "gender : " + gender);
//        Log.d("tag3344", "date_of_birth : " + date_of_birth);
//        Log.d("tag3344", "address : " + address);
//
//
//        RetrofitApiClient.getApiInterface().update_user_account(authorization, accept, name, mobile_number, email, password, gender, date_of_birth, address)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//
//                            Log.d("tag3344", response.toString());
//                            Log.d("tag3344", response.message().toString());
//                            Log.d("tag3344", String.valueOf(response.code()));
//                            Log.d("tag3344", "response.body(): " + response.body().toString());
//
//
//                            if (response.isSuccessful()) {
//
//
//                                UpdateUserAccountModel model = response.body();
//                                String message = model.getMessage();
//
//                                Log.d("tag3344", "message: " + message);
//
//
//                                boolean success = model.getSuccess();
//                                String responseString = response.message();
//                                Log.d("tag3344", "Response String:" + responseString);
//
//                                if (success) {
//
//                                    new MaterialDialog.Builder(EditProfileActivity.this)
//                                            .title("Status")
//                                            .content(message)
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                    dialog.dismiss();
//                                                    finish();
//                                                }
//                                            })
//                                            .show();
//
//                                }
//
//
////                                if (response.code() == 201) {
////
////                                    SharedData.saveIS_USER_REGISTERED(this, true);
////                                    SharedData.saveIS_USER_LOGGED_IN(this, true);
////
////                                    Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
////                                    startActivity(intent);
////                                    finish();
////                                }
//
//
//                            } else {
//                                Gson gson = new Gson();
//                                ErrorResponseRegistration errorResponse = gson.fromJson(
//                                        response.errorBody().string(),
//                                        ErrorResponseRegistration.class);
//
////                                List<String> errorList = errorResponse.getValidationError();
//                                ErrorResponseRegistration.Errors error = errorResponse.getErrors();
//                                List<String> name_error_list = error.getName();
//                                List<String> passwd_error_list = error.getPassword();
//                                List<String> email_error_list = error.getEmail();
//                                List<String> address_error_list = error.getAddress();
//                                List<String> gender_error_list = error.getGender();
//                                List<String> dateOfBirth_error_list = error.getDateOfBirth();
//                                List<String> mobile_error_list = error.getMobileNumber();
//
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
//
////                                String bmdc_error = name_error_list;
////                                String passwd_error = ;
//                                String totalErrors = passwd_error_list + "\n" + passwd_error_list + "\n" + email_error_list +
//                                        "\n" + address_error_list + "\n" + gender_error_list + "\n" + dateOfBirth_error_list + "\n" + mobile_error_list;
//                                Log.d("tag3344", " totalErrors: " + totalErrors);
//
//                                new MaterialDialog.Builder(EditProfileActivity.this)
//                                        .title("Registration Status")
//                                        .content(totalErrors)
//                                        .positiveText("")
//                                        .negativeText("Ok")
//                                        .show();
//
//                            }
//                        },
//                        error -> {
//                            Log.d("tag20", error.getMessage().toString());
//
//                        },
//                        () -> {
//                            Log.d("tag3344", "onComplete");
//                        }
//                );
//
//
//    }
//
//
//    ////image part starts
//    private void chooseProfilePicture() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.alert_dialog_picture_upload, null);
//        builder.setCancelable(false);
//        builder.setView(dialogView);
//
//        ImageView imageViewADPPCamera = dialogView.findViewById(R.id.imageViewADPPCamera);
//        ImageView imageViewADPPGallery = dialogView.findViewById(R.id.imageViewADPPGallery);
//
//        final AlertDialog alertDialogProfilePicture = builder.create();
//        alertDialogProfilePicture.show();
//
//        imageViewADPPCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (checkAndRequestPermissions()) {
//                    takePictureFromCamera();
//                    alertDialogProfilePicture.dismiss();
//                }
//            }
//        });
//
//        imageViewADPPGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                takePictureFromGallery();
//                alertDialogProfilePicture.dismiss();
//            }
//        });
//    }
//
//    private void takePictureFromGallery() {
//        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(pickPhoto, 1);
//    }
//
//    private void takePictureFromCamera() {
//        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePicture.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePicture, 2);
//        }
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case 1:
//                if (resultCode == RESULT_OK) {
//                    Uri selectedImageUri = data.getData();
//                    binding.ivProfileImage.setImageURI(selectedImageUri);
//
//                    try {
//                        InputStream is = getContentResolver().openInputStream(data.getData());
//                        uploadImage(getBytes(is));
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                break;
//            case 2:
//                if (resultCode == RESULT_OK) {
//                    Bundle bundle = data.getExtras();
//                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
//                    binding.ivProfileImage.setImageBitmap(bitmapImage);
//
//
//                    try {
//                        InputStream is = getContentResolver().openInputStream(data.getData());
//                        uploadImage(getBytes(is));
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                break;
//        }
//    }
//
//    private boolean checkAndRequestPermissions() {
//        if (Build.VERSION.SDK_INT >= 23) {
//            int cameraPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
//            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 20);
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            takePictureFromCamera();
//        } else
//            Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT).show();
//    }
//    ////image part ends
//
//
//    ///image upload api call
//
//
//    public byte[] getBytes(InputStream is) throws IOException {
//        ByteArrayOutputStream byteBuff = new ByteArrayOutputStream();
//
//        int buffSize = 1024;
//        byte[] buff = new byte[buffSize];
//
//        int len = 0;
//        while ((len = is.read(buff)) != -1) {
//            byteBuff.write(buff, 0, len);
//        }
//
//        return byteBuff.toByteArray();
//    }
//
//
//    @SuppressLint("CheckResult")
//    public void uploadImage(byte[] imageBytes) {
//
//        showProgressDialog();
//
//        String token = SharedData.getTOKEN(this);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//
//        String pat_id = SharedData.getUSER_ID(this);
//        String pat_name = "";
//        String pat_mobile = "";
//        pat_name = SharedData.getUSER_NAME(this);
//        pat_mobile = SharedData.getUSER_MOBILE(this);
////        String hospital_name = "";
////        String test_list = "hospital_namee";
////        String test_price_list = "test_price_liste";
//        String has_prescription = "has_prescriptione";
//        String date = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss", Locale.getDefault()).format(new Date());
//
//        ArrayList<String> testList = new ArrayList<>();
//        ArrayList<String> testPriceList = new ArrayList<>();
//        ArrayList<String> hospitalList = new ArrayList<>();
//
//        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), imageBytes);
//        MultipartBody.Part body = MultipartBody.Part.createFormData("profile_image", "image.jpg", requestFile);
//
//        Log.d("tag111666", " authorization: " + authorization);
//        Log.d("tag111666", " body: " + body);
//        Log.d("tag111666", " requestFile: " + requestFile);
//
////        RetrofitApiClient.getApiInterface().upload_prescription(authorization, accept, body)
//        RetrofitApiClient.getApiInterface().my_account_image_update(authorization, accept, body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//
//                            Log.d("tag111666", " response: " + response);
//                            Log.d("tag111666", " response.code(): " + response.code());
//
//                            closeProgressDialog();
//
//                            Log.d("tag111666", " response.code(): " + response.code());
//                            Log.d("tag111666", " response.message()(): " + response.message());
//                            Log.d("tag111666", " response.body()()(): " + response.body());
//
//                            if (response.code() == 404) {
//
//                            }
//
////                            progressDialog.dismiss();
//
//                            if (response.isSuccessful()) {
//
//                                MyAccountImageUpdateModel model = response.body();
//
//                                String message = model.getMessage();
//                                boolean success = model.getSuccess();
//
////                                Log.d("tag111666", " success: " + success);
////                                Log.d("tag111666", " model: " + model);
////
//
//
//
//                                if (success) {
//
//                                    String imageUrl = model.getImage();
//                                    Log.d("tag111666", " imageUrl: " + imageUrl);
//
//                                    Glide.with(this).load(imageUrl).into(binding.ivProfileImage);
//
//                                    new MaterialDialog.Builder(this)
//                                            .title("Status")
//                                            .content(message)
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                    dialog.dismiss();
//                                                    finish();
//                                                }
//                                            })
//                                            .show();
//
//                                } else {
//                                    new MaterialDialog.Builder(this)
//                                            .title("Status")
//                                            .content(message)
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                    dialog.dismiss();
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
////                                response.errorBody().string(); // do something with that
////                                Gson gson = new Gson();
////                                ErrorResponseGeneric errorResponse = gson.fromJson(
////                                        response.errorBody().string(),
////                                        ErrorResponseGeneric.class);
//                            }
//                        },
//                        error -> {
//                            Log.d("tag111666", " error: " + error.getMessage());
//                        },
//                        () -> {
//                            Log.d("tag111666", " response.code(): ");
//                        }
//                );
//
//    }
//
//
//    ProgressDialog progressDialog;
//
//    private void showProgressDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Please wait ....");
//        progressDialog.show();
//    }
//
//    private void closeProgressDialog() {
//        if (progressDialog.isShowing())
//            progressDialog.dismiss();
//    }
//
//
//}