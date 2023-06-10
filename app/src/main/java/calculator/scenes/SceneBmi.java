package calculator.scenes;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SceneBmi {
    private TextField weightField;
    private TextField heightField;

    private Label resultLabel;
    private Stage stage;

    public SceneBmi(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator : BMI Calculator");
    }

    public void show() {
        Label weightLabel = new Label("Weight (kg)");
        weightLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 12px;");
        weightField = new TextField();
        weightField.setStyle("-fx-alignment: center; -fx-text-fill: #ffffff; -fx-max-width: 120px; -fx-border-color: #ffffff; -fx-border-width: 0 0 2px 0; -fx-background-color: rgb(20,29,38)");

        Label heightLabel = new Label("Height (m)");
        heightLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 12px;");
        heightField = new TextField();
        heightField.setStyle("-fx-alignment: center; -fx-text-fill: white; -fx-max-width: 120px; -fx-border-color: #ffffff; -fx-border-width: 0 0 2px 0; -fx-background-color: rgb(20,29,38)");

        Button calculateButton = new Button("Calculate");
        calculateButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 100px; -fx-cursor: hand;");
        calculateButton.setOnAction(event -> calculateBMI());

        resultLabel = new Label();
        resultLabel.setPrefHeight(50);
        resultLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 12px; -fx-text-alignment: center;");

        Button clearB = new Button("Clear");
        clearB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        clearB.setOnAction(e -> {
            weightField.clear();
            heightField.clear();
            resultLabel.setText("");
        });

        Button backB = new Button("Back");
        backB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");

        backB.setOnAction(e -> {
            CategoryScene categoryScene = new CategoryScene(stage);
            categoryScene.show();
        });

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10));
        buttons.getChildren().addAll(clearB, backB);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(weightLabel, weightField, heightLabel, heightField, resultLabel, calculateButton, buttons);

        Scene scene = new Scene(layout, 300, 480);
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(20,29,38), null, null);
        Background background = new Background(backgroundFill);
        layout.setBackground(background);

        stage.setScene(scene);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
    
            double bmi = (weight / (height * height));
            String result;
    
            if (bmi < 18.5) {
                result = "Underweight.\nPlease eat more";
            } else if (bmi < 25) {
                result = "Normal Weight.\nGood job";
            } else if (bmi < 30) {
                result = "Overweight.\nWatch what you eat";
            } else {
                result = "Obese.\nYou don't love yourself, do you?";
            }
    
            resultLabel.setText(String.format("BMI: %.2f, Your are %s", bmi, result));

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input.\nPlease enter valid weight and height.");
        }
    }
}
