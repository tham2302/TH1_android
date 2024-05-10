package com.example.kt2_bottomnavigation.fragment;
import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2_bottomnavigation.R;
import com.example.kt2_bottomnavigation.adapter.ThongTinAdapter;
import com.example.kt2_bottomnavigation.dal.SQLiteHelper;
import com.example.kt2_bottomnavigation.model.ItemDanhSach;
import com.example.kt2_bottomnavigation.model.ItemThongTin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentThongTin extends Fragment{
    private RecyclerView recyclerView;
    ThongTinAdapter adapter;

    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thongtin,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView =view.findViewById(R.id.recycleView);
        adapter=new ThongTinAdapter(getContext());
        db=new SQLiteHelper(getContext());
        List<ItemThongTin>list=db.getAllThongTin();


        adapter.setList(list);


        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
