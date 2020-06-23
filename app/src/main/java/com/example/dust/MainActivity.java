package com.example.dust;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference myRef;
    private TextView mtxt1,mtxt2,mtxt3;
    private Button mbut;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtxt1 = (TextView) findViewById(R.id.txt1);
        mtxt2 = (TextView) findViewById(R.id.txt2);
        mbut= (Button)findViewById(R.id.but);
//        mtxt3 = (TextView) findViewById(R.id.txt3);

        mbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two = new Intent(getApplicationContext(),
                        Main_twoActivity.class);
                startActivity(two);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map =(Map)dataSnapshot.getValue();

                String measured =String.valueOf(map.get("Measured"));
                mtxt1.setText(measured);

//                String voltage =String.valueOf(map.get("Voltage"));
//                mtxt3.setText(voltage);

                String dust =String.valueOf(map.get("Dust"));
                mtxt2.setText(dust);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
