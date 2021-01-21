package com.example.finalproject2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SplashDataActivity extends AppCompatActivity {

    private DataBaseHelper db;
    Button btn_save, btn_get;
    ArrayList<Mechanics> al_data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_data);
        db = new DataBaseHelper(com.example.finalproject2.SplashDataActivity.this);
        try {
            db.createDatabase();
            db.openDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }


        btn_get = findViewById(R.id.btn_get);
        ListView list=(ListView)findViewById(R.id.list);

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = new DataBaseHelper(com.example.finalproject2.SplashDataActivity.this);
                try {
//                    db.createDatabase();
//                    db.openDatabase();
                    al_data=db.getAppCategoryDetail();
                    CustomAdapter customAd=new CustomAdapter(com.example.finalproject2.SplashDataActivity.this,al_data);
                    list.setAdapter(customAd);
                    for(int i=0;i<al_data.size();i++){
                        Log.e("Arraylist",al_data.get(i).getFirstName());
                        Log.e("Arraylist",""+al_data.get(i).getRating());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getAppCategoryDetail();
            }
        });


    }
}