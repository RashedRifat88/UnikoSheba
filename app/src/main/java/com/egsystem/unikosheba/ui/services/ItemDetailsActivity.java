package com.egsystem.unikosheba.ui.services;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.MainActivity;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.cart.CartListActivity;
import com.egsystem.unikosheba.cart.CartModel;
import com.egsystem.unikosheba.cart.Service;
import com.egsystem.unikosheba.cart.ShoppingCartHelper;
import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.model.Services;

import java.util.List;

public class ItemDetailsActivity extends AppCompatActivity {


    String title;

    Services service;

    private DatabaseHelper db;
    List<Service> cart;
    TextView tv_cart_badge_count;
    ImageView img_back;
    FrameLayout frame_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_details);

        initComponents();

        db = new DatabaseHelper(this);


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


        title = getIntent().getStringExtra("TITLE_NAME");
        service = (Services) getIntent().getSerializableExtra("item");

//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//        ab.setTitle("Details");

//        List<Service> catalog = ShoppingCartHelper.getCatalog(getResources());

//        Log.d("tag444", "cart: "+cart);
//
//        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
//        final Service selectedProduct = catalog.get(productIndex);
//        Log.d("tag444", "selectedProduct: "+selectedProduct);
//
//        // Set the proper image and text
//        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
//        productImageView.setImageDrawable(selectedProduct.productImage);
//        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
//        productTitleTextView.setText(selectedProduct.title);
//        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
//        productDetailsTextView.setText(selectedProduct.description);
//

        // Set the proper image and text
//        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
//        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.txtTitle);
        productTitleTextView.setText(service.title);
        TextView productDetailsTextView = (TextView) findViewById(R.id.txtProductDetails);
        productDetailsTextView.setText(service.description);

        ImageView ivProduct = findViewById(R.id.ivProduct);


        Glide.with(this)
                .load(service.image)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(ivProduct);


        Button addToCartButton = (Button) findViewById(R.id.btnAddToCart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


//                cart.add(selectedProduct);
//                int cartItemNumber = cart.size();

//                addItemToCart("Appliance Repair",
//                        "Oven Services",
//                        "102",
//                        "250",
//                        "0",
//                        "1",
//                        "icons/oven.png");

                addItemToCart("",
                        "",
                        service.getId().toString(),
                        service.getTitle(),
                        String.valueOf(service.price),
                        "",
                        "1",
                        service.getImage());


//                int cartItemNumber = db.getCartModelsCount();

//                ServicesActivity.getCartItemsNumber(cartItemNumber);

//                Intent intent = new Intent(ItemDetailsActivity.this, ServicesActivity.class);
//                intent.putExtra("FRAGMENT_NAME", title);
//                startActivity(intent);
//                Log.d("tag55555", "title: "+title);
//
//                finish();

            }
        });

        // Disable the add to cart button if the item is already in the cart
//        if(cart.contains(selectedProduct)) {
//            addToCartButton.setEnabled(false);
//            addToCartButton.setText("Item already added");
//        }


//        MenuItem item = menu.findItem(R.id.action_cart);
//        View actionView = item.getActionView();

        frame_cart = findViewById(R.id.frame_cart);
        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);

        updateCartBadge();

        frame_cart.setOnClickListener(v -> {
            Intent intent = new Intent(ItemDetailsActivity.this, CartListActivity.class);
            startActivity(intent);
        });


        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(view -> {
            finish();
        });

    }

    private void initComponents() {
        img_back = findViewById(R.id.img_back);
    }


    private void addItemToCart(String category_name,
                               String sub_category_name,
                               String service_id,
                               String service_name,
                               String price,
                               String discount,
                               String quantity,
                               String img_link) {

        long id;

        if (!db.isCartTableEmpty()) {

            if (!db.isItemExists(service_id)) {

                id = db.insertCartModel(
                        category_name,
                        sub_category_name,
                        service_id,
                        service_name,
                        price,
                        discount,
                        quantity,
                        img_link
                );

                if (id != -1) {
                    Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
                    updateCartBadge();
                } else {
                    Toast.makeText(this, "Failed!" + id, Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Already added", Toast.LENGTH_SHORT).show();
            }

        } else {
            id = db.insertCartModel(
                    category_name,
                    sub_category_name,
                    service_id,
                    service_name,
                    price,
                    discount,
                    quantity,
                    img_link
            );

            if (id != -1) {
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
                updateCartBadge();
            } else {
                Toast.makeText(this, "Failed!" + id, Toast.LENGTH_SHORT).show();
            }
        }


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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    onBackPressed();
                }
//                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}