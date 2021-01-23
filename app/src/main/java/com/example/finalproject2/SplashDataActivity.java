package com.example.finalproject2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
        SharedPref shr=new SharedPref(getApplicationContext());

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(shr.getLoginStatus().equals("1")){
                    startActivity(new Intent(SplashDataActivity.this, Speciality.class));
                    finish();
                }else
                startActivity(new Intent(SplashDataActivity.this, Welcome_Actitivty.class));
                finish();
            }
        }, secondsDelayed * 1000);


    }
}