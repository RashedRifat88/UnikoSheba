package com.egsystem.unikosheba.ui.home;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.credential.LoginActivity;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.databinding.FragmentHomeBinding;
import com.egsystem.unikosheba.model.CategoryModel;
import com.egsystem.unikosheba.model.HomeScrollTextsModel;
import com.egsystem.unikosheba.model.HomeSliderImageModel;
import com.egsystem.unikosheba.model.HomeSliderModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.ui.home.adapter.HomeModuleAdapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private HomeModuleAdapter2 homeModuleAdapter;

    List<String> home_module_name_eng_list;
    List<String> home_module_name_ban_list = new ArrayList<>();
    List<String> home_module_image_list;
    List<String> home_module_id_list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView(root);

        initComponent();
//        loadListData();

        loadRecyclerView();


        topScrollText("");


//        topSlider();
//        appHomeapi();
        appHomeScrollText();
        appHomeSlidder();
        appHomeSlidder2();

        categoriesApi();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        loadListData();
//        loadRecyclerView();
    }

    @Override
    public void onAttach(Context context) {
        Log.d("TAG5566",
                "onAttach: ");
        super.onAttach(context);
    }


//    @SuppressLint("CheckResult")
//    public void appHomeapi() {
//
//        showProgressDialog();
//
//        String token = SharedData.getTOKEN(getContext());
//        Log.d("tag11111", " token: " + token);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//
//        RetrofitApiClient.getApiInterface().appHome(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag11111", " response.code(): " + response.code());
//
//
//                            if (response.code() == 401) {
//                                Intent intent = new Intent(getContext(), LoginActivity.class);
//                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
//                                startActivity(intent);
//                            }
//
//
//                            if (response.isSuccessful()) {
//                                closeProgressDialog();
//
//                                response.body(); // do something with that
//                                Log.d("tag11111", " response.body(): " + response.body());
//
//                                AppHomeModel model = response.body();
//                                String status = model.getStatus();
//
//                                String topScrollTextList = "";
//
//                                if (status.equalsIgnoreCase("success")) {
//
//

    /// /                                    ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !! | ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !! ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !!
