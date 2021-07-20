package com.yogiza.yogizabankoftsf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DBHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(1234567890,'Yogesh Chandewar',8902.00,'yogesh.01@gmail.com','XXXXXXXXXXXX5234','TSF48154517')");
        db.execSQL("insert into user_table values(2345678901,'Prem Chandewar',4882.67,'prem.02@gmail.com','XXXXXXXXXXXX8321','TSF45451382')");
        db.execSQL("insert into user_table values(3456789012,'Asaramji Chandewar',99359.56,'chandewar.03@gmail.com','XXXXXXXXXXXX3282','TSF74545452')");
        db.execSQL("insert into user_table values(4567890123,'Anita Chandewar',12500.01,'anita.04@gmail.com','XXXXXXXXXXXX4421','TSF42325353')");
        db.execSQL("insert into user_table values(5678901234,'Aditya Kumar',22603.48,'adikumar.05@gmail.com','XXXXXXXXXXXX2751','TSF48215733')");
        db.execSQL("insert into user_table values(6789012345,'Gaurang Awatade',18945.16,'gaurang.06@gmail.com','XXXXXXXXXXXX2481','TSF28123098')");
        db.execSQL("insert into user_table values(7890123456,'Ritesh Patil',5936.00,'ritesh.07@gmail.com','XXXXXXXXXXXX4127','TSF15745322')");
        db.execSQL("insert into user_table values(8901234567,'Deva Bhajipale',7857.22,'devab.08@gmail.com','XXXXXXXXXXXX7481','TSF84312383')");
        db.execSQL("insert into user_table values(9012345678,'Raghav Sharma',4398.46,'raghavs.9@gmail.com','XXXXXXXXXXXX7146','TSF483218231')");
        db.execSQL("insert into user_table values(1234567809,'Elon Musk',102.90,'elonx.10@gmail.com','XXXXXXXXXXXX9852','TSF64862646')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}