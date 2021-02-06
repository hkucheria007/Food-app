package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class DetailsActivity extends AppCompatActivity {

    TextInputEditText fn,ln,mno,add1,add2,add3,ct,pin;
    Button sub;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    String first,last,number,address1,address2,address3,city,pincode;
    String userId;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        fn=findViewById(R.id.fname);
        ln=findViewById(R.id.lname);
        mno=findViewById(R.id.MNumber);
        add1=findViewById(R.id.AddressLine1);
        add2=findViewById(R.id.AddressLine2);
        add3=findViewById(R.id.AddressLine3);
        ct=findViewById(R.id.City);
        pin=findViewById(R.id.Pincode);

        sub=findViewById(R.id.BtSubmit);

        //firebase instance
        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();


        //button onclick
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                first=fn.getText().toString();
                last=ln.getText().toString();
                number=mno.getText().toString();
                address1=add1.getText().toString();
                address2=add2.getText().toString();
                address3=add3.getText().toString();
                city=ct.getText().toString();
                pincode=pin.getText().toString();

                if(TextUtils.isEmpty(first)){
                    fn.setError("Can't leave Firstname Empty");
                }else if(TextUtils.isEmpty(last)){
                    ln.setError("Can't leave Lastname Empty");
                }else if(number.length()<10 || number.length()>10){
                    mno.setError("Enter Valid Number");
                }else if (TextUtils.isEmpty(address1)){
                    add1.setError("Can't leave Address1 Empty");
                }else if (TextUtils.isEmpty(address2)){
                    add2.setError("Can't leave Address2 Empty");
                }else if (TextUtils.isEmpty(address3)){
                    add3.setError("Can't leave Address3 Empty");
                }else if (TextUtils.isEmpty(city)){
                    ct.setError("Can't leave City Empty");
                }else if (TextUtils.isEmpty(pincode)){
                    pin.setError("Can't leave Pincode Empty");
                }else {

                    Intent in = new Intent(DetailsActivity.this, Invoice.class);
                    in.putExtra("First", first);
                    in.putExtra("Last", last);
                    in.putExtra("Mobile", number);
                    in.putExtra("Add1", address1);
                    in.putExtra("Add2", address2);
                    in.putExtra("Add3", address3);
                    in.putExtra("City", city);
                    in.putExtra("Pincode", pincode);
                    Bundle bundle = getIntent().getExtras();
                    if (bundle != null) {
                        in.putExtras(bundle);
                    }
                    startActivity(in);
//                    finish();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailsActivity.this,MainActivity.class));
//        finish();
    }
}