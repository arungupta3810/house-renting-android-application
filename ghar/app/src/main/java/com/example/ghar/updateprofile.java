package com.example.ghar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class updateprofile extends AppCompatActivity {
    private EditText ed1, ed2, ed3;
    private Button b1;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);

        ed1 = (EditText) findViewById(R.id.tsc1);
        ed2 = (EditText) findViewById(R.id.tsc2);
        ed3 = (EditText) findViewById(R.id.tsc3);
        b1 = (Button) findViewById(R.id.bsc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userprofile userprofile = dataSnapshot.getValue(userprofile.class);
                ed1.setText(userprofile.getEml());
                ed2.setText(userprofile.getFn());
                ed3.setText(userprofile.getUn());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(updateprofile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = ed1.getText().toString();
                String username = ed2.getText().toString();
                String email = ed3.getText().toString();
                userprofile userprofile = new userprofile(fullname, username, email);
                databaseReference.setValue(userprofile);
                startActivity(new Intent(updateprofile.this, profile.class));
                Toast.makeText(updateprofile.this, "profile updated", Toast.LENGTH_SHORT).show();
                finish();

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
