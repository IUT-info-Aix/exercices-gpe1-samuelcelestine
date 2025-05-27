package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Sliders
        Slider sliderCelsius = new Slider(0, 100, 0);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setShowTickMarks(true);

        Slider sliderFahrenheit = new Slider(0, 212, 32);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);
        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setShowTickMarks(true);

        TextField champCelsius = new TextField();
        TextField champFahrenheit = new TextField();

        champCelsius.setPrefColumnCount(4);
        champFahrenheit.setPrefColumnCount(4);

        DoubleProperty celsius = new SimpleDoubleProperty();
        DoubleProperty fahrenheit = new SimpleDoubleProperty();

        celsius.bindBidirectional(sliderCelsius.valueProperty());
        fahrenheit.bindBidirectional(sliderFahrenheit.valueProperty());

        celsius.addListener((obs, oldVal, newVal) -> {
            double f = newVal.doubleValue() * 9 / 5 + 32;
            if (Math.abs(fahrenheit.get() - f) > 0.01) {
                fahrenheit.set(f);
            }
        });

        fahrenheit.addListener((obs, oldVal, newVal) -> {
            double c = (newVal.doubleValue() - 32) * 5 / 9;
            if (Math.abs(celsius.get() - c) > 0.01) {
                celsius.set(c);
            }
        });

        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(champCelsius.textProperty(), celsius, converter);
        Bindings.bindBidirectional(champFahrenheit.textProperty(), fahrenheit, converter);

        VBox panneauCelsius = new VBox(30, new Label("°C"), sliderCelsius, champCelsius);
        VBox panneauFahrenheit = new VBox(30, new Label("°F"), sliderFahrenheit, champFahrenheit);

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Convertisseur de Températures");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
