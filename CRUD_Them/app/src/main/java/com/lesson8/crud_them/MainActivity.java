package com.lesson8.crud_them;

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
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.lesson8.crud_them.model.Book;
import com.lesson8.crud_them.model.BookAdapter;
import com.lesson8.crud_them.model.BookItemListener;
import com.lesson8.crud_them.model.SpinnerApdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookItemListener, SearchView.OnQueryTextListener, View.OnClickListener {
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private EditText eTenSach, eNxb, eGioSinh;
    private RadioButton enam, enu;
    private Spinner sp;
    private String[] imgs = {"Viet Nam", "Lao", "Campuchia"};
    private Button btAdd, btUpdate;
    private int pcurr;
    private SearchView searchView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        eNxb.setOnClickListener(this);
        eGioSinh.setOnClickListener(this);
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
                String gioSinh=eGioSinh.getText().toString();
                Boolean nam = enam.isChecked();
                Boolean nu = enu.isChecked();
                String i = sp.getSelectedItem().toString();
                String img = imgs[Integer.parseInt(i)];
                if (tenSach.equals("") || nxb.equals("") ||(gioSinh.equals("")) || (nam == false && nu == false)) {
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    book.setTenSach(tenSach);
                    book.setNgayXuatBan(nxb);
                    book.setGioSinh(gioSinh);
                    if (nam == true) {
                        book.setLaNam(true);
                    } else {
                        book.setLaNam(false);
                    }
                    book.setQuocTich(img);
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
                String gioSinh=eGioSinh.getText().toString();
                Boolean nam = enam.isChecked();
                Boolean nu = enu.isChecked();
                String i = sp.getSelectedItem().toString();
                String img = imgs[Integer.parseInt(i)];
                if (tenSach.equals("") || nxb.equals("") ||(gioSinh.equals("")) || (nam == false && nu == false)) {
                    Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    book.setTenSach(tenSach);
                    book.setNgayXuatBan(nxb);
                    book.setGioSinh(gioSinh);
                    if (nam == true) {
                        book.setLaNam(true);
                    } else {
                        book.setLaNam(false);
                    }
                    book.setQuocTich(img);
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
        enam = findViewById(R.id.nam);
        enu = findViewById(R.id.nu);
        eNxb = findViewById(R.id.nxb);
        eGioSinh=findViewById(R.id.gioSinh);
        sp = findViewById(R.id.img);
        SpinnerApdapter adapter = new SpinnerApdapter(this);
        sp.setAdapter(adapter);
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
        eGioSinh.setText(book.getGioSinh());
        String img = book.getQuocTich();
        int p=0;
        for (int i = 0; i < imgs.length; i++) {
            if (img.equals(imgs[i])) {
                p =i;
                break;
            }
        }
        sp.setSelection(p);
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
        if(view==eGioSinh){
            Calendar c = Calendar.getInstance();
            int hh=c.get(Calendar.HOUR_OF_DAY);
            int mm=c.get(Calendar.MINUTE);
            TimePickerDialog timedialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    eGioSinh.setText(h+":"+m);
                }
            }, hh, mm, false);
            timedialog.show();
        }
        if(view==eNxb){
            Calendar c = Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                    eNxb.setText(yy+"/"+(mm+1)+"/"+dd);
                }
            }, y, m, d);
            dialog.show();
        }
    }
}