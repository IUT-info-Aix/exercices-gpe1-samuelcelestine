package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;
    private StringProperty message;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        StringProperty message = new SimpleStringProperty();

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #56c90d; ");
            texteDuHaut.setText("Clique Vert :" + ++nbVert);
        });

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #56c90d; ");
            texteDuBas.setText("Le vert est une jolie couleur !");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #ff0000; ");
            texteDuHaut.setText("Clique Rouge :" + ++nbRouge);
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #ff0000; ");
            texteDuBas.setText("Le rouge est une jolie couleur !");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #0c8ebd; ");
            texteDuHaut.setText("Clique Bleu :" + ++nbBleu);
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            panneau.setStyle("-fx-background-color: #0c8ebd; ");
            texteDuBas.setText("Le bleu est une jolie couleur !");
        });


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

