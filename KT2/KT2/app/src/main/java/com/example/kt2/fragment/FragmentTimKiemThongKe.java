package com.example.kt2.fragment;

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

import com.example.kt2.R;
import com.example.kt2.adapter.DanhSach_TimKiem_Adapter;
import com.example.kt2.dal.SQLiteHelper;
import com.example.kt2.model.Ve;
import com.example.kt2.model.ItemThongKe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FragmentTimKiemThongKe extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private SearchView searchView;
    private DanhSach_TimKiem_Adapter adapter;

    private SQLiteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timkiemthongke,container,false);
    }

    @Override
    public void onClick(View v) {

    }
}
