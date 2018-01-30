package com.travel_world.travelmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/23.
 */

public class TravelDataDAODBImpl implements TravelDataDAO{
        Context context;
        SQLiteDatabase db;
        public TravelDataDAODBImpl(Context context)
        {
            this.context = context;
            MyDBHelper helper = new MyDBHelper(context);
            db = helper.getWritableDatabase();

 //          ((MainActivity) context).refreshData(); //

        }

        @Override
        public boolean add(TravelData s) {
            ContentValues cv = new ContentValues();
            cv.put("_id", s.id);
            cv.put("startTime", s.startTime);
            cv.put("name", s.name);
            cv.put("startLocation", s.startLocation);
            cv.put("destinationTime", s.destinationTime);
            cv.put("destinationLocation", s.destinationLocation);
            cv.put("Weblocation", s.Weblocation);
            cv.put("note", s.note);

            db.insert("traveldata", null, cv);
            return true;
        }

        @Override
        public ArrayList<TravelData> getList() {
            ArrayList<TravelData> mylist = new ArrayList<>();
            Cursor c = db.query("traveldata", new String[] {"_id", "startTime", "name","startLocation","destinationTime","destinationLocation","Weblocation","note"}, null, null, null, null, null);
            if (c.moveToFirst())
            {
                TravelData s1 = new TravelData(c.getInt(0), c.getString(1), c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7));
                mylist.add(s1);
                while(c.moveToNext())
                {
                    TravelData s = new TravelData(c.getInt(0), c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7));
                    mylist.add(s);
                }
            }
            return mylist;
        }

    @Override
        public TravelData getTravelData(int id) {
            Cursor c = db.query("traveldata", new String[]  {"_id", "startTime", "name","startLocation","destinationTime","destinationLocation","Weblocation","note"}, "_id=?", new String[] {String.valueOf(id)}, null, null, null);
            if (c.moveToFirst())
            {
                TravelData s1 = new TravelData(c.getInt(0), c.getString(1), c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7));
                return s1;
            }
            return null;
        }

        @Override
        public boolean update(TravelData s) {
            ContentValues cv = new ContentValues();
            cv.put("startTime", s.startTime);
            cv.put("name", s.name);
            cv.put("startLocation", s.startLocation);
            cv.put("destinationTime", s.destinationTime);
            cv.put("destinationLocation", s.destinationLocation);
            cv.put("Weblocation", s.Weblocation);
            cv.put("note", s.note);
            db.update("traveldata", cv, "_id=?", new String[] {String.valueOf(s.id)});
            return true;
        }

        @Override
        public boolean delete(int id) {
            db.delete("traveldata", "_id=?", new String[] {String.valueOf(id)});
            return true;
        }
    }