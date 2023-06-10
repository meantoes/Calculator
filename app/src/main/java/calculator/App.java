package calculator;

import calculator.scenes.HomeScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        HomeScene hs = new HomeScene(stage);
        hs.show();
    }
    public static void main(String[] args) {
        launch(); 
    }
}