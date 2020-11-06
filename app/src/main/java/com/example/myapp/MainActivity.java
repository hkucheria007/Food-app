package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    ImageView img1,img2,img3,img4;
    EditText e1,e2;
    LinearLayout lay1,lay2;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }
}