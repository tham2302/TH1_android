package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test6);
        sp=findViewById(R.id.sp2);
        String [] list = {"PTIT", "HUST", "NEU", "HANU"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, list);
        sp.setAdapter(adapter);
    }
}