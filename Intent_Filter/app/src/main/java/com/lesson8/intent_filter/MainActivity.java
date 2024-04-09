package com.lesson8.intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void email(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "Thamtt@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Moi ban tham du khoa hoc Android");
        startActivity(Intent.createChooser(intent, "Chon email"));
    }
    public void send(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(intent);
    }
}