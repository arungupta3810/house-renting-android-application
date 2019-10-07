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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1;
    ProgressBar p1;
    private FirebaseAuth mAuth;
    String fn,un,eml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ed1=(EditText)findViewById(R.id.t_fullname);
        ed2=(EditText)findViewById(R.id.t_username);
        ed3=(EditText)findViewById(R.id.t_email);
        ed4=(EditText)findViewById(R.id.t_password);
        ed5=(EditText)findViewById(R.id.t_cpassword);
        b1=(Button) findViewById(R.id.b_register);
        p1=(ProgressBar) findViewById(R.id.p_load);
        mAuth=FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=ed1.getText().toString().trim();
                un=ed2.getText().toString().trim();
                eml=ed3.getText().toString().trim();
                final String pwd=ed4.getText().toString().trim();
                String cpwd=ed5.getText().toString().trim();


                if (TextUtils.isEmpty(fn)){
                    Toast.makeText(signup.this, "plz enter your full name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(un)){
                    Toast.makeText(signup.this, "plz enter your username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(eml)){
                    Toast.makeText(signup.this, "plz enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(signup.this, "plz enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cpwd)){
                    Toast.makeText(signup.this, "plz enter your confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pwd.length()<6){
                    Toast.makeText(signup.this, "password too short", Toast.LENGTH_SHORT).show();
                    return;
                }

                p1.setVisibility(View.VISIBLE);

                if (pwd.equals(cpwd)){

                    mAuth.createUserWithEmailAndPassword(eml, pwd)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    p1.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        senduserdata();
                                        Toast.makeText(signup.this, "signup succeussful", Toast.LENGTH_SHORT).show();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));


                                    } else {

                                        Toast.makeText(signup.this, "account already exists", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });

                }


            }
        });
    }
    private void senduserdata(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myRef=firebaseDatabase.getReference(mAuth.getUid());
        userprofile userprofile=new userprofile(fn,un,eml);
        myRef.setValue(userprofile);
    }
}
