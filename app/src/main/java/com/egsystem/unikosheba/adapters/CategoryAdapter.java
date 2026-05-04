package com.egsystem.unikosheba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> list;
    Context context;
    OnCategoryClick listener;

    public interface OnCategoryClick{
        void onClick(int position);
    }

    public CategoryAdapter(Context context, List<Category> list, OnCategoryClick listener){
        this.context=context;
        this.list=list;
        this.listener=listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt;
        ImageView img;

        public ViewHolder(View itemView){
            super(itemView);

            txt=itemView.findViewById(R.id.txtCategory);
            img=itemView.findViewById(R.id.imgCategory);

            itemView.setOnClickListener(v -> {
                listener.onClick(getAdapterPosition());
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v= LayoutInflater.from(context)
                .inflate(R.layout.item_category,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){

        holder.txt.setText(list.get(position).name);
//        holder.img.setImageResource(list.get(position).icon);

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).icon)
                .placeholder(R.drawable.placeholder_image) // while loading
                .error(R.drawable.error_image)       // if failed
                .into(holder.img);

    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
