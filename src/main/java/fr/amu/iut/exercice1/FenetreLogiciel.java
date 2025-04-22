package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Créer une scène
        MenuBar menuBar = new MenuBar();
        VBox vBox = new VBox(menuBar);
        StackPane root = new StackPane();
        Scene scene = new Scene(vBox, 700, 400);
        // Définir la scène principale de l'application
        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();

        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);


    }
    public static void main(String[] args) {
        launch(args);

    }


}