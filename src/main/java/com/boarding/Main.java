package com.boarding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);

        /* Test code for serialization
        Gender gender = Gender.Male;
        LocalDate date = LocalDate.of(2022, Month.MAY, 4);
        LocalTime ETA = LocalTime.of(17, 30);
        LocalTime DT = LocalTime.of(12, 0);
        User user = new User();
        user.setName("Brett Hufnagle");
        user.setGender(gender);
        user.setEmail("schwifty42069@gmail.com");
        user.setPhoneNumber("5551236789");
        Flight flight = new Flight();
        flight.setDate(date);
        flight.setDestination("Los Angeles");
        flight.setOrigin("New York");
        flight.setETA(ETA);
        flight.setDT(DT);
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setFlight(flight);
        boardingPass.setUser(user);
        boardingPass.serialize();

         */

    }

    public static class Flights {
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

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 412, 732);
        stage.setTitle("Air-Con Boarding");
        stage.setScene(scene);
        stage.show();
    }
}
