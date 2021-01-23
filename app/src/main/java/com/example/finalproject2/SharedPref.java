package com.example.finalproject2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences sharedPref;
    Context context;

    public SharedPref(Context con)
    {
        sharedPref = con.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
    }

    public void setUsertId(String userid)
    {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("USER_ID",userid);
        editor.apply();
    }

    public String getUserId()
    {
        String parentId = sharedPref.getString("USER_ID", "");
        return  parentId;
    }


    public void setLoginStatus(String loginStatus)
    {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("LoginStatus",loginStatus);
        editor.apply();
    }

    public String getLoginStatus()
    {
        String loginStatus = sharedPref.getString("LoginStatus", "");
        return  loginStatus;
    }


    public void Clear_digtionrystatus()
    {
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("LoginStatus", "");


        editor.apply();
    }


}