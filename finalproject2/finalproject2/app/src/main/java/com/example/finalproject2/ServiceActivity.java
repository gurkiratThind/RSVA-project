package com.example.finalproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    SharedPreferences sh;
    SharedPreferences.Editor editor;

    TextView tv_key_lost_service,tv_toe_service,tv_flatTire_service,tv_repairing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        //TextViews
        tv_key_lost_service=findViewById(R.id.tv_key_lost_service);
        tv_toe_service=findViewById(R.id.tv_toe_service);
        tv_flatTire_service=findViewById(R.id.tv_flatTire_service);
        tv_repairing=findViewById(R.id.tv_repairing);

        sh=getSharedPreferences("Service", Context.MODE_PRIVATE);
        editor=sh.edit();
        
        tv_key_lost_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Chosen_Service","Key Lost");
                editor.commit();
                Intent in=new Intent(ServiceActivity.this,SplashDataActivity.class);
                startActivity(in);
            }
        });

        tv_toe_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Chosen_Service","Toe Service");
                editor.commit();
                Intent in=new Intent(ServiceActivity.this,MechanicList.class);
                startActivity(in);
            }
        });

        tv_flatTire_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Chosen_Service","Flat Tire");
                editor.commit();
                Intent in=new Intent(ServiceActivity.this,MechanicList.class);
                startActivity(in);
            }
        });


        tv_repairing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Chosen_Service","Repair");
                editor.commit();
                Intent in=new Intent(ServiceActivity.this,MechanicList.class);
                startActivity(in);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.services:
                Log.e("item", "onOptionsItemSelected: item1");
                return true;
            case R.id.about:
                Log.e("item", "onOptionsItemSelected: car");
                return true;
            case R.id.logout:
                Intent in = new Intent(ServiceActivity.this, Login.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}