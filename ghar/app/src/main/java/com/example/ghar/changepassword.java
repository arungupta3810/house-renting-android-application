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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changepassword extends AppCompatActivity {
    Button b1;
    EditText ed1,ed2;
    FirebaseAuth mAuth;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        ed1=(EditText)findViewById(R.id.edcp);
        ed2=(EditText)findViewById(R.id.edcp1);
        b1=(Button)findViewById(R.id.btcp);
        p=(ProgressBar) findViewById(R.id.pcp);
        mAuth=FirebaseAuth.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    String str = ed1.getText().toString().trim();
                    String str1 = ed2.getText().toString().trim();

                    if (TextUtils.isEmpty(str)) {
                        Toast.makeText(changepassword.this, "please enter the password", Toast.LENGTH_SHORT).show();
                    }

                    if (TextUtils.isEmpty(str1)) {
                        Toast.makeText(changepassword.this, "please enter the confirm password", Toast.LENGTH_SHORT).show();
                    }

                    if (str.length() < 6) {
                        Toast.makeText(changepassword.this, "password too short", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    p.setVisibility(View.VISIBLE);

                    if (str.equals(str1)) {
                        user.updatePassword(ed1.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        p.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            Toast.makeText(changepassword.this, "your password has been changed", Toast.LENGTH_SHORT).show();
                                            mAuth.signOut();
                                            finish();
                                            startActivity(new Intent(changepassword.this, Login.class));
                                        } else {

                                            Toast.makeText(changepassword.this, "password could not be changed !!", Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                });
                    }else{
                        p.setVisibility(View.GONE);
                        Toast.makeText(changepassword.this, "password doesn't match !!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

}
