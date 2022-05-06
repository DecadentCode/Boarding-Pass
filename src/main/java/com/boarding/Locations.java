package com.boarding;

import java.util.HashMap;
import java.util.Map;

//HashMap implementation that contains the Location object; May read objects from file, will figure out later.
public class Locations {

    private Map<String, Location> LocationList = new HashMap<>();

    //constructor
    Locations()
    {}

    //parameterized constructor
    Locations(String name, Location location)
    {}

    public void addToList(String name, Location location)
    {

        LocationList.put(name, location);
    }

    public Location getLocation(String key)
    {
        Location location = LocationList.get(key);
        return location;
    }
}
