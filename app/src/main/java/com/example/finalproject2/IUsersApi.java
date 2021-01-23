package com.example.finalproject2;

import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IUsersApi {
//    @Headers({
//
//            "Content-Type: application/x-www-form-urlencoded"
//
//    })

    @POST("register/")
    Call<Users> createUser(@Body Users user);

    @GET("clientspeciality/")
    Call<ClientSpeciality> getclList();

    @POST("mechaniclist/")
    Call<MechnicList> getmlist(@Body MechanicSpId spid);


}
