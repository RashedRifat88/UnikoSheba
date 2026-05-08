package com.egsystem.unikosheba.ui.services;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.adapters.RecentSearchAdapter;
import com.egsystem.unikosheba.adapters.ServicesForSearchAdapter;
import com.egsystem.unikosheba.databinding.ActivityServiceSearchBinding;
import com.egsystem.unikosheba.model.ServiceModel;
import com.egsystem.unikosheba.model.Services;
import com.egsystem.unikosheba.retrofit.Api;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServiceSearchActivity extends AppCompatActivity {

    private ActivityServiceSearchBinding binding;

    RecyclerView rvService;
    ServicesForSearchAdapter serviceAdapter;

    // MAIN LIST
    List<Services> services = new ArrayList<>();

    // FILTERED LIST
    List<Services> filteredServices = new ArrayList<>();


    RecyclerView rvRecentSearch;

    RecentSearchAdapter recentSearchAdapter;

    List<String> recentSearchList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityServiceSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponent();

        loadRecentSearches();

        singleSubCat();
    }




    private void loadRecentSearches() {

        String data = getSharedPreferences("search_pref", MODE_PRIVATE)
                .getString("recent", "");

        recentSearchList.clear();

        if (!data.isEmpty()) {

            String[] items = data.split(",");

            for (String item : items) {

                recentSearchList.add(item);
            }
        }

        recentSearchAdapter.notifyDataSetChanged();
    }




    private void initStatusBar() {

        View decor = getWindow().getDecorView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            getWindow().setStatusBarColor(
                    getResources().getColor(R.color.colorPrimary, this.getTheme())
            );

            decor.setSystemUiVisibility(
                    decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            );

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(
                    getResources().getColor(R.color.colorPrimary)
            );

            decor.setSystemUiVisibility(
                    decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            );
        }
    }

    private void initComponent() {

        binding.imgBack.setOnClickListener(v -> finish());

        rvService = findViewById(R.id.rvService);

        rvService.setLayoutManager(new LinearLayoutManager(this));

        // EMPTY ADAPTER
//        serviceAdapter = new ServicesForSearchAdapter(this, filteredServices);

        serviceAdapter = new ServicesForSearchAdapter(
                this,
                filteredServices,
                service -> {

                    // SAVE RECENT
                    saveRecentSearch(service.getName());

                    // OPEN DETAILS
//            Intent intent = new Intent(this, DetailsActivity.class);
//            startActivity(intent);

//                    Toast.makeText(this,
//                            service.getName(),
//                            Toast.LENGTH_SHORT).show();

                }
        );

        rvService.setAdapter(serviceAdapter);



        //recent
        rvRecentSearch = findViewById(R.id.rvRecentSearch);

        rvRecentSearch.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        recentSearchAdapter = new RecentSearchAdapter(
                this,
                recentSearchList,
                text -> {

                    binding.searchView.setQuery(text, true);
                }
        );

        rvRecentSearch.setAdapter(recentSearchAdapter);



        // SEARCH
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                saveRecentSearch(query);

                filterServices(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterServices(newText);

                return true;
            }
        });




    }



    private void saveRecentSearch(String text) {

        if (text == null || text.trim().isEmpty()) return;

        recentSearchList.remove(text);

        recentSearchList.add(0, text);

        // LIMIT
        if (recentSearchList.size() > 10) {
            recentSearchList.remove(recentSearchList.size() - 1);
        }

        getSharedPreferences("search_pref", MODE_PRIVATE)
                .edit()
                .putString("recent", android.text.TextUtils.join(",", recentSearchList))
                .apply();

        recentSearchAdapter.notifyDataSetChanged();
    }






    @SuppressLint("CheckResult")
    private void singleSubCat() {

        AppUtils.showProgressDialog(this);

        String accept = "application/json";

        RetrofitApiClient.getApiInterface()
                .services(accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                    AppUtils.hideProgressDialog();

                    if (response.code() == 401) {

                        AppUtils.goToLogin(this, true);

                        return;
                    }

                    if (response.isSuccessful() && response.body() != null) {

                        ServiceModel data = response.body();

                        List<ServiceModel.Result> service_list = data.getResults();

                        services.clear();

                        for (ServiceModel.Result item : service_list) {

                            services.add(
                                    new Services(
                                            item.getId().toString(),
                                            item.getName(),
                                            Api.BASE_URL_MAIN + item.getImage(),
                                            item.getShortDescription(),
                                            Double.parseDouble(item.getFinalPrice())
                                    )
                            );
                        }

                        // INITIAL LOAD
                        filteredServices.clear();
                        filteredServices.addAll(services);

                        serviceAdapter.notifyDataSetChanged();

                    } else {

                        Toast.makeText(
                                this,
                                "Failed to get services",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                }, error -> {

                    AppUtils.hideProgressDialog();

                    Toast.makeText(
                            this,
                            "Error loading services",
                            Toast.LENGTH_SHORT
                    ).show();
                });
    }

    // SEARCH FILTER
    private void filterServices(String text) {

        filteredServices.clear();

        if (text == null || text.trim().isEmpty()) {

            filteredServices.addAll(services);

        } else {

            String searchText = text.toLowerCase().trim();

            for (Services item : services) {

                boolean matchName =
                        item.getName() != null &&
                                item.getName().toLowerCase().contains(searchText);

                boolean matchDescription =
                        item.getDescription() != null &&
                                item.getDescription().toLowerCase().contains(searchText);

                if (matchName || matchDescription) {

                    filteredServices.add(item);
                }
            }
        }

        serviceAdapter.notifyDataSetChanged();
    }
}





