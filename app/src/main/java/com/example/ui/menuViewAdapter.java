package com.example.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
    public void onBindViewHolder(@NonNull final menuViewAdapter.myHolder holder, final int position) {
        holder.t.setText(titles[position]);
        holder.i.setImageResource(img[position]);
        holder.i.setAlpha(1f);




        holder.r.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Toast.makeText(ctx, "single click "+position, Toast.LENGTH_SHORT).show();
                holder.i.setAlpha(0.7f);



            }
        });




            holder.setLongClickListener(new LongClickListener() {

                @Override
                public void onItemLongClick(int pos) {
                    if(position>1) {
                        Toast.makeText(ctx, "long press " + titles[position], Toast.LENGTH_SHORT).show();
                    }
                }

            });






    }

    @Override
    public int getItemCount() {
        return img.length;
    }


    //for context menu
    public void getItemSelected(MenuItem item)
    {
        Toast.makeText(ctx,"long press 2 "+ item.getTitle(),Toast.LENGTH_SHORT).show();

    }







    public class myHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener , View.OnCreateContextMenuListener{

        TextView t;
        ImageView i;
        RelativeLayout r;
        LongClickListener longClickListener;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            t=(TextView)itemView.findViewById(R.id.text);
            i=(ImageView)itemView.findViewById(R.id.image);
            r=itemView.findViewById(R.id.menuLayout);

            itemView.setOnLongClickListener(this);
            itemView.setOnCreateContextMenuListener(this);



        }


        public void setLongClickListener(LongClickListener l)
        {
            this.longClickListener=l;
        }

        @Override
        public boolean onLongClick(View view) {

            this.longClickListener.onItemLongClick(getLayoutPosition());
            return false;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {


            if(getLayoutPosition()>1) {
                contextMenu.add(0, 0, 0, "add image");
                contextMenu.add(0, 1, 0, "quit album");
            }


        }
    }
}
