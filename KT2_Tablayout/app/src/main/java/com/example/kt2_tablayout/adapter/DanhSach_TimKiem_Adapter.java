package com.example.kt2_tablayout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2_tablayout.R;
import com.example.kt2_tablayout.model.ItemDanhSach;

import java.util.ArrayList;
import java.util.List;

public class DanhSach_TimKiem_Adapter extends RecyclerView.Adapter<DanhSach_TimKiem_Adapter.HomeViewHolder> {
    private List<ItemDanhSach>list;
    private ItemListener itemListener;
    public DanhSach_TimKiem_Adapter() {
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<ItemDanhSach> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public ItemDanhSach getItem(int position){
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
        ItemDanhSach itemDanhSach =list.get(position);
        holder.ten.setText(itemDanhSach.getTen());
        holder.tacgia.setText(itemDanhSach.getTacgia());
        holder.ngayxb.setText(itemDanhSach.getNgay());
        holder.nhaxb.setText(itemDanhSach.getNhaxuatban());
        holder.gia.setText(itemDanhSach.getGia()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView ten,tacgia,ngayxb,nhaxb,gia;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            ten=view.findViewById(R.id.tvName);
            tacgia=view.findViewById(R.id.tvtacgia);
            ngayxb=view.findViewById(R.id.tvDate);
            nhaxb=view.findViewById(R.id.tvnhaxuatban);
            gia=view.findViewById(R.id.tvGia);


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
