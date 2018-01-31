package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main0Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
    }

    public void click11(View v) {

       Intent it = new Intent(Main0Activity.this, MainActivity.class);
        startActivity(it);

    }

    public void click22(View v){
       Intent it = new Intent(Main0Activity.this, JtrafficActivity.class);
      startActivity(it);
 //      startActivityForResult(it,123);
    }

    public void clickbookhotels(View v){
 //      Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);

        Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);
     startActivity(it);
 //       startActivityForResult(it,123);
    }

    public void clickfood(View v){

    }

    public void clickmoney(View v){

    }

    public void clickhelp(View v){

    }
/*
    public void click11(View v) {

        Intent it = new Intent(Main0Activity.this, MainActivity.class);
        startActivity(it);

    }
*/
}
