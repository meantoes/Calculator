package calculator;

import calculator.scenes.HomeScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        HomeScene homeScene = new HomeScene(stage);
        homeScene.show();
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(); 
    }
}