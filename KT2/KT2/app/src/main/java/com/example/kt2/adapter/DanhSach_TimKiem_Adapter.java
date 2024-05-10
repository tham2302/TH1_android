package com.example.kt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2.R;
import com.example.kt2.model.Ve;

import java.util.ArrayList;
import java.util.List;

public class DanhSach_TimKiem_Adapter extends RecyclerView.Adapter<DanhSach_TimKiem_Adapter.HomeViewHolder> {
    private List<Ve> list;
    private ItemListener itemListener;
    public DanhSach_TimKiem_Adapter() {
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<Ve> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Ve getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsach,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Ve ve =list.get(position);
        holder.ten.setText(ve.getHoTen());
        holder.noi.setText(ve.getNoiKhoiHanh());
        holder.ngay.setText(ve.getNgayKhoiHanh());
        holder.thuoc.setChecked(ve.isThuoc());
        holder.an.setChecked(ve.isAn());
        holder.caphe.setChecked(ve.isCaphe());
        holder.kygui.setChecked(ve.isKyGui());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView ten, noi, ngay;
        private CheckBox thuoc, an, caphe, kygui;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            ten=view.findViewById(R.id.tvName);
            noi = view.findViewById(R.id.tvKhoiHanh);
            ngay = view.findViewById(R.id.tvNgayKhoiHanh);
            thuoc = view.findViewById(R.id.cbThuoc);
            an = view.findViewById(R.id.cbAn);
            caphe = view.findViewById(R.id.cbCaphe);
            kygui = view.findViewById(R.id.cbKyGui);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemListener!=null){
                itemListener.onItemClick(v,getAdapterPosition());
            }
        }
    }
    public interface ItemListener{
        void onItemClick(View view,int position);
    }
}
