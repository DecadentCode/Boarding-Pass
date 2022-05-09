package com.boarding;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateDemoFlightsFile {
    public static void main(String[] args) {
        Flights flights = new Flights();
        Flight flight;
        flight = new Flight(LocalDate.now(), "California", "Florida", LocalTime.now(), LocalTime.now().plusHours(2));
        flights.addFlight(123,flight);
        flight = new Flight(LocalDate.now(), "Florida", "California", LocalTime.now(), LocalTime.now());
        flights.addFlight(124,flight);
        flight = new Flight(LocalDate.now(), "Michigan", "Florida", LocalTime.now(), LocalTime.now());
        flights.addFlight(125,flight);
        flight = new Flight(LocalDate.now(), "Florida", "Michigan", LocalTime.now(), LocalTime.now());
        flights.addFlight(126,flight);
        flight = new Flight(LocalDate.now(), "Florida", "Illinois", LocalTime.now(), LocalTime.now());
        flights.addFlight(127,flight);
        flight = new Flight(LocalDate.now(), "Illinois", "Florida", LocalTime.now(), LocalTime.now());
        flights.addFlight(128,flight);
        flight = new Flight(LocalDate.now(), "Florida", "New York", LocalTime.now(), LocalTime.now());
        flights.addFlight(129,flight);
        flight = new Flight(LocalDate.now(), "New York", "Florida", LocalTime.now(), LocalTime.now());
        flights.addFlight(130,flight);
        flight = new Flight(LocalDate.now(), "Florida", "Nevada", LocalTime.now(), LocalTime.now());
        flights.addFlight(131,flight);
        flight = new Flight(LocalDate.now(), "Nevada", "Florida", LocalTime.now(), LocalTime.now());
        flights.addFlight(132,flight);
        flight = new Flight(LocalDate.now(), "Michigan", "New York", LocalTime.now(), LocalTime.now());
        flights.addFlight(133,flight);
        flight = new Flight(LocalDate.now(), "New York", "Michigan", LocalTime.now(), LocalTime.now());
        flights.addFlight(134,flight);
        flight = new Flight(LocalDate.now(), "Michigan", "Illinois", LocalTime.now(), LocalTime.now());
        flights.addFlight(135,flight);
        flight = new Flight(LocalDate.now(), "Illinois", "Michigan", LocalTime.now(), LocalTime.now());
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