package com.lesson8.demoitent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t= new Intent(MainActivity.this, SecondActivity.class);
                String name="Tham";
                t.putExtra("name", name);
                int age= 22;
                t.putExtra("age", age);
                String []subject = {"LTHDT", "LTW", "LTTBDD"};
                t.putExtra("subject", subject);
                Student sv=new Student(R.drawable.icon_student, "Phan Thi", 22);
                t.putExtra("Sinh vien", sv);
                List<Student> list=new ArrayList<>();
                list.add(sv);
                list.add(new Student(R.drawable.icon_student, "Tran Tham", 22));
                list.add(new Student(R.drawable.icon_student, "Tran Tuoi", 22));
                t.putExtra("data",(Serializable) list);
                startActivity(t);
            }
        });
    }
}