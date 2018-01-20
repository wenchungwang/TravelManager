package com.travel_world.travelmanager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thomas_wang on 2018/1/21.
 */

public class TravelDataFireBaseCloudDAO implements TravelDataDAO{
    public ArrayList<TravelData> mylist;
    Context context;
    public TravelDataFireBaseCloudDAO(Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
    }
    public boolean add(TravelData s)
    {
        mylist.add(s);
        saveFile();
        return true;
    }
    private void saveFile()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void load()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            mylist = gson.fromJson(str, new TypeToken<ArrayList<TravelData>>(){}.getType());
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList< TravelData> getList()
    {
        load();
        return mylist;
    }
    public  TravelData getTravelData(int id)
    {
        load();
        for (TravelData s : mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }
    public boolean update(TravelData s)
    {
        load();
        for (TravelData t : mylist)
        {
            if (t.id == s.id)
            {
                t.id = s.id;
                t.name =s.name;
                t.startLocation = s.startLocation;
                t.destinationLocation = s.destinationLocation;
                t.startTime = s.startTime;
                t.destinationTime = s.destinationTime;
                t.Weblocation = s.Weblocation;
                t.note = s.note;
                saveFile();
                return true;
            }
        }
        return false;
    }
    public boolean delete(int id)
    {
        load();
        for (int i=0;i<mylist.size();i++)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
                saveFile();
                return true;
            }
        }
        return false;
    }
}