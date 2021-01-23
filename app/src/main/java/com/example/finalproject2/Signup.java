package com.example.finalproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

public class Signup extends AppCompatActivity {
    private IUsersApi postsService;
    String name,pass,email;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Geocoder geocoder;
    private static  final int REQUEST_CODE_PERMISSION_LOCATION=1;
        Runnable test;
    double latitude, longitude;
    private final static String WAKE_LOCK = "MyWakelockTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText edname = (EditText) findViewById(R.id.edname);
        EditText edpassword = (EditText) findViewById(R.id.edpasswrd);
        EditText edemail = (EditText) findViewById(R.id.edemail);
        Button btn = (Button) findViewById(R.id.signupbtn);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_PERMISSION_LOCATION);
            }else{
                //getCurrLocation();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                 name = edname.getText().toString();
//                 pass = edpassword.getText().toString();
//                 email = edemail.getText().toString();
//
//                try {
////                    OkHttpClient client = new OkHttpClient.Builder()
////                            .connectTimeout(1, TimeUnit.MINUTES)
////                            .writeTimeout(1, TimeUnit.MINUTES)
////                            .readTimeout(1, TimeUnit.MINUTES)
////                            .build();
//                    Retrofit retrofit = new Retrofit.Builder()
//                          //  .baseUrl("http://10.0.2.2:8012/api/")   for emulator
//                            .baseUrl("http://192.168.2.28:8012/api/")       //for mobile device use ipconfig in cmd and then wireless and then take ip of ipv4
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .build();
//                    postsService = retrofit.create(IUsersApi.class);
//                    sendPost();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CODE_PERMISSION_LOCATION && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getCurrLocation();
            }else {
                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void getCurrLocation(){
        Intent intent = new Intent(getApplicationContext(), GpsTracker.class);
        startService(intent);
//      Handler handler = new Handler();
//        test = new Runnable() {
//            @Override
//            public void run() {
//                GpsTracker  gps = new GpsTracker(Signup.this);
//
//                if (gps.canGetLocation()) {
//
//                    latitude = gps.getLatitude();
//                    longitude = gps.getLongitude();
//
//                    Log.e("latlong", "" + latitude + "" + longitude);
//                    // Toast.makeText(
//                    // getApplicationContext(),
//                    // "Your Location is - \nLat: " + latitude + "\nLong: "
//                    // + longitude, Toast.LENGTH_LONG).show();
//                } else {
//                    gps.showSettingsAlert();
//                }
//                handler.postDelayed(test, 4000); //100 ms you should do it 4000
//            }
//        };
//
//        handler.postDelayed(test, 0);
//

    }
//
//    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            latitude = Double.valueOf(intent.getStringExtra("latutide"));
//            longitude = Double.valueOf(intent.getStringExtra("longitude"));
//            Log.e("latlong", "" + latitude + "" + longitude);
//            List<Address> addresses = null;
//
//
////
////            tv_latitude.setText(latitude+"");
////            tv_longitude.setText(longitude+"");
////            tv_address.getText();
//
//
//        }
//    };
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(broadcastReceiver, new IntentFilter(GpsTracker.str_receiver));
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(broadcastReceiver);
//    }
//


    private void sendPost() {
        Users user = new Users(name, email, pass);
        Call<Users> call = postsService.createUser(user);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Toast.makeText(getApplicationContext(), "great", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}