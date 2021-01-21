package com.example.finalproject2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbName="mydata";
    public DbManager(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id integer primary key autoincrement,name text,email text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        onCreate(db);
    }
    public String addRecord(String s1,String s2,String s3)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",s1);
        cv.put("email",s2);
        cv.put("password",s3);
        long res=db.insert("users",null,cv);
        if(res==-1)
        {
            return "failed";
        }
        else
        {
            return "successfully inserted";
        }
    }
    public Cursor allData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users",null);
        return cursor;
    }
//    public ArrayList<DbManagedata> getAlldata() {
//        ArrayList<DbManagedata> array_list = new ArrayList<>();
//        //hp = new HashMap();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from usersLogin", null );
//        res.moveToFirst();
//        while(res.isAfterLast() == false){
//            array_list.add(new DbManagedata(res.getString(1),res.getString(2)));
//            res.moveToNext();
//        }
//        return array_list;
//    }
}