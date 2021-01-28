package com.example.finalproject2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SplashDataActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //Variables
    Animation topAnim, bottomAnim;
    TextView RSA,App_Name, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_data);
        SharedPref shr=new SharedPref(getApplicationContext());
        //getSupportActionBar().hide();


        /* Text Animations */
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        RSA = findViewById(R.id.ani1);
        App_Name = findViewById(R.id.anim_2);
        slogan = findViewById(R.id.anim_3);

        RSA.setAnimation(topAnim);
        App_Name.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(shr.getLoginStatus().equals("1")){
                    startActivity(new Intent(SplashDataActivity.this, Speciality.class));
                    finish();
                }else
                    startActivity(new Intent(SplashDataActivity.this, Welcome_Actitivty.class));
                finish();
            }
        }, SPLASH_SCREEN);


    }}