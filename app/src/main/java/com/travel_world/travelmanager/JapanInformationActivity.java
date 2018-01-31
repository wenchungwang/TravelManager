package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JapanInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_information);
    }

    public void clicki1(View v){
        //      Intent it = new Intent(Main0Activity.this, JapanWeb1Activity.class);

        Intent it = new Intent(JapanInformationActivity.this, JapanWeb1Activity.class);
        startActivity(it);
    }



}
