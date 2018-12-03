package game;

import game.controller.GameAppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private GameAppController appController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.appController = new GameAppController(primaryStage);
        this.appController.initRootLayout();
    }


    public static void main(String[] args) {
        launch(args);
    }
}