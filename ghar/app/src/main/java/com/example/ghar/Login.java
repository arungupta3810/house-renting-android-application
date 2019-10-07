package com.example.ghar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    TextView tv;
    ProgressBar p1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = (EditText) findViewById(R.id.login_email);
        ed2 = (EditText) findViewById(R.id.login_password);
        b1 = (Button) findViewById(R.id.login_b1);
        p1 = (ProgressBar) findViewById(R.id.p_login);
        tv = (TextView) findViewById(R.id.tvf1);

        mAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eml = ed1.getText().toString().trim();
                String pwd = ed2.getText().toString().trim();

                if (TextUtils.isEmpty(eml)) {
                    Toast.makeText(Login.this, "please enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(Login.this, "please enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pwd.length() < 6) {
                    Toast.makeText(Login.this, " please enter the correct password", Toast.LENGTH_SHORT).show();
                    return;
                }

                p1.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(eml, pwd)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                p1.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    Toast.makeText(Login.this, "welcome you are logged in", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this, "user not available or password entered is wrong!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, forgotpssword.class));
                Toast.makeText(Login.this, "", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void btn_signupform(View view) {
        startActivity(new Intent(Login.this, signup.class));
    }
}