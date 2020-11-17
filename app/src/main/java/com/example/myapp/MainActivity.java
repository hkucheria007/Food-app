package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //First
    TextView t1,t2,t3;
    ImageView img1,img2,img3,img4;
    TextView e1,e2;
    LinearLayout lay1,lay2;

    //Second
    TextView t4,t5,t6;
    ImageView img5,img6,img7,img8;
    TextView e3,e4;
    LinearLayout lay3,lay4;

    //Third
    TextView t7,t8,t9;
    ImageView img9,img10,img11,img12;
    TextView e5,e6;
    LinearLayout lay5,lay6;


    int count=0;
    boolean first=true,second=true,third=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //First Implementation
        t1=findViewById(R.id.FirstTV);
        t2=findViewById(R.id.First1TV);
        t3=findViewById(R.id.First2TV);


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



    }
}