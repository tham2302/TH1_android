package com.example.recycleview.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.MainActivity;
import com.example.recycleview.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mlist;
    private CatItemListener catItemListener;

    public RecycleViewAdapter(List<Cat> mlist) {
        //    this.context = context;
        this.mlist = mlist;
    }

    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        CatViewHolder catViewHolder = new CatViewHolder(view);
        view.setOnClickListener(catViewHolder);
        return catViewHolder;
    }

    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mlist.get(position);
        if (cat == null)
            return;
        holder.img.setImageResource(cat.getImage());
        holder.txt.setText(cat.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView txt;

        //CardView cardView;
        public CatViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            txt = v.findViewById(R.id.txt);
            //cardView=v.findViewById(R.id.cview);
        }

        @Override
        public void onClick(View view) {
            if (catItemListener != null) {
                catItemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
