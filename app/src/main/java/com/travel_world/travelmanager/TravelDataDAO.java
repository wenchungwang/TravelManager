package com.travel_world.travelmanager;

import java.util.ArrayList;

/**
 * Created by Thomas_wang on 2018/1/19.
 */

public interface TravelDataDAO {
        public boolean add(TravelData s);
        public ArrayList<TravelData> getList();
        public TravelData getTravelData(int id);
        public boolean update(TravelData s);
        public boolean delete(int id);
    }
