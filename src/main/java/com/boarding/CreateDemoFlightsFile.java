package com.boarding;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateDemoFlightsFile {
    public static void main(String[] args) {
        Flights flights = new Flights();
        Flight flight = new Flight(LocalDate.now(), "Cleveland Hopkins", "Miami International", LocalTime.now(), LocalTime.now());
        flights.addFlight(123,flight);
        flight = new Flight(LocalDate.now(), "Detroit Metro Airport", "Cleveland Hopkins", LocalTime.now(), LocalTime.now());
        flights.addFlight(124,flight);
        String file = "src/main/resources/flights.ser";
        // Write File
        try {
            FileOutputStream f = new FileOutputStream(new File(file));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(flights);
            o.close();
            o.flush();
        } catch (IOException e) {
            System.out.println("json processing exception " + e);
        }

        //Sample Read
        try {
            FileInputStream fi = new FileInputStream(new File(file));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Flights newFlights = (Flights) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}