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

public class DeleteActivity extends AppCompatActivity {

    EditText edtflightno;
    Button btndelete;
    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_main);
        edtflightno=findViewById(R.id.edtflightno);
        btndelete=findViewById(R.id.btndelete);
        db=new DatabaseHelper(this);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DeleteActivity.this);
                builder.setMessage("Do you want to delete given flight ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    if(db.deleteFlights(Integer.parseInt(edtflightno.getText().toString())))
                        Toast.makeText(DeleteActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        else
                        Toast.makeText(DeleteActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("Delete Flight");
                alertDialog.show();

            }
        });
    }
}
