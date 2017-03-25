package com.example.vaibhav.learning_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;





public class DBHelper extends SQLiteOpenHelper {


    private static  final  int  DATABASE_VERSION =1;

    private static  final  String DB_NAME="learningsqlds.db";
    private static  final  String TB_NAME="learning";
    private static  final  String  COLUMN_ID="id";
    private static  final  String  COLUMN_NAME="name";
    private static  final  String  COLUMN_NO="no";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+TB_NAME +" ( " +
                COLUMN_NAME +" TEXT ,"+ COLUMN_NO +" INTEGER PRIMARY KEY  "+");";
        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS  "+TB_NAME+" ;";
        onCreate(db);
    }


    public void addplayer(String playername,int playerno){
        Log.d("insert",playername);
        Log.d("insert no",Integer.toString(playerno));
       SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(COLUMN_NAME,playername);
        values.put(COLUMN_NO,playerno);
        db.insert(TB_NAME,null,values);
        db.close();

    }

    public String  getcontact(int nos){
        Log.d("no came is ",Integer.toString(nos));
        SQLiteDatabase db =this.getWritableDatabase();
        Object ob;
        String playername =null;
        String query ="SELECT * from learning where no="+nos+";";

       Cursor cursor =db.rawQuery(query,null);
        int result =cursor.getColumnIndexOrThrow(COLUMN_NAME);
        Log.d("printing col name",Integer.toString(result));

        cursor.moveToFirst();
        playername = cursor.getString(result) ;
        Log.d("playername is ",playername);

        return playername;
    }

    public List getAllPLayer(){
        List namelist =new ArrayList();
        String query ="SELECT * FROM "+TB_NAME;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor =db.rawQuery(query,null);
        int result =cursor.getCount();
        Log.d("for all players",Integer.toString(result));


       if(cursor.moveToFirst()){
           do{
               String output =cursor.getString(0);
               Log.d("output=>",output);
               namelist.add(output);

           }while(cursor.moveToNext());
       }



        return namelist;
    }


}
