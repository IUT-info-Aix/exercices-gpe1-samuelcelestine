package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.security.cert.PolicyNode;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();

        // Création d'un conteneur VBox avec ses éléments centrés
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        root.setBottom(hbox);

        // Création de la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre
        primaryStage.setScene(scene);

        panneau = new Pane();
        root.setCenter(panneau);

        // Ajout d'un bouton avec du texte
        Button button = new Button("Vert");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #56c90d; ");
        });
        hbox.getChildren().add( button );
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        // Ajout d'un bouton avec du texte
        Button button1 = new Button("Rouge");
        hbox.getChildren().add( button1 );
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #ff0000; ");
        });

        // Ajout d'un bouton avec du texte
        Button button2 = new Button("Bleu");
        hbox.getChildren().add( button2 );
        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #0c8ebd; ");
        });

        primaryStage.setTitle("");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}

