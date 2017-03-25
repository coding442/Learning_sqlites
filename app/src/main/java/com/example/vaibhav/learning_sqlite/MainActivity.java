package com.example.vaibhav.learning_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db =new DBHelper(this,null,null,1) ;
//        db.addplayer("vaibhav",800); uncomment when first initialized $$$$$
//        db.addplayer("vidhi",901);
//        db.addplayer("ayush",902);
//        db.addplayer("mehul",987);

        String name =db.getcontact(800);
        Log.d("returned name",name);


        List showcontacts =db.getAllPLayer();


        ListView listing =(ListView)findViewById(R.id.listview);
        ArrayAdapter adapter =new ArrayAdapter(this,R.layout.activity_list,showcontacts);
        listing.setAdapter(adapter);







    }
}
