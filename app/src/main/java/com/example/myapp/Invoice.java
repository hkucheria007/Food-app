package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    TextView piz1,piz2,do1,do2,san1,san2,qpiz1,qpiz2,qdo1,qdo2,qsan1,qsan2;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    String userId;
    Button place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        piz1=findViewById(R.id.p1);
        piz2=findViewById(R.id.p2);
        do1=findViewById(R.id.d1);
        do2=findViewById(R.id.d2);
        san1=findViewById(R.id.s1);
        san2=findViewById(R.id.s2);

        qpiz1=findViewById(R.id.qp1);
        qpiz2=findViewById(R.id.qp2);
        qdo1=findViewById(R.id.qd1);
        qdo2=findViewById(R.id.qd2);
        qsan1=findViewById(R.id.qs1);
        qsan2=findViewById(R.id.qs2);

        place=findViewById(R.id.Order);

        Bundle b=getIntent().getExtras();
        String qp1=b.getString("QP1");
        String qp2=b.getString("QP2");
        String qd1=b.getString("QD1");
        String qd2=b.getString("QD2");
        String qs1=b.getString("QS1");
        String qs2=b.getString("QS2");

        String first=getIntent().getStringExtra("First");
        String last=getIntent().getStringExtra("Last");
        String number=getIntent().getStringExtra("Mobile");
        String address1=getIntent().getStringExtra("Add1");
        String address2=getIntent().getStringExtra("Add2");
        String address3=getIntent().getStringExtra("Add3");
        String city=getIntent().getStringExtra("City");
        String pincode=getIntent().getStringExtra("Pincode");


                qpiz1.setText("x"+qp1);
                qpiz2.setText("x"+qp2);
                qdo1.setText("x"+qd1);
                qdo2.setText("x"+qd2);
                qsan1.setText("x"+qs1);
                qsan2.setText("x"+qs2);


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

                        dr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Invoice.this, "Updated", Toast.LENGTH_SHORT).show();
//                        Intent i=new Intent(MainActivity.this,DetailsActivity.class);
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

                dr1.set(user1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Invoice.this, "Database Updated", Toast.LENGTH_SHORT).show();
//                        Intent i=new Intent(DetailsActivity.this,Invoice.class);
//                        startActivity(i);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Invoice.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                        Toast.makeText(Invoice.this, "Order Placed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}