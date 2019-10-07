package com.example.ghar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

import java.io.IOException;

public class profile extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private Button b1;
    private ImageView i1;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE=123;
    Uri ImagePath;
    private StorageReference storageReference;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode ==PICK_IMAGE && resultCode==RESULT_OK && data.getData() != null){
            ImagePath=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),ImagePath);
                i1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tv1=(TextView)findViewById(R.id.edp1);
        tv2=(TextView)findViewById(R.id.edp2);
        tv3=(TextView)findViewById(R.id.edp3);
        b1=(Button)findViewById(R.id.bp);
        i1=(ImageView) findViewById(R.id.ip);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();

        storageReference=firebaseStorage.getReference();

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"select image"),PICK_IMAGE);
            }
        });



        DatabaseReference databaseReference=firebaseDatabase.getReference(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userprofile userprofile=dataSnapshot.getValue(userprofile.class);
                tv3.setText("Email:" + userprofile.getEml());
                tv1.setText("Name:" + userprofile.getFn());
                tv2.setText("username:" + userprofile.getUn());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this,updateprofile.class));
                Toast.makeText(profile.this, "update profile", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    //
    public void senduserpic() {
        StorageReference imgerefrece = storageReference.child(mAuth.getUid()).child("Images").child("profile pic");
        UploadTask uploadTask = imgerefrece.putFile(ImagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(profile.this, "upload failed!!", Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(profile.this, "upload successful", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void btn_update(View view) {
        startActivity(new Intent(getApplicationContext(),updateprofile.class));
    }
}
