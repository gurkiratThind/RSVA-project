package com.example.finalproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Mechanics> al_Custom;

    public CustomAdapter(Context context, ArrayList<Mechanics> al_Custom) {
        super(context,R.layout.activity_custom_adapter);

        this.context = context;
        this.al_Custom = al_Custom;
    }

    @Override
    public int getCount() {
        return al_Custom.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.activity_custom_adapter,parent,false);

        ImageView iv_image=rowView.findViewById(R.id.img_tumbnali);
        iv_image.setImageBitmap(al_Custom.get(position).thumbnail);

        TextView tv_first_name=rowView.findViewById(R.id.tv_first_name);//set image name
        tv_first_name.setText(al_Custom.get(position).firstName);

        TextView tv_last_name=rowView.findViewById(R.id.tv_last_name);//set image name
        tv_last_name.setText(al_Custom.get(position).lastName);

        TextView tv_rating=rowView.findViewById(R.id.tv_rating);//set image name
        tv_rating.setText(Float.toString(al_Custom.get(position).rating));

        return rowView;
    }
}
