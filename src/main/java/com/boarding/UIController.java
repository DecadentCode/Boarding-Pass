package com.boarding;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UIController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Air-Con!");
    }

    @FXML
    protected void onGoodbyeButtonClick() {
        welcomeText.setText("Goodbye!");
    }
}