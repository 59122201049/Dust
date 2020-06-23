package com.example.dust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_twoActivity extends AppCompatActivity {
    private Button bbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        bbut= (Button) findViewById(R.id.dbut);

        bbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent one = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(one);
            }
        });

    }
}
