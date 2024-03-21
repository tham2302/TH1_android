package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleview.model.Cat;
import com.example.recycleview.model.CatItemListener;
import com.example.recycleview.model.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CatItemListener {
    RecyclerView reView;
    RecycleViewAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reView=findViewById(R.id.reView);
        List<Cat> list= getList();
        adapter = new RecycleViewAdapter( list);
        adapter.setCatItemListener(MainActivity.this);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        reView.setLayoutManager(manager);
        reView.setAdapter(adapter);
    }
    private List<Cat> getList(){
        List<Cat> list= new ArrayList<>();
        list.add(new Cat(R.drawable.img, "CAT 1"));
        list.add(new Cat(R.drawable.img_1, "CAT 2"));
        list.add(new Cat(R.drawable.img_2, "CAT 2"));
        list.add(new Cat(R.drawable.img_3, "CAT 3"));
        return list;
    }
    @Override
    public void onItemClick(View view, int position) {
        Cat c=getList().get(position);
        Toast.makeText(this, c.getName(), Toast.LENGTH_LONG).show();
    }
}