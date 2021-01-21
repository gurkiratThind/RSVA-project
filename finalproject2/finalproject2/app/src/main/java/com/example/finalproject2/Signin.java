package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    EditText email,password,name;
    Button login;
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        email=findViewById(R.id.uEmail);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.ulogin);
        name=findViewById(R.id.uName);;
        login=findViewById(R.id.button5);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Signin.this,Login.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String emailid=email.getText().toString();
                String Passwords=password.getText().toString();
               String uname=name.getText().toString();
                addRecord(uname,emailid,Passwords);
                Intent in=new Intent(Signin.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
    public void addRecord(String name,String email,String password) {

        DbManager db=new DbManager(this);
        String res=db.addRecord(name,email,password);
        Log.e("email",res);
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();
    }
}