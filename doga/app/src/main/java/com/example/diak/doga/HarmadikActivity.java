package com.example.diak.doga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HarmadikActivity extends AppCompatActivity {

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmadik);
        init();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMasodik = new Intent(HarmadikActivity.this,MasodikActivity.class);
                startActivity(goToMasodik);
                finish();
            }
        });
    }

    private void init(){
        btn_back = (Button) findViewById(R.id.btn_back);
    }
}
