package com.travel_world.travelmanager;

/**
 * Created by Thomas_wang on 2018/1/19.
 */

public class TravelData {
    public int id;
    public String startTime;
    public String name;
    public String startLocation;
    public String destinationTime;
    public String destinationLocation;
    public String Weblocation;
 //   public String GPSlocation;
    public String note;
    public TravelData(int id,String startTime,String name, String startLocation, String destinationTime,String destinationLocation,
                      String Weblocation,String note)
    {
        this.id = id;
        this.name =name;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
        this.startTime = startTime;
        this.destinationTime = destinationTime;
        this.Weblocation = Weblocation;
        this.note = note;
    }



}
