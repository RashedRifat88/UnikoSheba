package com.egsystem.unikosheba.ui.checkout;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystem.unikosheba.MainActivity;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.adapters.ServicesAdapter;
import com.egsystem.unikosheba.cart.CartAdapter;
import com.egsystem.unikosheba.cart.CartListActivity;
import com.egsystem.unikosheba.cart.CartModel;
import com.egsystem.unikosheba.cart.Service;
import com.egsystem.unikosheba.credential.LoginActivity;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.databinding.ActivityCheckoutBinding;
import com.egsystem.unikosheba.databinding.ActivityServicesBinding;
import com.egsystem.unikosheba.model.Services;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
import com.egsystem.unikosheba.ui.services.ItemDetailsActivity;
import com.egsystem.unikosheba.utils.AppUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CheckoutActivity extends AppCompatActivity {


    private ActivityCheckoutBinding binding;

    private DatabaseHelper db;
    List<CartModel> cartList;

    ImageView img_back;
    FrameLayout frame_cart;
    TextView tv_cart_badge_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new DatabaseHelper(this);
        cartList = db.getAllCartModels();

        initComponents();
        loadPrevData();
        calculateTotal();
    }

    private void loadPrevData() {
        String address = SharedData.getPRESENT_ADDRESS(this);
        if (!address.isEmpty() ) {
            binding.etAddress.setText(address);
        }
    }

    private void initComponents() {

        binding.imgBack.setOnClickListener(view -> {
            finish();
        });

        setupDatePicker();
        setupTimePicker();
        loadCartItems();
        calculateTotal();


        frame_cart = findViewById(R.id.frame_cart);
        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);

        updateCartBadge();

        frame_cart.setOnClickListener(v -> {
            finish();
        });


        binding.btnPlaceOrder.setOnClickListener(v -> placeOrder());
    }


    private void setupDatePicker() {
        binding.tvDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            DatePickerDialog dialog = new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> {
                        binding.tvDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));

            dialog.show();
        });
    }


    private void setupTimePicker() {
        binding.tvTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            TimePickerDialog dialog = new TimePickerDialog(this,
                    (view, hourOfDay, minute) -> {
                        binding.tvTime.setText(hourOfDay + ":" + minute);
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true);

            dialog.show();
        });
    }


    private void loadCartItems() {
        List<CartModel> cartList = db.getAllCartModels();

        CartAdapter adapter = new CartAdapter(this, cartList, true);
        binding.recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerCart.setAdapter(adapter);

    }


    private void updateCartBadge() {

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


    private void calculateTotal() {
        int total = 0;

        Log.d("tag444", "calculateTotal os hit");

        for (CartModel item : cartList) {

            Log.d("tag444", "cartList2: " + cartList);
            try {
                Log.d("tag444", "cartList3: " + cartList);
                Log.d("tag444", "item.getPrice(): " + item.getPrice());
                int price = (int) Double.parseDouble(item.getPrice());
                int qty = (int) Double.parseDouble(item.getQuantity());

                Log.d("tag444", "price: " + price);

                total += price * qty;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        binding.tvTotal.setText("Total: ৳ " + total + "/=");
    }


    private void placeOrder() {

        String address = binding.etAddress.getText().toString().trim();
        String mobile = binding.etMobile.getText().toString().trim();
        String date = binding.tvDate.getText().toString();
        String time = binding.tvTime.getText().toString();

        if (address.isEmpty()) {
            binding.etAddress.setError("Enter address");
            return;
        }else {
            SharedData.savePRESENT_ADDRESS(this, address);
        }

//        if (mobile.isEmpty()) {
//            binding.etMobile.setError("Enter mobile");
//            return;
//        }

        if (date.isEmpty() || date.equalsIgnoreCase("Select Date")) {
            binding.tvDate.setError("Select date");
            return;
        }

        if (time.isEmpty() || date.equalsIgnoreCase("Select Time")) {
            binding.tvTime.setError("Select time");
            return;
        }


            if (db.isCartTableEmpty()) {
            Toast.makeText(this, "Cart is empty!", Toast.LENGTH_SHORT).show();
            return;
        }


        postOrder();


//        finish();
    }


//    {
//        "items": [
//        {"service": 3, "quantity": 20},
//        {"service": 4, "quantity": 5}
//    ],
//        "remark": "Additional remarks or instructions from the client",
//            "visiting_date": "2026-04-24",
//            "visiting_time": "14:30",
//            "visiting_duration": 5,
//            "working_date": "2026-04-25",
//            "working_time": null,
//            "working_duration": 2,
//            "location": "Manually place this location",
//            "service_area": 1,
//            "upazila": 1,
//            "district": 1,
//            "division": 1,
//            "is_serviceable": true,
//            "urgency": "high"
//    }


    public String buildPostJson() {
        try {
            JSONObject obj = new JSONObject();
            JSONArray itemsArray = new JSONArray();

            // 🔹 Loop all cart items
            if (cartList != null && !cartList.isEmpty()) {

                for (CartModel item : cartList) {
                    JSONObject itemObj = new JSONObject();

                    itemObj.put("service", Integer.parseInt(item.getService_id()));
                    itemObj.put("quantity", Integer.parseInt(item.getQuantity()));

                    itemsArray.put(itemObj);
                }
            }

            // 🔹 Add items array
            obj.put("items", itemsArray);

            // 🔹 Other fields (dynamic from UI)
            obj.put("remark", binding.etAddress.getText().toString().trim());

            // 👉 convert date (dd/MM/yyyy → yyyy-MM-dd if needed)
            obj.put("visiting_date", formatDate(binding.tvDate.getText().toString()));
            obj.put("visiting_time", binding.tvTime.getText().toString());

            obj.put("visiting_duration", 5);   // you can make dynamic later
            obj.put("working_date", formatDate(binding.tvDate.getText().toString()));
            obj.put("working_time", JSONObject.NULL);
            obj.put("working_duration", 2);

            obj.put("location", binding.etAddress.getText().toString().trim());

            // 🔹 Static / API required values
            obj.put("service_area", 1);
            obj.put("upazila", 1);
            obj.put("district", 1);
            obj.put("division", 1);

            obj.put("is_serviceable", true);
            obj.put("urgency", "high");

            return obj.toString(2);

        } catch (Exception e) {
            Log.e("Checkout", "JSON build error: " + e.getMessage());
            return "{}";
        }
    }

    @SuppressLint("CheckResult")
    private void postOrder() {

        String postJson = buildPostJson();
        Log.d("tag444", "postJson: " + postJson);

//        AppUtils.showProgressDialog(this);


        String authorization = "Bearer" + " " +  SharedData.getTOKEN(this);
        Log.d("authorization", "authorization order: " + authorization);
        String accept = "application/json";
        String content_type = "application/json";

        Log.d("tag444", "authorization: " + authorization);

        RetrofitApiClient.getApiInterface()
                .post_order(authorization, postJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            AppUtils.hideProgressDialog();
                            Log.d("Response Code", "response: " + response);
                            Log.d("Response Code", "Response Code Order Post: " + response.code());

                            if (response.code() == 401) {
//                                AppUtils.goToLogin(this, false);
                                Intent intent = new Intent(CheckoutActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }

                            if (response.isSuccessful()) {

//                                Toast.makeText(this, "Order Posted successfully", Toast.LENGTH_LONG).show();

                                new MaterialDialog.Builder(this)
                                        .title("Order Status")
                                        .content("Order Posted successfully")
                                        .positiveText("")
                                        .negativeText("Ok")
                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                                db.clearCart();
                                                Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();

                                            }
                                        })
                                        .show();

                                db.clearCart();

                            } else {
                                AppUtils.showDialog(this, "Server Error", "Response code: " + response.code());
                            }

                        },
                        error -> {
                            AppUtils.hideProgressDialog();
//                            Log.e("tag_this", "Login error: " + error.g());
//                            AppUtils.showDialog(this, "Network Error", "Unable to connect post visit. Please check your internet connection.");
                        },
                        () -> Log.d("tag_this", "Login request completed")
                );


    }


    private String formatDate(String inputDate) {
        try {
            String[] parts = inputDate.split("/");

            String day = parts[0];
            String month = parts[1];
            String year = parts[2];

            if (month.length() == 1) month = "0" + month;
            if (day.length() == 1) day = "0" + day;

            return year + "-" + month + "-" + day;

        } catch (Exception e) {
            return inputDate; // fallback
        }
    }


}