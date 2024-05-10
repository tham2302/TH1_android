package com.quizz.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.quizz.R;
import com.quizz.TopicActivity;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {

    public Home_Fragment() {
        // Required empty public constructor
    }

    CardView heading1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_, container, false);

        heading1=view.findViewById(R.id.heading1);

        heading1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), TopicActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}