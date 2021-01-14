package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class StartPage extends AppCompatActivity {
    LinearLayout l1,l2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        l1=findViewById(R.id.adminLayout);
        l2=findViewById(R.id.customerLayout);
        b1=findViewById(R.id.Admin);
        b2=findViewById(R.id.Customer);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StartPage.this,AdminLogin.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StartPage.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}