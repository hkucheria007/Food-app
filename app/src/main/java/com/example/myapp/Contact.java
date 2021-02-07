package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    TextView contacthead,supporthead,mobilename,mobilenumber,landlinename,landlinenumber,emailname,emailstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contacthead=findViewById(R.id.ContactHeading);
        supporthead=findViewById(R.id.SupportHeading);
        mobilename=findViewById(R.id.SupportMobileNoName);
        mobilenumber=findViewById(R.id.SupportMobileNoNumber);
        landlinename=findViewById(R.id.SupportLandlineNoName);
        landlinenumber=findViewById(R.id.SupportLandlineNoNumber);
        emailname=findViewById(R.id.SupportEmailName);
        emailstring=findViewById(R.id.SupportEmailString);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Contact.this,MainActivity.class));
        finish();
    }
}
