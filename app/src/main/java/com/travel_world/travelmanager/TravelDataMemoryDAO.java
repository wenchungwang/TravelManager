                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              package com.travel_world.travelmanager;

import java.util.ArrayList;
import java.util.regex.Pattern;  //?? check thomas wang 20180117
/**
 * Created by Thomas_wang on 2018/1/19.
 */

public class TravelDataMemoryDAO implements TravelDataDAO{
/*
        public ArrayList<TravelData> mylist;
        public TravelDataDAO()
        {
            mylist = new ArrayList<>();
        }
        public boolean  add(TravelData s)
        {
            mylist.add(s);
            return true;
        }
        public ArrayList<TravelData> getList()
        {
            return mylist;
        }

        public TravelData getTravelData(int id)
        {
            for (TravelData s : mylist)
            {
                if (s.id == id)
                {
                    return s;
                }
            }
            return null;
        }
*/

    public ArrayList<TravelData> mylist;
    public TravelDataMemoryDAO()
    {
        mylist = new ArrayList<>();
    }
    public boolean  add(TravelData s)
    {
        mylist.add(s);
        return true;
    }
    public ArrayList<TravelData> getList()
    {
        return mylist;
    }

    public TravelData getTravelData(int id)
    {
        for (TravelData s : mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }

        public boolean  update(TravelData t)
        {
            for (TravelData s : mylist)
            {
                if (t.id == s.id)
                {
                    t.id = s.id;
                    t.startLocation = s.startLocation;
                    t.destinationLocation = s.destinationLocation;
                    t.startTime = s.startTime;
                    t.destinationTime = s.destinationTime;
                    t.Weblocation = s.Weblocation;
                    t.note = s.note;
                    return true;
                }
            }
            return false;
        }

        public boolean  delete(int id)
        {
            for(int i=0;i<mylist.size();i++)
            {
                if(mylist.get(i).id ==id)
                {
                    mylist.remove(i);
                    return true;
                }
            }
            return false;
        }

    }
