package com.example.kt2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kt2.dal.SQLiteHelper;
import com.example.kt2.model.Ve;

import java.util.Calendar;

public class SuaXoaActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText name, ngay;
    private CheckBox thuoc, caphe, an, kygui;
    private SQLiteHelper db;
    private Button sua, xoa, save;

    private Ve ve;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_xoa);

        Intent intent = getIntent();
        ve = (Ve) intent.getSerializableExtra("ve");

        spinner = findViewById(R.id.spnoiKhoiHanh);
        name = findViewById(R.id.tvName);
        ngay = findViewById(R.id.tvNgayKhoiHanh);
        thuoc = findViewById(R.id.cbThuoc);
        an = findViewById(R.id.cbAn);
        caphe = findViewById(R.id.cbCaphe);
        kygui = findViewById(R.id.cbKyGui);
        save = findViewById(R.id.btAdd);
        sua = findViewById(R.id.btSua);
        xoa = findViewById(R.id.btXoa);

        name.setText(ve.getHoTen());
        ngay.setText(ve.getNgayKhoiHanh());
        thuoc.setChecked(ve.isThuoc());
        an.setChecked(ve.isAn());
        caphe.setChecked(ve.isCaphe());
        kygui.setChecked(ve.isKyGui());


        db =new SQLiteHelper(this);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tname = name.getText().toString();
                String tngay = ngay.getText().toString();
                String tnoi = spinner.getSelectedItem().toString();
                Ve ve_moi = new Ve(0, tname, tnoi, tngay, kygui.isChecked(), thuoc.isChecked(), an.isChecked(), caphe.isChecked());
                db.updateVe(ve.getId(), ve_moi);
                finish();

            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteVe(ve.getId());
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(SuaXoaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                        ngay.setText(yy+"/"+(mm+1)+"/" +dd);
                    }
                },y,m,d);
                dialog.show();
            }
        });

    }
}
