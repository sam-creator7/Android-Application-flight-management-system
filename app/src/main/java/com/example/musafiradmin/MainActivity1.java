package com.example.musafiradmin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity
{
    String flight_no,flight_name,from,to,date;
    String data;
    int travellers;

    Button btnselect,btndelete,btnadd,btnupdate;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity2_main);
        db=new DatabaseHelper(MainActivity1.this);
        btnselect=findViewById(R.id.btnshowall);
        btnadd=findViewById(R.id.btnadd);
        btndelete=findViewById(R.id.btndeleteflights);
        btnupdate=findViewById(R.id.btnupdate);

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=db.getAllFlights();
                if (cursor!=null)
                {
                    if (cursor.getCount()>0)
                    {
                        cursor.moveToFirst();
                        int a=1;
                        data="";
                        while (!cursor.isAfterLast())
                        {

                            flight_no=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_NO));
                            flight_name=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_NAME));
                            from=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_FROM));
                            to=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_TO));
                            date=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_DATE));
                            travellers=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_FLIGHT_AVAIL_SEATS));
                            data=data+"\n\n"+a+".FLIGHT NAME : "+flight_name+"\tFLIGHT NUMBER : "+flight_no+"\tFLIGHT DATE : " +date
                                    +"\tSOURCE : "+from+"\tDESTINATION : "+to+"\tFLIGHT SEATS : "+travellers;
                            a++;
                            cursor.moveToNext();
                        }
                    }
            }
                Intent intent=new Intent(MainActivity1.this,FlightsInfo.class);
                intent.putExtra("alldata",data);
                startActivity(intent);
        }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity1.this,AddActivity.class);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity1.this,DeleteActivity.class);
                startActivity(intent);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity1.this,UpdateActivity.class);
                startActivity(intent);
            }
        });





    }

}

