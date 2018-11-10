package game.controller;

import game.model.Board;
import javafx.fxml.FXML;


public class GameOverviewController {

    private GameAppController appController;
    private Board data;

    @FXML
    private void initialize() {
    }

    public void setData(Board board) {
        this.data = board;
    }

    public void setAppController(GameAppController appController) {
        this.appController = appController;
    }
}
