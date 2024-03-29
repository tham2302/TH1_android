package com.lesson8.demobuttomnavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lesson8.demobuttomnavigation.R;
import com.lesson8.demobuttomnavigation.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHoler>{
    private Context context;
    private List<Message> list;

    public MessageAdapter(Context context, List<Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new ViewHoler(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Message s=list.get(position);
        holder.img.setImageResource(s.getImg());
        holder.name.setText(s.getName());
        holder.title.setText(s.getTitle());
        holder.gio.setText(s.getGio());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name, title, gio;

        public ViewHoler(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            name=view.findViewById(R.id.tname);
            gio=view.findViewById(R.id.tgio);
            title=view.findViewById(R.id.title);
        }
    }
}
