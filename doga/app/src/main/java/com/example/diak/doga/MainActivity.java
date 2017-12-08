package com.example.diak.doga;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText et_name;

    public static final String preferences = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(preferences, MODE_PRIVATE).edit();
                editor.putString("name", et_name.getText().toString());
                editor.apply();

                Intent goToMasodik = new Intent(MainActivity.this,MasodikActivity.class);
                startActivity(goToMasodik);
                finish();
            }
        });
    }

    private void init(){
        btn_submit = (Button) findViewById(R.id.btn_submit);
        et_name = (EditText) findViewById(R.id.et_name);
    }
}
