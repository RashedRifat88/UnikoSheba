package com.egsystem.unikosheba;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.cart.CartListActivity;
import com.egsystem.unikosheba.credential.LoginActivity;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.databinding.ActivityMainWithDrawerBinding;
import com.egsystem.unikosheba.model.AllNotificationModel;
import com.egsystem.unikosheba.model.CategoryModel;
import com.egsystem.unikosheba.model.SetFcmTokenModel;
import com.egsystem.unikosheba.model.UnreadNotificationsCountModel;
import com.egsystem.unikosheba.model.UserAccountModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.ui.notifications.NotificationsActivity;
import com.egsystem.unikosheba.ui.services.ServiceSearchActivity;
import com.egsystem.unikosheba.utils.AppUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.egsystem.unikosheba.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private ActivityMainWithDrawerBinding binding2;
    private AppBarConfiguration mAppBarConfiguration;

    static TextView tv_user_name, tv_user_phone, tv_user_profile_completion_status;
    View headerView;
    static ImageView iv_profile_image;
    String userName;
    LinearLayout linear1, linear10;
    DrawerLayout drawerLayout;
    ImageView iv_menu1;
    FrameLayout frame_notification, frame_search;
    ActionBarDrawerToggle toggle;
    NavigationView navigationViewDrawer;
    Toolbar toolbar;
    private TextView tv_notification_badge_count;
    static int mNotificationsCount = 0;

    String fcm_token = "";

    private DatabaseHelper db;
    TextView tv_cart_badge_count;
    FrameLayout frame_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_with_drawer);

        db = new DatabaseHelper(this);
        db.getWritableDatabase();

//        db.clearCart();

        frame_cart = findViewById(R.id.frame_cart);
        frame_search = findViewById(R.id.frame_search);
        frame_notification = findViewById(R.id.frame_notification);
        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);

        updateCartBadge();

        frame_cart.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, CartListActivity.class);
                startActivity(intent);
        });

        frame_search.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ServiceSearchActivity.class);
                startActivity(intent);
        });


//        frame_notification.setOnClickListener(v -> {
//            androidx.navigation.NavController navController =
//                    androidx.navigation.Navigation.findNavController(
//                            this,
//                            R.id.nav_host_fragment_activity_main
//                    );
//            navController.navigate(R.id.navigation_notifications);
//        });
//

        frame_notification.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });


//        binding = ActivityMainBinding.inflate(getLayoutInflater());
////        binding2 = ActivityMainWithDrawerBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_my_history, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(navView, navController);

        initStatusBar();

        initNavigationMenu();


