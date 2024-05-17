package com.example.demoth2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoth2.dal.SQLiteHelper;
import com.example.demoth2.model.ItemDanhSach;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    public Spinner spTacgia;
    private EditText eTen,eDate,eGia, eGio;
    private RadioButton eHoc,eTracuu;
    private Button btAdd,btCancel;
    private RatingBar erate;
    private CheckBox eck1, eck2, eck3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btAdd.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        eDate.setOnClickListener(this);
        eGio.setOnClickListener(this);
    }

    private void initView() {
//        spAlbum=findViewById(R.id.spAlbum);
        spTacgia=findViewById(R.id.spTacgia);
        eTen=findViewById(R.id.tvName);
        eHoc=findViewById(R.id.nam);
        eTracuu=findViewById(R.id.nu);
        eDate=findViewById(R.id.tvDate);
        eGio=findViewById(R.id.tvGio);
        eGia=findViewById(R.id.tvGia);
        eck1=findViewById(R.id.ck1);
        eck2=findViewById(R.id.ck2);
        eck3=findViewById(R.id.ck3);
        erate=findViewById(R.id.rating);


//        thich=findViewById(R.id.gYes);
//        kthich=findViewById(R.id.gNo);
        btAdd=findViewById(R.id.btUpdate);
        btCancel=findViewById(R.id.btCancel);
        spTacgia.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.NXB)));
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
        if(v==eGio){
            Calendar c = Calendar.getInstance();
            int hh = c.get(Calendar.HOUR_OF_DAY);
            int mm = c.get(Calendar.MINUTE);
            TimePickerDialog timedialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    eGio.setText(h + ":" + m);
                }
            }, hh, mm, false);
            timedialog.show();
        }
        if(v==btCancel){
            finish();
        }
        if(v==btAdd){
            String n=eTen.getText().toString();
            String tg=spTacgia.getSelectedItem().toString();
            Boolean hoc=eHoc.isChecked();
            Boolean tracuu=eTracuu.isChecked();
            Boolean ck1 = eck1.isChecked();
            Boolean ck2 = eck2.isChecked();
            Boolean ck3 = eck3.isChecked();
            Integer rate = (int)erate.getRating();
//            String th="";
//            if(thich.isChecked())
//                th="Có";
//            else th="Không";
            String d=eDate.getText().toString();
            String h=eGio.getText().toString();
            int p=0;
            try {
                p=Integer.parseInt(eGia.getText().toString());
                if(n.isEmpty() || tg.isEmpty() || h.isEmpty() || d.isEmpty() || (ck1 == false && ck2 == false && ck3 == false)){
                    Toast.makeText(this, "Nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else {
                    ItemDanhSach i=new ItemDanhSach(n, tg, d, h, hoc,tracuu, ck1, ck2, ck3, rate, p);
                    SQLiteHelper db=new SQLiteHelper(this);
                    db.addItem(i);
                    finish();
                }
            }
            catch (Exception e){
                Toast.makeText(this, "Nhập số", Toast.LENGTH_SHORT).show();
            }

        }
    }
}