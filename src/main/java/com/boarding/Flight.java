package com.boarding;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

public class Flight implements Serializable {

    // Date, Origin, Destination, Estimated time of arrival (ETA), Departure Time
    private LocalDate date;
    private String origin;
    private String destination;
    private LocalTime ETA;
    private LocalTime DT;

    //constructor
    public Flight()
    {

    }

    // Parameterized constructor

    public Flight(LocalDate date, String origin, String destination, LocalTime ETA, LocalTime DT) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.ETA = ETA;
        this.DT = DT;
    }

    //setters

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setETA(LocalTime ETA) {
        this.ETA = ETA;
    }

    public void setDT(LocalTime DT)
    {
        this.DT = DT;
    }

    //getters
    public LocalDate getDate() {
        return date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getETA()
    {
        LocalDateTime timeOfArrival = getETA(origin, destination, DT, date);
        this.ETA = LocalTime.of(timeOfArrival.getHour(), timeOfArrival.getMinute());
        return this.ETA;
    }

    public LocalTime getDT()
    {
        return DT;
    }



    // ETA Calculations
    public static double getDistance(double x1, double x2, double y1, double y2)
    {
        final int R = 3959; //earth's mean radius in miles
        double latDistance = toRad(y1 - y2);
        double longDistance = toRad(x1 -x2);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(y1)) * Math.cos(toRad(y2)) *
                        Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;
        return Math.round(distance);
    }

    private static double toRad(double value) {
        return value * Math.PI / 180;
    }

    //Takes an origin and destination as a String and returns the ETA
    private static LocalDateTime getETA( String origin, String destination, LocalTime DT, LocalDate date)
    {
        Locations dictionary = new Locations();
        Location one = dictionary.getLocation(origin);
        Location two = dictionary.getLocation(destination);
        final double avgSpeed = 500;
        double distance = getDistance(one.getLongitude(), two.getLongitude(), one.getLatitude(), two.getLatitude());
        double ETA = (distance / avgSpeed) * 2;
        String[] strArr = String.valueOf(new DecimalFormat("##.##").format(ETA))
                .replace(".", ",").split(",");
        int hours = Integer.parseInt(strArr[0]);
        int mins = Integer.parseInt(strArr[1]);

        LocalTime LT2 = DT.plusHours(hours).plusMinutes(mins);

        if(LT2.getHour() >= 23)
        {
            LocalTime LT3 = LT2.minusHours(LT2.getHour()).minusMinutes(LT2.getMinute());
            LocalDateTime TotalTravelTime = LocalDateTime.of(date.plusDays(1), LT3);
            return TotalTravelTime;
        }
        else if (DT.getMinute() >= 60)
        {
            LocalTime LT3 = LocalTime.of(LT2.getHour() + 1, 00);
            LocalDateTime TotalTravelTime = LocalDateTime.of(date, LT3);
            return TotalTravelTime;
        }
        else
        {
            LocalDateTime TotalTravelTime = LocalDateTime.of(date, LT2);
            return TotalTravelTime;
        }

    }
}

