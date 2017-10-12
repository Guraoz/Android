package com.example.diak.szamologep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //változók létrehozása
    private Button egy,ketto, harom, negy, ot, hat, het, nyolc, kilenc, nulla, egyenlo,osszead, kivon, szoroz, oszt, clear;
    private int elso,masodik,vegeredmeny;
    private int muvelet; //0 = összeadás, 1 = kivonás, 2 = szorzás, 3 = osztás
    private EditText kiiratas;
    private String szam ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //változók össze kapcsolása layoutokon található widgetekkel
        egy = (Button) findViewById(R.id.button_egy);
        ketto = (Button) findViewById(R.id.button_ketto);
        harom = (Button) findViewById(R.id.button_harom);
        negy = (Button) findViewById(R.id.button_negy);
        ot = (Button) findViewById(R.id.button_ot);
        hat = (Button) findViewById(R.id.button_hat);
        het = (Button) findViewById(R.id.button_het);
        nyolc = (Button) findViewById(R.id.button_nyolc);
        kilenc = (Button) findViewById(R.id.button_kilenc);
        nulla = (Button) findViewById(R.id.button_nulla);
        egyenlo = (Button) findViewById(R.id.button_egyenlo);
        osszead = (Button) findViewById(R.id.button_osszeadas);
        kivon = (Button) findViewById(R.id.button_kivonas);
        szoroz = (Button) findViewById(R.id.button_szorzas);
        oszt = (Button) findViewById(R.id.button_osztas);
        kiiratas = (EditText) findViewById(R.id.editText);

        clear = (Button) findViewById(R.id.button_clear);

        //Számok
        egy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam +="1";
                kiiratas.setText(szam);
            }
        });

        ketto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam +="2";
                kiiratas.setText(szam);
            }
        });

        harom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam +="3";
                kiiratas.setText(szam);
            }
        });

        negy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam +="4";
                kiiratas.setText(szam);
            }
        });

        ot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "5";
                kiiratas.setText(szam);
            }
        });

        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "6";
                kiiratas.setText(szam);
            }
        });

        het.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "7";
                kiiratas.setText(szam);
            }
        });

        nyolc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "8";
                kiiratas.setText(szam);
            }
        });

        kilenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "9";
                kiiratas.setText(szam);
            }
        });

        nulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam += "0";
                kiiratas.setText(szam);
            }
        });

        //Művelet gombok
        osszead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!szam.isEmpty()){
                    elso = Integer.parseInt(szam);
                }else{
                    elso = 0;
                }
                muvelet = 0;
                szam = "";
                kiiratas.setText(szam);
            }
        });

        kivon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!szam.isEmpty()){
                    elso = Integer.parseInt(szam);
                }else{
                    elso = 0;
                }
                muvelet = 1;
                szam = "";
                kiiratas.setText(szam);
            }
        });

        szoroz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!szam.isEmpty()){
                    elso = Integer.parseInt(szam);
                }else{
                    elso = 0;
                }
                muvelet = 2;
                szam = "";
                kiiratas.setText(szam);
            }
        });

        oszt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!szam.isEmpty()){
                    elso = Integer.parseInt(szam);
                }else{
                    elso = 0;
                }
                muvelet = 3;
                szam = "";
                kiiratas.setText(szam);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam = "";
                kiiratas.setText(szam);
            }
        });

        egyenlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!szam.isEmpty()){
                    masodik = Integer.parseInt(szam);
                }else{
                    masodik = 0;
                }
                switch (muvelet)
                {
                    //összeadás
                    case 0:
                        vegeredmeny = elso + masodik;
                        kiiratas.setText(elso + "+" + masodik + "=" + vegeredmeny);
                        szam = Integer.toString(vegeredmeny);
                        break;
                    //kivonás
                    case 1:
                        vegeredmeny = elso - masodik;
                        kiiratas.setText(elso + "-" + masodik + "=" + vegeredmeny);
                        szam = Integer.toString(vegeredmeny);
                        break;
                    //szorzás
                    case 2:
                        vegeredmeny = elso * masodik;
                        kiiratas.setText(elso + "*" + masodik + "=" + vegeredmeny);
                        szam = Integer.toString(vegeredmeny);
                        break;
                    //osztás
                    case 3:
                        if (masodik == 0){      //0-val való osztás -> crash
                            masodik = 1;
                        }
                        vegeredmeny = elso / masodik;
                        kiiratas.setText(elso + "/" + masodik + "=" + vegeredmeny);
                        szam = Integer.toString(vegeredmeny);
                        break;
                }
            }
        });
    }
}
