package com.example.kt2_tablayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kt2_tablayout.dal.SQLiteHelper;
import com.example.kt2_tablayout.model.ItemDanhSach;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    public Spinner spLoai;
    private EditText eTen,etacgia,eDate,eGia;
//    RadioButton thich,kthich;
    private Button btUpdate,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        eDate.setOnClickListener(this);
    }

    private void initView() {
//        spAlbum=findViewById(R.id.spAlbum);
        spLoai=findViewById(R.id.spLoai);
        eTen=findViewById(R.id.tvName);
        etacgia=findViewById(R.id.tvtacgia);
        eDate=findViewById(R.id.tvDate);
        eGia=findViewById(R.id.tvGia);

//        thich=findViewById(R.id.gYes);
//        kthich=findViewById(R.id.gNo);
        btUpdate=findViewById(R.id.btUpdate);
        btCancel=findViewById(R.id.btCancel);
        spLoai.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.NXB)));
//        spLoai.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.Loai)));
    }

    @Override
    public void onClick(View v) {
        if(v==eDate){
            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog =new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                    String date="";
                    if(month1>8){
                        date=dayOfMonth+"/"+(month1+1)+"/"+year1;
                    }
                    else {
                        date=dayOfMonth+"/0"+(month1+1)+"/"+year1;
                    }
                    eDate.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if(v==btCancel){
            finish();
        }
        if(v==btUpdate){
            String n=eTen.getText().toString();
            String tg=etacgia.getText().toString();
            String nxb= spLoai.getSelectedItem().toString();
            String th="";
//            if(thich.isChecked())
//                th="Có";
//            else th="Không";
            String d=eDate.getText().toString();
            int p=0;
            try {
                p=Integer.parseInt(eGia.getText().toString());
                if(!n.isEmpty()){
                    ItemDanhSach i=new ItemDanhSach(n,tg,d,nxb,p);
                    SQLiteHelper db=new SQLiteHelper(this);
                    db.addItem(i);
                    finish();
                }
                else {
                    Toast.makeText(this, "Hoan thien form", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(this, "Nhap dung du lieu", Toast.LENGTH_SHORT).show();
            }


        }
    }
}