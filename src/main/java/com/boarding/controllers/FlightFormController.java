package com.boarding.controllers;

import com.boarding.Main;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class FlightFormController implements Initializable {

    //    Populates the combo box with the flights
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Integer flightNo : Main.getFlights().getFlights().keySet()) {
            if(!Main.getFlights().getFlights().get(flightNo).getDestination().equals("") ||
                    Main.getFlights().getFlights().get(flightNo).getDestination().equals("destinationCityField.getText()")) {
//                flightsCombo.getItems().add(String.valueOf(flightNo));
            }
        }
    }
}
