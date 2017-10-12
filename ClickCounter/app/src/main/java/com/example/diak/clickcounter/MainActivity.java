package com.example.diak.clickcounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button plus, minus, reset;
    private TextView tV;
    private int szam = 0;
    private int kattintasokSzama = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plus = (Button) findViewById(R.id.button_plus);
        minus = (Button) findViewById(R.id.button_minus);
        reset = (Button) findViewById(R.id.button_reset);
        tV = (TextView) findViewById(R.id.textView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam++;
                kattintasokSzama++;
                if(kattintasokSzama == 20){
                    Toast.makeText(MainActivity.this, "Bob", Toast.LENGTH_LONG).show();
                }
                tV.setText(Integer.toString(szam));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam--;
                kattintasokSzama++;
                if(kattintasokSzama == 20){
                    Toast.makeText(MainActivity.this, "Bob", Toast.LENGTH_LONG).show();
                }
                tV.setText(Integer.toString(szam));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam = 0;
                tV.setText(Integer.toString(szam));
            }
        });





    }

}
