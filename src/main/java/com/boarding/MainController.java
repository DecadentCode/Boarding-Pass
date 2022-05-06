package com.boarding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;

public class MainController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;

    @FXML
    private Label welcomeText, submittedText;
    @FXML
    private TextField nameField, emailField, phoneField, genderField, ageField, destinationField, departureField;
    @FXML
    private DatePicker dateField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Air-Con!");
    }

    @FXML
    protected void onGoodbyeButtonClick() {
        welcomeText.setText("Goodbye!");
    }

    @FXML
    protected void submitForm(ActionEvent event) throws Exception {
        submittedText.setText("Submitted! (not really)");
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String gender = genderField.getText();
        String age = ageField.getText();
        LocalDate date = dateField.getValue();
        String destination = destinationField.getText();
        String departure = departureField.getText();

        System.out.println(name+email+phone+gender+age+date+destination+departure);

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("submitted.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loader.load(), 412, 732);
        stage.setScene(scene);
        stage.show();
    }
}