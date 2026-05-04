package com.egsystem.unikosheba.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.cart.Service;
import com.egsystem.unikosheba.cart.ShoppingCartHelper;
import com.egsystem.unikosheba.data.database.DatabaseHelper;
import com.egsystem.unikosheba.model.Services;
import com.egsystem.unikosheba.ui.services.ItemDetailsActivity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder>{

    List<Services> list;
    Context context;

    private DatabaseHelper db;
    List<Service> cart;
    HashMap<Object, String> cartWithTitleName = new HashMap<Object, String>();




    public ServicesAdapter(Context context, List<Services> list){

        db = new DatabaseHelper(context);

        this.context=context;
        this.list=list;

        this.cart = ShoppingCartHelper.getCart();

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView txt;

        LinearLayout linear_main;

        public ViewHolder(View itemView){

            super(itemView);

            img=itemView.findViewById(R.id.imgService);
            txt=itemView.findViewById(R.id.txtService);
            linear_main=itemView.findViewById(R.id.linear_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v= LayoutInflater.from(context)
                .inflate(R.layout.item_service,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){

        holder.txt.setText(list.get(position).title);
//        holder.img.setImageResource(list.get(position).image);

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).image)
                .placeholder(R.drawable.placeholder_image) // while loading
                .error(R.drawable.error_image)       // if failed
                .into(holder.img);

        holder.linear_main.setOnClickListener(v ->{
            Intent productDetailsIntent = new Intent(context, ItemDetailsActivity.class);
            productDetailsIntent.putExtra("TITLE_NAME", list.get(position).title);
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
            productDetailsIntent.putExtra("item", list.get(position));
            context.startActivity(productDetailsIntent);
            ((AppCompatActivity) context).finish();
        });


    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
