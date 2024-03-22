package com.lesson8.de1_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.lesson8.de1_crud.model.Book;
import com.lesson8.de1_crud.model.BookAdapter;
import com.lesson8.de1_crud.model.BookItemListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookItemListener, SearchView.OnQueryTextListener, View.OnClickListener{

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private EditText eTenSach, eTacGia, eNxb;
    private CheckBox eck1, eck2, eck3;
    private Button btAdd, btUpdate;
    private int pcurr;
    private SearchView searchView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        eNxb.setOnClickListener(this);
        adapter = new BookAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String tenSach = eTenSach.getText().toString();
                String tacGia = eTacGia.getText().toString();
                String nxb = eNxb.getText().toString();
                Boolean ck1 = eck1.isChecked();
                Boolean ck2 = eck2.isChecked();
                Boolean ck3 = eck3.isChecked();
                if(tenSach.equals("") || tacGia.equals("") || nxb.equals("")|| (ck1==false && ck2==false && ck3==false)){
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    book.setTenSach(tenSach);
                    book.setTacGia(tacGia);
                    book.setNgayXuatBan(nxb);
                    book.setKhoaHoc(ck1);
                    book.setTieuThuyet(ck2);
                    book.setThieuNhi(ck3);
                    adapter.add(book);
                }

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String tenSach = eTenSach.getText().toString();
                String tacGia = eTacGia.getText().toString();
                String nxb = eNxb.getText().toString();
                Boolean ck1 = eck1.isChecked();
                Boolean ck2 = eck2.isChecked();
                Boolean ck3 = eck3.isChecked();
                if(tenSach.equals("") || tacGia.equals("") || nxb.equals("")|| (ck1==false && ck2==false && ck3==false)){
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    book.setTenSach(tenSach);
                    book.setTacGia(tacGia);
                    book.setNgayXuatBan(nxb);
                    book.setKhoaHoc(ck1);
                    book.setTieuThuyet(ck2);
                    book.setThieuNhi(ck3);
                    adapter.update(pcurr, book);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        eTenSach = findViewById(R.id.tenSach);
        eTacGia = findViewById(R.id.tacGia);
        eNxb=findViewById(R.id.nxb);
        eck1=findViewById(R.id.ck1);
        eck2=findViewById(R.id.ck2);
        eck3=findViewById(R.id.ck3);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView=findViewById(R.id.searchView);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        pcurr = position;
        Book book = adapter.getItem(position);
        String tenSach = book.getTenSach();
        eTenSach.setText(book.getTenSach());
        eTacGia.setText(book.getTacGia());
        eNxb.setText(book.getNgayXuatBan());
        eck1.setChecked(book.isKhoaHoc());
        eck2.setChecked(book.isTieuThuyet());
        eck3.setChecked(book.isThieuNhi());
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }
    public void filter(String s){
        List<Book> filterList=new ArrayList<>();
        int kt=0;
        for(Book i:adapter.getBackup()){
            if((s.equalsIgnoreCase("Phe phan") && i.isKhoaHoc())
                    || (s.equalsIgnoreCase("Su that") && i.isTieuThuyet()) ||
                    (s.equalsIgnoreCase("Cham biem") && i.isThieuNhi()))
                filterList.add(i);
        }

        if(filterList.isEmpty()){
            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.filterList(filterList);
        }
    }

    @Override
    public void onClick(View view) {
        Calendar c = Calendar.getInstance();
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        TimePickerDialog timedialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                eNxb.setText(h + ":" + m);
            }
        }, hh, mm, false);
        timedialog.show();
    }
}