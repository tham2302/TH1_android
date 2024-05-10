package com.example.kt2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2.R;
import com.example.kt2.SuaXoaActivity;
import com.example.kt2.adapter.DanhSach_TimKiem_Adapter;
import com.example.kt2.dal.SQLiteHelper;
import com.example.kt2.model.Ve;

import java.util.List;

public class FragmentDanhSach extends Fragment implements DanhSach_TimKiem_Adapter.ItemListener {
    private DanhSach_TimKiem_Adapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_danhsach,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycleView);
        adapter=new DanhSach_TimKiem_Adapter();

        db=new SQLiteHelper(getContext());
        List<Ve>list=db.getAllVe();

        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Ve ve =adapter.getItem(position);
        Intent intent=new Intent(getActivity(), SuaXoaActivity.class);
        intent.putExtra("ve", ve);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Ve>list=db.getAllVe();
        adapter.setList(list);
    }
}
