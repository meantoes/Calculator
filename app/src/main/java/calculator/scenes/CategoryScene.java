package calculator.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CategoryScene {
    private Stage stage;

    public CategoryScene(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator");
    }

    public void show() {
        Text tTitle = new Text("Choose The Calculator");
        tTitle.setStyle("-fx-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-font-size: 2em;");

        // BUTTON
        Button bCalculator1 = new Button("Curs Converter");
        bCalculator1.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.5em 2em; -fx-cursor: hand;");

        bCalculator1.setOnAction(v -> {
            SceneCurs curs = new SceneCurs(stage);
            curs.show();
        });

        Button bCalculator2 = new Button("BMI Calculator");
        bCalculator2.setStyle("-fx-background-color: rgb(20,29,38); -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-padding: 0.5em 2em; -fx-cursor: hand;");

        bCalculator2.setOnAction(v -> {
            
        });

        VBox sectionRight = new VBox(tTitle, bCalculator1, bCalculator2);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setSpacing(15);
        sectionRight.setPrefWidth(30);

        VBox rootNode = new VBox(sectionRight);
        rootNode.setAlignment(Pos.CENTER);
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, null, null);
        Background background = new Background(backgroundFill);
        rootNode.setBackground(background);
        Scene scene = new Scene(new StackPane(rootNode), 300, 480);

        stage.setScene(scene);
    }
}
