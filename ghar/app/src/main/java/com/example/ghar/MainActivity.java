package com.example.ghar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b4=(Button)findViewById(R.id.bt4);
        b5=(Button)findViewById(R.id.bt5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),profile.class));
                Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Settings.class));
                Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),renthouse.class));
                Toast.makeText(MainActivity.this, "rent house", Toast.LENGTH_SHORT).show();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),payingguest.class));
                Toast.makeText(MainActivity.this, "pying guest", Toast.LENGTH_SHORT).show();

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),guidance.class));
                Toast.makeText(MainActivity.this, "guidance", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
