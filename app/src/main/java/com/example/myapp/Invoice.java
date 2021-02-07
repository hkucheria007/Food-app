package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Invoice extends AppCompatActivity {

    TextView billheading,itemtotal,itemamount,deliveryfee,deliveryamount,topay,payamount;
    TextView piz1,piz2,do1,do2,san1,san2,qpiz1,qpiz2,qdo1,qdo2,qsan1,qsan2;
    TextView prip1,prip2,prid1,prid2,pris1,pris2;
    ImageView i1,i2,i3,i4,i5,i6;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    String userId,quantity="0";
    Button place;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        toolbar=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        //Item TextView
        piz1=findViewById(R.id.p1);
        piz2=findViewById(R.id.p2);
        do1=findViewById(R.id.d1);
        do2=findViewById(R.id.d2);
        san1=findViewById(R.id.s1);
        san2=findViewById(R.id.s2);

        //Quantity TextView
        qpiz1=findViewById(R.id.qp1);
        qpiz2=findViewById(R.id.qp2);
        qdo1=findViewById(R.id.qd1);
        qdo2=findViewById(R.id.qd2);
        qsan1=findViewById(R.id.qs1);
        qsan2=findViewById(R.id.qs2);

        //Price TextView
        prip1=findViewById(R.id.priceP1);
        prip2=findViewById(R.id.priceP2);
        prid1=findViewById(R.id.priceD1);
        prid2=findViewById(R.id.priceD2);
        pris1=findViewById(R.id.priceS1);
        pris2=findViewById(R.id.priceS2);

        //Veg ImageView
        i1=findViewById(R.id.vegimage1);
        i2=findViewById(R.id.vegimage2);
        i3=findViewById(R.id.vegimage3);
        i4=findViewById(R.id.vegimage4);
        i5=findViewById(R.id.vegimage5);
        i6=findViewById(R.id.vegimage6);

        //Buuton
        place=findViewById(R.id.Order);

        //Bill TextView
        billheading=findViewById(R.id.BillHead);
        itemtotal=findViewById(R.id.ItemTotal);
        itemamount=findViewById(R.id.ItemAmount);
        deliveryfee=findViewById(R.id.DeliveryFee);
        deliveryamount=findViewById(R.id.DeliveryAmount);
        topay=findViewById(R.id.Pay);
        payamount=findViewById(R.id.PayAmount);

        Bundle b=getIntent().getExtras();
        String qp1=b.getString("QP1");
        String qp2=b.getString("QP2");
        String qd1=b.getString("QD1");
        String qd2=b.getString("QD2");
        String qs1=b.getString("QS1");
        String qs2=b.getString("QS2");
        String pp1=b.getString("PriceP1");
        String pp2=b.getString("PriceP2");
        String pd1=b.getString("PriceD1");
        String pd2=b.getString("PriceD2");
        String ps1=b.getString("PriceS1");
        String ps2=b.getString("PriceS2");

        String grandtotal=b.getString("GrandTotal");
        String tax="20";
        String totalPay=String.valueOf(Integer.valueOf(grandtotal)+Integer.valueOf(tax));

        itemamount.setText(grandtotal);
        deliveryamount.setText(tax);
        payamount.setText(totalPay);

        Toast.makeText(this, grandtotal, Toast.LENGTH_SHORT).show();

        String first=getIntent().getStringExtra("First");
        String last=getIntent().getStringExtra("Last");
        String number=getIntent().getStringExtra("Mobile");
        String address1=getIntent().getStringExtra("Add1");
        String address2=getIntent().getStringExtra("Add2");
        String address3=getIntent().getStringExtra("Add3");
        String city=getIntent().getStringExtra("City");
        String pincode=getIntent().getStringExtra("Pincode");

        //pizza1 quantity check
        if(!qp1.equals(quantity)){
            i1.setVisibility(View.VISIBLE);
            qpiz1.setVisibility(View.VISIBLE);
            piz1.setVisibility(View.VISIBLE);
            prip1.setVisibility(View.VISIBLE);
            qpiz1.setText(qp1);
            prip1.setText(pp1);
        }else {
            i1.setVisibility(View.GONE);
            qpiz1.setVisibility(View.GONE);
            piz1.setVisibility(View.GONE);
            prip1.setVisibility(View.GONE);
        }

        //pizza2 quantity check
        if(!qp2.equals(quantity)){
            i2.setVisibility(View.VISIBLE);
            qpiz2.setVisibility(View.VISIBLE);
            piz2.setVisibility(View.VISIBLE);
            prip2.setVisibility(View.VISIBLE);
            qpiz2.setText(qp2);
            prip2.setText(pp2);
        }else {
            i2.setVisibility(View.GONE);
            qpiz2.setVisibility(View.GONE);
            piz2.setVisibility(View.GONE);
            prip2.setVisibility(View.GONE);
        }

        //Donut1 quantity check
        if(!qd1.equals(quantity)){
            i3.setVisibility(View.VISIBLE);
            qdo1.setVisibility(View.VISIBLE);
            do1.setVisibility(View.VISIBLE);
            prid1.setVisibility(View.VISIBLE);
            qdo1.setText(qd1);
            prid1.setText(pd1);
        }else {
            i3.setVisibility(View.GONE);
            qdo1.setVisibility(View.GONE);
            do1.setVisibility(View.GONE);
            prid1.setVisibility(View.GONE);
        }


        if(!qd2.equals(quantity)){
            i4.setVisibility(View.VISIBLE);
            qdo2.setVisibility(View.VISIBLE);
            do2.setVisibility(View.VISIBLE);
            prid2.setVisibility(View.VISIBLE);
            qdo2.setText(qd2);
            prid2.setText(pd2);
        }else {
            i4.setVisibility(View.GONE);
            qdo2.setVisibility(View.GONE);
            do2.setVisibility(View.GONE);
            prid2.setVisibility(View.GONE);
        }


        if(!qs1.equals(quantity)){
            i5.setVisibility(View.VISIBLE);
            qsan1.setVisibility(View.VISIBLE);
            san1.setVisibility(View.VISIBLE);
            pris1.setVisibility(View.VISIBLE);
            qsan1.setText(qs1);
            pris1.setText(ps1);
        }else {
            i5.setVisibility(View.GONE);
            qsan1.setVisibility(View.GONE);
            san1.setVisibility(View.GONE);
            pris1.setVisibility(View.GONE);
        }


        if(!qs2.equals(quantity)){
            i6.setVisibility(View.VISIBLE);
            qsan2.setVisibility(View.VISIBLE);
            san2.setVisibility(View.VISIBLE);
            pris2.setVisibility(View.VISIBLE);
            qsan2.setText(qs2);
            pris2.setText(ps2);
        }else {
            i6.setVisibility(View.GONE);
            qsan2.setVisibility(View.GONE);
            san2.setVisibility(View.GONE);
            pris2.setVisibility(View.GONE);
        }

                //place order button
                place.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userId=auth.getCurrentUser().getUid();

                        //Product Storage
                        DocumentReference dr=firestore.collection("Products").document(userId);
                        Map<String,Object> user=new HashMap<>();

                        user.put("Pizza1",qp1);
                        user.put("Pizza2",qp2);
                        user.put("Donut1",qd1);
                        user.put("Donut2",qd2);
                        user.put("Sandwitch1",qs1);
                        user.put("Sandwitch2",qs2);
                        user.put("Total",totalPay);

                        dr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Invoice.this, "Updated", Toast.LENGTH_SHORT).show();
//                        Intent i=new Intent(Invoice.this,MainActivity.class);
//                        startActivity(i);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Invoice.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                        //Customer Details Storage
                        DocumentReference dr1=firestore.collection("CustomerDetails").document(userId);
                Map<String,Object> user1=new HashMap<>();
                user1.put("FirstName",first);
                user1.put("LastName",last);
                user1.put("Mobile",number);
                user1.put("Address1",address1);
                user1.put("Address2",address2);
                user1.put("Address3",address3);
                user1.put("City",city);
                user1.put("Pincode",pincode);
                user1.put("ID",userId);

                dr1.set(user1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Invoice.this, "Database Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Invoice.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                        Toast.makeText(Invoice.this, "Order Placed", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Invoice.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Invoice.this,DetailsActivity.class));
        finish();
    }
}