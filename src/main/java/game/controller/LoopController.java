package game.controller;

import game.model.Board;
import game.model.command.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;


public class LoopController {
    private String loopSeq = "";
    private GameOverviewController ovc;
    private LinkedList<ITurtleCommand> commands = new LinkedList<ITurtleCommand>();
    private int iters;
    private Board board;
    @FXML
    private Text commandSeq;

    private Stage dialogStage;

    @FXML
    private TextField howManyIters; // walidowac czy numer

    public void setData(GameOverviewController ovc, Board b) {
        this.board = b;
        this.ovc = ovc;
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage=dialogStage;
    }
    @FXML
    private void handleAddStepForwardAction(ActionEvent event) {
        commands.add(new StepForwardCommand(board));
        loopSeq += "F";
        commandSeq.setText(commandSeq.getText() + "F\n");
        System.out.println("Step forward event fired.");
    }

    @FXML
    private void handleAddTurnLeftAction(ActionEvent event) {
        commands.add(new TurnLeftCommand(board));
        loopSeq += "L";
        commandSeq.setText(commandSeq.getText() + "L\n");
        System.out.println("Turn left event fired.");
    }

    @FXML
    private void handleAddTurnRightAction(ActionEvent event) {
        commands.add(new TurnRightCommand(board));
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

        try {
            iters = Integer.parseInt(howManyIters.getText());
        } catch (NumberFormatException e) {
            iters = 0;
        }

        LoopCommand loop = new LoopCommand(iters,commands);
        ovc.addCommand(loop);
        dialogStage.close();

    }
}
