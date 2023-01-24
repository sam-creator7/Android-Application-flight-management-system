package com.example.musafiradmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    EditText edtlogin,edtpass;
    Button btnlogin,btnsignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtlogin=findViewById(R.id.edtuserid);
        edtpass=findViewById(R.id.edtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        btnsignup=findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUpActivity.class);
                startActivityForResult(i,1);
            }
        });


    }
    protected void onActivityResult ( int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            final String firstname = data.getStringExtra("firstname");
            final String lastname = data.getStringExtra("lastname");
            final String email2 = data.getStringExtra("email");
            final String password = data.getStringExtra("password");
            edtlogin.setText(email2);
            edtpass.setText(password);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email1 = edtlogin.getText().toString();
                    String pass = edtpass.getText().toString();
                    if (email1.equals(email2) && pass.equals(password)) {
                        Intent expin3 = new Intent(MainActivity.this, MainActivity1.class);
                        expin3.putExtra("fn", firstname);
                        expin3.putExtra("ln", lastname);
                        setResult(RESULT_OK);
                        startActivity(expin3);

                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Username/Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
