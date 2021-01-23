package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Speciality extends AppCompatActivity {
    IUsersApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);
        ListView list=(ListView) findViewById(R.id.splistitems);
                try {
                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.MINUTES)
                            .writeTimeout(1, TimeUnit.MINUTES)
                            .readTimeout(1, TimeUnit.MINUTES)
                            .build();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:8012/api/")  // for emulator
                           //.baseUrl("http://192.168.2.28:8012/api/")       //for mobile device use ipconfig in cmd and then wireless and then take ip of ipv4
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

               jsonPlaceHolderApi = retrofit.create(IUsersApi.class);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }




        Call<ClientSpeciality> listCall = jsonPlaceHolderApi.getclList();

        listCall.enqueue(new Callback<ClientSpeciality>() {
            @Override
            public void onResponse(Call<ClientSpeciality> call, Response<ClientSpeciality> response) {
                if (!response.isSuccessful()) {
                    System.out.println("great");
                   // textView.setText("Code " + response.code());
                    return;
                }

                ClientSpeciality posts = response.body();
                System.out.println(posts);


                CustomAdapter cst=new CustomAdapter(getApplicationContext(),posts);
                list.setAdapter(cst);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int spid=posts.getData().get(position).getSpId();
                        Intent in=new Intent(Speciality.this,MechanicList.class);
                        in.putExtra("sp_id",spid);
                        startActivity(in);
                    }
                });


            }

            @Override
            public void onFailure(Call<ClientSpeciality> call, Throwable t) {
                System.out.println(t);
            }
        });


    }
}