package com.travel_world.travelmanager;

import android.content.Context;

/**
 * Created by Thomas_wang on 2018/1/19.
 */

public class TravelDataFactoryDAO {
        public static TravelDataDAO getDAOInstance(Context context, DBtype dbType)
        {
            switch (dbType)
            {
                case MEMORY:
                    return new TravelDataMemoryDAO();
                case FILE:
                    return new TravelDataFileDAO(context);
                case DB:
                    return new TravelDataDAODBImpl(context);
                case CLOUD:
                    return new TravelDataCloudDAO(context);
            }
            return null;
        }
    }