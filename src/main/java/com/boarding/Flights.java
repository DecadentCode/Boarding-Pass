package com.boarding;

import java.io.Serializable;
import java.util.HashMap;

public class Flights implements Serializable {
    private HashMap<Integer, Flight> flights = new HashMap<>();
    public HashMap<Integer, Flight> getFlights() {
            return flights;
        }
    public void setFlights(HashMap<Integer, Flight> flights) {
            this.flights = flights;
        }
    public void addFlight(Integer flightNo, Flight flight){
            flights.put(flightNo, flight);
        }
}
