package com.boarding;

import java.time.LocalTime;
import java.time.LocalDate;

public class Flight {

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
}

