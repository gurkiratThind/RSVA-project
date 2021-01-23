
package com.example.finalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThankyouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        Button logoutbtn=(Button) findViewById(R.id.logoutbtn);
        Button homebtn=(Button) findViewById(R.id.homebtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ThankyouActivity.this,Login.class);
                SharedPref shrd=new SharedPref(getApplicationContext());
                shrd.Clear_digtionrystatus();
                startActivity(in);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ThankyouActivity.this,Speciality.class);

                startActivity(in);
            }
        });

    }
}