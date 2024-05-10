package com.example.kt2_tablayout.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kt2_tablayout.R;
import com.example.kt2_tablayout.adapter.DanhSach_TimKiem_Adapter;
import com.example.kt2_tablayout.adapter.ThongKeViewAdapter;
import com.example.kt2_tablayout.dal.SQLiteHelper;
import com.example.kt2_tablayout.model.ItemDanhSach;
import com.example.kt2_tablayout.model.ItemThongKe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FragmentTimKiemThongKe extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private Button btSearch,btTK;
    private SearchView searchView;
    private EditText eFrom,eTo;
    private Spinner spCategory;
    private DanhSach_TimKiem_Adapter adapter;

    private ThongKeViewAdapter tkAdapter;
    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timkiemthongke,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter=new DanhSach_TimKiem_Adapter();
        tkAdapter=new ThongKeViewAdapter();
        db=new SQLiteHelper(getContext());
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        List<ItemDanhSach>list=db.getAll();
        adapter.setList(list);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<ItemDanhSach>list=db.searchByName(newText);
                adapter.setList(list);
                recyclerView.setAdapter(adapter);
                return true;
            }
        });
        eFrom.setOnClickListener(this);
        eTo.setOnClickListener(this);
        btSearch.setOnClickListener(this);
        btTK.setOnClickListener(this);
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cate=spCategory.getItemAtPosition(position).toString();
                List<ItemDanhSach>list;
                if(!cate.equalsIgnoreCase("All")){
                    list=db.searchByLoai(cate);
                }
                else {
                    list=db.getAll();
                }
                adapter.setList(list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void initView(View view) {
        recyclerView=view.findViewById(R.id.recycleView);
        btSearch=view.findViewById(R.id.btSearch);
        btTK=view.findViewById(R.id.btTK);
        searchView=view.findViewById(R.id.search);
        eFrom=view.findViewById(R.id.eFrom);
        eTo=view.findViewById(R.id.eTo);
        spCategory=view.findViewById(R.id.spCategory);
        String[]arr=getResources().getStringArray(R.array.NXB);
        String[]arr1=new String[arr.length+1];
        arr1[0]="All";
        for (int i = 0; i < arr.length; i++) {
            arr1[i+1]=arr[i];

        }
        spCategory.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.item_spinner,arr1));
    }

    @Override
    public void onClick(View v) {
        if(v==btTK){
            List<ItemThongKe>tl=new ArrayList<>();
            String[]THE_Loai=getResources().getStringArray(R.array.NXB);
            for (String x:THE_Loai){
                List<ItemDanhSach>tmp_i=db.searchByLoai(x);
                tl.add(new ItemThongKe(x,tmp_i.size()));
            }
            Collections.sort(tl, new Comparator<ItemThongKe>() {
                @Override
                public int compare(ItemThongKe item1, ItemThongKe item2) {
                    // So sánh theo thuộc tính 'sl', giảm dần
                    return Integer.compare(item2.getSl(), item1.getSl());
                }
            });
            tkAdapter.setList(tl);
            recyclerView.setAdapter(tkAdapter);
        }

        if(v==eFrom){
                final Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                        String date="";
                        if(month1>8){
                            date=dayOfMonth+"/"+(month1+1)+"/"+year1;
                        }
                        else {
                            date=dayOfMonth+"/0"+(month1+1)+"/"+year1;
                        }
                        eFrom.setText(date);
                    }
                },year,month,day);
                dialog.show();
        }
        if(v==eTo){
            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                    String date="";
                    if(month1>8){
                        date=dayOfMonth+"/"+(month1+1)+"/"+year1;
                    }
                    else {
                        date=dayOfMonth+"/0"+(month1+1)+"/"+year1;
                    }
                    eTo.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if(v==btSearch){
            String from=eFrom.getText().toString();
            String to=eTo.getText().toString();
            if(!from.isEmpty()&&!to.isEmpty()){
                List<ItemDanhSach>list=db.searchByDate(from,to);
                adapter.setList(list);
                recyclerView.setAdapter(adapter);
            }
        }
    }
}
