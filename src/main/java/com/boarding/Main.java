package com.boarding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main extends Application{
    public static final String flightsFile = "src/main/resources/flights.ser";
    private static Flights flights = new Flights();
    public static Flights getFlights() {
        return flights;
    }
    public static void setFlights(Flights flights) {
        Main.flights = flights;
    }
    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream(new File(flightsFile));
            ObjectInputStream oi = new ObjectInputStream(fi);
            flights = (Flights) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        launch(args);

        /*/ Test code for serialization
        Gender gender = Gender.Male;
        LocalDate date = LocalDate.of(2022, Month.MAY, 4);
        LocalTime ETA = flight.getETA();
        LocalTime DT = LocalTime.of(12, 0);
        User user = new User();
        user.setName("Brett Hufnagle");
        user.setGender(gender);
        user.setEmail("schwifty42069@gmail.com");
        user.setPhoneNumber("5551236789");
        Flight flight = new Flight();
        flight.setDate(date);
        flight.setDestination("California");
        flight.setOrigin("New York");
        flight.setETA(ETA);
        flight.setDT(DT);
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setFlight(flight);
        boardingPass.setUser(user);
        boardingPass.serialize();
   */

    }

//    LOADS THE GUI
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("userForm.fxml"));
        Scene scene = new Scene(loader.load(), 412, 732);
//        stage.getIcons().add(new Image("/images/plane.png")); TODO FILE NOT FOUND?!?
        stage.setTitle("Air-Con Boarding");
        stage.setScene(scene);
        stage.show();
    }
}
