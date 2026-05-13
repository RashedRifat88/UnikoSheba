package com.egsystem.unikosheba.ui.my_history;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.egsystem.unikosheba.adapters.OrdersAdapter;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.databinding.FragmentMyHistoryBinding;
import com.egsystem.unikosheba.model.OrderList;
import com.egsystem.unikosheba.retrofit.Api;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.utils.AppUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MyHistoryFragment extends Fragment {

    private FragmentMyHistoryBinding binding;
    Context context;

    LottieAnimationView animationView;
    RecyclerView recyclerView;
    LinearLayout linear_back;
    OrdersAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMyHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initComponents();
        loadRecyclerView();
        orderListApi();

        return root;
    }




    private void loadRecyclerView() {
        adapter = new OrdersAdapter(getActivity());
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        binding.recyclerView.setLayoutManager(mLayoutManager);
//        adapter.setData(appointmentImageList, appointmentsTitleList, popularTopicPriceList, false);
        adapter.notifyDataSetChanged();
    }



    @SuppressLint("CheckResult")
    public void orderListApi() {

        if (binding.animationView.getVisibility() == View.GONE) {
            binding.animationView.setVisibility(View.VISIBLE);
        }

        String token = SharedData.getTOKEN(getActivity());
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";
        String phone = "01814220954";

//        String url = Api.BASE_URL + Api.subcategories + "/" + subCatId;
        String url = Api.BASE_URL + Api.jobs;


        RetrofitApiClient.getApiInterface().order_list(url, authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag111444", " response.code(): " + response.code());
//                            progressDialog.dismiss();
                            binding.animationView.setVisibility(View.GONE);


                            if (response.code() == 401) {
                                AppUtils.goToLogin(getActivity(), true);
                                return;
                            }

                            if (response.isSuccessful()) {

                                binding.animationView.setVisibility(View.GONE);

                                OrderList model = response.body();
                                Log.d("tag11111", " model: " + model);

                                List<OrderList.Result> order_list = model.getResults();
                                Log.d("tag11111", " order_list: " + order_list);

//                                Collections.reverse(order_list);

                                adapter.setData(order_list, "main_activity");
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







    private void initComponents() {

//        binding.linearAppointment.setOnClickListener(v -> {
//            Intent intent = new Intent(context, AppointmentHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//        binding.linearReport.setOnClickListener(v -> {
//            Intent intent = new Intent(context, DiagnosisTestHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearNursing.setOnClickListener(v -> {
//            Intent intent = new Intent(context, NursingHistoryActivity.class);
//            context.startActivity(intent);
//        });




//        binding.linearBloodDonation.setOnClickListener(v -> {
//            Intent intent = new Intent(context, BloodDonationHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearBuySell.setOnClickListener(v -> {
//            Intent intent = new Intent(context, BuySellHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearHouseRent.setOnClickListener(v -> {
//            Intent intent = new Intent(context, HouseRentHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearJobs.setOnClickListener(v -> {
//            Intent intent = new Intent(context, JobsHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearQuiz.setOnClickListener(v -> {
//            Intent intent = new Intent(context, QuizHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearTution.setOnClickListener(v -> {
//            Intent intent = new Intent(context, TutionHistoryActivity.class);
//            context.startActivity(intent);
//        });
//
//
//        binding.linearAmbulance.setOnClickListener(v -> {
//            Intent intent = new Intent(context, AmbulanceHistoryActivity.class);
//            context.startActivity(intent);
//        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}