package calculator.scenes;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SceneCurs {
    private static final double EUR_TO_IDR = 16010.83; // JUNE 11th
    private static final double USD_TO_IDR = 14866.65;
    private static final double SGD_TO_IDR = 11023.64;
    private static final double AUD_TO_IDR = 10038.87;
    private static final double MYR_TO_IDR = 3226.62;
    private static final double CNY_TO_IDR = 2088.62;
    private static final double THB_TO_IDR = 430.38;
    private static final double JPY_TO_IDR = 106.84;
    private static final double KRW_TO_IDR = 11.56;
    private static final double VND_TO_IDR = 0.63;
    
    
    private Label resultLabel;

    private Stage stage;

    public SceneCurs(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator : Curs Conventer");
    }

    public void show() {
        ChoiceBox<String> currencyDm = new ChoiceBox<>();
        currencyDm.getItems().addAll("EUR", "USD", "SGD", "AUD", "MYR", "CNY", "THB", "JPY", "KRW", "VND");
        currencyDm.getSelectionModel().selectFirst();
        currencyDm.setStyle("-fx-border-color: rgb(20,29,38); -fx-border-width: 2px; -fx-text-fill: #ffffff; -fx-background-color: white; -fx-font-weight: bold; -fx-padding: 0 2em; -fx-cursor: hand;");

        Label inputLabel = new Label("Enter the Amount You Want to Convert");
        inputLabel.setStyle("-fx-fill: rgb(20,29,38); -fx-font-size: 12px;");

        resultLabel = new Label();
        resultLabel.setStyle("-fx-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-font-size: 12px;");

        TextField tInput = new TextField();
        tInput.setStyle("-fx-alignment: center; -fx-text-fill: rgb(20,29,38); -fx-max-width: 120px; -fx-border-color: rgb(20,29,38); -fx-border-width: 0 0 2px 0; -fx-background-color: #ffffff");

        Button calculateB = new Button("Convert");
        calculateB.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 110px; -fx-cursor: hand;");
        calculateB.setOnAction(e -> convertCurrency(currencyDm.getValue(), Double.parseDouble(tInput.getText())));

        Button clearB = new Button("Clear");
        clearB.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        clearB.setOnAction(e -> {
            tInput.clear();
            resultLabel.setText("");
        });

        // Button untuk kembali
        Button backB = new Button("Back");
        backB.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        backB.setOnAction(e -> {
            CategoryScene categoryScene = new CategoryScene(stage);
            categoryScene.show();
        });

        // setting layout scene
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10));
        buttons.getChildren().addAll(clearB, backB);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(currencyDm, inputLabel, tInput, resultLabel, calculateB, buttons);


        Scene scene = new Scene(layout, 300, 480);
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, null, null);
        Background background = new Background(backgroundFill);
        layout.setBackground(background);

        stage.setScene(scene);
    }

    private void convertCurrency(String currency, double amount) {
        try {
            double result;
            switch (currency) {
                case "EUR":
                    result = amount * EUR_TO_IDR;
                    break;
                case "USD":
                    result = amount * USD_TO_IDR;
                    break;
                case "SGD":
                    result = amount * SGD_TO_IDR;
                    break;
                case "AUD":
                    result = amount * AUD_TO_IDR;
                    break;
                case "MYR":
                    result = amount * MYR_TO_IDR;
                    break;
                case "CNY":
                    result = amount * CNY_TO_IDR;
                    break;
                case "THB":
                    result = amount * THB_TO_IDR;
                    break;
                case "JPY":
                    result = amount * JPY_TO_IDR;
                    break;
                case "KRW":
                    result = amount * KRW_TO_IDR;
                    break;
                case "VND":
                    result = amount * VND_TO_IDR;
                    break;
                default:
                    result = 0;
            }

            resultLabel.setText(String.format("Result: %.2f IDR", result));

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid amount.");
        }
    }
}