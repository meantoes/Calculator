package calculator.scenes;

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
import javafx.stage.Stage;

public class ScenePL {
    private Stage stage;
    private Label resultLabel;

    private TextField costPField;
    private TextField sellingPField;

    public ScenePL(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator : Profit and Loss");
    }

    public void show()  {
        Label costPLabel = new Label("Cost Price");
        costPLabel.setStyle("-fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-font-size: 12px;");
        costPField = new TextField();
        costPField.setStyle("-fx-alignment: center; -fx-text-fill: rgb(20,29,38); -fx-max-width: 120px; -fx-border-color: rgb(20,29,38); -fx-border-width: 0 0 2px 0; -fx-background-color: #ffffff");

        Label sellingPLabel = new Label("Selling Price");
        sellingPLabel.setStyle("-fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-font-size: 12px;");
        sellingPField = new TextField();
        sellingPField.setStyle("-fx-alignment: center; -fx-text-fill: rgb(20,29,38); -fx-max-width: 120px; -fx-border-color: rgb(20,29,38); -fx-border-width: 0 0 2px 0; -fx-background-color: #ffffff");

        Button calculateButton = new Button("Check Profit");
        calculateButton.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 90px; -fx-cursor: hand;");
        calculateButton.setOnAction(event -> calculateProfit());

        resultLabel = new Label();
        resultLabel.setPrefHeight(30);
        resultLabel.setStyle("-fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-font-size: 12px; -fx-text-alignment: center;");

        Button clearB = new Button("Clear");
        clearB.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        clearB.setOnAction(e -> {
            costPField.clear();
            sellingPField.clear();
            resultLabel.setText("");
        });

        Button backB = new Button("Back");
        backB.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");

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
        layout.getChildren().addAll(costPLabel, costPField, sellingPLabel, sellingPField, resultLabel, calculateButton, buttons);

        Scene scene = new Scene(layout, 300, 480);
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, null, null);
        Background background = new Background(backgroundFill);
        layout.setBackground(background);

        stage.setScene(scene);
    }

    private void calculateProfit() {
        try {
            double costP = Double.parseDouble(costPField.getText());
            double sellingP = Double.parseDouble(sellingPField.getText());


            if (costP < sellingP) {
                double profit = sellingP - costP;
                resultLabel.setText(String.format("Your Profit: Rp.%.2f", profit));
            } else if (costP > sellingP) {
                double loss = costP - sellingP;
                resultLabel.setText(String.format("Your Loss: Rp.%.2f", loss));
            } else {
                resultLabel.setText("You neither lose nor profit.");
            }
            
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input.\nPlease enter valid value.");
        }
    }
}