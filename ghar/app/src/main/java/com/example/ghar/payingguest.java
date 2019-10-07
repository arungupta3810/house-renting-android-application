package com.example.ghar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class payingguest extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
   private TextView t1,t2,t3;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_payingguest);
            t1=(TextView) findViewById(R.id.nme);
            t2=(TextView) findViewById(R.id.mob);
            t3=(TextView) findViewById(R.id.age);
            b1=(Button) findViewById(R.id.proceed);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  openDialog();
                }
            });
        } }
        public void openDialog(){
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
        }

    @Override
    public void applyTexts(String name, int mob, int age) {
        t1.setText(name);
        t2.setText(mob);
        t3.setText(age);
    }
}
