package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] images={R.drawable.car};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mImageView=(ImageView)findViewById(R.id.iv_image);
        mImageView.setImageResource(images[0]);
        Thread thread=new Thread()
        {
            @Override
            public void run(){
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            sleep(50000);
//                    Log.e("splashActivity","dummy text");
                            Intent in = new Intent(MainActivity.this, Login.class);
                            startActivity(in);
                            Toast.makeText(MainActivity.this,"u are in main activity now", Toast.LENGTH_LONG).show();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        thread.start();
    }
}