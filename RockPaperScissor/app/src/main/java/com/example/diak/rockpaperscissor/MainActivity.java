package com.example.diak.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_ko, btn_papir, btn_ollo;
    private TextView textView_eredmeny, textView_ember, textView_robot;
    private ImageView imageView_ember, imageView_robot;
    private int ember_pont = 0;
    private int robot_pont = 0;

    private int ember;
    private int robot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ko = (Button) findViewById(R.id.btn_ko);
        btn_papir = (Button) findViewById(R.id.btn_papir);
        btn_ollo = (Button) findViewById(R.id.btn_ollo);

        textView_eredmeny = (TextView) findViewById(R.id.textView_eredmeny);

        imageView_ember = (ImageView) findViewById(R.id.imageView_ember);
        imageView_robot = (ImageView) findViewById(R.id.imageView_robot);

        btn_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_ember.setBackgroundResource(R.drawable.rock);
                ember = 0;
                play();
            }
        });

        btn_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_ember.setBackgroundResource(R.drawable.paper);
                ember = 1;
                play();
            }
        });

        btn_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_ember.setBackgroundResource(R.drawable.scissors);
                ember = 2;
                play();
            }
        });
    }

    private void play(){
        Random rnd = new Random();
        int random = rnd.nextInt(3);

        switch (random){
            case 0:
                robot = 0;
                imageView_robot.setBackgroundResource(R.drawable.rock);
                break;
            case 1:
                robot = 1;
                imageView_robot.setBackgroundResource(R.drawable.paper);
                break;
            case 2:
                robot = 2;
                imageView_robot.setBackgroundResource(R.drawable.scissors);
                break;
        }

        if (ember == 0 && robot == 2 || ember == 1 && robot == 0 || ember == 2 && robot == 1){
            ember_pont++;
            Toast.makeText(this, "777 go casino!", Toast.LENGTH_SHORT).show();
        }else if (ember == robot){
            switch (ember){
                case 0:
                    Toast.makeText(this, "Fist bump!", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(this, "High five!", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "18+", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "I'm out of memes, help!", Toast.LENGTH_SHORT).show();
                    break;
            }

        }else{
            Toast.makeText(this, "Mission Failed, we'll get em next time!", Toast.LENGTH_SHORT).show();
            robot_pont++;
        }

        textView_eredmeny.setText(ember_pont + ":" + robot_pont);

    }


}
