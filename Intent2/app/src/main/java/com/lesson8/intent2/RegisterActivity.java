package com.lesson8.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lesson8.intent2.model.Account;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUser, tvPass;
    private Button btRegister, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        btRegister.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }
    private void initView() {
        tvUser=findViewById(R.id.user);
        tvPass=findViewById(R.id.pass);
        btRegister=findViewById(R.id.register);
        btCancel=findViewById(R.id.cancel);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.register:
                Account acc=new Account(tvUser.getText().toString(), tvPass.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("data", acc);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.cancel:
                setResult(RESULT_CANCELED, null);
                finish();
                break;
        }
    }
}