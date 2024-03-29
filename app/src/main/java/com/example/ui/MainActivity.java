package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String str[];
    int menuImages[]={R.drawable.add_album,R.drawable.qrcode,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens};
    menuViewAdapter ad;
    RecyclerView r;
    SearchView s;
    TextView searchText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=findViewById(R.id.searchBarz);
        int id = s.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        searchText = (TextView) s.findViewById(id);
        searchText.setTextColor(Color.WHITE);
        searchText.setBackgroundColor(Color.TRANSPARENT);


        String picUrls[] = getResources().getStringArray(R.array.urls);
        RecyclerView srecyclerView = (RecyclerView)findViewById(R.id.StaggeredRecyclerView);

        r= findViewById(R.id.recycler_view);
        str=getResources().getStringArray(R.array.menuElements);
        ad=new menuViewAdapter(this,menuImages,str,srecyclerView);

        r.setAdapter(ad);
        r.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));




        //staggered recycler view

        staggeredViewAdapter staggeredViewAdapter = new staggeredViewAdapter(this,picUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        srecyclerView.setLayoutManager(staggeredGridLayoutManager);
        srecyclerView.setAdapter(staggeredViewAdapter);






    }

    public void userDetails(View view) {
        Intent profile =new Intent(this,userProfile.class);
        startActivity(profile);

    }

    public boolean onContextitemSelected(MenuItem item) {
        ad.getItemSelected(item);

        return super.onContextItemSelected(item);
    }










}
