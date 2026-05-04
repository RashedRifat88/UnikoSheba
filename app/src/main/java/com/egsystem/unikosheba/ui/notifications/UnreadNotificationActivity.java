//package com.egsystem.unikosheba.ui.notifications;
//
//import android.annotation.SuppressLint;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.LinearLayout;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.airbnb.lottie.LottieAnimationView;
//import com.egsystem.unikosheba.R;
//import com.egsystem.unikosheba.data.SharedData;
//import com.egsystem.unikosheba.model.AllNotificationModel;
//import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
//import com.egsystem.unikosheba.ui.notifications.adapter.UnreadNotificationAdapter;
//
//import java.util.List;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class UnreadNotificationActivity extends AppCompatActivity {
//
//
//    LottieAnimationView animationView;
//    RecyclerView recyclerView;
//    LinearLayout linear_back;
//    UnreadNotificationAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_unread_notification);
//
//        initStatusBar();
//        initComponents();
//        loadRecyclerView();
//        appointmentListApi();
//    }
//
//
//
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
//
//
//    private void initComponents() {
//
//        animationView = findViewById(R.id.animationView);
//        recyclerView = findViewById(R.id.recyclerView);
//        linear_back = findViewById(R.id.linear_back);
//
////        tv_appointments_all.setOnClickListener(view -> {
////            Intent intent = new Intent(getActivity(), ResourceAllActivity.class);
////            startActivity(intent);
////        });
//
//
//        linear_back.setOnClickListener(view -> {
//            finish();
//        });
//
//
//    }
//
//
//    private void loadRecyclerView() {
//        adapter = new UnreadNotificationAdapter(this);
//        recyclerView.setAdapter(adapter);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
//        recyclerView.setLayoutManager(mLayoutManager);
////        adapter.setData(appointmentImageList, appointmentsTitleList, popularTopicPriceList, false);
//        adapter.notifyDataSetChanged();
//    }
//
//
//
//    @SuppressLint("CheckResult")
//    public void appointmentListApi() {
//
//        if (animationView.getVisibility() == View.GONE) {
//            animationView.setVisibility(View.VISIBLE);
//        }
//
//        String token = SharedData.getTOKEN(this);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//        String phone = "01814220954";
//
//
//        RetrofitApiClient.getApiInterface().unread_notifications(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag11111", " response.code(): " + response.code());
//                            Log.d("tag111444", " response.code(): " + response.code());
////                            progressDialog.dismiss();
//                            animationView.setVisibility(View.GONE);
//
//                            if (response.isSuccessful()) {
//
//                                animationView.setVisibility(View.GONE);
//
//                                AllNotificationModel model = response.body();
//                                Log.d("tag11111", " model: " + model);
//
//                                List<AllNotificationModel.Notification> appointment_list = model.getResult().getNotifications();
//                                Log.d("tag11111", " appointment_list: " + appointment_list);
//
////                                Collections.reverse(appointment_list);
//
//                                adapter.setData(appointment_list, "unread_notification_activity");
//                                adapter.notifyDataSetChanged();
//
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
//
//
//}