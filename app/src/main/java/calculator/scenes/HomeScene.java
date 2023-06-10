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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
        stage.setTitle("Hanana's Calculator");
    }

    public void show() {
        Text tTitle = new Text("Hanana's Calculator");
        tTitle.setStyle("-fx-fill: #ffffff; -fx-font-weight: bold; -fx-font-size: 18px;");

        Button mulai = new Button("Start");
        mulai.setStyle("-fx-background-color: #ffffff; -fx-text-fill: rgb(20,29,38); -fx-font-weight: bold; -fx-padding: 0.3em 2em; -fx-cursor: hand;"); // BUTTON STYLE
        
        mulai.setOnAction(v -> {
            CategoryScene categoryScene = new CategoryScene(stage);
            categoryScene.show();
        });

        VBox sectionRight = new VBox(tTitle, mulai);
        sectionRight.setSpacing(10);
        sectionRight.setAlignment(Pos.CENTER);
        
        // IMPORT IMAGE
        Image iconI = new Image(getClass().getClassLoader().getResourceAsStream("images/icon.png"));
        ImageView icon = new ImageView(iconI);
        icon.setFitWidth(200);
        icon.setFitHeight(200);

        VBox rootNode = new VBox(icon, sectionRight);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setSpacing(10);
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(20,29,38), null, null);
        Background background = new Background(backgroundFill);
        rootNode.setBackground(background);
        Scene scene = new Scene(new StackPane(rootNode), 300, 480);

        stage.setScene(scene);
    }
}