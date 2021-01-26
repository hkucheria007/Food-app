package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //First
    TextView t1,t2,t3,price1,price2;
    ImageView img1,img2,img3,img4;
    TextView e1,e2;
    LinearLayout lay1,lay2;

    //Second
    TextView t4,t5,t6,price3,price4;
    ImageView img5,img6,img7,img8;
    TextView e3,e4;
    LinearLayout lay3,lay4;

    //Third
    TextView t7,t8,t9,price5,price6;
    ImageView img9,img10,img11,img12;
    TextView e5,e6;
    LinearLayout lay5,lay6;

    //Button
    Button next,logout;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    String userId;
    String pizza1,pizza2,donut1,donut2,sandwitch1,sandwitch2;
    String Quantityp1,Quantityp2,Quantityd1,Quantityd2,Quantitys1,Quantitys2;
    String p1,p2,p3,p4,p5,p6;
    String pp1,pp2,pd1,pd2,ps1,ps2,grandtotal;

    int count=0;
    boolean first=true,second=true,third=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Implementation
        next=findViewById(R.id.button);
        logout=findViewById(R.id.logout);
        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        //First Implementation
        t1=findViewById(R.id.FirstTV);
        t2=findViewById(R.id.First1TV);
        t3=findViewById(R.id.First2TV);
        price1=findViewById(R.id.Price1TV);
        price2=findViewById(R.id.Price2TV);


        img1=findViewById(R.id.imageView1);
        img2=findViewById(R.id.imageView2);
        img3=findViewById(R.id.imageView3);
        img4=findViewById(R.id.imageView4);

        e1=findViewById(R.id.editTextQuantity1);
        e2=findViewById(R.id.editTextQuantity2);

        lay1=findViewById(R.id.layout1);
        lay2=findViewById(R.id.layout2);


        t1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (first== true) {
                    lay1.setVisibility(View.GONE);
                    lay2.setVisibility(View.GONE);
                    first=false;
                    t1.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_down_24,0);
                }
                else {
                    lay1.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.VISIBLE);
                    t1.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_up_24,0);
                    first=true;
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e1.getText().toString());
                count=count+1;
                e1.setText(Integer.toString(count));
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e1.getText().toString());
                if(count!=0){
                    count=count-1;
                    e1.setText(Integer.toString(count));
                }
                else{
                    e1.setText("0");
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e2.getText().toString());
                count=count+1;
                e2.setText(Integer.toString(count));
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e2.getText().toString());
                if(count!=0){
                    count=count-1;
                    e2.setText(Integer.toString(count));
                }
                else{
                    e2.setText("0");
                }
            }
        });


        //Second Implementation
        t4=findViewById(R.id.SecondTV);
        t5=findViewById(R.id.Second1TV);
        t6=findViewById(R.id.Second2TV);
        price3=findViewById(R.id.Price3TV);
        price4=findViewById(R.id.Price4TV);


        img5=findViewById(R.id.imageView5);
        img6=findViewById(R.id.imageView6);
        img7=findViewById(R.id.imageView7);
        img8=findViewById(R.id.imageView8);

        e3=findViewById(R.id.editTextSecondQuantity1);
        e4=findViewById(R.id.editTextSecondQuantity2);

        lay3=findViewById(R.id.layout3);
        lay4=findViewById(R.id.layout4);


        t4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (second== true) {
                    lay3.setVisibility(View.GONE);
                    lay4.setVisibility(View.GONE);
                    second=false;
                    t4.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_down_24,0);
                }
                else {
                    lay3.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.VISIBLE);
                    t4.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_up_24,0);
                    second=true;
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e3.getText().toString());
                count=count+1;
                e3.setText(Integer.toString(count));
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e3.getText().toString());
                if(count!=0){
                    count=count-1;
                    e3.setText(Integer.toString(count));
                }
                else{
                    e3.setText("0");
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e4.getText().toString());
                count=count+1;
                e4.setText(Integer.toString(count));
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e4.getText().toString());
                if(count!=0){
                    count=count-1;
                    e4.setText(Integer.toString(count));
                }
                else{
                    e4.setText("0");
                }
            }
        });



        //Third Implementation
        //Second Implementation
        t7=findViewById(R.id.ThirdTV);
        t8=findViewById(R.id.Third1TV);
        t9=findViewById(R.id.Third2TV);
        price5=findViewById(R.id.Price5TV);
        price6=findViewById(R.id.Price6TV);

        img9=findViewById(R.id.imageView9);
        img10=findViewById(R.id.imageView10);
        img11=findViewById(R.id.imageView11);
        img12=findViewById(R.id.imageView12);

        e5=findViewById(R.id.editTextThirdQuantity1);
        e6=findViewById(R.id.editTextThirdQuantity2);

        lay5=findViewById(R.id.layout5);
        lay6=findViewById(R.id.layout6);


        t7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                if (third== true) {
                    lay5.setVisibility(View.GONE);
                    lay6.setVisibility(View.GONE);
                    third=false;
                    t7.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_down_24,0);
                }
                else {
                    lay5.setVisibility(View.VISIBLE);
                    lay6.setVisibility(View.VISIBLE);
                    t7.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_arrow_drop_up_24,0);
                    third=true;
                }
            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e5.getText().toString());
                count=count+1;
                e5.setText(Integer.toString(count));
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e5.getText().toString());
                if(count!=0){
                    count=count-1;
                    e5.setText(Integer.toString(count));
                }
                else{
                    e5.setText("0");
                }
            }
        });

        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e6.getText().toString());
                count=count+1;
                e6.setText(Integer.toString(count));
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= Integer.parseInt(e6.getText().toString());
                if(count!=0){
                    count=count-1;
                    e6.setText(Integer.toString(count));
                }
                else{
                    e6.setText("0");
                }
            }
        });

        //logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               auth.signOut();
               if(auth.getCurrentUser()==null){
                   startActivity(new Intent(MainActivity.this,LoginActivity.class));
                   finish();
               }
            }
        });

        //next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //name
                pizza1=t2.getText().toString();
                pizza2=t3.getText().toString();
                donut1=t5.getText().toString();
                donut2=t6.getText().toString();
                sandwitch1=t8.getText().toString();
                sandwitch2=t9.getText().toString();

                //quantity
                Quantityp1=e1.getText().toString();
                Quantityp2=e2.getText().toString();
                Quantityd1=e3.getText().toString();
                Quantityd2=e4.getText().toString();
                Quantitys1=e5.getText().toString();
                Quantitys2=e6.getText().toString();

                //Price
                p1=price1.getText().toString();
                p2=price2.getText().toString();
                p3=price3.getText().toString();
                p4=price4.getText().toString();
                p5=price5.getText().toString();
                p6=price6.getText().toString();

                //Total
                pp1=String.valueOf(Integer.valueOf(Quantityp1)*Integer.valueOf(p1));
                pp2=String.valueOf(Integer.valueOf(Quantityp2)*Integer.valueOf(p2));
                pd1=String.valueOf(Integer.valueOf(Quantityd1)*Integer.valueOf(p3));
                pd2=String.valueOf(Integer.valueOf(Quantityd2)*Integer.valueOf(p4));
                ps1=String.valueOf(Integer.valueOf(Quantitys1)*Integer.valueOf(p5));
                ps2=String.valueOf(Integer.valueOf(Quantitys2)*Integer.valueOf(p6));
                grandtotal=String.valueOf(Integer.valueOf(pp1)+Integer.valueOf(pp2)+Integer.valueOf(pd1)+Integer.valueOf(pd2)+Integer.valueOf(ps1)+Integer.valueOf(ps2));

                Intent i=new Intent(MainActivity.this,DetailsActivity.class);
                i.putExtra("QP1",Quantityp1);
                i.putExtra("QP2",Quantityp2);
                i.putExtra("QD1",Quantityd1);
                i.putExtra("QD2",Quantityd2);
                i.putExtra("QS1",Quantitys1);
                i.putExtra("QS2",Quantitys2);
                i.putExtra("PriceP1",pp1);
                i.putExtra("PriceP2",pp2);
                i.putExtra("PriceD1",pd1);
                i.putExtra("PriceD2",pd2);
                i.putExtra("PriceS1",ps1);
                i.putExtra("PriceS2",ps2);
                i.putExtra("GrandTotal",grandtotal);
                startActivity(i);
                finish();
            }
     });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        finish();
    }
}
