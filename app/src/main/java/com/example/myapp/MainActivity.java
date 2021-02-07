package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String quantity = "0";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //First
    TextView t1, t2, t3, price1, price2;
    ElegantNumberButton elegantNumberButton1,elegantNumberButton2;
    RelativeLayout lay1,lay2;

    //Second
    TextView t4, t5, t6, price3, price4;
    ElegantNumberButton elegantNumberButton3,elegantNumberButton4;
    RelativeLayout lay3, lay4;

    //Third
    TextView t7, t8, t9, price5, price6;
    ElegantNumberButton elegantNumberButton5,elegantNumberButton6;
    RelativeLayout lay5, lay6;

    //Button
    Button next;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    String userId;
    String pizza1, pizza2, donut1, donut2, sandwitch1, sandwitch2;
    String Quantityp1, Quantityp2, Quantityd1, Quantityd2, Quantitys1, Quantitys2;
    String p1, p2, p3, p4, p5, p6;
    String pp1, pp2, pd1, pd2, ps1, ps2, grandtotal;

    boolean first = true, second = true, third = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationDrawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //Button Implementation
        next = findViewById(R.id.button);

        //fierbase authentication
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        //Navigation Onclick
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.idYourOrder:
                        startActivity(new Intent(MainActivity.this,YourOrder.class));
                        finish();
                        break;

                    case R.id.idAboutUs:
                        startActivity(new Intent(MainActivity.this, AboutUs.class));
                        finish();
                        break;

                    case R.id.idContact:
                        startActivity(new Intent(MainActivity.this, Contact.class));
                        finish();
                        break;

                    case R.id.idShareApp:
//                        startActivity(new Intent(MainActivity.this, ShareApp.class));
//                        finish();
                        break;

                    case R.id.idRateApp:
