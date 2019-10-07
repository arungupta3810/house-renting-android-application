package com.example.ghar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText t1,t2,t3;
    private ExampleDialogListener Listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("add paying guest")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String name =t1.getText().toString();
                        int mob = Integer.parseInt(t2.getText().toString());
                        int age = Integer.parseInt(t3.getText().toString());
                        Listener.applyTexts(name,mob,age);

                    }
                });
        t1=view.findViewById(R.id.nme);
        t2=view.findViewById(R.id.mob);
        t3=view.findViewById(R.id.age);

        return  builder.create();


    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            Listener=(ExampleDialogListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() +"must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String name,int mob,int age);

    }
}
