package com.boarding;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private TextField nameField, emailField, phoneField, ageField, destinationField, departureField;
    @FXML
    private DatePicker dateField;
    @FXML
    public ComboBox<String> genderCombo, flightsCombo;
    @FXML
    private Text errorText;



    @FXML
    protected void submitForm(ActionEvent event) throws Exception {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String gender;
        if(genderCombo.getValue() != null) {
            gender = genderCombo.getValue().toString();
            if(gender.equals("Prefer Not To Say")){ gender = "wontSay"; }
            else{ gender = genderCombo.getValue().toString().toLowerCase(); }
        }else{ gender = ""; }
        String age = ageField.getText();
        String flight = flightsCombo.getValue();

        System.out.println("Name: "+name+" Email: "+email+" Phone: "+phone+" Gender: "+gender+" Age: "+age+" flight: "+flight);

        if(name.equals("") || email.equals("") || phone.equals("") || age.equals("") || gender.equals("") || flight==null){
            errorText.setText("Please fill in all the fields");
        }else{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("submitted.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load(), 412, 732);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Flight flight : Main.getFlights().getFlights().values()) {
            flightsCombo.getItems().add(flight.getDestination());
        }
    }
}
