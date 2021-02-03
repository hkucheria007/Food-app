package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    private final int splashLength=2000;

    FirebaseAuth auth;
    FirebaseUser CurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        auth = FirebaseAuth.getInstance();

    imageView=findViewById(R.id.splashImage);
    textView=findViewById(R.id.Slogan);

    textView.setText("The Best food Delivery App,"+"\n"+"Which Serves food to the whole world");

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {


            CurrentUser = auth.getCurrentUser();

            if (CurrentUser != null) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(i);
                SplashActivity.this.finish();
            }
            else{
                Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                SplashActivity.this.startActivity(i);
                SplashActivity.this.finish();
            }
        }
    },splashLength);
    }
}