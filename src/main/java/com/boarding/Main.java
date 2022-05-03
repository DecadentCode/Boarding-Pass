package com.boarding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 412, 732);
        stage.setTitle("Air-Con Boarding");
        stage.setScene(scene);
        stage.show();
    }
}
