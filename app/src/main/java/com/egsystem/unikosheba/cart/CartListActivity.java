package com.egsystem.unikosheba.cart;

import android.content.Intent;
import android.os.Bundle;

import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.ui.checkout.CheckoutActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egsystem.unikosheba.databinding.ActivityCartListBinding;

import com.egsystem.unikosheba.R;

import java.util.ArrayList;
import java.util.List;



public class CartListActivity extends AppCompatActivity implements CartAdapter.OnCartChangeListener {

    RecyclerView recyclerView;
    TextView tvTotal;
    Button btnCheckout;
    ImageView img_back;

    List<CartModel> cartList;
    CartAdapter adapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        initComponents();
        loadCartData();
    }

    private void initComponents() {
        btnCheckout = findViewById(R.id.btnCheckout);
        img_back = findViewById(R.id.img_back);
        recyclerView = findViewById(R.id.rvCart);
        tvTotal = findViewById(R.id.tvTotal);

        db = new DatabaseHelper(this);
        db.getWritableDatabase();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        img_back.setOnClickListener(view -> {
            finish();
        });

        btnCheckout.setOnClickListener(view -> {
            Intent intent = new Intent(CartListActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });

    }

    private void loadCartData() {
        cartList = db.getAllCartModels();

        adapter = new CartAdapter(this, cartList, this, false);
        recyclerView.setAdapter(adapter);

        calculateTotal();
    }

    @Override
    public void onCartChanged() {
        loadCartData(); // reload after remove
    }

//    private void calculateTotal() {
//        int total = 0;
//
//        for (CartModel item : cartList) {
//            try {
//                total += Integer.parseInt(item.getPrice());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        tvTotal.setText("Total: ৳" + total);
//    }


    private void calculateTotal() {
        int total = 0;

        Log.d("tag444", "calculateTotal os hit");
        Log.d("tag444", "cartList: "+cartList);

        for (CartModel item : cartList) {

            Log.d("tag444", "cartList2: "+cartList);
            try {
                Log.d("tag444", "cartList3: "+cartList);
                Log.d("tag444", "item.getPrice(): "+item.getPrice());
                int price = (int) Double.parseDouble(item.getPrice());
                int qty = (int) Double.parseDouble(item.getQuantity());

                Log.d("tag444", "price: "+price);

                total += price * qty;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tvTotal.setText("Total: ৳ " + total +  " /=");
    }



}