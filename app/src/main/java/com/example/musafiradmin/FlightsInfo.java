package com.example.musafiradmin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FlightsInfo extends AppCompatActivity
{
    TextView txtinfo;
    String alldata;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_info);
        txtinfo=findViewById(R.id.txtallfights);
        Intent intent=getIntent();
        alldata = intent.getStringExtra("alldata");
        txtinfo.setText(alldata);

    }
}
