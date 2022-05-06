package com.boarding;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText, submittedText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Air-Con!");
    }

    @FXML
    protected void onGoodbyeButtonClick() {
        welcomeText.setText("Goodbye!");
    }

    @FXML
    protected void onSubmitButtonClick() {
        submittedText.setText("Submitted! (not really)");
    }
}