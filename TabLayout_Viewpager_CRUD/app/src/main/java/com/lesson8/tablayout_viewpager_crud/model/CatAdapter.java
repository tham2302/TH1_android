package com.lesson8.tablayout_viewpager_crud.model;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lesson8.tablayout_viewpager_crud.MainActivity;
import com.lesson8.tablayout_viewpager_crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat>mlist;
    private CatItemListener catItemListener;
    private MainActivity mainActivity;

    public CatAdapter(MainActivity mainActivity) {
        mlist=new ArrayList<>();
        this.mainActivity=mainActivity;
    }

    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }
    public Cat getItem(int position){
        return mlist.get(position);
    }
    public List<Cat> getList(){
        return mlist;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat=mlist.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice()+"");
        holder.desc.setText(cat.getDescribe());
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan xoa "+cat.getName()+" khong?");
                builder.setIcon(R.drawable.ic_remove);
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mlist.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void update(Cat cat, int position) {
        mlist.set(position, cat);
        notifyDataSetChanged();
    }

    public void add(Cat cat) {
        mlist.add(cat);
        notifyDataSetChanged();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView name, price, desc;
        Button btRemove;

        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.item_img);
            name=view.findViewById(R.id.item_name);
            price=view.findViewById(R.id.item_price);
            desc=view.findViewById(R.id.item_desc);
            btRemove=view.findViewById(R.id.item_btRemove);
            btRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(catItemListener!=null){
                catItemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
