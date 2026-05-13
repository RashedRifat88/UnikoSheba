package com.egsystem.unikosheba.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.databinding.ActivityNotificationsBinding;
import com.egsystem.unikosheba.databinding.FragmentNotificationsBinding;
import com.egsystem.unikosheba.model.AllNotificationModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.ui.notifications.adapter.AllNotificationAdapter;
import com.egsystem.unikosheba.utils.AppUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NotificationsActivity extends AppCompatActivity {


    private ActivityNotificationsBinding binding;

    LottieAnimationView animationView;
    RecyclerView recyclerView;
    LinearLayout linear_back;
    AllNotificationAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
            binding = ActivityNotificationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



            initComponents();
        loadRecyclerView();
        notificationListApi();


    }




//    private void initStatusBar() {
//        View decor = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
////            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
//
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
    ////            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
//        }
//
//    }


    private void initComponents() {

//        animationView = findViewById(R.id.animationView);
//        recyclerView = findViewById(R.id.recyclerView);
//        linear_back = findViewById(R.id.linear_back);
//
//
//        linear_back.setOnClickListener(view -> {
//            finish();
//        });


    }


    private void loadRecyclerView() {
        adapter = new AllNotificationAdapter(this);
        binding.rvNotifications.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        binding.rvNotifications.setLayoutManager(mLayoutManager);
//        adapter.setData(appointmentImageList, appointmentsTitleList, popularTopicPriceList, false);
        adapter.notifyDataSetChanged();
    }



    @SuppressLint("CheckResult")
    public void notificationListApi() {


        String token = SharedData.getTOKEN(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";
        String phone = "01814220954";


        RetrofitApiClient.getApiInterface().all_notifications(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag111444", " response.code(): " + response.code());
//                            progressDialog.dismiss();


                            if (response.code() == 401) {
                                AppUtils.goToLogin(this, true);
                                return;
                            }


                            if (response.isSuccessful()) {


                                AllNotificationModel model = response.body();
                                Log.d("tag11111", " model: " + model);

                                List<AllNotificationModel.Result> notifi_list = model.getResults();
                                Log.d("tag11111", " notifi_list: " + notifi_list);

//                                Collections.reverse(notifi_list);

                                adapter.setData(notifi_list, "notification_activity");
                                adapter.notifyDataSetChanged();


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





}