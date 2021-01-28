package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MechanicList extends AppCompatActivity {
    ArrayList<Mechanics> db=new ArrayList<>();
    private IUsersApi postsService;
    ListView list;
    int spid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_list);
        Intent in=getIntent();
         spid=in.getIntExtra("sp_id",0);
         list=(ListView) findViewById(R.id.listitems);

        try {
                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.MINUTES)
                            .writeTimeout(1, TimeUnit.MINUTES)
                            .readTimeout(1, TimeUnit.MINUTES)
                            .build();
                    Retrofit retrofit = new Retrofit.Builder()
                           .baseUrl("http://10.0.2.2:8012/api/")  // for emulator
                           // .baseUrl("http://192.168.2.28:8012/api/")       //for mobile device use ipconfig in cmd and then wireless and then take ip of ipv4
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    postsService = retrofit.create(IUsersApi.class);
                    sendPost();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }


    }



    private void sendPost() {
        MechanicSpId user = new MechanicSpId(spid);
        Call<MechnicList> call = postsService.getmlist(user);

        call.enqueue(new Callback<MechnicList>() {
            @Override
            public void onResponse(Call<MechnicList> call, Response<MechnicList> response) {
                if (!response.isSuccessful()) {
                    System.out.println("great");
                    // textView.setText("Code " + response.code());
                    return;
                }

                List<Datumlist> dtlist=response.body().getData();
                System.out.println("dataaaaaaaaa"+dtlist);
                CustomMechanicAdapter cmat=new CustomMechanicAdapter(MechanicList.this,dtlist);
                list.setAdapter(cmat);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int spid=dtlist.get(position).getSpId();

                        Shopphoto bmp=dtlist.get(position).getShopphoto();
                        Mechphoto bmpmech=dtlist.get(position).getMechphoto();

                        List<Integer> img=bmp.getData();
                        List<Integer> imgmech=bmpmech.getData();
                       byte[] shopbytes = new byte[img.size()];
                        for (int i = 0; i < img.size(); i++) {
                            shopbytes[i] = (byte) img.get(i).intValue();
                        }


                        byte[] mechbytes = new byte[imgmech.size()];
                        for (int i = 0; i < imgmech.size(); i++) {
                            mechbytes[i] = (byte) imgmech.get(i).intValue();
                        }
                        Intent in=new Intent(MechanicList.this,MechanicInfo.class);
                        in.putExtra("sp_id",spid);
                        in.putExtra("shopname",dtlist.get(position).getShopname());
                        in.putExtra("mechname",dtlist.get(position).getMechname());
                        in.putExtra("shopaddress",dtlist.get(position).getShopaddress());
                        in.putExtra("basicrate",dtlist.get(position).getBasicRate());
                        in.putExtra("Otimmings",dtlist.get(position).getOpentime());
                        in.putExtra("Ctimmings",dtlist.get(position).getClosetime());
                        in.putExtra("lat",dtlist.get(position).getLat());
                        in.putExtra("long",dtlist.get(position).getLong());
                        in.putExtra("shopimg",shopbytes);
                        in.putExtra("mechimg",mechbytes);
                        startActivity(in);
                    }
                });


            }
            @Override
            public void onFailure(Call<MechnicList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}