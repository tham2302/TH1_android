package com.lesson8.intent_khong_tuong_minh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iWeb, iSms, iPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iWeb=findViewById(R.id.web);
        iSms=findViewById(R.id.sms);
        iPhone=findViewById(R.id.phone);
        iWeb.setOnClickListener(this);
        iSms.setOnClickListener(this);
        iPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.web:
                Intent w=new Intent(Intent.ACTION_VIEW);
                w.setData(Uri.parse("https://www.youtube.com/watch?v=YSEDXvvlnbc&list=PLD8zSU7U1L2GVhpPIUlJegpP8HRC2r58w&index=27"));
                startActivity(w);
                break;
            case R.id.sms:
                Intent m=new Intent(Intent.ACTION_VIEW);
                m.setData(Uri.parse("sms:"+"09124512"));
                m.putExtra("sms_body", "");
                startActivity(m);
                break;
            case R.id.phone:
                Intent p=new Intent(Intent.ACTION_DIAL);
                p.setData(Uri.parse("tel:09124512"));
                startActivity(p);
                break;
        }
    }
}