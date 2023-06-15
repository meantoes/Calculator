package calculator.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneShapes {
    private Stage stage;
    private ComboBox<String> shapesCB = new ComboBox<>();
    // private Label inputLabel1;
    // private Label inputLabel2;
    private TextField inputField1;
    private TextField inputField2;
    private Label resultLabel;

    public SceneShapes(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator : Shapes");
    }

    public void show() {
        // CREATING ELEMENTS
        // COMBOBOX
        shapesCB = new ComboBox<>();
        shapesCB.getItems().addAll(
                "Square",
                "Rectangle",
                "circle",
                "Triangle",
                "Trapezoid",
                "Jajar Genjang",
                "Kite",
                "Belah Ketupat"
        );
        shapesCB.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px; -fx-text: #ffffff; -fx-background-color: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0 2em; -fx-cursor: hand; -fx-max-width: 180px;");

        // INPUT TEXTFIELDS
        inputField1 = new TextField();
        inputField1.setStyle("-fx-alignment: center; -fx-text-fill: #ffffff; -fx-max-width: 120px; -fx-border-color:#ffffff; -fx-border-width: 0 0 2px 0; -fx-background-color: rgb(20,29,38)");
        
        inputField2 = new TextField();
        inputField2.setStyle("-fx-alignment: center; -fx-text-fill: #ffffff; -fx-max-width: 120px; -fx-border-color: #ffffff; -fx-border-width: 0 0 2px 0; -fx-background-color: rgb(20,29,38)");

        // LABELS
        resultLabel = new Label();
        resultLabel.setPrefHeight(40);
        resultLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 12px; -fx-text-alignment: center;");

        // BUTTONS
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculate());
        calculateButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 110px; -fx-cursor: hand;");

        Button clearB = new Button("Clear");
        clearB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        clearB.setOnAction(e -> {
            inputField1.clear();
            inputField2.clear();
            resultLabel.setText("");
        });

        Button backB = new Button("Back");
        backB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
        backB.setOnAction(e -> {
            CategoryScene categoryScene = new CategoryScene(stage);
            categoryScene.show();
        });

        // LAYOUTS
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10));
        buttons.getChildren().addAll(clearB, backB);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(shapesCB, inputField1, inputField2, resultLabel, calculateButton, buttons);

        Scene scene = new Scene(layout, 300, 480);
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(20,29,38), null, null);
        Background background = new Background(backgroundFill);
        layout.setBackground(background);
        stage.setScene(scene);
    }

    // VOID METHOD
    private void calculate() {
        String selectedBangunDatar = shapesCB.getValue();
        double input1 = Double.parseDouble(inputField1.getText());
        double input2 = Double.parseDouble(inputField2.getText());

        double result = 0.0;
        String resultText = "";

        if (selectedBangunDatar == null) {
            resultText = "Please Choose a Shape.";
        } else {
            switch (selectedBangunDatar) {
                case "Square":
                    result = input1 * input1;
                    resultText = "Area: " + result + "\nPerimeter: " + (4 * input1);
                    break;
                case "Rectangle":
                    result = input1 * input2;
                    resultText = "Area: " + result + "\nPerimeter: " + (2 * (input1 + input2));
                    break;
                case "circle":
                    result = Math.PI * input1 * input1;
                    resultText = "Area: " + result + "\nPerimeter: " + (2 * Math.PI * input1);
                    break;
                case "Triangle":
                    result = 0.5 * input1 * input2;
                    resultText = "Area: " + result + "\nPerimeter: " + (input1 + input2 + Math.sqrt(input1 * input1 + input2 * input2));
                    break;
                case "Trapezoid":
                    result = 0.5 * (input1 + input2) * input2;
                    double sisiMiring = Math.sqrt((input2 * input2) + ((input1 - input2) / 2) * ((input1 - input2) / 2));
                    resultText = "Area: " + result + "\nPerimeter: " + (2 * input2 + input1 + sisiMiring);
                    break;
                case "Jajar Genjang":
                    result = input1 * input2;
                    resultText = "Area: " + result + "\nPerimeter: " + (2 * (input1 + input2));
                    break;
                case "Kite":
                    result = 0.5 * input1 * input2;
                    resultText = "Area: " + result + "\nPerimeter: " + (2 * (input1 + input2));
                    break;
                case "Belah Ketupat":
                    result = 0.5 * input1 * input2;
                    resultText = "Area: " + result + "\nPerimeter: " + (4 * input1);
                    break;
            }
        }

        resultLabel.setText(resultText);
    }
}
    //     shapesCB = new ComboBox<>();
    //     shapesCB.getItems().addAll("Square", "Rectangle", "Triangle", "Circle", "Parallelogram", "Trapezoid", "Rhombus", "Kite");

    //     inputLabel1 = new Label();
    //     inputLabel2 = new Label();

    //     inputField1 = new TextField();
    //     inputField2 = new TextField();

    //     resultLabel = new Label();

    //     Button calculateButton = new Button("Calculate");
    //     calculateButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 100px; -fx-cursor: hand;");
    //     calculateButton.setOnAction(event -> calculate());

    //     resultLabel = new Label();
    //     resultLabel.setPrefHeight(50);
    //     resultLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 12px; -fx-text-alignment: center;");

    //     Button clearB = new Button("Clear");
    //     clearB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");
    //     clearB.setOnAction(e -> {
    //         inputField1.clear();
    //         inputField2.clear();
    //         resultLabel.setText("");
    //     });

    //     Button backB = new Button("Back");
    //     backB.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 3.5em; -fx-cursor: hand;");

    //     backB.setOnAction(e -> {
    //         CategoryScene categoryScene = new CategoryScene(stage);
    //         categoryScene.show();
    //     });

    //     // THE STAGE
    // }

    // private void calculate() {
    //     String selectedShape = shapesCB.getValue();
    //     double input1 = Double.parseDouble(inputField1.getText());
    //     double input2 = Double.parseDouble(inputField2.getText());

    //     double area = 0.0;
    //     double perimeter = 0.0;
    //     String resultText = "";

    //     if ( selectedShape == null) {
    //         resultText = "Please choose a shape.";
    //     } else {
    //         switch (selectedShape) {
    //             case "Square":
    //                 inputLabel1.setText("Sisi: ");
    //                 area = input1 * input2;
    //                 perimeter = 4 * input1;
    //                 resultText = "Area: " + area + " Perimeter: " + perimeter;
    //                 break;
    //         }
    //     }
    // }

