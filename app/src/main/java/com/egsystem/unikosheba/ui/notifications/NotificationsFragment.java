package com.egsystem.unikosheba.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.databinding.FragmentNotificationsBinding;
import com.egsystem.unikosheba.model.AllNotificationModel;
import com.egsystem.unikosheba.model.NotificationModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.ui.notifications.adapter.AllNotificationAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    LottieAnimationView animationView;
    RecyclerView recyclerView;
    LinearLayout linear_back;
    AllNotificationAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        initStatusBar();
        initComponents();
        loadRecyclerView();
//        notificationListApi();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
        adapter = new AllNotificationAdapter(getActivity());
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        binding.recyclerView.setLayoutManager(mLayoutManager);
//        adapter.setData(appointmentImageList, appointmentsTitleList, popularTopicPriceList, false);
        adapter.notifyDataSetChanged();
    }



//    @SuppressLint("CheckResult")
//    public void notificationListApi() {
//
//        if (binding.animationView.getVisibility() == View.GONE) {
//            binding.animationView.setVisibility(View.VISIBLE);
//        }
//
//        String token = SharedData.getTOKEN(getActivity());
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//        String phone = "01814220954";
//
//
//        RetrofitApiClient.getApiInterface().all_notification(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag11111", " response.code(): " + response.code());
//                            Log.d("tag111444", " response.code(): " + response.code());
////                            progressDialog.dismiss();
//                            binding.animationView.setVisibility(View.GONE);
//
//                            if (response.isSuccessful()) {
//
//                                binding.animationView.setVisibility(View.GONE);
//
//                                NotificationModel model = response.body();
//                                Log.d("tag11111", " model: " + model);
//
//                                List<NotificationModel.Result> notifi_list = model.getResults();
//                                Log.d("tag11111", " notifi_list: " + notifi_list);
//
////                                Collections.reverse(notifi_list);
//
//                                adapter.setData(notifi_list, "appointment_history_activity");
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





}