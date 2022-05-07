package com.boarding;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Arrays;

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

    public LocalTime getETA() {
        return ETA;
    }

    public LocalTime getDT() {
        return DT;
    }

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

    private static double getETA(Location one, Location two)
    {
        final double avgSpeed = 500;
        double distance = getDistance(one.getLongitude(), two.getLongitude(), one.getLatitude(), two.getLatitude());
        double ETA = (distance / avgSpeed) * 2;
        String[] strArr = String.valueOf(ETA).replace(".", ",").split(" ");
        System.out.println(Arrays.toString(strArr));
        return Math.round(ETA);
    }
}

