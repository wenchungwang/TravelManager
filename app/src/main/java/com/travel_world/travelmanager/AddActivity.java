package com.travel_world.travelmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117

public class AddActivity extends AppCompatActivity {
    int id=0;
    String startTime= "";
    String startLocation= "";
    String destinationTime= "";
    String destinationLocation= "";
    String Weblocation= "";
    String note= "";
    String name= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void clickAdd(View v)
    {


        EditText ed6 = (EditText) findViewById(R.id.editText16);
        EditText ed7 = (EditText) findViewById(R.id.editText17);
        EditText ed8 = (EditText) findViewById(R.id.editText19);
        EditText ed9 = (EditText) findViewById(R.id.editText18);
        EditText ed10 = (EditText) findViewById(R.id.editText110);
        EditText ed11 = (EditText) findViewById(R.id.editText111);
        EditText ed12 = (EditText) findViewById(R.id.editText112);
        EditText ed13 = (EditText) findViewById(R.id.editTextname);

//        int id = Integer.valueOf(ed6.getText().toString());     //CHECK this .because it need to add real id again //thomas 20180119
/*
        String startTime= ed7.getText().toString();
        String startLocation= ed8.getText().toString();
        String destinationTime= ed9.getText().toString();
        String destinationLocation= ed10.getText().toString();
        String Weblocation= ed11.getText().toString();
        String note= ed12.getText().toString();
        String name= ed13.getText().toString();
*/
        if ("".equals(ed6.getText().toString().trim())) {
            Log.d("NET", "ADD0");
        }
        if ("".equals(ed7.getText().toString().trim()))
        {
            Log.d("NET", "ADD1");
        }
        else if ("".equals(ed8.getText().toString().trim()))
        {
            Log.d("NET", "ADD2");
        }
        else if ("".equals(ed9.getText().toString().trim()))
        {
            Log.d("NET", "ADD3");
        }
        else if ("".equals(ed10.getText().toString().trim()))
        {
            Log.d("NET", "ADD4");
        }
        else if ("".equals(ed11.getText().toString().trim()))
        {
            Log.d("NET", "TJ1");
        }
        else if ("".equals(ed12.getText().toString().trim()))
        {
            Log.d("NET", "TJ1");
        }
        else if ("".equals(ed13.getText().toString().trim()))
        {
            Log.d("NET", "TJ1");
        }
        else {
            id = Integer.valueOf(ed6.getText().toString());     //CHECK this .because it need to add real id again //thomas 20180119
            startTime = ed7.getText().toString();
            startLocation = ed8.getText().toString();
            destinationTime = ed9.getText().toString();
            destinationLocation = ed10.getText().toString();
            Weblocation = ed11.getText().toString();
            note = ed12.getText().toString();
            name = ed13.getText().toString();

            MainActivity.dao.add(new TravelData(id, startTime, name, startLocation, destinationTime, destinationLocation, Weblocation, note));
        }
/*
        EditText ed1 = (EditText) findViewById(R.id.editText);
        EditText ed2 = (EditText) findViewById(R.id.editText4);
        EditText ed3 = (EditText) findViewById(R.id.editText3);
        int id = Integer.valueOf(ed1.getText().toString());
        String name = ed2.getText().toString();
        int score = Integer.valueOf(ed3.getText().toString());
        MainActivity.dao.add(new TravelData(id, name, score));
*/

        finish();
    }

    public void clickback3(View v)
    {
        finish();
    }

}
