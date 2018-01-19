package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    int id;
    TravelData s;
//    TextView tv4;
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ed1 = findViewById(R.id.editText16);
        ed2 = findViewById(R.id.editText17);
        ed3 = findViewById(R.id.editText18);
        ed4 = findViewById(R.id.editText19);
        ed5 = findViewById(R.id.editText110);
        ed6 = findViewById(R.id.editText111);
        ed7 = findViewById(R.id.editText112);

        //       tv4.setText(String.valueOf(s.id));
        ed1.setText(s.id);
        ed2.setText(s.startTime);
        ed3.setText(s.startLocation);
        ed4.setText(s.destinationTime);
        ed5.setText(s.destinationLocation);
        ed6.setText(s.Weblocation);
        ed7.setText(s.note);

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

        TravelData s = new TravelData(id, ed2.getText().toString(),ed3.getText().toString(),
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
