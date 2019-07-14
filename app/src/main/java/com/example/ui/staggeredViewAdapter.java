package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class staggeredViewAdapter extends RecyclerView.Adapter<staggeredViewAdapter.viewHolder> {

    Context ctx;
    String picURLs[];


    public staggeredViewAdapter(Context ctx, String picURLs[]) {
        this.ctx = ctx;
        this.picURLs = picURLs;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {

        RequestOptions requestOptions =new RequestOptions().placeholder(R.drawable.inlens_notification);

        Glide.with(ctx)
                .load(picURLs[position])
                .apply(requestOptions)
                .into(holder.i);


        holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,position+"clicked",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return picURLs.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView i;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            i=itemView.findViewById(R.id.imageviewforstaggered);
        }
    }
}
