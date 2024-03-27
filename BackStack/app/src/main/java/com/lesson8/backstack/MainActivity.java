package com.lesson8.backstack;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.lesson8.backstack.model.FragmentA;
import com.lesson8.backstack.model.FragmentB;
import com.lesson8.backstack.model.FragmentC;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getSupportFragmentManager();
    }
    private void add(Fragment fg, String tag, String name){
        transaction=manager.beginTransaction();
        transaction.add(R.id.frame, fg, tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }
    private void addA(View view){
        FragmentA fg= new FragmentA();
        add(fg, "fragA", "fa");
    }
    private void addB(View view){
        FragmentB fg= new FragmentB();
        add(fg, "fragB", "fb");
    }
    private void addC(View view){
        FragmentC fg= new FragmentC();
        add(fg, "fragC", "fc");
    }
    private void remove(Fragment fg, String tag){
        transaction=manager.beginTransaction();
        fg=manager.findFragmentByTag(tag);
        transaction.remove(fg);
        transaction.commit();
    }
    private void removeA(View view){
        FragmentA fg=new FragmentA();
        remove(fg, "fragA");
    }
    private void removeB(View view){
        FragmentB fg=new FragmentB();
        remove(fg, "fragB");
    }
    private void removeC(View view){
        FragmentC fg=new FragmentC();
        remove(fg, "fragC");
    }
    public void back(View view){
        manager.popBackStack();
    }
    public void popA(View view){
        manager.popBackStack("fa", 0);
    }

    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount()>0){
            manager.popBackStack();
        }
        super.onBackPressed();
    }
}