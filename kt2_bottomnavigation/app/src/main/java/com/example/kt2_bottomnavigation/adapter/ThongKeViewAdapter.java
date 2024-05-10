package com.example.kt2_bottomnavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2_bottomnavigation.R;
import com.example.kt2_bottomnavigation.model.ItemThongKe;

import java.util.ArrayList;
import java.util.List;

public class ThongKeViewAdapter extends RecyclerView.Adapter<ThongKeViewAdapter.HomeViewHolder> {
    private List<ItemThongKe>list;
    public ThongKeViewAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<ItemThongKe> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongke,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        ItemThongKe item=list.get(position);
        holder.ten.setText(item.getName());
        holder.sl.setText(item.getSl()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView ten,sl;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            ten=view.findViewById(R.id.tvName);
            sl=view.findViewById(R.id.tvSoluong);
        }

    }
}
