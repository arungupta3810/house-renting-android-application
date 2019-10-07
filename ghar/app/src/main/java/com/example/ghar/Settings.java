package com.example.ghar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Settings extends AppCompatActivity {
    Button logout, chpwd, de;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = (Button) findViewById(R.id.b_logout);
        chpwd = (Button) findViewById(R.id.b_chpwd);
        de = (Button) findViewById(R.id.b_deact);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Settings.this, "you are logged out successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Settings.this, Login.class);
                startActivity(i);
            }
        });

        chpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Settings.this, changepassword.class));
            }
        });

        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account Deactivated", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(Settings.this, Login.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Account could not be Deactivated", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}