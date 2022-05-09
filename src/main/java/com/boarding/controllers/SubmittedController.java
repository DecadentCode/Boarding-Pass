package com.boarding.controllers;

import com.boarding.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SubmittedController {

    @FXML
    protected void restart(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("userForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load(), 412, 732);
        stage.setScene(scene);
        stage.show();
    }
}
