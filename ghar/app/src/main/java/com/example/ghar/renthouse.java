package com.example.ghar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ghar.R;
import com.example.ghar.b1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class renthouse extends AppCompatActivity {
    private static final String FB_DATBASE_PATH="userdetails";
    Button b1,b2,b3,b4,b5,b6,b11,b12,b13,b14,b15,b16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renthouse);
        b11 = (Button) findViewById(R.id.gh1);
        b12 = (Button) findViewById(R.id.gh2);
        b13 = (Button) findViewById(R.id.gh3);
        b14 = (Button) findViewById(R.id.gh4);
        b15 = (Button) findViewById(R.id.gh5);
        b16 = (Button) findViewById(R.id.gh6);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        b3 = (Button) findViewById(R.id.bt3);
        b4 = (Button) findViewById(R.id.bt4);
        b5 = (Button) findViewById(R.id.bt5);
        b6 = (Button) findViewById(R.id.bt6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b1.class));
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b2.class));
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b3.class));
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b4.class));
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b5.class));
            }

        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b6.class));
            }

        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b1.class));
            }

        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b2.class));
            }

        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b3.class));
            }

        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b4.class));
            }

        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b5.class));
            }

        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ghar.b6.class));
            }

        });

    }
}