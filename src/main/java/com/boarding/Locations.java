package com.boarding;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.stream.Stream;


public class Locations {

    private Map<String, Location> LocationList = new HashMap<>();

    //constructor
    Locations()
    {
        LocationList.put("Alabama", Alabama);
        LocationList.put("Alaska",  Alaska);
        LocationList.put("Arizona",  Arizona);
        LocationList.put("Arkansas",  Arkansas);
        LocationList.put("California",  California);
        LocationList.put("Colorado",  Colorado);
        LocationList.put("Connecticut",  Connecticut);
        LocationList.put("Delaware",  Delaware);
        LocationList.put("Florida",  Florida);
        LocationList.put("Georgia",  Georgia);
        LocationList.put("Hawaii",  Hawaii);
        LocationList.put("Idaho",  Idaho);
        LocationList.put("Illinois",  Illinois);
        LocationList.put("Indiana",  Indiana);
        LocationList.put("Iowa",  Iowa);
        LocationList.put("Kansas",  Kansas);
        LocationList.put("Kentucky",  Kentucky);
        LocationList.put("Louisiana",  Louisiana);
        LocationList.put("Maine",  Maine);
        LocationList.put("Maryland",  Maryland);
        LocationList.put("Massachusetts",  Massachusetts);
        LocationList.put("Michigan",  Michigan);
        LocationList.put("Minnesota",  Minnesota);
        LocationList.put("Mississippi",  Mississippi);
        LocationList.put("Missouri",  Missouri);
        LocationList.put("Montana",  Montana);
        LocationList.put("Nebraska",  Nebraska);
        LocationList.put("Nevada",  Nevada);
        LocationList.put("New Hampshire",  NewHampshire);
        LocationList.put("New Jersey",  NewJersey);
        LocationList.put("New Mexico",  NewMexico);
        LocationList.put("New York",  NewYork);
        LocationList.put("North Carolina",  NorthCarolina);
        LocationList.put("North Dakota", NorthDakota);
        LocationList.put("Ohio", Ohio);
        LocationList.put("Oklahoma", Oklahoma);
        LocationList.put("Oregon", Oregon);
        LocationList.put("Pennsylvania", Pennsylvania);
        LocationList.put("Rhode Island", RhodeIsland);
        LocationList.put("South Carolina", SouthCarolina);
        LocationList.put("South Dakota", SouthDakota);
        LocationList.put("Tennessee", Tennessee);
        LocationList.put("Texas", Texas);
        LocationList.put("Utah", Utah);
        LocationList.put("Vermont", Vermont);
        LocationList.put("Virginia", Virginia);
        LocationList.put("Washington", Washington);
        LocationList.put("West Virginia", WestVirginia);
        LocationList.put("Wisconsin", Wisconsin);
        LocationList.put("Wyoming", Wyoming);

    }

    //parameterized constructor
    Locations(String name, Location location)
    {}

    public void addToList(String name, Location location)
    {

        LocationList.put(name, location);
    }

    public Location getLocation(String key)
    {
        Location WH = LocationList.get(key);
        return WH;
    }


