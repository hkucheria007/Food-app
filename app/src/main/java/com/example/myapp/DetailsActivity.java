package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {
    TextView head;
    TextInputEditText fn,ln,mno,add1,add2,add3,ct,pin;
    Button sub;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    String first,last,number,address1,address2,address3,city,pincode;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        head=findViewById(R.id.headline);
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

                Intent in=new Intent(DetailsActivity.this,Invoice.class);
                in.putExtra("First",first);
                in.putExtra("Last",last);
                in.putExtra("Mobile",number);
                in.putExtra("Add1",address1);
                in.putExtra("Add2",address2);
                in.putExtra("Add3",address3);
                in.putExtra("City",city);
                in.putExtra("Pincode",pincode);
                Bundle bundle=getIntent().getExtras();
                if(bundle!=null){
                    in.putExtras(bundle);
                }
                startActivity(in);

            }
        });

    }
}