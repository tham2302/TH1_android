package com.lesson8.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesson8.intent2.model.Account;

public class MainActivity extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        Intent intent=getIntent();
        if(intent.getSerializableExtra("account")!=null && intent.getSerializableExtra("user")!=null){
            Account log=(Account) intent.getSerializableExtra("account");
            Account user=(Account) intent.getSerializableExtra("user");
            if(log.getUser().equals(user.getUser()) && log.getPass().equals(user.getPass())){
                txt.setText("Dang nhap thanh cong!!!");
            }
            else{
                txt.setText("Tai khoan khong ton tai!");
            }
        }
    }
}