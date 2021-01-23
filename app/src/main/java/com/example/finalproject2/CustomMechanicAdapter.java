package com.example.finalproject2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomMechanicAdapter  extends ArrayAdapter{
    Context context;
    List<Datumlist> dataList;
    byte[] bytes;
    Bitmap bms;
    public CustomMechanicAdapter(Context context,  List<Datumlist> dataList) {
        super(context,R.layout.activity_custom_adapter);

        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.mechniclistlayout,parent,false);


        ImageView shopimage=(ImageView) rowView.findViewById(R.id.mcshopimage);
        TextView shopname=(TextView) rowView.findViewById(R.id.mcshopname);
        TextView shopaddress=(TextView) rowView.findViewById(R.id.mcshopaddress);
        TextView shopOpen=(TextView) rowView.findViewById(R.id.mcshopopentime);
        TextView shopclose=(TextView) rowView.findViewById(R.id.mcshopclosetime);
        TextView shopbasic=(TextView) rowView.findViewById(R.id.mcshopbasicrate);



        shopname.setText(dataList.get(position).getShopname());
        shopaddress.setText(dataList.get(position).getShopaddress());
        shopOpen.setText(dataList.get(position).getOpentime());
        shopclose.setText(dataList.get(position).getClosetime());
        shopbasic.setText(String.valueOf(dataList.get(position).getBasicRate()));


        Shopphoto bmp=dataList.get(position).getShopphoto();

        List<Integer> img=bmp.getData();
        bytes = new byte[img.size()];
        for (int i = 0; i < img.size(); i++) {
            bytes[i] = (byte) img.get(i).intValue();
        }

        bms=getImage(bytes);
        shopimage.setImageBitmap(bms);
        //iv_image.setImageBitmap(bms);


        //  iv_image.setImageBitmap(bmaps);
        return rowView;
    }

    public Bitmap getImage(byte[] image) {
        // ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
        Bitmap bmsp = BitmapFactory.decodeByteArray(image, 0 ,image.length);
        return bmsp;


    }
}
