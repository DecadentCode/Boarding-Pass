package com.boarding;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateDemoFlightsFile {
    public static void main(String[] args) {
        Flights flights = new Flights();
        Flight flight;
        flight = new Flight(LocalDate.now(), "Hollywood", "Miami", LocalTime.now(), LocalTime.now().plusHours(2));
        flights.addFlight(123,flight);
        flight = new Flight(LocalDate.now(), "Miami", "Hollywood", LocalTime.now(), LocalTime.now());
        flights.addFlight(124,flight);
        flight = new Flight(LocalDate.now(), "Detroit", "Miami", LocalTime.now(), LocalTime.now());
        flights.addFlight(125,flight);
        flight = new Flight(LocalDate.now(), "Miami", "Detroit", LocalTime.now(), LocalTime.now());
        flights.addFlight(126,flight);
        flight = new Flight(LocalDate.now(), "Miami", "Chicago", LocalTime.now(), LocalTime.now());
        flights.addFlight(127,flight);
        flight = new Flight(LocalDate.now(), "Chicago", "Miami", LocalTime.now(), LocalTime.now());
        flights.addFlight(128,flight);
        flight = new Flight(LocalDate.now(), "Miami", "New York", LocalTime.now(), LocalTime.now());
        flights.addFlight(129,flight);
        flight = new Flight(LocalDate.now(), "New York", "Miami", LocalTime.now(), LocalTime.now());
        flights.addFlight(130,flight);
        flight = new Flight(LocalDate.now(), "Miami", "Los Angeles", LocalTime.now(), LocalTime.now());
        flights.addFlight(131,flight);
        flight = new Flight(LocalDate.now(), "Los Angeles", "Miami", LocalTime.now(), LocalTime.now());
        flights.addFlight(132,flight);
        flight = new Flight(LocalDate.now(), "Detroit", "New York", LocalTime.now(), LocalTime.now());
        flights.addFlight(133,flight);
        flight = new Flight(LocalDate.now(), "New York", "Detroit", LocalTime.now(), LocalTime.now());
        flights.addFlight(134,flight);
        flight = new Flight(LocalDate.now(), "Detroit", "Chicago", LocalTime.now(), LocalTime.now());
        flights.addFlight(135,flight);
        flight = new Flight(LocalDate.now(), "Chicago", "Detroit", LocalTime.now(), LocalTime.now());
        flights.addFlight(136,flight);

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