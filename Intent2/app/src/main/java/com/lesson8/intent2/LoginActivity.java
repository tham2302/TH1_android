package com.lesson8.intent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lesson8.intent2.model.Account;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUser, tvPass;
    private Button btLogin, btRegister;
    private final static int REQUEST_CODE=10000;
    private Account user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }

    private void initView() {
        tvUser=findViewById(R.id.user);
        tvPass=findViewById(R.id.pass);
        btLogin=findViewById(R.id.login);
        btRegister=findViewById(R.id.register);
    }

    @Override
    public void onClick(View view) {
    switch(view.getId()){
        case R.id.login:
            Intent logIntent = new Intent(LoginActivity.this, MainActivity.class);
            Account acc=new Account(tvUser.getText().toString(), tvPass.getText().toString());
            logIntent.putExtra("account", acc);
            logIntent.putExtra("user", user);
            startActivity(logIntent);
            break;
        case R.id.register:
            Intent reIntent=new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(reIntent,REQUEST_CODE);
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            if(data==null){
                Toast.makeText(this, "Nguoi dung huy dang ki", Toast.LENGTH_SHORT).show();
            }
            else{
                user=(Account) data.getSerializableExtra("data");
                tvUser.setText(user.getUser());
                tvPass.setText(user.getPass());
            }
        }
        else{
            user=null;
        }
    }
}