//package com.egsystem.unikosheba.ui.services;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.egsystem.unikosheba.R;
//import com.egsystem.unikosheba.adapters.CategoryAdapter;
//import com.egsystem.unikosheba.adapters.ServicesForSearchAdapter;
//import com.egsystem.unikosheba.cart.CartListActivity;
//import com.egsystem.unikosheba.data.database.DatabaseHelper;
//import com.egsystem.unikosheba.databinding.ActivityServiceSearchBinding;
//import com.egsystem.unikosheba.databinding.ActivityServicesBinding;
//import com.egsystem.unikosheba.model.Category;
//import com.egsystem.unikosheba.model.ServiceModel;
//import com.egsystem.unikosheba.model.Services;
//import com.egsystem.unikosheba.model.SingleCategoryModel;
//import com.egsystem.unikosheba.model.SingleSubCategoryModel;
//import com.egsystem.unikosheba.retrofit.Api;
//import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
//import com.egsystem.unikosheba.utils.AppUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class ServiceSearchActivity extends AppCompatActivity {
//
//    private ActivityServiceSearchBinding binding;
//
//    RecyclerView rvService;
//    ServicesForSearchAdapter serviceAdapter;
//
//    List<SingleCategoryModel.Subcategory> sub_cat_list = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityServiceSearchBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//
////        frame_cart.setOnClickListener(v -> {
////            startActivity(new Intent(this, CartListActivity.class));
////        });
//
//        initStatusBar();
//        initComponent();
//
//        singleSubCat();
//    }
//
//    private void initStatusBar() {
//        View decor = getWindow().getDecorView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
//    }
//
//    private void initComponent() {
//
//        binding.imgBack.setOnClickListener(v -> finish());
//
//        rvService = findViewById(R.id.rvService);
//
//        rvService.setLayoutManager(new LinearLayoutManager(this));
//
//        // empty adapter initially
//        serviceAdapter = new ServicesForSearchAdapter(this, new ArrayList<>());
//        rvService.setAdapter(serviceAdapter);
//    }
//
//
//    @SuppressLint("CheckResult")
//    private void singleSubCat() {
//
//        AppUtils.showProgressDialog(this);
//
////        String url = Api.BASE_URL + Api.subcategories + "/" + subCatId;
//        String accept = "application/json";
//
//        RetrofitApiClient.getApiInterface()
//                .services(accept)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//
//                    AppUtils.hideProgressDialog();
//
//                    if (response.code() == 401) {
//                        AppUtils.goToLogin(this, true);
//                        return;
//                    }
//
//                    if (response.isSuccessful() && response.body() != null) {
//
//                        ServiceModel data = response.body();
//
//                        List<ServiceModel.Result> service_list = data.getResults();
//
//                        List<Services> services = new ArrayList<>();
//
//                        for (ServiceModel.Result item : service_list) {
//                            services.add(new Services(
//                                    item.getId().toString(),
//                                    item.getName(),
//                                    Api.BASE_URL_MAIN + item.getImage(),
//                                    item.getShortDescription(),
//                                    Double.parseDouble(item.getFinalPrice())
//                            ));
//                        }
//
//                        serviceAdapter = new ServicesForSearchAdapter(this, services);
//                        rvService.setAdapter(serviceAdapter);
//
//                    } else {
//                        Toast.makeText(this, "Failed to get services", Toast.LENGTH_SHORT).show();
//                    }
//
//                }, error -> {
//                    AppUtils.hideProgressDialog();
//                    Toast.makeText(this, "Error loading services", Toast.LENGTH_SHORT).show();
//                });
//    }
//
//
//
//
//
//}