//                        startActivity(new Intent(MainActivity.this, RateApp.class));
//                        finish();
                        break;

                    case R.id.idLogout:
                        auth.signOut();
                        if (auth.getCurrentUser() == null) {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            Toast.makeText(MainActivity.this, "Logout Succesfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        //First Implementation
        t1 = findViewById(R.id.FirstTV);
        t2 = findViewById(R.id.First1TV);
        t3 = findViewById(R.id.First2TV);
        price1 = findViewById(R.id.Price1TV);
        price2 = findViewById(R.id.Price2TV);
        elegantNumberButton1=findViewById(R.id.elegant1);
        elegantNumberButton2=findViewById(R.id.elegant2);
        lay1 = findViewById(R.id.layout1);
        lay2 = findViewById(R.id.layout2);


        t1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (first == true) {
                    lay1.setVisibility(View.GONE);
                    lay2.setVisibility(View.GONE);
                    first = false;
                    t1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_down_24, 0);
                } else {
                    lay1.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.VISIBLE);
                    t1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_up_24, 0);
                    first = true;
                }
            }
        });



        //Second Implementation
        t4 = findViewById(R.id.SecondTV);
        t5 = findViewById(R.id.Second1TV);
        t6 = findViewById(R.id.Second2TV);
        price3 = findViewById(R.id.Price3TV);
        price4 = findViewById(R.id.Price4TV);
        elegantNumberButton3=findViewById(R.id.elegant3);
        elegantNumberButton4=findViewById(R.id.elegant4);
        lay3 = findViewById(R.id.layout3);
        lay4 = findViewById(R.id.layout4);


        t4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (second == true) {
                    lay3.setVisibility(View.GONE);
                    lay4.setVisibility(View.GONE);
                    second = false;
                    t4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_down_24, 0);
                } else {
                    lay3.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.VISIBLE);
                    t4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_up_24, 0);
                    second = true;
                }
            }
        });

        //Third Implementation
        t7 = findViewById(R.id.ThirdTV);
        t8 = findViewById(R.id.Third1TV);
        t9 = findViewById(R.id.Third2TV);
        price5 = findViewById(R.id.Price5TV);
        price6 = findViewById(R.id.Price6TV);
        elegantNumberButton5=findViewById(R.id.elegant5);
        elegantNumberButton6=findViewById(R.id.elegant6);
        lay5 = findViewById(R.id.layout5);
        lay6 = findViewById(R.id.layout6);


        t7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (third == true) {
                    lay5.setVisibility(View.GONE);
                    lay6.setVisibility(View.GONE);
                    third = false;
                    t7.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_down_24, 0);
                } else {
                    lay5.setVisibility(View.VISIBLE);
                    lay6.setVisibility(View.VISIBLE);
                    t7.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_up_24, 0);
                    third = true;
                }
            }
        });


        //next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userId=auth.getCurrentUser().getUid();
                DocumentReference dr=firestore.collection("Products").document(userId);

                dr.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            DocumentSnapshot document=task.getResult();
                            if (document.exists()){
                                Toast.makeText(MainActivity.this, "Current Order is in Process,Wait Until it's Delivered", Toast.LENGTH_SHORT).show();
                            }else{


                //name
                pizza1 = t2.getText().toString();
                pizza2 = t3.getText().toString();
                donut1 = t5.getText().toString();
                donut2 = t6.getText().toString();
                sandwitch1 = t8.getText().toString();
                sandwitch2 = t9.getText().toString();

                //quantity
                Quantityp1 = elegantNumberButton1.getNumber();
                Quantityp2 = elegantNumberButton2.getNumber();
                Quantityd1 = elegantNumberButton3.getNumber();
                Quantityd2 = elegantNumberButton4.getNumber();
                Quantitys1 = elegantNumberButton5.getNumber();
                Quantitys2 = elegantNumberButton6.getNumber();


                //Price
                p1 = price1.getText().toString();
                p2 = price2.getText().toString();
                p3 = price3.getText().toString();
                p4 = price4.getText().toString();
                p5 = price5.getText().toString();
                p6 = price6.getText().toString();

                //Total
                pp1 = String.valueOf(Integer.valueOf(Quantityp1) * Integer.valueOf(p1));
                pp2 = String.valueOf(Integer.valueOf(Quantityp2) * Integer.valueOf(p2));
                pd1 = String.valueOf(Integer.valueOf(Quantityd1) * Integer.valueOf(p3));
                pd2 = String.valueOf(Integer.valueOf(Quantityd2) * Integer.valueOf(p4));
                ps1 = String.valueOf(Integer.valueOf(Quantitys1) * Integer.valueOf(p5));
                ps2 = String.valueOf(Integer.valueOf(Quantitys2) * Integer.valueOf(p6));
                grandtotal = String.valueOf(Integer.valueOf(pp1) + Integer.valueOf(pp2) + Integer.valueOf(pd1) + Integer.valueOf(pd2) + Integer.valueOf(ps1) + Integer.valueOf(ps2));


                if (!Quantityp1.equals(quantity) || !Quantityp2.equals(quantity) || !Quantityd1.equals(quantity) || !Quantityd2.equals(quantity) || !Quantitys1.equals(quantity) || !Quantitys2.equals(quantity)) {
                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                    i.putExtra("QP1", Quantityp1);
                    i.putExtra("QP2", Quantityp2);
                    i.putExtra("QD1", Quantityd1);
                    i.putExtra("QD2", Quantityd2);
                    i.putExtra("QS1", Quantitys1);
                    i.putExtra("QS2", Quantitys2);
                    i.putExtra("PriceP1", pp1);
                    i.putExtra("PriceP2", pp2);
                    i.putExtra("PriceD1", pd1);
                    i.putExtra("PriceD2", pd2);
                    i.putExtra("PriceS1", ps1);
                    i.putExtra("PriceS2", ps2);
                    i.putExtra("GrandTotal", grandtotal);
                    startActivity(i);
//                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Please Add Some food items", Toast.LENGTH_SHORT).show();
                }

                            }
                        }
                    }
                });

            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            moveTaskToBack(true);
            finish();
        }
    }
}
