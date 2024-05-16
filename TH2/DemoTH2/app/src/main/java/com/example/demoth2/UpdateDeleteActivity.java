package com.example.demoth2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.demoth2.dal.SQLiteHelper;
import com.example.demoth2.model.ItemDanhSach;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner spTacgia;
    private EditText eTen,eDate,eGia, eGio;
    private RadioButton eHoc,eTracuu;
    private Button btAdd,btCancel;
    private RatingBar erate;
    private CheckBox eck1, eck2, eck3;
    private Button btUpdate,btDelete,btBack;
    private ItemDanhSach itemDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        initView();
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btBack.setOnClickListener(this);
        eDate.setOnClickListener(this);
        eGio.setOnClickListener(this);


        Intent intent=getIntent();
        itemDanhSach=(ItemDanhSach) intent.getSerializableExtra("itemDanhSach");

        eTen.setText(itemDanhSach.getTen());
        eDate.setText(itemDanhSach.getNxb());
        eGio.setText(itemDanhSach.getGio());
        eGia.setText(itemDanhSach.getGia()+"");
        eHoc.setChecked(itemDanhSach.isHoc());
        eTracuu.setChecked(itemDanhSach.isHoc() ? false: true);
        eck1.setChecked(itemDanhSach.isCNTT());
        eck2.setChecked(itemDanhSach.isVT());
        eck3.setChecked(itemDanhSach.isDT());
        int p=0;
        for (int i = 0; i < spTacgia.getCount(); i++) {
            if(spTacgia.getItemAtPosition(i).toString().equalsIgnoreCase(itemDanhSach.getTacgia())){
                p=i;
                break;
            }
        }
        spTacgia.setSelection(p);
//        p=0;
//        for (int i = 0; i < spLoai.getCount(); i++) {
//            if(spLoai.getItemAtPosition(i).toString().equalsIgnoreCase(itemDanhSach.getLoai())){
//                p=i;
//                break;
//            }
//        }
//        spLoai.setSelection(p);

//        String kt= itemDanhSach.getLike();
//        if(kt.equalsIgnoreCase("Có"))
//            thich.setChecked(true);
//        else
//            kthich.setChecked(true);
    }
    private void initView() {
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

        btUpdate=findViewById(R.id.btUpdate);
        btBack=findViewById(R.id.btBack);
        btDelete=findViewById(R.id.btDelete);
//        spAlbum.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.Album)));
        spTacgia.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.NXB)));        btBack=findViewById(R.id.btBack);
        btDelete=findViewById(R.id.btDelete);
    }

    @Override
    public void onClick(View v) {
        SQLiteHelper db=new SQLiteHelper(this);
        if(v==eDate){
            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog =new DatePickerDialog(UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if(v==btBack){
            finish();
        }
        if(v==btUpdate){
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
                if(n.isEmpty() || tg.isEmpty() || h.isEmpty() || d.isEmpty() && (ck1 == false && ck2 == false && ck3 == false)
                        || (hoc==false && tracuu==false)){

                    ItemDanhSach i=new ItemDanhSach(n, tg, d, h, hoc,tracuu, ck1, ck2, ck3, rate, p);
                    SQLiteHelper db1=new SQLiteHelper(this);
                    db1.addItem(i);
                    finish();
                }
                else {
                    Toast.makeText(this, "Nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Toast.makeText(this, "Nhập số", Toast.LENGTH_SHORT).show();
            }

        }
        if(v==btDelete){
            int id= itemDanhSach.getId();
            AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
            builder.setTitle("Thông báo xóa");
            builder.setMessage("Bạn có chắc chắn muốn xóa :'"+ itemDanhSach.getTen()+"'không ? ");
            builder.setIcon(R.drawable.delete_ic);
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SQLiteHelper bb= new SQLiteHelper(getApplicationContext());
                    bb.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
        }
    }
}