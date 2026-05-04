package com.egsystem.unikosheba.ui.services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.adapters.CategoryAdapter;
import com.egsystem.unikosheba.adapters.ServicesAdapter;
import com.egsystem.unikosheba.cart.CartListActivity;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.databinding.ActivityServicesBinding;
import com.egsystem.unikosheba.model.Category;
import com.egsystem.unikosheba.model.Services;
import com.egsystem.unikosheba.model.SingleCategoryModel;
import com.egsystem.unikosheba.model.SingleSubCategoryModel;
import com.egsystem.unikosheba.retrofit.Api;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServicesActivity extends AppCompatActivity {

    private ActivityServicesBinding binding;

    RecyclerView rvCategory, rvService;
    ServicesAdapter serviceAdapter;

    private DatabaseHelper db;
    TextView tv_cart_badge_count;
    FrameLayout frame_cart;

    String cat_id;

    // Keep subcategory list globally
    List<SingleCategoryModel.Subcategory> sub_cat_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityServicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cat_id = getIntent().getStringExtra("cat_id");

        db = new DatabaseHelper(this);
        db.getWritableDatabase();

        frame_cart = findViewById(R.id.frame_cart);
        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);

        updateCartBadge();

        frame_cart.setOnClickListener(v -> {
            startActivity(new Intent(this, CartListActivity.class));
        });

        initStatusBar();
        initComponent();

        singleCat();
    }

    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private void initComponent() {

        binding.imgBack.setOnClickListener(v -> finish());

        rvCategory = findViewById(R.id.rvCategory);
        rvService = findViewById(R.id.rvService);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvService.setLayoutManager(new LinearLayoutManager(this));

        // empty adapter initially
        serviceAdapter = new ServicesAdapter(this, new ArrayList<>());
        rvService.setAdapter(serviceAdapter);
    }

    // 🔥 Load category + subcategory
    @SuppressLint("CheckResult")
    private void singleCat() {

        AppUtils.showProgressDialog(this);

        String url = Api.BASE_URL + Api.categories + "/" + cat_id;

        RetrofitApiClient.getApiInterface()
                .single_category(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                    AppUtils.hideProgressDialog();

                    if (response.code() == 401) {
                        AppUtils.goToLogin(this, true);
                        return;
                    }

                    if (response.isSuccessful() && response.body() != null) {

                        SingleCategoryModel data = response.body();

                        sub_cat_list = data.getSubcategories();

                        List<Category> categories = new ArrayList<>();

                        for (SingleCategoryModel.Subcategory item : sub_cat_list) {
                            categories.add(new Category(
                                    item.getName(),
                                    Api.BASE_URL_MAIN + item.getIcon()
                            ));
                        }

                        CategoryAdapter categoryAdapter = new CategoryAdapter(
                                this,
                                categories,
                                position -> {

                                    String subCatId = sub_cat_list.get(position).getId().toString();
                                    Log.d("CLICK", "SubCat ID: " + subCatId);

                                    singleSubCat(subCatId);
                                });

                        rvCategory.setAdapter(categoryAdapter);

                        // auto load first subcategory
                        if (!sub_cat_list.isEmpty()) {
                            singleSubCat(sub_cat_list.get(0).getId().toString());
                        }

                    } else {
                        Toast.makeText(this, "Failed to get data", Toast.LENGTH_SHORT).show();
                    }

                }, error -> {
                    AppUtils.hideProgressDialog();
                    Toast.makeText(this, "Error loading categories", Toast.LENGTH_SHORT).show();
                });
    }

    // 🔥 Load services of selected subcategory
    @SuppressLint("CheckResult")
    private void singleSubCat(String subCatId) {

        AppUtils.showProgressDialog(this);

        String url = Api.BASE_URL + Api.subcategories + "/" + subCatId;

        RetrofitApiClient.getApiInterface()
                .single_sub_category(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                    AppUtils.hideProgressDialog();

                    if (response.code() == 401) {
                        AppUtils.goToLogin(this, true);
                        return;
                    }

                    if (response.isSuccessful() && response.body() != null) {

                        SingleSubCategoryModel data = response.body();

                        List<SingleSubCategoryModel.Service> service_list = data.getServices();

                        List<Services> services = new ArrayList<>();

                        for (SingleSubCategoryModel.Service item : service_list) {
                            services.add(new Services(
                                    item.getId().toString(),
                                    item.getName(),
                                    Api.BASE_URL_MAIN + item.getImage(),
                                    item.getShortDescription(),
                                    Double.parseDouble(item.getFinalPrice())
                            ));
                        }

                        // 🔥 update adapter
                        serviceAdapter = new ServicesAdapter(this, services);
                        rvService.setAdapter(serviceAdapter);

                    } else {
                        Toast.makeText(this, "Failed to get services", Toast.LENGTH_SHORT).show();
                    }

                }, error -> {
                    AppUtils.hideProgressDialog();
                    Toast.makeText(this, "Error loading services", Toast.LENGTH_SHORT).show();
                });
    }

    private void updateCartBadge() {
        try {
            if (db == null || tv_cart_badge_count == null) return;

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

    @Override
    protected void onResume() {
        super.onResume();
        updateCartBadge();
    }
}




//package com.egsystem.unikosheba.ui.services;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Bundle;
//
//import com.egsystem.unikosheba.adapters.CategoryAdapter;
//import com.egsystem.unikosheba.adapters.ServicesAdapter;
//import com.egsystem.unikosheba.cart.CartListActivity;
//import com.egsystem.unikosheba.cart.Service;
//import com.egsystem.unikosheba.cart.ShoppingCartHelper;
//import com.egsystem.unikosheba.data.SharedData;
//import com.egsystem.unikosheba.data.database.DatabaseHelper;
//import com.egsystem.unikosheba.model.Category;
//import com.egsystem.unikosheba.model.Services;
//import com.egsystem.unikosheba.model.SingleCategoryModel;
//import com.egsystem.unikosheba.model.SingleSubCategoryModel;
//import com.egsystem.unikosheba.retrofit.Api;
//import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
//import com.egsystem.unikosheba.utils.AppUtils;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.util.Log;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.egsystem.unikosheba.databinding.ActivityServicesBinding;
//
//import com.egsystem.unikosheba.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class ServicesActivity extends AppCompatActivity {
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityServicesBinding binding;
//
//    RecyclerView rvCategory, rvService;
//    ServicesAdapter serviceAdapter;
//
//    List<Services> applianceList = new ArrayList<>();
//    List<Services> cleaningList = new ArrayList<>();
//
//
//    static int mNotificationsCount = 0;
//    static int cartItemNumber = 0;
//    private List<Service> mProductList;
//
//    private DatabaseHelper db;
//    TextView tv_cart_badge_count;
//    FrameLayout frame_cart;
//
//    String cat_id;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityServicesBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        cat_id = getIntent().getStringExtra("cat_id");
//
////        setSupportActionBar(binding.toolbar);
//
//        db = new DatabaseHelper(this);
//        db.getWritableDatabase();
//
//        frame_cart = findViewById(R.id.frame_cart);
//        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);
//        updateCartBadge();
//        frame_cart.setOnClickListener(v -> {
//            Intent intent = new Intent(ServicesActivity.this, CartListActivity.class);
//            startActivity(intent);
//        });
//
//        initStatusBar();
//        initComponent();
//
//        singleCat();
//
//
//        mProductList = ShoppingCartHelper.getCatalog(getResources());
//
////        new FetchCountTask().execute();
////
////        android.os.Handler customHandler = new android.os.Handler();
////        customHandler.postDelayed(updateTimerThread, 0);
//
//
//    }
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
//    private void initComponent() {
//        binding.imgBack.setOnClickListener(v -> {
//            finish();
//        });
//
////        binding.btnMakePost.setOnClickListener(v -> {
////            Intent intent = new Intent(HouseRentActivity.this, HouseRentPostActivity.class);
////            startActivity(intent);
////        });
//
//
//        rvCategory = findViewById(R.id.rvCategory);
//        rvService = findViewById(R.id.rvService);
//
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        rvService.setLayoutManager(new LinearLayoutManager(this));
//
////        List<Category> categories = new ArrayList<>();
////
////        categories.add(new Category("Appliance Repair", R.drawable.ic_alarm));
////        categories.add(new Category("Cleaning", R.drawable.ic_alarm_clock));
////        categories.add(new Category("Beauty", R.drawable.ic_badge1));
//
////        applianceList.add(new Services("Oven Services", R.drawable.doctors, "Description1", 150.00));
////        applianceList.add(new Services("TV Services", R.drawable.award, "Description2", 110));
////        applianceList.add(new Services("Refrigerator Services", R.drawable.doctors, "Description3", 200));
////
////        cleaningList.add(new Services("Home Cleaning", R.drawable.application_form, "Description5", 150.00));
////        cleaningList.add(new Services("Bathroom Cleaning", R.drawable.electrician, "Description6", 150.00));
//
//        serviceAdapter = new ServicesAdapter(this, applianceList);
//
//        rvService.setAdapter(serviceAdapter);
//
//
////        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories, position -> {
////
////            if (position == 0) {
////
////                serviceAdapter = new ServicesAdapter(this, applianceList);
////
////            } else if (position == 1) {
////
////                serviceAdapter = new ServicesAdapter(this, cleaningList);
////
////            }
////
////            rvService.setAdapter(serviceAdapter);
////
////        });
////
////        rvCategory.setAdapter(categoryAdapter);
//
//
//    }
//
//
//    @SuppressLint("CheckResult")
//    private void singleCat() {
//
//
//        AppUtils.showProgressDialog(this);
//
//        String authorization = SharedData.getTOKEN(this);
//        Log.d("authorization", "authorization: " + authorization);
//        String accept = "application/json";
//        String content_type = "application/json";
//        String activeFlag = "";
//        String sort = "bddVisitId,desc";
//
//        String url = Api.BASE_URL + Api.categories + "/"
//                + cat_id;
//
//        RetrofitApiClient.getApiInterface().single_category(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(response -> {
//            AppUtils.hideProgressDialog();
//            Log.d("Response Code", "response: " + response);
//            Log.d("Response Code", "Response Code: " + response.code());
//            Log.d("Response Code response.body()", "Response Code response.body(): " + response.body());
//
//            if (response.code() == 401) {
//                AppUtils.goToLogin(this, true);
//            }
//
//
//            if (response.isSuccessful() && response.body() != null) {
//                SingleCategoryModel data = response.body();
//                Log.d("Response Code data", "data: " + data);
//
//                List<SingleCategoryModel.Subcategory> sub_cat_list = data.getSubcategories();
//                Log.d("tag1111166", " sub_cat_list: " + sub_cat_list);
//
//
//                List<Category> categories = new ArrayList<>();
//
//
//                for (SingleCategoryModel.Subcategory item : sub_cat_list) {
//                    categories.add(new Category(item.getName(), Api.BASE_URL_MAIN + item.getIcon()));
//                    Log.d("tag1111166", " categories inside 1: " + categories);
//                }
//
//                CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories, position -> {
//
//                    Log.d("tag1111166", " categories inside 2: " + categories);
//
//                    singleSubCat( subCatId);
//
////                    if (position == 0) {
////
////                        serviceAdapter = new ServicesAdapter(this, applianceList);
////
////                    } else if (position == 1) {
////
////                        serviceAdapter = new ServicesAdapter(this, cleaningList);
////
////                    }
//
//                    rvService.setAdapter(serviceAdapter);
//
//                });
//
//                rvCategory.setAdapter(categoryAdapter);
//
//
//            } else {
//                Toast.makeText(this, "Failed to get data", Toast.LENGTH_SHORT).show();
//            }
//
//
//        }, error -> {
//
//            Log.e("VisitListActivity", "Error: " + error.getMessage());
//            Toast.makeText(this, "Error loading visits", Toast.LENGTH_SHORT).show();
//            AppUtils.hideProgressDialog();
//            Log.e("tag_this", "Login error: " + error.getMessage());
//
//        }, () -> Log.d("tag_this", "Login request completed"));
//
//    }
//
//
//
//
//
//    @SuppressLint("CheckResult")
//    private void singleSubCat(String subCatId) {
//
//
//        AppUtils.showProgressDialog(this);
//
//        String authorization = SharedData.getTOKEN(this);
//        Log.d("authorization", "authorization: " + authorization);
//        String accept = "application/json";
//        String content_type = "application/json";
//        String activeFlag = "";
//        String sort = "bddVisitId,desc";
//
//        String url = Api.BASE_URL + Api.subcategories + "/"
//                + subCatId;
//
//        RetrofitApiClient.getApiInterface().single_sub_category(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(response -> {
//            AppUtils.hideProgressDialog();
//            Log.d("Response Code", "response: " + response);
//            Log.d("Response Code", "Response Code: " + response.code());
//            Log.d("Response Code response.body()", "Response Code response.body(): " + response.body());
//
//            if (response.code() == 401) {
//                AppUtils.goToLogin(this, true);
//            }
//
//
//            if (response.isSuccessful() && response.body() != null) {
//                SingleSubCategoryModel data = response.body();
//                Log.d("Response Code data", "data: " + data);
//
//                List<SingleSubCategoryModel.Service> service_list = data.getServices();
//                Log.d("tag1111166", " service_list: " + service_list);
//
//
//                List<Services> services = new ArrayList<>();
//
//
//                for (SingleSubCategoryModel.Service item : service_list) {
////                    services.add(new Category(item.getName(), Api.BASE_URL_MAIN + item.getIcon()));
//                    services.add(new Services(item.getName(), Api.BASE_URL_MAIN + item.getImage(), item.getShortDescription(), Double.parseDouble(item.getFinalPrice())));
//                    Log.d("tag1111166", " categories inside 1: " + services);
//                }
//
//                serviceAdapter = new ServicesAdapter(this, services);
//                rvService.setAdapter(serviceAdapter);
////                rvCategory.setAdapter(categoryAdapter);
//
//
//
////                CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories, position -> {
////
////                    Log.d("tag1111166", " categories inside 2: " + categories);
////
////                    if (position == 0) {
////
////                        serviceAdapter = new ServicesAdapter(this, applianceList);
////
////                    } else if (position == 1) {
////
////                        serviceAdapter = new ServicesAdapter(this, cleaningList);
////
////                    }
////
////                    rvService.setAdapter(serviceAdapter);
////
////                });
////
////                rvCategory.setAdapter(categoryAdapter);
//
//
//            } else {
//                Toast.makeText(this, "Failed to get data", Toast.LENGTH_SHORT).show();
//            }
//
//
//        }, error -> {
//
//            Log.e("VisitListActivity", "Error: " + error.getMessage());
//            Toast.makeText(this, "Error loading visits", Toast.LENGTH_SHORT).show();
//            AppUtils.hideProgressDialog();
//            Log.e("tag_this", "Login error: " + error.getMessage());
//
//        }, () -> Log.d("tag_this", "Login request completed"));
//
//    }
//
//
//
//
//
//
//    private Runnable updateTimerThread = new Runnable() {
//        public void run() {
//            new FetchCountTask().execute();
//
//            android.os.Handler customHandler = new android.os.Handler();
//            customHandler.postDelayed(this, 1000);
//        }
//    };
//
//
//    private void updateNotificationsBadge(int count) {
//        mNotificationsCount = count;
//
//        // force the ActionBar to relayout its MenuItems.
//        // onCreateOptionsMenu(Menu) will be called again.
//        invalidateOptionsMenu();
//    }
//
//    /*
//    AsyncTask to fetch the notifications count
//    */
//    public class FetchCountTask extends AsyncTask<Void, Void, Integer> {
//
//        @Override
//        protected Integer doInBackground(Void... params) {
//
//
//            int count = cartItemNumber;
//            Log.d("tag222", "count: " + count);
//
//            return count;
//        }
//
//        @Override
//        public void onPostExecute(Integer count) {
//            updateNotificationsBadge(count);
//        }
//    }
//
//    public static void getCartItemsNumber(int getCartItemsNumber) {
//        cartItemNumber = getCartItemsNumber;
////        mNotificationsCount = cartItemNumber;
//        Log.d("tag222", "getCartItemsNumber: " + cartItemNumber);
//    }
//
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        updateCartBadge(); // 🔥 important
//    }
//
//
//    private void updateCartBadge() {
//
////        int count = db.getCartModelsCount();
////
////        if (count == 0) {
////            tv_cart_badge_count.setVisibility(View.GONE);
////        } else {
////            tv_cart_badge_count.setText(String.valueOf(count));
////            tv_cart_badge_count.setVisibility(View.VISIBLE);
////        }
//
//        try {
//
//            if (db == null) return;
//            if (tv_cart_badge_count == null) return;
//
//            int count = db.getCartModelsCount();
//
//            if (count <= 0) {
//                tv_cart_badge_count.setVisibility(View.GONE);
//            } else {
//                tv_cart_badge_count.setText(String.valueOf(count));
//                tv_cart_badge_count.setVisibility(View.VISIBLE);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//}