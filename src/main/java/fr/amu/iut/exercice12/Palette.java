package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private Label texteDuHaut;

    private fr.amu.iut.exercice2.CustomButton vert;
    private fr.amu.iut.exercice2.CustomButton rouge;
    private fr.amu.iut.exercice2.CustomButton bleu;

    private fr.amu.iut.exercice2.CustomButton sourceOfEvent;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private VBox bas;
    private Label texteDuBas;

    private EventHandler<ActionEvent> gestionnaireEvenement;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        texteDuBas = new Label();

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));

        bas = new VBox();
        bas.getChildren().addAll(boutons, texteDuBas);
        bas.setAlignment(Pos.CENTER_RIGHT);

        vert = new fr.amu.iut.exercice2.CustomButton("Vert", "#56c90d");
        rouge = new fr.amu.iut.exercice2.CustomButton("Rouge", "#F21411");
        bleu = new fr.amu.iut.exercice2.CustomButton("Bleu", "#3273A4");

        gestionnaireEvenement = event -> {
            sourceOfEvent = (fr.amu.iut.exercice2.CustomButton) event.getSource();
            sourceOfEvent.setNbClics(sourceOfEvent.getNbClics() + 1);
        };

        vert.setOnAction(gestionnaireEvenement);
        rouge.setOnAction(gestionnaireEvenement);
        bleu.setOnAction(gestionnaireEvenement);

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Palette");
        primaryStage.show();

        ChangeListener<Number> nbClicsListener = new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                if (sourceOfEvent != null) {
                    texteDuHaut.setText(sourceOfEvent.getText() + " cliqué " + newValue + " fois");
                    panneau.setStyle("-fx-background-color: " + sourceOfEvent.getCouleur());
                    texteDuBas.setText("Total de clics : " + newValue);
                }
            }
        };

        vert.nbClicsProperty().addListener(nbClicsListener);
        rouge.nbClicsProperty().addListener(nbClicsListener);
        bleu.nbClicsProperty().addListener(nbClicsListener);
    }
}
