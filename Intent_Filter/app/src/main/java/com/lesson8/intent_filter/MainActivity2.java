package com.lesson8.intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent=new Intent();
    }
    public void web(View view){
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=0H4qeNhoVOo&list=PLD8zSU7U1L2GVhpPIUlJegpP8HRC2r58w&index=29"));
        startActivity(intent);
    }

}