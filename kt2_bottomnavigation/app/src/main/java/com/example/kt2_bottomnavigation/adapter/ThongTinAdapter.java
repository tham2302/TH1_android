package com.example.kt2_bottomnavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kt2_bottomnavigation.R;
import com.example.kt2_bottomnavigation.model.ItemThongTin;

import java.util.ArrayList;
import java.util.List;

public class ThongTinAdapter extends RecyclerView.Adapter<ThongTinAdapter.HomeViewHolder> {
    private List<ItemThongTin>list;
    private Context context;
    public ThongTinAdapter(Context context) {
        this.context=context;
        list = new ArrayList<>();
    }
//    private int[]imgs={R.drawable.img,R.drawable.img_1,R.drawable.img_2,
//            R.drawable.img_3, R.drawable.img_4};
    public void setList(List<ItemThongTin> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongtin,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ItemThongTin item=list.get(position);
        holder.ten.setText(item.getTen());
        holder.mota.setText(item.getNhanxet());
//        holder.itemdt_image.setImageResource(imgs[item.getImg()-1]);
        Glide.with(context)
                .load(item.getAnh())
                .into(holder.itemdt_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView ten,mota;
        private ImageView itemdt_image;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            ten=view.findViewById(R.id.item_ten);
            mota=view.findViewById(R.id.item_info);
            itemdt_image=view.findViewById(R.id.itemdt_image);
        }

    }
}
