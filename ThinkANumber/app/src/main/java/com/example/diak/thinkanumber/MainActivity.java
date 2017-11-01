package com.example.diak.thinkanumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_negative, btn_submit;
    private TextView number;
    private ImageView imgV_1, imgV_2, imgV_3, imgV_4, imgV_5;
    private int kitalalando_szam, tippelt_szam;
    private int eletekSzama;

    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        startGame();
    }

    //START GAME
    private void startGame(){
        Random rnd = new Random();

        eletekSzama = 5;
        tippelt_szam = 0;
        number.setText(Integer.toString(tippelt_szam));
        kitalalando_szam = rnd.nextInt(50)+1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam<50){
                    tippelt_szam++;
                }
                number.setText(Integer.toString(tippelt_szam));
            }
        });

        btn_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam>0){
                    tippelt_szam--;
                }
                number.setText(Integer.toString(tippelt_szam));
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam > kitalalando_szam){
                    eletekSzama--;
                    eletHUD();
                    Toast.makeText(MainActivity.this, "Lejjebb", Toast.LENGTH_SHORT).show();
                } else if (tippelt_szam < kitalalando_szam){
                    eletekSzama--;
                    eletHUD();
                    Toast.makeText(MainActivity.this, "Feljebb", Toast.LENGTH_SHORT).show();
                }
                alertPopup();
            }
        });
    }

    private void alertPopup(){
        if (tippelt_szam == kitalalando_szam){
            alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Gratulálok nyertél!")         //Cím adás
                    .setMessage("Újra akarod kezdeni a játékot?")       //Kérdés amit felteszünk.
                    .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            finish();
                        }
                    })
                    .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            eletHUDReset();
                            startGame();
                        }
                    })
                    .setCancelable(false)   //Ezzel azt csináljuk, hogy nem lehet kikattintani a dialog boxból.
                    .create();           //Létrehozzuk
            alert.show();   //Megjelenítés
        }else if (eletekSzama <= 0) {
            alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Vesztettél!")
                    .setMessage("Újra akarod kezdeni a játékot?")
                    .setPositiveButton("Nem", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            finish();
                        }
                    })
                    .setNegativeButton("Igen", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            eletHUDReset();
                            startGame();
                        }
                    })
                    .setCancelable(false)
                    .create();
            alert.show();
        }
    }

    private void eletHUDReset(){
        imgV_1.setBackgroundResource(R.drawable.heart2);
        imgV_2.setBackgroundResource(R.drawable.heart2);
        imgV_3.setBackgroundResource(R.drawable.heart2);
        imgV_4.setBackgroundResource(R.drawable.heart2);
        imgV_5.setBackgroundResource(R.drawable.heart2);
    }

    private void eletHUD(){
        switch (eletekSzama){
            case 0: imgV_1.setBackgroundResource(R.drawable.heart1);
                break;
            case 1: imgV_2.setBackgroundResource(R.drawable.heart1);
                break;
            case 2: imgV_3.setBackgroundResource(R.drawable.heart1);
                break;
            case 3: imgV_4.setBackgroundResource(R.drawable.heart1);
                break;
            case 4: imgV_5.setBackgroundResource(R.drawable.heart1);
                break;
        }
    }

    //INIT
    private void init(){

        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_negative = (Button) findViewById(R.id.btn_negative);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        number = (TextView) findViewById(R.id.textView_szam);
        imgV_1 = (ImageView) findViewById(R.id.imageView_elet1);
        imgV_2 = (ImageView) findViewById(R.id.imageView_elet2);
        imgV_3 = (ImageView) findViewById(R.id.imageView_elet3);
        imgV_4 = (ImageView) findViewById(R.id.imageView_elet4);
        imgV_5 = (ImageView) findViewById(R.id.imageView_elet5);

    }
}
