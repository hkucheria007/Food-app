package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout t1;
    TextInputEditText te1;
    Button b1;
    FirebaseUser CurrentUser;
//    FirebaseFirestore firestore;
    String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        t1 = findViewById(R.id.TIL1);
        te1 = findViewById(R.id.mobileNo);
        b1 = findViewById(R.id.getOTP);

        CurrentUser=FirebaseAuth.getInstance().getCurrentUser();

        if(CurrentUser!=null){
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        else{
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mobile=te1.getText().toString().trim();

                    if(mobile.isEmpty()||mobile.length()<12){
                        te1.setError("Enter valid Mobile No");
                        te1.requestFocus();
                        return;
                    }

                    Intent i=new Intent(LoginActivity.this,VerifyMobile.class);
                    i.putExtra("Mobile",mobile);
                    startActivity(i);
                }
            });
        }
//        firestore = FirebaseFirestore.getInstance();
    }
}