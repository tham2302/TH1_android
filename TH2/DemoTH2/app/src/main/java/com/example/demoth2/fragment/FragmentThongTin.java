package com.example.demoth2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoth2.R;
import com.example.demoth2.adapter.ThongTinAdapter;
import com.example.demoth2.dal.SQLiteHelper;
import com.example.demoth2.model.ItemThongTin;
import com.example.demoth2.R;
import com.example.demoth2.adapter.ThongTinAdapter;
import com.example.demoth2.dal.SQLiteHelper;
import com.example.demoth2.model.ItemThongTin;

import java.util.List;

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
