package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menuViewAdapter extends RecyclerView.Adapter<menuViewAdapter.myHolder>{

    String titles[];
    int img[];
    Context ctx;


    public menuViewAdapter(Context ct,int i[],String s[]){
        ctx=ct;
        img=i;
        titles=s;
    }




    @NonNull
    @Override
    public menuViewAdapter.myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater =LayoutInflater.from(ctx);
        View myOwnView=myInflater.inflate(R.layout.menu_view,parent,false);
        return new myHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull menuViewAdapter.myHolder holder, final int position) {
        holder.t.setText(titles[position]);
        holder.i.setImageResource(img[position]);

        holder.r.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,titles[position],Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return img.length;
    }


    public class myHolder extends RecyclerView.ViewHolder{

        TextView t;
        ImageView i;
        RelativeLayout r;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            t=(TextView)itemView.findViewById(R.id.text);
            i=(ImageView)itemView.findViewById(R.id.image);
            r=itemView.findViewById(R.id.menuLayout);
        }
    }
}