//        notificationListApi();
        unreadNotificationCountApi();

        userAccount("");


        requestPermission();
    }


    private ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission Granted
                    //Get Device token from firebase
                    getDeviceToken();
                } else {
                    //Permission denied
                }
            }
    );


    public void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                //Permission already Granted
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                //You can explain user that why do you need permission bu showing Dialogue box or Toast Message
            } else {
                //Request For Permission
                resultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        } else {
            //GEt Device Token from Firebase
            getDeviceToken();
        }
    }

    public void getDeviceToken() {
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull Task<String> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("FireBaseLogs", " Fetching Toke Failed" + task.getException());
//                    return;
//                }
//
//                //Get Device Token
//                String token = task.getResult();
//                fcm_token = task.getResult();
//
////                        String msg = getString(R.string.msg_token_fmt, token);
//
//                Log.d("tag_fcm", "fcm token: " + token);
//                Log.d("tag_fcm", "fcm token n: " + fcm_token);
//                SharedData.saveFCM_TOKEN(MainActivity.this, token);
//
//                sendFcmTokenToServer(fcm_token);
//
//            }
//        });
    }


    @SuppressLint("CheckResult")
    public void sendFcmTokenToServer(String fcm_token) {

        String token = SharedData.getTOKEN(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        String manufacturer = android.os.Build.MANUFACTURER;
        String model_name = android.os.Build.MODEL;
        String device_name = Settings.Global.getString(this.getContentResolver(), "device_name");

        Log.d("tag11111222", " device_name: " + device_name);


        RetrofitApiClient.getApiInterface().set_fcm_token(authorization, accept, device_name, fcm_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111222", " response.code(): " + response.code());
                            Log.d("tag11111222", " response.message(): " + response.message());
                            Log.d("tag11111222", " response.body(): " + response.body());
                            Log.d("tag11111222", " response.errorBody(): " + response.errorBody());


                            if (response.code() == 401) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            if (response.isSuccessful()) {

                                SetFcmTokenModel fcmModel = response.body();
                                Log.d("tag11111222", " itemModel: " + fcmModel);

                                String message = fcmModel.getMessage();
                                Log.d("tag11111222", " message: " + message);


                            } else {

                            }

                        },
                        error -> {

                            Log.d("tag11111", " error: " + error.getMessage());
                        },
                        () -> {
                            Log.d("tag11111", " response.code(): ");
                        }

                );

    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBgHome, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBgHome));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }
    }


    private void initNavigationMenu() {

        tv_notification_badge_count = findViewById(R.id.tv_notification_badge_count);
        iv_menu1 = findViewById(R.id.iv_menu1);
//        frame_notification = findViewById(R.id.frame_notification);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationViewDrawer = findViewById(R.id.nav_view_drawer);
        navigationViewDrawer.setNavigationItemSelectedListener(this);

        navigationViewDrawer.setItemIconTintList(null);

        iv_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

//        frame_notification.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, UnreadNotificationActivity.class);
//            startActivity(intent);
//        });

//        navigationViewDrawer.getMenu().getItem(0).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(1).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(2).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(3).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(4).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(5).setActionView(R.layout.layout_arrow_right);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        headerView = navigationViewDrawer.getHeaderView(0);
        tv_user_profile_completion_status = headerView.findViewById(R.id.tv_user_profile_completion_status);
        tv_user_name = headerView.findViewById(R.id.tv_user_name);
        tv_user_phone = headerView.findViewById(R.id.tv_user_phone);
        iv_profile_image = headerView.findViewById(R.id.iv_profile_image);
        linear10 = headerView.findViewById(R.id.linear10);


        String userName = SharedData.getUSER_NAME(this);
        String userPhone = SharedData.getUSER_MOBILE(this);

        if (userName != null) {
            tv_user_name.setText(userName);
        } else {
            tv_user_name.setText("User Name");
        }

        if (userPhone != null) {
            tv_user_phone.setText(userPhone);
        } else {
            tv_user_phone.setText("User Phone");
        }


//        if (SharedData.getUserName(this) == null) {
//            tv_user_profile_completion_status.setText("");
//        } else {
//            tv_user_profile_completion_status.setText(SharedData.getUserProfileCompletionPercent(this));
//        }
//
//        if (SharedData.getUserName(this) == null) {
//            tv_user_name.setText("User Name");
//        } else {
//            tv_user_name.setText(SharedData.getUserName(this));
//        }


//        String pro_pic = SharedData.getUserImage(this);
//        Log.d("tag222", "pro_pic: " + pro_pic);
//        if (pro_pic == null) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else if (pro_pic.equalsIgnoreCase("null")) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else if (pro_pic.equalsIgnoreCase("")) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else {
//            Log.d("tag1000", "pro_pic Glide: " + pro_pic);
//            Glide.with(this).load(pro_pic).placeholder(R.drawable.ic_profile).into(iv_profile_image);
//
//        }


//        linear1 = findViewById(R.id.linear1);
//        linear10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
//
//                if (userName == null) {
//                    intent.putExtra("user_name", "User Name");
//                } else {
//                    intent.putExtra("user_name", userName);
//                }
//
//                startActivityForResult(intent, 201);
//            }
//        });
//

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

//        if (item.getItemId() == R.id.menu1) {
//
//            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
////            String menu_name = "1";
////            intent.putExtra("menuName", menu_name);
//            startActivity(intent);
//
//        }

        if (item.getItemId() == R.id.menu2) {

//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);
//            String menu_name = "1";
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);

        }


        if (item.getItemId() == R.id.menu3) {
//            rateApp();
        }


        if (item.getItemId() == R.id.nav_logout) {
            SharedData.saveIS_USER_LOGGED_IN(MainActivity.this, false);
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.putExtra("from_where", "drawer_view");
            startActivity(intent);
            finish();
        }

        return false;

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    //notification count
    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

        if (tv_notification_badge_count != null) {
            if (mNotificationsCount == 0) {
                if (tv_notification_badge_count.getVisibility() != View.GONE) {
                    tv_notification_badge_count.setVisibility(View.GONE);
                }


                frame_notification.setOnClickListener(view -> {
                    new MaterialDialog.Builder(MainActivity.this)
                            .title("Notification Status")
                            .content("No new notification")
                            .positiveText("")
                            .negativeText("Ok")
                            .show();
                });


            } else {
                tv_notification_badge_count.setText(String.valueOf(Math.min(mNotificationsCount, 99)));
                if (tv_notification_badge_count.getVisibility() != View.VISIBLE) {
                    tv_notification_badge_count.setVisibility(View.VISIBLE);
                }

                frame_notification.setOnClickListener(view -> {
//                    Intent intent = new Intent(MainActivity.this, UnreadNotificationActivity.class);
//                    startActivity(intent);
                });
            }
        }

    }


    @SuppressLint("CheckResult")
    public void unreadNotificationCountApi() {

        String token = SharedData.getTOKEN(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";
        String phone = "01814220954";


        RetrofitApiClient.getApiInterface().unread_notifications_count(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag111444", " response.code() unread: " + response.code());


                            if (response.code() == 401) {
                                AppUtils.goToLogin(this, true);
                                return;
                            }


                            if (response.isSuccessful()) {

                                UnreadNotificationsCountModel model = response.body();
                                Log.d("tag11111", " model: " + model);

                                int unreadCount = model.getUnreadCount();
                                Log.d("tag1111166", " unreadCount: " + unreadCount);
                                Log.d("tag111444", " unreadCount: " + unreadCount);


                                updateNotificationsBadge(unreadCount);

                            } else {

                            }

                        },
                        error -> {

                            Log.d("tag11111", " error: " + error.getMessage());
                        },
                        () -> {
                            Log.d("tag11111", " response.code(): ");
                        }

                );

    }

