package com.example.musafiradmin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final EditText edtflightname,edtflightno,edtfrom,edtto,edtdate,edttravellers;
        Button btnupdateflights;
        final DatabaseHelper db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_main);
        edtflightname=findViewById(R.id.edtflight_name);
        edtflightno=findViewById(R.id.edtflight_no);
        edtdate=findViewById(R.id.edtflight_date);
        edttravellers=findViewById(R.id.edtflight_travellers);
        edtfrom=findViewById(R.id.edtflight_from);
        edtto=findViewById(R.id.edtflight_to);
        db=new DatabaseHelper(this);
        btnupdateflights=findViewById(R.id.btnupdateflights);
        btnupdateflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(UpdateActivity.this);
                builder.setMessage("Do you want to udpate given flight ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            if (db.updateStudent(Integer.parseInt(edtflightno.getText().toString()),edtflightname.getText().toString(),edtfrom.getText().toString(),edtto.getText().toString(),edtdate.getText().toString(),Integer.parseInt(edttravellers.getText().toString())))
                                Toast.makeText(UpdateActivity.this, "Updated details successfully!", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(UpdateActivity.this, "Failed to update", Toast.LENGTH_LONG).show();
                             }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("Update Flight");
                alertDialog.show();

            }
        });
    }
}
