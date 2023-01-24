package com.example.musafiradmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText edtflightname,edtflightno,edtfrom,edtto,edtdate,edttravellers;
    Button btnaddflights;
    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);
        edtflightname=findViewById(R.id.edtflightname);
        edtflightno=findViewById(R.id.edtflightno);
        edtdate=findViewById(R.id.edtflightdate);
        edttravellers=findViewById(R.id.edtflighttravellers);
        edtfrom=findViewById(R.id.edtflightfrom);
        edtto=findViewById(R.id.edtflightto);
        db=new DatabaseHelper(this);
        btnaddflights=findViewById(R.id.btnaddflights);
        btnaddflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AddActivity.this);
                builder.setMessage("Do you want to add given flight ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (db.addProduct(edtflightname.getText().toString(),Integer.parseInt(edtflightno.getText().toString()),edtdate.getText().toString(),edtfrom.getText().toString(),edtto.getText().toString(),Integer.parseInt(edttravellers.getText().toString())))
                            Toast.makeText(AddActivity.this, "Added successfully!", Toast.LENGTH_LONG).show();
                       // db.addProduct(edtflightname.getText().toString(),Integer.parseInt(edtflightno.getText().toString()),edtdate.getText().toString(),edtfrom.getText().toString(),edtto.getText().toString(),Integer.parseInt(edttravellers.getText().toString()));
                        else
                            Toast.makeText(AddActivity.this, "Error adding flight", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("Add Flight");
                alertDialog.show();

            }
        });






    }
}
