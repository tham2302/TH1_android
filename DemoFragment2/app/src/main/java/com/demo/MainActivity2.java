package com.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.model.FragmentA;
import com.demo.model.FragmentB;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private Button btA, btB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btA=findViewById(R.id.btA);
        btB=findViewById(R.id.btB);
        btA.setOnClickListener(this);
        btA.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fg;
        switch(view.getId()){
            case R.id.btA:
                fg=new FragmentA();
                transaction.add(R.id.frame, fg);
                break;
            case R.id.btB:
                fg=new FragmentB();
                transaction.add(R.id.frame, fg);
                break;
        }
        transaction.commit();
    }
}