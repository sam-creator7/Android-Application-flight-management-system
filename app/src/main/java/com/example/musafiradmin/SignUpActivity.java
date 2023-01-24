package com.example.musafiradmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity
{
    EditText edtfn,edtln,edtemail,edtpass1,edtpass2;
    Button btnsignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        edtfn=(EditText)findViewById(R.id.firstname);
        edtln=(EditText)findViewById(R.id.ln);
        edtemail=(EditText)findViewById(R.id.email1);
        edtpass1=(EditText)findViewById(R.id.pass1);
        edtpass2=(EditText)findViewById(R.id.pass2);
        btnsignup=(Button)findViewById(R.id.signup1);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass1 =edtpass1.getText().toString();
                String pass2 = edtpass2.getText().toString();
                if (pass1.equals(pass2)){
                    Intent expin = new Intent();
                    expin.putExtra("firstname",edtfn.getText().toString());
                    expin.putExtra("lastname",edtln.getText().toString());
                    expin.putExtra("email",edtemail.getText().toString());
                    expin.putExtra("password",pass1);
                    setResult(RESULT_OK,expin);
                    finish();
                }
                else {

                    Toast.makeText(SignUpActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

