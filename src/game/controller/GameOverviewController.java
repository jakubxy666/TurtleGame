package game.controller;

import game.model.Board;
import game.model.CommandSequence;
import game.model.command.StepForwardCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class GameOverviewController {

    private GameAppController appController;
    private Board boardData;
    private CommandSequence commandSequence;

    @FXML
    private void initialize() {
        this.commandSequence = new CommandSequence();
    }

    @FXML
    private void handleAddStepForwardAction(ActionEvent event) {
        commandSequence.addCommand(new StepForwardCommand(boardData.getTurtle()));
        System.out.println("Step forward event fired.");
    }

    @FXML
    private void handleRemoveLastCommandAction(ActionEvent event) {
        commandSequence.removeLastCommand();
        System.out.println("Remove last command event fired.");
    }

    @FXML
    private void handleClearCommandSequenceAction(ActionEvent event) {
        commandSequence.clear();
        System.out.println("Clear sequence event fired.");
    }

    @FXML
    private void handleExecuteCommandSequenceAction(ActionEvent event) {
        commandSequence.execute();
        System.out.println("Execute event fired.");
    }

    public void setData(Board board) {

        this.boardData = board;

    }

    public void setAppController(GameAppController appController) {
        this.appController = appController;
    }
}
