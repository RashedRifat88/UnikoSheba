package com.egsystem.unikosheba.cart;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.data.database.DatabaseHelper;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    List<CartModel> list;
    Context context;
    OnCartChangeListener listener;
    DatabaseHelper db;
    boolean isCheckout = false;

    public interface OnCartChangeListener {
        void onCartChanged();
    }

    public CartAdapter(Context context, List<CartModel> list, OnCartChangeListener listener, boolean isCheckout) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        this.isCheckout = isCheckout;
        db = new DatabaseHelper(context);
    }

    public CartAdapter(Context context, List<CartModel> list, boolean isCheckout) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        this.isCheckout = isCheckout;
        db = new DatabaseHelper(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CartModel item = list.get(position);

        holder.name.setText(item.getService_name());
        holder.price.setText("৳ " + item.getPrice() + "/=");




        Glide.with(context)
                .load(item.getImg_link())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(holder.imgItem);

        // Remove Item (DB + UI)
        holder.remove.setOnClickListener(v -> {

            db.deleteCartModel(item);

            list.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, list.size());

            listener.onCartChanged(); // update total
        });


        int price = (int) Double.parseDouble(item.getPrice());
        final int[] qty = {(int) Double.parseDouble(item.getQuantity())};


        holder.price.setText("৳ " + (price * qty[0]) + "/=");


        if (isCheckout) {
            holder.btnPlus.setVisibility(View.GONE);
            holder.btnMinus.setVisibility(View.GONE);
            holder.remove.setVisibility(View.GONE);

            holder.txtQty.setText("Amount: " + String.valueOf(qty[0]));

        } else {
            holder.btnPlus.setVisibility(View.VISIBLE);
            holder.btnMinus.setVisibility(View.VISIBLE);
            holder.remove.setVisibility(View.VISIBLE);

            holder.txtQty.setText(String.valueOf(qty[0]));
        }



        holder.btnPlus.setOnClickListener(v -> {
            qty[0] = (int) Double.parseDouble(item.getQuantity());
            qty[0]++;

            item.setQuantity(String.valueOf(qty[0]));
            db.updateCartQuantity(item.getId(), qty[0]);

            notifyItemChanged(position);
            listener.onCartChanged();
        });

        holder.btnMinus.setOnClickListener(v -> {
            qty[0] = (int) Double.parseDouble(item.getQuantity());

            if (qty[0] > 1) {
                qty[0]--;

                item.setQuantity(String.valueOf(qty[0]));
                db.updateCartQuantity(item.getId(), qty[0]);

                notifyItemChanged(position);
                listener.onCartChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView remove, imgItem;
        TextView txtQty;
        ImageView btnPlus, btnMinus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            price = itemView.findViewById(R.id.txtPrice);
            remove = itemView.findViewById(R.id.btnRemove);
            imgItem = itemView.findViewById(R.id.imgItem);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnMinus = itemView.findViewById(R.id.btnMinus);
            txtQty = itemView.findViewById(R.id.txtQty);
        }
    }
}