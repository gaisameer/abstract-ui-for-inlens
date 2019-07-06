package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String str[];
    int menuImages[]={R.drawable.add_album,R.drawable.qrcode,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens,R.drawable.lens};
    menuViewAdapter ad;
    RecyclerView r;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent;
                homeIntent = new Intent(MainActivity.this,splashScreen.class);
                startActivity(homeIntent);
                finish();
            }
        },3000); */

        r= (RecyclerView)findViewById(R.id.recycler_view);
        str=getResources().getStringArray(R.array.menuElements);
        ad=new menuViewAdapter(this,menuImages,str);

        r.setAdapter(ad);
        r.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    public void userDetails(View view) {
        Intent profile =new Intent(this,userProfile.class);
        startActivity(profile);

    }

    /*

    public void newAlbum(View view) {
        Toast.makeText(this,"new album",Toast.LENGTH_SHORT).show();

    }




    public void scan(View view) {
        Toast.makeText(this,"scan",Toast.LENGTH_SHORT).show();
    }

    public void albumSelect(View view) {
        Toast.makeText(this,"view album",Toast.LENGTH_SHORT).show();
    }
      */



}