//
//                                    String topScrollText = model.getDataResponse().getTopScrollText().toString();
//                                    String topScrollText2 = model.getDataResponse().getTopScrollText2().toString();
//                                    String topScrollText3 = model.getDataResponse().getTopScrollText3().toString();
//                                    String topScrollText4 = model.getDataResponse().getTopScrollText4().toString();
//                                    String topScrollText5 = model.getDataResponse().getTopScrollText5().toString();
//
//                                    if (topScrollText != null) {
//                                        topScrollTextList = topScrollTextList  + topScrollText;
//                                    }
//                                    if (topScrollText2 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText2;
//                                    }
//                                    if (topScrollText3 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText3;
//                                    }
//                                    if (topScrollText4 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText4;
//                                    }
//                                    if (topScrollText5 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText5;
//                                    }
//
//                                    Log.d("tag11111", " topScrollTextList: " + topScrollTextList);
//                                    topScrollText(topScrollTextList);
//
//                                    ArrayList<SlideModel> imageList = new ArrayList<>();
//                                    String imageUrl1 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg1();
//                                    String imageUrl2 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg2();
//                                    String imageUrl3 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg3();
//                                    imageList.add(new SlideModel(imageUrl1, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl2, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl3, ScaleTypes.FIT));
//
//                                    binding.imageSlider.setImageList(imageList);
//
//                                    Log.d("tag11111", " imageUrl1: " + imageUrl1);
//                                    Log.d("tag11111", " imageUrl2: " + imageUrl2);
//                                    Log.d("tag11111", " imageUrl3: " + imageUrl3);
//
//
//                                } else {
//                                    new MaterialDialog.Builder(getContext())
//                                            .title("Doctor Status")
//                                            .content("List is empty....")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
//
//                            }
//
//
//                        },
//                        error -> {
//
//                            Log.d("tag11111", " response.code(): " + error.toString());
//
//                        },
//                        () -> {
//
//                        }
//                );
//
//
//    }




    @SuppressLint("CheckResult")
    public void categoriesApi() {

        String token = SharedData.getTOKEN(getContext());
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";
        String phone = "01814220954";


//        RetrofitApiClient.getApiInterface().categories(authorization, accept)
        RetrofitApiClient.getApiInterface().categories( accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag111444", " response.code(): " + response.code());


                            if (response.isSuccessful()) {

                                CategoryModel model = response.body();
                                Log.d("tag11111", " model: " + model);

                                List<CategoryModel.Result> cat_list = model.getResults();
                                Log.d("tag1111166", " cat_list: " + cat_list);
                                Log.d("tag1111166", " cat_list.size: " + cat_list.size());


                                int unread_notification_number = cat_list.size();

//                                updateNotificationsBadge(unread_notification_number);

//                                home_module_name_eng_list = Arrays.asList(getResources().getStringArray(R.array.home_module_name_eng_list));
//                                home_module_image_list = Arrays.asList(getResources().getStringArray(R.array.home_module_image_list));


                                home_module_name_eng_list = new ArrayList<>();
                                home_module_image_list = new ArrayList<>();
                                home_module_id_list = new ArrayList<>();

                                for (CategoryModel.Result item : cat_list) {
                                    home_module_name_eng_list.add(item.getName());
                                    home_module_image_list.add(item.getIcon());
                                    home_module_id_list.add(item.getId().toString());
                                }

                                homeModuleAdapter.setData(home_module_name_eng_list, home_module_image_list, home_module_id_list);
                                homeModuleAdapter.notifyDataSetChanged();

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








    @SuppressLint("CheckResult")
    public void appHomeScrollText() {


//        String topScrollTextList1 = " ইউনিকো সেবা অ্যাপে আপনাকে স্বাগত.... ওই সেকশনে আমাদের হাইলাইট করা তথ্য পাচ্ছেন... ";
//        topScrollText(topScrollTextList1);


//        showProgressDialog();

        String token = SharedData.getTOKEN(getContext());
        Log.d("tag11111", " token: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().home_scroll_texts(accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());

//                            closeProgressDialog();

                            if (response.code() == 401) {
                                Intent intent = new Intent(getContext(), LoginActivity.class);
                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
                                startActivity(intent);
                            }


                            if (response.isSuccessful()) {


                                Log.d("tag11111", " response.body(): " + response.body());

                                HomeScrollTextsModel model = response.body();
//                                boolean status = model.getSuccess();

                                String topScrollTextList = "";

//                                if (status) {



//                                    String topScrollText = model.getDataResponse().getTopScrollText().toString();
                                    for (HomeScrollTextsModel.Result text : model.getResults()) {
                                        topScrollTextList = topScrollTextList + text.getText();
                                    }


                                    Log.d("tag11111", " topScrollTextList: " + topScrollTextList);
                                    topScrollText(topScrollTextList);

//                                    ArrayList<SlideModel> imageList = new ArrayList<>();
//                                    String imageUrl1 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg1();
//                                    String imageUrl2 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg2();
//                                    String imageUrl3 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg3();
//                                    imageList.add(new SlideModel(imageUrl1, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl2, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl3, ScaleTypes.FIT));
//
//                                    binding.imageSlider.setImageList(imageList);
//
//                                    Log.d("tag11111", " imageUrl1: " + imageUrl1);
//                                    Log.d("tag11111", " imageUrl2: " + imageUrl2);
//                                    Log.d("tag11111", " imageUrl3: " + imageUrl3);


//                                } else {
//                                    new MaterialDialog.Builder(getContext())
//                                            .title("Doctor Status")
//                                            .content("List is empty....")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }

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


    @SuppressLint("CheckResult")
    public void appHomeSlidder() {

        ///
        ArrayList<SlideModel> imageList1 = new ArrayList<>();

//        imageList1.add(new SlideModel("file:///android_asset/home/img11.png", ScaleTypes.FIT));
//        imageList1.add(new SlideModel("file:///android_asset/home/img11.png", ScaleTypes.FIT));
//        imageList1.add(new SlideModel("file:///android_asset/home/img11.png", ScaleTypes.FIT));

        binding.imageSlider.setImageList(imageList1);
        ///

//        showProgressDialog();

        String token = SharedData.getTOKEN(getContext());
        Log.d("tag11111", " token: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().home_slider_images( accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag111112", "2 response.code(): " + response.code());

//                            closeProgressDialog();


                            if (response.code() == 401) {
                                Intent intent = new Intent(getContext(), LoginActivity.class);
                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
                                startActivity(intent);
                            }


                            if (response.isSuccessful()) {

                                response.body(); // do something with that
                                Log.d("tag111112", "2 response.body(): " + response.body());

                                HomeSliderModel model = response.body();


                                String topScrollTextList = "";

//                                if (success) {

                                    ArrayList<SlideModel> imageList = new ArrayList<>();

                                    for (HomeSliderModel.Result slider : model.getResults()) {
                                        imageList.add(new SlideModel(slider.getImageUrl(), ScaleTypes.FIT));
                                    }

                                    binding.imageSlider.setImageList(imageList);

                                    Log.d("tag111112", "2 imageList: " + imageList);

//                                }
//                                else {
//                                    new MaterialDialog.Builder(getContext())
//                                            .title("Slider Status")
//                                            .content("List is empty....")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }

                            } else {

                            }


                        },
                        error -> {

                            Log.d("tag111112", "2 response.code(): " + error.toString());

                        },
                        () -> {

                        }
                );


    }

    @SuppressLint("CheckResult")
    public void appHomeSlidder2() {

        ///
        ArrayList<SlideModel> imageList2 = new ArrayList<>();

        imageList2.add(new SlideModel("file:///android_asset/home/img12.png", ScaleTypes.FIT));

        binding.imageSlider2.setImageList(imageList2);
        ///

//        showProgressDialog();

        String token = SharedData.getTOKEN(getContext());
        Log.d("tag11111", " token: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

//        RetrofitApiClient.getApiInterface().home_slider_images(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag111112", "2 response.code(): " + response.code());
//
////                            closeProgressDialog();
//
//
//                            if (response.code() == 401) {
//                                Intent intent = new Intent(getContext(), LoginActivity.class);
//                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
//                                startActivity(intent);
//                            }
//
//
//                            if (response.isSuccessful()) {
//
//                                response.body(); // do something with that
//                                Log.d("tag111112", "2 response.body(): " + response.body());
//
//                                HomeSliderModel model = response.body();
//                                boolean success = model.getSuccess();
//
//                                String topScrollTextList = "";
//
//                                if (success) {
//
//                                    ArrayList<SlideModel> imageList = new ArrayList<>();
//
//                                    for (HomeSliderImageModel.HomeSliderImage imageUrl : model.getResult().getHomeSliderImages()) {
//                                        imageList.add(new SlideModel(imageUrl.getImage(), ScaleTypes.FIT));
//                                    }
//
//                                    binding.imageSlider.setImageList(imageList);
//
//                                    Log.d("tag111112", "2 imageList: " + imageList);
//
//                                } else {
//                                    new MaterialDialog.Builder(getContext())
//                                            .title("Slider Status")
//                                            .content("List is empty....")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
//
//                            }
//
//
//                        },
//                        error -> {
//
//                            Log.d("tag111112", "2 response.code(): " + error.toString());
//
//                        },
//                        () -> {
//
//                        }
//                );


    }


//        @SuppressLint("CheckResult")
//    public void appHomeSlidder() {
//
//        showProgressDialog();
//
//        String token = SharedData.getTOKEN(getContext());
//        Log.d("tag11111", " token: " + token);
//        String authorization = "Bearer" + " " + token;
//        String accept = "application/json";
//
//        RetrofitApiClient.getApiInterface().appHome(authorization, accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            Log.d("tag11111", " response.code(): " + response.code());
//
//                            closeProgressDialog();
//
//
//                            if (response.code() == 401) {
//                                Intent intent = new Intent(getContext(), LoginActivity.class);
//                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
//                                startActivity(intent);
//                            }
//
//
//                            if (response.isSuccessful()) {
//
//
//                                response.body(); // do something with that
//                                Log.d("tag11111", " response.body(): " + response.body());
//
//                                AppHomeModel model = response.body();
//                                String status = model.getStatus();
//
//                                String topScrollTextList = "";
//
//                                if (status.equalsIgnoreCase("success")) {
//
//

    /// /                                    ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !! | ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !! ময়মনসিংহ হেল্পলাইন এ আপনাকে স্বাগতম !!
//
//                                    String topScrollText = model.getDataResponse().getTopScrollText().toString();
//                                    String topScrollText2 = model.getDataResponse().getTopScrollText2().toString();
//                                    String topScrollText3 = model.getDataResponse().getTopScrollText3().toString();
//                                    String topScrollText4 = model.getDataResponse().getTopScrollText4().toString();
//                                    String topScrollText5 = model.getDataResponse().getTopScrollText5().toString();
//
//                                    if (topScrollText != null) {
//                                        topScrollTextList = topScrollTextList  + topScrollText;
//                                    }
//                                    if (topScrollText2 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText2;
//                                    }
//                                    if (topScrollText3 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText3;
//                                    }
//                                    if (topScrollText4 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText4;
//                                    }
//                                    if (topScrollText5 != null) {
//                                        topScrollTextList = topScrollTextList + " | " + topScrollText5;
//                                    }
//
//                                    Log.d("tag11111", " topScrollTextList: " + topScrollTextList);
//                                    topScrollText(topScrollTextList);
//
//                                    ArrayList<SlideModel> imageList = new ArrayList<>();
//                                    String imageUrl1 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg1();
//                                    String imageUrl2 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg2();
//                                    String imageUrl3 = Api.BASE_URL_HOME_SLIDER + model.getDataResponse().getTopSliderImg3();
//                                    imageList.add(new SlideModel(imageUrl1, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl2, ScaleTypes.FIT));
//                                    imageList.add(new SlideModel(imageUrl3, ScaleTypes.FIT));
//
//                                    binding.imageSlider.setImageList(imageList);
//
//                                    Log.d("tag11111", " imageUrl1: " + imageUrl1);
//                                    Log.d("tag11111", " imageUrl2: " + imageUrl2);
//                                    Log.d("tag11111", " imageUrl3: " + imageUrl3);
//
//
//                                } else {
//                                    new MaterialDialog.Builder(getContext())
//                                            .title("Doctor Status")
//                                            .content("List is empty....")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
//
//                            }
//
//
//                        },
//                        error -> {
//
//                            Log.d("tag11111", " response.code(): " + error.toString());
//
//                        },
//                        () -> {
//
//                        }
//                );
//
//
//    }
    private void topScrollText(String scrollText) {

        binding.tvMarquee.setSelected(true);

        binding.tvMarquee.setText(scrollText);
        Paint textPaint = binding.tvMarquee.getPaint();
        String text = binding.tvMarquee.getText().toString();//get text
        int width = Math.round(textPaint.measureText(text));//measure the text size
        ViewGroup.LayoutParams params = binding.tvMarquee.getLayoutParams();
//        params.width = width;
//        binding.tvMarquee.setLayoutParams(params); //refine

//        DisplayMetrics displaymetrics = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
//        int screenWidth = displaymetrics.widthPixels;
//
//        //this is optional. do not scroll if text is shorter than screen width
//        //remove this won't effect the scroll
//        if (width <= screenWidth) {
//            //All text can fit in screen.
//            return;
//        }
//        //set the animation
//        TranslateAnimation slide = new TranslateAnimation(0, -width, 0, 0);
//        slide.setDuration(50000);
//        slide.setRepeatCount(Animation.INFINITE);
//        slide.setRepeatMode(Animation.RESTART);
//        slide.setInterpolator(new LinearInterpolator());
//
//        binding.tvMarquee.startAnimation(slide);


        int textWidth = (int) binding.tvMarquee.getPaint()
                .measureText(binding.tvMarquee.getText().toString());

        int viewWidth = binding.tvMarquee.getWidth();

        TranslateAnimation slide = new TranslateAnimation(
                viewWidth, -textWidth, 0, 0
        );

        slide.setDuration(20000);
        slide.setRepeatCount(Animation.INFINITE);
        slide.setInterpolator(new LinearInterpolator());

        binding.tvMarquee.startAnimation(slide);


    }


    private void initView(View root) {

//        binding.etSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                filter(s.toString());
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                filter(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });
    }

    private void topSlider() {

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.medical, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.admission, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.service, ScaleTypes.FIT));

        binding.imageSlider.setImageList(imageList);
    }


    private void loadListData() {
        home_module_name_eng_list = Arrays.asList(getResources().getStringArray(R.array.home_module_name_eng_list));
//        home_module_name_ban_list = Arrays.asList(getResources().getStringArray(R.array.home_module_name_ban_list));
        home_module_image_list = Arrays.asList(getResources().getStringArray(R.array.home_module_image_list));
    }

    private void initComponent() {
//        recyclerView = findViewById(R.id.recyclerView);
    }


    private void loadRecyclerView() {

//        loadListData();

//        home_module_name_eng_list = Arrays.asList(getResources().getStringArray(R.array.home_module_name_eng_list));
////        home_module_name_ban_list = Arrays.asList(getResources().getStringArray(R.array.home_module_name_ban_list));
//        home_module_image_list = Arrays.asList(getResources().getStringArray(R.array.home_module_image_list));

        homeModuleAdapter = new HomeModuleAdapter2(getActivity());
        binding.recyclerView.setAdapter(homeModuleAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);
        binding.recyclerView.setLayoutManager(mLayoutManager);
//        homeModuleAdapter.setData(home_module_name_eng_list, home_module_name_ban_list, home_module_image_list);
//        homeModuleAdapter.setData(home_module_name_eng_list, home_module_image_list);
//        homeModuleAdapter.notifyDataSetChanged();

    }


    private void filter(String text) {
        List<String> filteredList = new ArrayList<>();
//        List<String> filteredListBan = new ArrayList<>();
        List<String> filteredListImg = new ArrayList<>();
        List<String> filteredListId = new ArrayList<>();
        List<Integer> filteredPosition = new ArrayList<>();

        for (String item : home_module_name_eng_list) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
                filteredPosition.add(home_module_name_eng_list.indexOf(item));
            }
        }

//        for (int position : filteredPosition) {
//            filteredListBan.add(home_module_name_ban_list.get(position));
//            filteredListImg.add(home_module_image_list.get(position));
//        }

        homeModuleAdapter.filterList(filteredList, filteredListImg, filteredListId);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    ProgressDialog progressDialog;

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait ....");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }


}