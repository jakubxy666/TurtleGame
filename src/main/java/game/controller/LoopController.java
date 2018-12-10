package game.controller;

import game.model.Board;
import game.model.CommandSequence;
import game.model.command.StepForwardCommand;
import game.model.command.TurnLeftCommand;
import game.model.command.TurnRightCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class LoopController {
    private String loopSeq = "";
    private GameOverviewController ovc;
    @FXML
    private Text commandSeq;

    @FXML
    private TextField howManyIters; // walidowac czy numer

    public void setData(GameOverviewController ovc){
        this.ovc = ovc;
    }



    @FXML
    private void handleAddStepForwardAction(ActionEvent event) {
        loopSeq += "F";
        commandSeq.setText(commandSeq.getText() + "F\n");
        System.out.println("Step forward event fired.");
    }

    @FXML
    private void handleAddTurnLeftAction(ActionEvent event) {
        loopSeq += "L";
        commandSeq.setText(commandSeq.getText() + "L\n");
        System.out.println("Turn left event fired.");
    }

    @FXML
    private void handleAddTurnRightAction(ActionEvent event) {
        loopSeq += "R";
        commandSeq.setText(commandSeq.getText() + "R\n");
        System.out.println("Turn right event fired.");
    }

    @FXML
    private void handleRemoveLastCommandAction(ActionEvent event) {
        if (loopSeq.length() > 0) {
            loopSeq = loopSeq.substring(0, loopSeq.length() - 1);
            commandSeq.setText(commandSeq.getText().substring(0, commandSeq.getText().length() - 2));
        }
        System.out.println("Remove last command event fired.");
    }

    @FXML
    private void handleClearCommandSequenceAction(ActionEvent event) {
        loopSeq = "";
        commandSeq.setText("");
        System.out.println("Clear sequence event fired.");
    }

    @FXML
    private void handleAddLoopAction(ActionEvent event) {
        loopSeq += ("-" + howManyIters);
    }
}
