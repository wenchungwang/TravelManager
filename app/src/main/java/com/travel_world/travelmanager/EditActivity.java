package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117

public class EditActivity extends AppCompatActivity {
    int id;
    TravelData s;
    TextView tv4;
    EditText ed2, ed3, ed4, ed5, ed6, ed7,edname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getTravelData(id);
      //item =  MainActivity.dao.getList();
/*
        tv4 = findViewById(R.id.textView111);
        ed2 = findViewById(R.id.editText17);
        ed3 = findViewById(R.id.editText18);
        ed4 = findViewById(R.id.editText19);
        ed5 = findViewById(R.id.editText110);
        ed6 = findViewById(R.id.editText111);
        ed7 = findViewById(R.id.editText112);
        edname = findViewById(R.id.editTextname);
*/
/*

*/
        tv4 = findViewById(R.id.textVieweditid);
        edname = findViewById(R.id.editTextnamename);

        ed2 = findViewById(R.id.editTextdestinationTime);
        ed3 = findViewById(R.id.editTextdestinationLocation);
        ed4 = findViewById(R.id.editTextstartTime);
        ed5 = findViewById(R.id.editTextstartLocation);
        ed6 = findViewById(R.id.editTextWeblocation);
        ed7 = findViewById(R.id.editTextnote);

/*
        tv4 = findViewById(R.id.textVieweditid);
        ed2 = findViewById(R.id.editTextstartTime);
        ed3 = findViewById(R.id.editTextstartLocation);
        ed4 = findViewById(R.id.editTextdestinationTime);
        ed5 = findViewById(R.id.editTextdestinationLocation);
        ed6 = findViewById(R.id.editTextWeblocation);
        ed7 = findViewById(R.id.editTextnote);
        edname = findViewById(R.id.editTextnamename);
*/

        //       tv4.setText(String.valueOf(s.id));
        tv4.setText(String.valueOf(s.id));
 //       tv4.setText(item);


//        ed2.setText(s.startTime);

        edname.setText(s.startTime);
        ed2.setText(s.name);
       ed3.setText(s.startLocation);
        ed4.setText(s.destinationTime);
        ed5.setText(s.destinationLocation);
        ed6.setText(s.Weblocation);
        ed7.setText(s.note);

/*
        ed2.setText(s.name);
        ed3.setText(s.startLocation);
        ed4.setText(s.destinationTime);
        ed5.setText(s.destinationLocation);
        ed6.setText(s.Weblocation);
        ed7.setText(s.note);
        edname.setText(s.startTime);
*/
/*
        ed2.setText(s.name);
        ed3.setText(s.startLocation);
        ed4.setText(s.destinationTime);
        ed5.setText(s.destinationLocation);
        ed6.setText(s.Weblocation);
        ed7.setText(s.note);
        edname.setText(s.startTime);
*/

//        edname.setText(s.name);



    }





    // editText16,editText17, editText18,editText19,editText110,editText111,editText112;
/*
    id = getIntent().getIntExtra("id", 0);
  //  s = MainActivity.dao.getTravelData(id);

    tv4 = findViewById(R.id.textView4);
    ed4 = findViewById(R.id.editText4);
    ed5 = findViewById(R.id.editText5);

       tv4.setText(String.valueOf(s.id));
        ed4.setText(s.name);
       ed5.setText(String.valueOf(s.score));
*/
//}

//    @Override
/*
    protected void onResume() {
        super.onResume();
//      s = MainActivity.dao.getStudent(id);
        tv4.setText(String.valueOf(s.id));
        ed4.setText(s.name);
       ed5.setText(String.valueOf(s.score));
    }
*/



    public void clickedit2(View v)
    {

        TravelData s = new TravelData(id,edname.getText().toString(),ed2.getText().toString(), ed3.getText().toString(),
                ed4.getText().toString(),ed5.getText().toString(),
                ed6.getText().toString(),ed7.getText().toString()

        );

        MainActivity.dao.update(s);

        Intent it = new Intent(EditActivity.this, MainActivity.class);
        it.putExtra("id",id);
        startActivity(it);

        finish();
    }

    public void clickback2(View v)
    {
        finish();
    }

}
