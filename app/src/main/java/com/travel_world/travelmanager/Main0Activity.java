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
        Intent it = new Intent(Main0Activity.this,FoodActivity.class);
        startActivity(it);
    }

    public void clickmoney(View v){
        Intent it = new Intent(Main0Activity.this,MoneyActivity.class);
        startActivity(it);
    }

    public void clickhelp(View v){
        Intent it = new Intent(Main0Activity.this,JinActivity.class);
        startActivity(it);

    }
/*
    public void click11(View v) {

        Intent it = new Intent(Main0Activity.this, MainActivity.class);
        startActivity(it);

    }
*/
}