    // Location Objects - List of states to be stored in Locations map
    Location Alabama =       new Location("Alabama",32.318230, -86.902298, TimeZone.getTimeZone("EST"));
    Location Alaska =        new Location("Alaska",64.200844, -149.493668, TimeZone.getTimeZone("AKT"));
    Location Arizona =       new Location("Arizona",34.048927, -111.093735, TimeZone.getTimeZone("EST"));
    Location Arkansas =      new Location("Arkansas",35.201050, -91.831833, TimeZone.getTimeZone("EST"));
    Location California =    new Location("California",37.229564, -120.047533, TimeZone.getTimeZone("EST"));
    Location Colorado =      new Location("Colorado",38.7251776, -105.607716, TimeZone.getTimeZone("EST"));
    Location Connecticut =   new Location("Connecticut",41.6500201, -72.7342163, TimeZone.getTimeZone("EST"));
    Location Delaware =      new Location("Delaware",38.6920451, -75.4013315, TimeZone.getTimeZone("EST"));
    Location Florida =       new Location("Florida",27.756766, -81.4639835, TimeZone.getTimeZone("EST"));
    Location Georgia =       new Location("Georgia",32.3293809, -83.1137366, TimeZone.getTimeZone("EST"));
    Location Hawaii =        new Location("Hawaii",19.5938015, -155.4283701, TimeZone.getTimeZone("EST"));
    Location Idaho =         new Location("Idaho",43.6447642, -114.015407, TimeZone.getTimeZone("EST"));
    Location Illinois =      new Location("Illinois",40.0796606, -89.4337288, TimeZone.getTimeZone("EST"));
    Location Indiana =       new Location("Indiana",40.3270127, -86.1746933, TimeZone.getTimeZone("EST"));
    Location Iowa =          new Location("Iowa",41.9216734, -93.3122705, TimeZone.getTimeZone("EST"));
    Location Kansas =        new Location("Kansas",38.27312, -98.5821872, TimeZone.getTimeZone("EST"));
    Location Kentucky =      new Location("Kentucky",37.5726028, -85.1551411, TimeZone.getTimeZone("EST"));
    Location Louisiana =     new Location("Louisiana",30.8703881, -92.007126, TimeZone.getTimeZone("EST"));
    Location Maine =         new Location("Maine",45.709097, -68.8590201, TimeZone.getTimeZone("EST"));
    Location Maryland =      new Location("Maryland",39.5162401, -76.9382069, TimeZone.getTimeZone("EST"));
    Location Massachusetts = new Location("Massachusetts",42.3788774, -72.032366, TimeZone.getTimeZone("EST"));
    Location Michigan =      new Location("Michigan",43.6211955, -84.6824346, TimeZone.getTimeZone("EST"));
    Location Minnesota =     new Location("Minnesota",45.9896587, -94.6113288, TimeZone.getTimeZone("EST"));
    Location Mississippi =   new Location("Mississippi",32.9715285, -89.7348497, TimeZone.getTimeZone("EST"));
    Location Missouri =      new Location("Missouri",38.7604815, -92.5617875, TimeZone.getTimeZone("EST"));
    Location Montana =       new Location("Montana",47.3752671, -109.638757, TimeZone.getTimeZone("EST"));
    Location Nebraska =      new Location("Nebraska",41.7370229, -99.5873816, TimeZone.getTimeZone("EST"));
    Location Nevada =        new Location("Nevada",39.5158825, -116.8537227, TimeZone.getTimeZone("EST"));
    Location NewHampshire =  new Location("NewHampshire",43.4849133, -71.6553992, TimeZone.getTimeZone("EST"));
    Location NewJersey =     new Location("NewJersey",40.0757384, -74.4041622, TimeZone.getTimeZone("EST"));
    Location NewMexico =     new Location("NewMexico",34.5708167, -105.993007, TimeZone.getTimeZone("EST"));
    Location NewYork =       new Location("NewYork",40.7127281, -74.0060152, TimeZone.getTimeZone("EST"));
    Location NorthCarolina = new Location("NorthCarolina",35.6729639, -79.0392919, TimeZone.getTimeZone("EST"));
    Location NorthDakota=    new Location("NorthDakota",47.6201461, -100.540737, TimeZone.getTimeZone("EST"));
    Location Ohio =          new Location("Ohio",40.2253569, -82.6881395, TimeZone.getTimeZone("EST"));
    Location Oklahoma =      new Location("Oklahoma",34.9550817, -97.2684063, TimeZone.getTimeZone("EST"));
    Location Oregon =        new Location("Oregon",43.9792797, -120.737257, TimeZone.getTimeZone("EST"));
    Location Pennsylvania =  new Location("Pennsylvania",40.9699889, -77.7278831, TimeZone.getTimeZone("EST"));
    Location RhodeIsland =   new Location("RhodeIsland",41.7962409, -71.5992372, TimeZone.getTimeZone("EST"));
    Location SouthCarolina = new Location("SouthCarolina",33.6874388, -80.4363743, TimeZone.getTimeZone("EST"));
    Location SouthDakota =   new Location("SouthDakota",44.6471761, -100.348761, TimeZone.getTimeZone("EST"));
    Location Tennessee =     new Location("Tennessee",35.7730076, -86.2820081, TimeZone.getTimeZone("EST"));
    Location Texas =         new Location("Texas",31.2638905, -98.5456116, TimeZone.getTimeZone("EST"));
    Location Utah =          new Location("Utah",39.4225192, -111.714358, TimeZone.getTimeZone("EST"));
    Location Vermont =       new Location("Vermont",44.5990718, -72.5002608, TimeZone.getTimeZone("EST"));
    Location Virginia =      new Location("Virginia",37.1232245, -78.4927721, TimeZone.getTimeZone("EST"));
    Location Washington =    new Location("Washington",47.2868352, -120.212613, TimeZone.getTimeZone("EST"));
    Location WestVirginia=   new Location("WestVirginia",38.4758406, -80.8408415, TimeZone.getTimeZone("EST"));
    Location Wisconsin =     new Location("Wisconsin",44.4308975, -89.6884637, TimeZone.getTimeZone("EST"));
    Location Wyoming =       new Location("Wyoming",43.1700264, -107.568534, TimeZone.getTimeZone("EST"));

}
