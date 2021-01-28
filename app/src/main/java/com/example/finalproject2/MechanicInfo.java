package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MechanicInfo extends AppCompatActivity {

    private  Bitmap shopbmap,mechbmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_info);
        Intent in=getIntent();
        String shopname=in.getStringExtra("shopname");
        String mechname=in.getStringExtra("mechname");
        String shopaddress=in.getStringExtra("shopaddress");
        String Otimmings=in.getStringExtra("Otimmings");
        String Ctimmings=in.getStringExtra("Ctimmings");
        int sp_id=in.getIntExtra("sp_id",0);
        double basicrate=in.getDoubleExtra("basicrate",0);
        byte[] shopimg=in.getByteArrayExtra("shopimg");
        byte[] mechimg=in.getByteArrayExtra("mechimg");
        double latitude=in.getDoubleExtra("lat",0);
        double longitude=in.getDoubleExtra("long",0);
        Button sendrequest=(Button) findViewById(R.id.sendrequest);

        TextView textshopname=(TextView) findViewById(R.id.selectedmcshopname);
        TextView textmechname=(TextView) findViewById(R.id.selectedmechname);
        TextView textshopaddress=(TextView) findViewById(R.id.selectedmcaddress);
        TextView textshoptimmings=(TextView) findViewById(R.id.selectedmctimmings);
        TextView textshopbasic=(TextView) findViewById(R.id.selectedmcbasicrate);
        ImageView textshopimg=(ImageView) findViewById(R.id.selectedmcimg1);
        ImageView textmechimg=(ImageView)findViewById(R.id.selectedmcpersonimage);



        textshopname.setText(shopname.toString());
        textmechname.setText(mechname.toString());
        textshopaddress.setText(shopaddress.toString());
        textshoptimmings.setText(Otimmings.toString()+"-"+Ctimmings.toString());

        textshopbasic.setText(String.valueOf(basicrate));
        shopbmap= BitmapFactory.decodeByteArray(shopimg, 0 ,shopimg.length);
        mechbmap= BitmapFactory.decodeByteArray(mechimg, 0 ,mechimg.length);
        textshopimg.setImageBitmap(shopbmap);
        textmechimg.setImageBitmap(mechbmap);

        sendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MechanicInfo.this,MechLocationActivity.class);
                in.putExtra("lat",latitude);
                in.putExtra("long",longitude);
                startActivity(in);
            }
        });



    }
}