package com.travel_world.travelmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.travel_world.travelmanager.TravelData;       //check thomas wang 20180117
import com.travel_world.travelmanager.TravelDataFileDAO;
import com.travel_world.travelmanager.TravelDataMemoryDAO;
import com.travel_world.travelmanager.TravelDataCloudDAO;
import com.travel_world.travelmanager.TravelDataDAODBImpl;

public class MainActivity extends AppCompatActivity {

    public static TravelDataDAO dao;
    //    int dbType;
    DBtype dbType;
    ListView lv;
    ArrayList<String> TravelDataNames; //
    ArrayAdapter<String> adapter;
    String str[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dao = new StudentFileDAO(this);   //for old method
        dbType =DBtype.DB;
//        dbType = 1; // 1:記憶體 2:檔案
        dao =  TravelDataFactoryDAO.getDAOInstance(this, dbType);
        str = new String[] {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
        TravelDataNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, TravelDataNames);
        lv = (ListView) findViewById(R.id.ListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, str[position], Toast.LENGTH_SHORT).show();     //for test 20180129
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
                startActivity(it);
            }
        });
    }



    @Override

    protected void onResume() {
        super.onResume();
/*
        lv = (ListView) findViewById(R.id.ListView);
        ArrayList<String>  TravelDataNames = new ArrayList<>();
        for (TravelData s : dao.getList())
        {
          //  String.valueOf(s.id)
//           TravelDataNames.add(s.name);        //check or startLocation  thomas 20180119      //CHECK
         TravelDataNames.add(s.startTime);        //check or startLocation  thomas 20180119      //CHECK
     //       TravelDataNames.add( String.valueOf(s.id));        //check or startLocation  thomas 20180119      //CHECK
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, TravelDataNames);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it =new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
                startActivity(it);
          }
        });
*/
        refreshData();

    }

    public void refreshData()
    {
        TravelDataNames.clear();
        for (TravelData s : dao.getList())
        {
//            TravelDataNames.add(s.startTime);   //thomas 20180123
//            TravelData.add(s.name);
 //          TravelDataNames.add(s.startTime);
            TravelDataNames.add(s.startTime);
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }


}
