package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    Label counterLabel;

    @FXML
    Button decrementButton;

    @FXML
    Button incrementButton;

    int counter = 0;

    @FXML
    public void increment() {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    @FXML
    public void decrement() {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
    }
}