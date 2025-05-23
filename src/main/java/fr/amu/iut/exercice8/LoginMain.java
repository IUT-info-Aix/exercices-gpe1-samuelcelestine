package fr.amu.iut.exercice8;

import fr.amu.iut.exercice4.BonjourFenetre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("exercice8/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //scene.getStylesheets().addAll(this.getClass().getResource("Login.css").toExternalForm());
        stage.setTitle("FXML Custom Control");
        stage.show();
    }
}
