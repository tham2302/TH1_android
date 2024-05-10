package com.example.kt2_tablayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner spLoai;
    private EditText eTen,etacgia,eDate,eGia;
//    RadioButton thich,kthich;
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


        Intent intent=getIntent();
        itemDanhSach=(ItemDanhSach) intent.getSerializableExtra("itemDanhSach");

        eTen.setText(itemDanhSach.getTen());
        etacgia.setText(itemDanhSach.getTacgia());
        eDate.setText(itemDanhSach.getNgay());
        eGia.setText(itemDanhSach.getGia()+"");

        int p=0;
        for (int i = 0; i < spLoai.getCount(); i++) {
            if(spLoai.getItemAtPosition(i).toString().equalsIgnoreCase(itemDanhSach.getNhaxuatban())){
                p=i;
                break;
            }
        }
        spLoai.setSelection(p);
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
//        spAlbum=findViewById(R.id.spAlbum);
        spLoai=findViewById(R.id.spLoai);
        eTen=findViewById(R.id.tvName);
        etacgia=findViewById(R.id.tvtacgia);
        eDate=findViewById(R.id.tvDate);
        eGia=findViewById(R.id.tvGia);
//        kthich=findViewById(R.id.gNo);
        btUpdate=findViewById(R.id.btUpdate);
//        spAlbum.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.Album)));
        spLoai.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner,getResources().getStringArray(R.array.NXB)));
        btBack=findViewById(R.id.btBack);
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
        if(v==btBack){
            finish();
        }
        if(v==btUpdate){
            String ten=eTen.getText().toString();
            String tg=etacgia.getText().toString();
            String loai=spLoai.getSelectedItem().toString();
            String ngay=eDate.getText().toString();
            int p=0;
            try {
                p=Integer.parseInt(eGia.getText().toString());
                if(!ten.isEmpty()){
                    ItemDanhSach i=new ItemDanhSach(itemDanhSach.getId(),ten,tg,ngay,loai,p);
                    db.update(i);
                    finish();
                }
                else {
                    Toast.makeText(this, "Hoan Thien form", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(this, "Nhap dung du lieu", Toast.LENGTH_SHORT).show();
            }


//            String th="";
//            if(thich.isChecked())
//                th="Có";
//            else th="Không";


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