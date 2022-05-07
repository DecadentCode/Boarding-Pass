package com.boarding;
import java.util.TimeZone;

public class Location {

    private String locationName;
    private double longitude;
    private double latitude;
    private TimeZone tz;

    Location()
    {}

    Location(String LN, double lat, double lng, TimeZone t)
    {
        this.locationName = LN;
        this.latitude = lat;
        this.longitude = lng;
        this.tz = t;
    }

    public void setLongitude(double x)
    {
        this.longitude = x;
    }

    public void setLatitude(double y)
    {
        this.latitude = y;
    }

    public void setTz(TimeZone zone)
    {
        this.tz = zone;
    }

    public void setLocationName(String lname)
    {
        this.locationName = lname;
    }

    public String getLocationName() {
        return locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public TimeZone getTz() {
        return tz;
    }

}
