package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login;
    EditText email,password;
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DbManager db=new DbManager(this);
        email=findViewById(R.id.uEmail);
        signin=findViewById(R.id.uSignin);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button5);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, Signin.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                int flag=0;
                String emailid=email.getText().toString();
                String Passwords=password.getText().toString();
                Cursor cursor=db.allData();
                if(cursor.getCount()<0)
                {
                    Toast.makeText(Login.this,"No data found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while(cursor.moveToNext()) {
                        Log.e("email", cursor.getString(2));
                        Log.e("password", cursor.getString(3));
                        String email=(cursor.getString(2));
                        String password=(cursor.getString(3));

                        if(emailid.equals(cursor.getString(2)))
                        {
                            if(Passwords.equals(cursor.getString(3)))
                            {
                                flag=1;
                            }
                        }

                    }
                    if(flag==1)
                    {
                        Log.e("message", "email id or password correct");
                    }
                    else
                    {
                        Log.e("message", "email id or password not correct");
                    }
                }
//                Intent in=new Intent(MainActivity.this,Welcome.class);
//                startActivity(in);
            }
        });

    }
}