package com.example.diak.doga;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MasodikActivity extends AppCompatActivity {

    private TextView tv_name;
    private Button btn_nextActivity, btn_nameChange, btn_information,  btn_exit;
    private AlertDialog.Builder alert;

    public static final String preferences = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masodik);
        init();

        SharedPreferences prefs = getSharedPreferences(preferences, MODE_PRIVATE);
        tv_name.setText(prefs.getString("name", null));

        btn_nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHarmadik = new Intent(MasodikActivity.this,HarmadikActivity.class);
                startActivity(goToHarmadik);
                finish();
            }
        });


        btn_nameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNegyedik = new Intent(MasodikActivity.this,NegyedikActivity.class);
                startActivity(goToNegyedik);
                finish();
            }
        });

        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(preferences, MODE_PRIVATE);
                Toast.makeText(MasodikActivity.this, "A neved: " + prefs.getString("name", null), Toast.LENGTH_SHORT).show();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
    }

    private void init(){
        tv_name = (TextView) findViewById(R.id.tv_name);
        btn_nextActivity = (Button) findViewById(R.id.btn_nextActivity);
        btn_nameChange = (Button) findViewById(R.id.btn_nameChange);
        btn_information = (Button) findViewById(R.id.btn_information);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        alert = new AlertDialog.Builder(MasodikActivity.this);
        alert.setMessage("Ki akarsz lépni?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }
}
