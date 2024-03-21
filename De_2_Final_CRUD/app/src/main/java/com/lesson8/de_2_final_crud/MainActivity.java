package com.lesson8.de_2_final_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.lesson8.de_2_final_crud.model.Book;
import com.lesson8.de_2_final_crud.model.BookAdapter;
import com.lesson8.de_2_final_crud.model.BookItemListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookItemListener, SearchView.OnQueryTextListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private EditText eTenSach, eNxb;
    private RadioButton enam, enu;
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
                String nxb = eNxb.getText().toString();
                Boolean nam=enam.isChecked();
                Boolean nu=enu.isChecked();
                Boolean ck1 = eck1.isChecked();
                Boolean ck2 = eck2.isChecked();
                Boolean ck3 = eck3.isChecked();
                if (tenSach.equals("")  || nxb.equals("") || (ck1 == false && ck2 == false && ck3 == false) || (nam==false && nu==false)) {
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    book.setTenSach(tenSach);
                    book.setNgayXuatBan(nxb);
                    book.setKhoaHoc(ck1);
                    book.setTieuThuyet(ck2);
                    book.setThieuNhi(ck3);
                    if(nam==true){
                        book.setLaNam(true);
                    }
                    else{
                        book.setLaNam(false);
                    }
                    adapter.add(book);
                }

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String tenSach = eTenSach.getText().toString();
                String nxb = eNxb.getText().toString();
                Boolean nam=enam.isChecked();
                Boolean nu=enu.isChecked();
                Boolean ck1 = eck1.isChecked();
                Boolean ck2 = eck2.isChecked();
                Boolean ck3 = eck3.isChecked();
                if (tenSach.equals("")  || nxb.equals("") || (ck1 == false && ck2 == false && ck3 == false) || (nam==false && nu==false)) {
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    book.setTenSach(tenSach);
                    book.setNgayXuatBan(nxb);
                    book.setKhoaHoc(ck1);
                    book.setTieuThuyet(ck2);
                    book.setThieuNhi(ck3);
                    if(nam==true){
                        book.setLaNam(true);
                    }
                    else{
                        book.setLaNam(false);
                    }
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
        enam=findViewById(R.id.nam);
        enu=findViewById(R.id.nu);
        eNxb = findViewById(R.id.nxb);
        eck1 = findViewById(R.id.ck1);
        eck2 = findViewById(R.id.ck2);
        eck3 = findViewById(R.id.ck3);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.searchView);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        pcurr = position;
        Book book = adapter.getItem(position);
        String tenSach = book.getTenSach();
        eTenSach.setText(book.getTenSach());
        enam.setChecked(book.isLaNam());
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

    public void filter(String s) {
        List<Book> filterList = new ArrayList<>();
        for (Book i : adapter.getBackup()) {
            if (i.getTenSach().toLowerCase().contains(s.toLowerCase())) {
                filterList.add(i);
            }
        }
        if (filterList.isEmpty()) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filterList);
        }
    }

    @Override
    public void onClick(View view) {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                eNxb.setText(yy + "/" + (mm + 1) + "/" + dd);
            }
        }, y, m, d);
        dialog.show();
    }
}