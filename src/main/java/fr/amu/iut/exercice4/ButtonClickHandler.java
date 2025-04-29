package fr.amu.iut.exercice4;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonClickHandler extends BonjourFenetre implements EventHandler<Event> {

    private Label helloLabel;
    private TextField nameField;

    public ButtonClickHandler(Label helloLabel, TextField nameField) {
        this.helloLabel = helloLabel;
        this.nameField = nameField;
    }

    @Override
    public void handle(Event event) {
        // Utiliser le Label récupéré
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );

    }
}

