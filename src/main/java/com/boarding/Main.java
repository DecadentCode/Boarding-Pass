package com.boarding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public static class Flights {
        private ArrayList<Flight> flights = new ArrayList<>();
        public ArrayList getFlights() {
            return flights;
        }
        public void setFlights(ArrayList flights) {
            this.flights = flights;
        }
        public void addFlight(Flight flight){
            flights.add(flight);
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
