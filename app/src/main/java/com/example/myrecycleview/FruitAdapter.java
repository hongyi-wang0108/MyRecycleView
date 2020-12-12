package com.example.myrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Fruit> mlist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View v;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView = itemView.findViewById(R.id.iv_item);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }

    public FruitAdapter(List<Fruit> list) {
        mlist = list;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder vh = new ViewHolder(view);
        vh.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = vh.getAdapterPosition();
                Fruit fruit = mlist.get(p);
                Toast.makeText(parent.getContext(),"click view" +fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        vh.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = vh.getAdapterPosition();
                Fruit fruit = mlist.get(p);
                Toast.makeText(parent.getContext(),"click view" +fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return vh;
    }

    //shezhi
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Fruit fruit = mlist.get(position);
        viewHolder.imageView.setImageResource(fruit.getImageView());
        viewHolder.textView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
