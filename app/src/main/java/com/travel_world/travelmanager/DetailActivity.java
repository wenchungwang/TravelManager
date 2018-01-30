package com.travel_world.travelmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117

public class DetailActivity extends AppCompatActivity {

    TravelData s;
    TextView tv1, tv2, tv3,tv4, tv5, tv6,tv7,tv11;
    int id;
  boolean Fastback=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        id = getIntent().getIntExtra("id", 0);
//        s = MainActivity.dao.getStudent(id);


//        tv1 = (TextView) findViewById(R.id.textView11);

        tv2 = (TextView) findViewById(R.id.textView12);
        tv3 = (TextView) findViewById(R.id.textView13);
        tv4 = (TextView) findViewById(R.id.textView14);
        tv5 = (TextView) findViewById(R.id.textView15);
        tv6 = (TextView) findViewById(R.id.textView16);
        tv7 = (TextView) findViewById(R.id.textView17);
        tv11 = (TextView) findViewById(R.id.textViewname0);


//        tv1.setText(String.valueOf(s.id));
//        tv2.setText(s.name);
//        tv3.setText(String.valueOf(s.score));

        tv1 = findViewById(R.id.textVieweditid0);
/*
        tv2 = findViewById(R.id.textTextstartTime);
        tv3 = findViewById(R.id.textTextstartLocation);
        tv4 = findViewById(R.id.textTextdestinationTime);
        tv5 = findViewById(R.id.textTextdestinationLocation);
        tv6 = findViewById(R.id.textTextWeblocation);
        tv7 = findViewById(R.id.textTextnote);
        tv11 = findViewById(R.id.textTextnamename);
*/



    }

    @Override
    protected void onResume() {
        super.onResume();
        s = MainActivity.dao.getTravelData(id);
        tv1.setText(String.valueOf(s.id));
        tv2.setText(s.startTime);
        tv3.setText(s.startLocation);
        tv4.setText(s.destinationTime);
        tv5.setText(s.destinationLocation);
        tv6.setText(s.Weblocation);
        tv7.setText(s.note);
        tv11.setText(s.name);

      if(Fastback)
        {
            finish();
        }

    }

    public void clickedit(View v)
    {
        Intent it = new Intent(DetailActivity.this, EditActivity.class);
       Fastback =true;
       it.putExtra("id",id);
       startActivity(it);

    }

    public void clickdel(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setTitle("刪除確認");
        builder.setMessage("確認要刪除本筆資料嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }


    public void clickback(View v)
    {

        finish();
    }
}
