package com.example.ghar;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class guidance extends AppCompatActivity {

    VideoView r,s;
    Button b1,b2;
    MediaController mediaController,mediaController1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaController=new MediaController(this);
        setContentView(R.layout.activity_guidance);
        r=(VideoView)findViewById(R.id.v1);
        s=(VideoView)findViewById(R.id.v2);
        mediaController1=new MediaController(this);
        mediaController=new MediaController(this);
        b1=(Button)findViewById(R.id.g1);
        b2=(Button)findViewById(R.id.g2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Videopaths="android.resource://com.example.ghar/" +R.raw.r;
                Uri uri=Uri.parse(Videopaths);
                r.setVideoURI(uri);
                r.setMediaController(mediaController);
                mediaController.setAnchorView(r);
                r.start();


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Videopath="android.resource://com.example.ghar/" +R.raw.tips;
                Uri uri1=Uri.parse(Videopath);
                s.setVideoURI(uri1);
                s.setMediaController(mediaController1);
                mediaController1.setAnchorView(s);
                s.start();


            }
        });


    }

}
