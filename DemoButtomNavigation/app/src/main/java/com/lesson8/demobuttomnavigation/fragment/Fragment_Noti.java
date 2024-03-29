package com.lesson8.demobuttomnavigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lesson8.demobuttomnavigation.R;
import com.lesson8.demobuttomnavigation.adapter.MessageAdapter;
import com.lesson8.demobuttomnavigation.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Noti extends Fragment {
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    List<Message> list;

    public Fragment_Noti() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_noti, container, false);
        list=new ArrayList<>();
        list.add(new Message(R.drawable.icon_cat, "Thanh", "Ban an com chua", "10:10"));
        list.add(new Message(R.drawable.icon_cat, "Tham", "Ban an com chua", "10:15"));
        list.add(new Message(R.drawable.icon_cat, "Thi", "Ban an com chua", "20:10"));
        list.add(new Message(R.drawable.icon_cat, "Thanh", "Ban an com ngon khong", "20:20"));
        list.add(new Message(R.drawable.icon_cat, "Thi", "Ban ngu chua", "23:10"));
        recyclerView=view.findViewById(R.id.recyclView);
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);
        messageAdapter=new MessageAdapter(view.getContext(), list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messageAdapter);
        return view;
    }
}
