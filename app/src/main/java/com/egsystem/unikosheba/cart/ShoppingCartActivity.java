//package com.egsystem.unikosheba.cart;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//import com.egsystem.unikosheba.R;
////import com.baoyachi.stepview.HorizontalStepView;
////import com.baoyachi.stepview.bean.StepBean;
////import com.swotsystemltd.uniko.R;
////import com.swotsystemltd.uniko.SecondStep.SubItemAdapter;
////import com.swotsystemltd.uniko.SecondStep.SubItemsActivity;
////import com.swotsystemltd.uniko.ThirdStep.DateTimeAddressActivity2;
////import com.swotsystemltd.uniko.model.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShoppingCartActivity extends AppCompatActivity {
//
//    String title;
//    String category_id;
//    private List<Service> mCartList;
//    private SubItemAdapter mSubItemAdapter;
//    int cartItemNumber;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.shoppingcart);
//
//        title = getIntent().getStringExtra("TITLE_NAME");
//        category_id = getIntent().getStringExtra("CATEGORY_ID");
//
//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//        ab.setTitle("Service Cart");
//
//
//        mCartList = ShoppingCartHelper.getCart();
//        Log.d("tag444", "mCartList: "+mCartList);
//        cartItemNumber = mCartList.size();
//
//        // Make sure to clear the selections
//        for(int i=0; i<mCartList.size(); i++) {
//            mCartList.get(i).selected = false;
//        }
//
//        // Create the list
//        final RecyclerView listViewCatalog = (RecyclerView) findViewById(R.id.RecyclerViewViewCatalog);
//
//        listViewCatalog.setLayoutManager(new LinearLayoutManager(this));
//        listViewCatalog.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//
//        mSubItemAdapter = new SubItemAdapter(mCartList, getLayoutInflater(), true, ShoppingCartActivity.this, new CustomItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Log.d("tag444", "clicked position:" + position);
////                long postId = data.get(position).getID();
//
//                Service selectedProduct = mCartList.get(position);
//                if(selectedProduct.selected == true){
//                    selectedProduct.selected = false;
//                }
//                else {
//                    selectedProduct.selected = true;
//                }
//                mSubItemAdapter.notifyDataSetChanged();
//
//            }
//        });
////        mSubItemAdapter = new SubItemAdapter(mCartList, getLayoutInflater(), true, ShoppingCartActivity.this);
//        listViewCatalog.setAdapter(mSubItemAdapter);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
//        listViewCatalog.setLayoutManager(mLayoutManager);
//
////        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {
////
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position,
////                                    long id) {
////                Product selectedProduct = mCartList.get(position);
////
////                if(selectedProduct.selected == true){
////                    selectedProduct.selected = false;
////                }
////                else {
////                    selectedProduct.selected = true;
////                }
//////                mSubItemAdapter.notifyDataSetInvalidated();
////                mSubItemAdapter.notifyDataSetChanged();
////            }
////        });
//
//
//
//        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
//        removeButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Loop through and remove all the products that are selected
//                // Loop backwards so that the remove works correctly
//                for(int i = mCartList.size()-1; i>=0; i--) {
//
//                    if(mCartList.get(i).selected) {
//                        mCartList.remove(i);
////                        updateCartList();
//
//                        new SubItemAdapter(mCartList, getLayoutInflater(), false, ShoppingCartActivity.this, new CustomItemClickListener() {
//                            @Override
//                            public void onItemClick(View v, int position) {
//                                Log.d("tag444", "clicked position:" + position);
//
//                            }
//                        });
//
//                    }
//                }
//                mSubItemAdapter.notifyDataSetChanged();
//            }
//        });
//
//
//
//        Button nextButton = (Button) findViewById(R.id.btn_next);
//        nextButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                gotoOrderSubmitActivity();
////                Intent intent = new Intent(ShoppingCartActivity.this, DateTimeAddressActivity2.class);
////                startActivity(intent);
//            }
//        });
//
//
//        getStepView();
//    }
//
//
//    private void gotoOrderSubmitActivity() {
//
//        cartItemNumber = mCartList.size();
//
//        if (cartItemNumber < 1){
//            new MaterialDialog.Builder(ShoppingCartActivity.this)
//                    .title("Status")
//                    .content("You should select at least one service for going the next step!" )
//                    .positiveText("")
//                    .negativeText("Ok")
//                    .onPositive(new MaterialDialog.SingleButtonCallback() {
//                        @Override
//                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                        }
//                    })
//                    .show();
//        }
//        else {
//            Intent intent = new Intent(this, DateTimeAddressActivity2.class);
//            intent.putExtra("TITLE_NAME", title);
//            startActivity(intent);
////            finish();
//        }
//
//
//    }
//
//
//    private void getStepView() {
//        HorizontalStepView setpview = (HorizontalStepView) findViewById(R.id.step_view);
//        List<StepBean> stepsBeanList = new ArrayList<>();
//        StepBean stepBean0 = new StepBean("Add",1);
//        StepBean stepBean1 = new StepBean("Cart",0);
//        StepBean stepBean2 = new StepBean("Submit",-1);
////        StepBean stepBean3 = new StepBean("送单",0);
////        StepBean stepBean4 = new StepBean("完成",-1);
//        stepsBeanList.add(stepBean0);
//        stepsBeanList.add(stepBean1);
//        stepsBeanList.add(stepBean2);
//
//
//        setpview
//                .setStepViewTexts(stepsBeanList)
//                .setTextSize(10)//set textSize
//                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))
//                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))
//                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))
//                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))
//                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))
//                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))
//                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));
//    }
//
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//
//            case android.R.id.home:
//                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//                    getSupportFragmentManager().popBackStack();
//
//                    SubItemsActivity.getCartItemsNumber(cartItemNumber);
//
//                    Intent intent = new Intent(ShoppingCartActivity.this, SubItemsActivity.class);
//                    intent.putExtra("FRAGMENT_NAME", title);
//                    intent.putExtra("CATEGORY_ID", category_id);
//                    startActivity(intent);
//
//                } else {
//                    onBackPressed();
//                }
////                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        SubItemsActivity.getCartItemsNumber(cartItemNumber);
//
//        Intent intent = new Intent(ShoppingCartActivity.this, SubItemsActivity.class);
//        intent.putExtra("FRAGMENT_NAME", title);
//        intent.putExtra("CATEGORY_ID", category_id);
//        startActivity(intent);
//
//
//
//    }
//}
