package com.boarding.controllers;

import com.boarding.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFormController {
    public User user;
    @FXML
    private TextField nameField, emailField, phoneField, ageField;
    @FXML
    public ComboBox<String> genderCombo;
    @FXML
    private Text errorText;

//    Handles the submit button
    @FXML
    protected void submitForm(ActionEvent event) throws Exception {
        String name = nameField.getText(),
                email = emailField.getText().toLowerCase(),
                phone = phoneField.getText().toLowerCase(),
                age = ageField.getText(),
                gender;
        if(genderCombo.getValue() != null) {
            gender = genderCombo.getValue().toString();
            if(gender.equals("Prefer Not To Say")){ gender = "wontSay"; }
            else{ gender = genderCombo.getValue(); }
        }else{ gender = ""; }

        System.out.println("Name: "+name+" Email: "+email+" Phone: "+phone+" Gender: "+gender+" Age: "+age);

//        Checks each field for completion
        if(name.equals("") || email.equals("") || phone.equals("") || age.equals("") || gender.equals("")){
            errorText.setText("Please fill in all the fields");
        }else{
//            Constructs the user
            User user = new User(name, email, phone, gender);

//            Loads the Submitted scene
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("flightForm.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setUserData(user); // Sets the user to the stage
            Scene scene = new Scene(loader.load(), 412, 732);
            stage.setScene(scene);
            stage.show();
        }
    }
}
