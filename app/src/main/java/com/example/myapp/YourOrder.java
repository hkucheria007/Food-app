package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class YourOrder extends AppCompatActivity {

    CardView cardView;
    TextView namehotel,locationhotel,pricehotel,itemhead,itemdetails;
    TextView nocurrentorder,activityheading;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    String userId;
    String qp1,qp2,qd1,qd2,qs1,qs2,price;
    String a="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);

        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        cardView=findViewById(R.id.cardviewYourOrder);
        namehotel=findViewById(R.id.HotelName);
        locationhotel=findViewById(R.id.AddressHotel);
        pricehotel=findViewById(R.id.PriceHotel);
        itemhead=findViewById(R.id.itemsHeading);
        itemdetails=findViewById(R.id.itemsDetails);
        nocurrentorder=findViewById(R.id.NoCurrentOrder);
        activityheading=findViewById(R.id.headingYourOrder);

        //data retrieve
        userId=auth.getCurrentUser().getUid();
        DocumentReference dr=firestore.collection("Products").document(userId);

        dr.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document=task.getResult();
                    if (document.exists()){

//                      nocurrentorder.setVisibility(View.GONE);
                        cardView.setVisibility(View.VISIBLE);
                        activityheading.setVisibility(View.VISIBLE);

                        dr.addSnapshotListener(YourOrder.this, new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                                qp1=value.getString("Pizza1");
                                qp2=value.getString("Pizza2");
                                qd1=value.getString("Donut1");
                                qd2=value.getString("Donut2");
                                qs1=value.getString("Sandwitch1");
                                qs2=value.getString("Sandwitch2");
                                price=value.getString("Total");

                                //Validation
                                if (!qp1.equals(a)){
                                    qp1=qp1+" "+"X "+"Pizza1,";
                                }else{
                                    qp1="";
                                }

                                if (!qp2.equals(a)){
                                    qp2=qp2+" "+"X "+"Pizza2,";
                                }else{
                                    qp2="";
                                }

                                if (!qd1.equals(a)){
                                    qd1=qd1+" "+"X "+"Donut1,";
                                }else{
                                    qd1="";
                                }

                                if (!qd2.equals(a)){
                                    qd2=qd2+" "+"X "+"Donut2,";
                                }else{
                                    qd2="";
                                }

                                if (!qs1.equals(a)){
                                    qs1=qs1+" "+"X "+"Sandwitch1,";
                                }else{
                                    qs1="";
                                }

                                if (!qs2.equals(a)){
                                    qs2=qs2+" "+"X "+"Sandwitch2,";
                                }else{
                                    qs2="";
                                }

                                //set TextView
                                itemdetails.setText(qp1+qp2+qd1+qd2+qs1+qs2);
                                pricehotel.setText(price);
                            }
                        });


                    }else {
//                        cardView.setVisibility(View.GONE);
//                        activityheading.setVisibility(View.GONE);
                        nocurrentorder.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(YourOrder.this,MainActivity.class));
        finish();
    }
}