package com.example.musafiradmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME="flights.db";
    public static final int DATABASEVERSION=1;
    public static final String TABLE_FLIGHTS="tblflights";
    public static final String COLUMN_FLIGHT_NAME="flight_name";
    public static final String COLUMN_FLIGHT_NO="flight_no";
    public static final String COLUMN_FLIGHT_FROM="flight_from";
    public static final String COLUMN_FLIGHT_TO="flight_to";
    public static final String COLUMN_FLIGHT_DATE="flight_date";
    public static final String COLUMN_FLIGHT_AVAIL_SEATS="flight_avail_seats";

    public static final String CREATE_FLIGHT_TABLE="CREATE TABLE "+TABLE_FLIGHTS+"("+
            COLUMN_FLIGHT_NAME+" TEXT,"
            +COLUMN_FLIGHT_NO+" INTEGER PRIMARY KEY,"
            +COLUMN_FLIGHT_DATE+" TEXT,"
            +COLUMN_FLIGHT_FROM+" TEXT,"
            +COLUMN_FLIGHT_TO+" TEXT,"
            +COLUMN_FLIGHT_AVAIL_SEATS+" INTEGER);";

    public DatabaseHelper(Context con)
    {
        super(con, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_FLIGHT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    Cursor getAllFlights()
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_FLIGHTS,null);
        return cursor;
    }
    boolean deleteFlights(int flight_no)
    {
        SQLiteDatabase db=getWritableDatabase();
        long result= db.delete(TABLE_FLIGHTS,COLUMN_FLIGHT_NO+"=?",new String[]{Integer.toString(flight_no)});
        if(result>0)
            return true;
        else
            return false;
    }
    boolean updateStudent(int flight_no,String flight_name,String from,String to,String date,int travellers)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues updatevalues=new ContentValues();

        updatevalues.put(COLUMN_FLIGHT_NAME,flight_name);
        updatevalues.put(COLUMN_FLIGHT_FROM,from);
        updatevalues.put(COLUMN_FLIGHT_TO,to);
        updatevalues.put(COLUMN_FLIGHT_DATE,date);
        updatevalues.put(COLUMN_FLIGHT_AVAIL_SEATS,travellers);
        String whereclause=COLUMN_FLIGHT_NO+"=?";
        String[] whereargs={Integer.toString(flight_no)};
        long result=db.update(TABLE_FLIGHTS,updatevalues,whereclause,whereargs);
        if(result>0)
            return true;
        else
            return false;

    }
    public boolean addProduct(String flight_name,int flight_no,String date,String flight_from,String flight_to,int avail_seats)
    {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COLUMN_FLIGHT_NAME,flight_name);
        contentValues.put(COLUMN_FLIGHT_NO,flight_no);
        contentValues.put(COLUMN_FLIGHT_DATE,date);
        contentValues.put(COLUMN_FLIGHT_FROM,flight_from);
        contentValues.put(COLUMN_FLIGHT_TO,flight_to);
        contentValues.put(COLUMN_FLIGHT_AVAIL_SEATS,avail_seats);
        long result= db.insert(TABLE_FLIGHTS,null,contentValues);

        if(result>0)
            return true;
        else
            return false;
    }
}