//    @SuppressLint("CheckResult")
//    public void notificationListApi() {
//
//        String token = SharedData.getTOKEN(this);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//        String phone = "01814220954";
//
//
//        RetrofitApiClient.getApiInterface().all_notifications(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag11111", " response.code(): " + response.code());
//                            Log.d("tag1111166", " response.code(): " + response.code());
//
//
//                            if (response.code() == 401) {
//                                AppUtils.goToLogin(this, true);
//                                return;
//                            }
//
//
//                            if (response.isSuccessful()) {
//
//                                AllNotificationModel model = response.body();
//                                Log.d("tag11111", " model: " + model);
//
//                                List<AllNotificationModel.Notification> notifi_list = model.getResult().getNotifications();
//                                Log.d("tag1111166", " notifi_list: " + notifi_list);
//                                Log.d("tag1111166", " notifi_list.size: " + notifi_list.size());
//
//
//                                int unread_notification_number = notifi_list.size();
//
////                                updateNotificationsBadge(unread_notification_number);
//
//                            } else {
//
//                            }
//
//                        },
//                        error -> {
//
//                            Log.d("tag11111", " error: " + error.getMessage());
//                        },
//                        () -> {
//                            Log.d("tag11111", " response.code(): ");
//                        }
//
//                );
//
//    }
//
//



    @SuppressLint("CheckResult")
    public void userAccount(String id) {

//        showProgressDialog();

        String token = SharedData.getTOKEN(this);
        Log.d("tag11111", " token: " + token);
        Log.d("tag11111", " id: " + id);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().show_user_account(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

//                            closeProgressDialog();

                            Log.d("tag1111134", " response.code(): " + response.code());
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag11111", " response.toString(): " + response.toString());


//                            if (response.code() == 401) {
//                                Intent intent = new Intent(this, LoginActivity.class);
//                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
//                                startActivity(intent);
//                            }


                            if (response.isSuccessful()) {


                                UserAccountModel model = response.body();
                                Log.d("tag11111", " response.body(): " + response.body());

                                boolean success = model.getSuccess();
                                Log.d("tag11111", " show_user_account success: " + success);

//                                name = model.getResult().getName();
//                                phone = model.getResult().getMobileNumber();
//
//
//                                binding.tvName.setText(name);
//                                binding.tvMobileNumber.setText(phone);
//
//                                if (model.getResult().getEmail() != null) {
//                                    email = model.getResult().getEmail();
//                                    binding.tvEmail.setText(email);
//                                    SharedData.saveEMAIL(context, email);
//                                } else {
//                                    binding.tvEmail.setText("Email is not set yet");
//                                }
//
//
//                                if (model.getResult().getDateOfBirth() != null) {
//                                    date_of_birth = model.getResult().getDateOfBirth();
//                                    binding.tvDob.setText(date_of_birth);
//                                    SharedData.saveDOB(context, date_of_birth);
//                                } else {
//                                    binding.tvDob.setText("Date of birth is not set yet");
//                                }
//
//
//                                if (model.getResult().getAddress() != null) {
//                                    adddress = model.getResult().getAddress();
//                                    binding.tvAddress.setText(adddress);
//                                    SharedData.savePRESENT_ADDRESS(context, adddress);
//                                } else {
//                                    binding.tvAddress.setText("Address is not set yet");
//                                }
//
//
//                                if (model.getResult().getGender() != null) {
//                                    gender = model.getResult().getGender();
//                                    binding.tvGender.setText(gender);
//                                    SharedData.saveGENDER(context, gender);
//                                } else {
//                                    binding.tvGender.setText("Gender is not set yet");
//                                }


                                String imageUrl = model.getResult().getProfileImage();
                                Glide.with(this).load(imageUrl).into(iv_profile_image);

                                iv_profile_image.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        boolean wrapInScrollView = true;
                                        MaterialDialog dialog1 = new MaterialDialog.Builder(MainActivity.this)
                                                .customView(R.layout.material_dialog_photo, wrapInScrollView)
                                                .build();

                                        ImageView iv_dialog_fullscreen = dialog1.getCustomView().findViewById(R.id.iv_dialog_fullscreen);
                                        Glide.with(MainActivity.this).load(imageUrl).into(iv_dialog_fullscreen);

                                        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                                        WindowManager.LayoutParams wmlp = dialog1.getWindow()
                                                .getAttributes();
                                        wmlp.width = android.view.WindowManager.LayoutParams.MATCH_PARENT;
                                        wmlp.height = android.view.WindowManager.LayoutParams.WRAP_CONTENT;
                                        dialog1.show();

                                        dialog1.setCancelable(true);
                                        dialog1.setCanceledOnTouchOutside(true);
                                    }
                                });


                            } else {

                            }


                        },
                        error -> {

                            Log.d("tag11111", " response.code(): " + error.toString());

                        },
                        () -> {

                        }
                );


    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("tag1111166", " onResume is called in main: ");
////        notificationListApi();
//    }

    @Override
    protected void onStart() {
        Log.d("tag1111166", " onStart is called in main: ");
        super.onStart();
//        notificationListApi();
        if (SharedData.isLog)
        unreadNotificationCountApi();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag1111166", " onPause is called in main: ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateCartBadge();
        unreadNotificationCountApi();
    }


    private void updateCartBadge() {

//        int count = db.getCartModelsCount();
//
//        if (count == 0) {
//            tv_cart_badge_count.setVisibility(View.GONE);
//        } else {
//            tv_cart_badge_count.setText(String.valueOf(count));
//            tv_cart_badge_count.setVisibility(View.VISIBLE);
//        }
//

        try {

            if (db == null) return;
            if (tv_cart_badge_count == null) return;

            int count = db.getCartModelsCount();

            if (count <= 0) {
                tv_cart_badge_count.setVisibility(View.GONE);
            } else {
                tv_cart_badge_count.setText(String.valueOf(count));
                tv_cart_badge_count.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}








//public class MainActivity extends AppCompatActivity {
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}