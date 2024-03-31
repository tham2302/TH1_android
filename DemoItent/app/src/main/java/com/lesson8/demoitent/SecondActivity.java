package com.lesson8.demoitent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private Button bt;
    private TextView tvName, tvSub, tvStu, tvList;

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt=findViewById(R.id.bt);
        tvName=findViewById(R.id.tvName);
        tvSub=findViewById(R.id.tvSub);
        tvStu=findViewById(R.id.tvStu);
        tvList=findViewById(R.id.tvList);
        img=findViewById(R.id.img);
        Intent t= getIntent();
        String name=t.getStringExtra("name");
        int age=t.getIntExtra("age", 20);
        tvName.setText(name+","+age);
        String []sub=t.getStringArrayExtra("subject");
        tvSub.setText(Arrays.toString(sub));
        Student s=(Student) t.getSerializableExtra("Sinh vien");
        img.setImageResource(s.getImg());
        tvStu.setText(s.getName()+", "+s.getAge());
        List<Student> list=(List<Student>) t.getSerializableExtra("data");
        String tt="";
        for(Student i:list){
            tt+=i.getName()+", "+i.getAge()+"\n";
        }
        tvList.setText(tt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}