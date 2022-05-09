package com.boarding.controllers;

import com.boarding.BoardingPass;
import com.boarding.Flight;
import com.boarding.Main;
import com.boarding.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

public class FlightFormController implements Initializable {
    String currentDeparture, currentArrival;
    Integer currentFlightNumber;
    @FXML
    private ListView<String> departureList, arrivalList;
    @FXML
    private ListView<Integer> flightList;
    //    Populates the combo box with the flights
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HashSet<String> departures = new HashSet<>();
        HashSet<String> arrivals = new HashSet<>();
        HashSet<Integer> flights = new HashSet<>();
//        Populates the departure list
        for (Flight flight : Main.getFlights().getFlights().values()) {
            departures.add(flight.getOrigin());
        }
        departureList.getItems().addAll(departures);
//        Populates the arrival list filtered by the selected departure
        departureList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            arrivals.clear();
            arrivalList.getItems().clear();
            currentDeparture = departureList.getSelectionModel().getSelectedItem();
            for (Flight flight : Main.getFlights().getFlights().values()) {
                if (flight.getOrigin().equals(currentDeparture)) {
                    arrivals.add(flight.getDestination());
                }
            }
            arrivalList.getItems().addAll(arrivals);
        });
//        Populates the flight list filtered by the selected departure and arrival
        arrivalList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            flights.clear();
            flightList.getItems().clear();
            currentDeparture = departureList.getSelectionModel().getSelectedItem();
            currentArrival = arrivalList.getSelectionModel().getSelectedItem();
            for (Integer flightNo : Main.getFlights().getFlights().keySet()) {
                if (Main.getFlights().getFlights().get(flightNo).getOrigin().equals(currentDeparture) &&
                        Main.getFlights().getFlights().get(flightNo).getDestination().equals(currentArrival)) {
                    flights.add(flightNo);
                }
            }
            flightList.getItems().addAll(flights);
        });
    }
//    Submits the selected flight
    @FXML
    protected void submitButtonPressed(ActionEvent event) throws Exception{
        currentFlightNumber = flightList.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("submitted.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // create boarding pass and serialize
        Flight flightObj = Main.getFlights().getFlights().get(currentFlightNumber);
        User user = (User) stage.getUserData(); // get user from stage
        BoardingPass boardingPass = new BoardingPass(flightObj, user); // create boarding pass
        System.out.println(user.getName());
        System.out.println(boardingPass.getFlight().getDestination());
        boardingPass.serialize(); // serialize boarding pass
        Scene scene = new Scene(loader.load(), 412, 732);
        stage.setScene(scene);
        stage.show();
    }
//    Restarts the application
    @FXML
    protected void restart(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("userForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load(), 412, 732);
        stage.setScene(scene);
        stage.show();
    }
}
