package com.lesson8.backstack.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lesson8.backstack.R;

public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText tName=view.findViewById(R.id.tName);
        Button bt=view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=tName.getText().toString();
                tName.setText("Hello "+name+"!");
            }
        });
        tName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tName.setText("");
            }
        });
    }
}