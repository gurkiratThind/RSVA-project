package com.example.finalproject2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    ClientSpeciality cspt;
    byte[] bytes;
    Bitmap bms;
    public CustomAdapter(Context context, ClientSpeciality cspt) {
        super(context,R.layout.activity_custom_adapter);

        this.context = context;
        this.cspt = cspt;
    }

    @Override
    public int getCount() {
        return cspt.getData().size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.activity_custom_adapter,parent,false);


        CircleImageView iv_image=rowView.findViewById(R.id.img_tumbnali);
        TextView id_text=(TextView) rowView.findViewById(R.id.idtext);
        id_text.setText(cspt.getData().get(position).getSpName());
        RelativeLayout relclick=(RelativeLayout) rowView.findViewById(R.id.relclick);

        SpImage bmp=cspt.getData().get(position).getSpImage();

        List<Integer> img=bmp.getData();
         bytes = new byte[img.size()];
        for (int i = 0; i < img.size(); i++) {
            bytes[i] = (byte) img.get(i).intValue();
        }

        bms=getImage(bytes);

        iv_image.setImageBitmap(bms);



      //  iv_image.setImageBitmap(bmaps);
        return rowView;
    }

    public Bitmap getImage(byte[] image) {
       // ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
       Bitmap bmsp = BitmapFactory.decodeByteArray(image, 0 ,image.length);
        return bmsp;


    }
}
