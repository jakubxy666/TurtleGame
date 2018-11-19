package game.controller;

import game.model.Board;
import game.model.CommandSequence;
import game.model.Turtle;
import game.model.command.StepForwardCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GameOverviewController {

    private GameAppController appController;
    private Board boardData;
    private CommandSequence commandSequence;
    @FXML
    private Canvas boardCanvas;
    private GraphicsContext gc;
    private Image fxImage;

    @FXML
    private void initialize() {
        this.commandSequence = new CommandSequence();
        gc = boardCanvas.getGraphicsContext2D();
        try {
            fxImage = new Image(new FileInputStream("turtle.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        updateCanvas();
    }

    public void updateCanvas() {

        for (int i = 0; i < boardData.getFields().length; i++) {
            for (int j = 0; j < boardData.getFields().length; j++) {
                if (boardData.getFields()[j][i].isVisible()) {
                    if(!boardData.getFields()[j][i].isVisited()){
                        gc.setFill(Color.BROWN);
                    } else {
                        gc.setFill(Color.BLUE);
                    }
                    gc.fillRect(100 * i+5, 100 * j+5, 100-10, 100-10);
                    Turtle t = boardData.getTurtle();
                    if(t.getX()==i&&t.getY()==j){
//                        gc.setFill(Color.GREEN);
//                        gc.fillRect(100 * i+15, 100 * j+15, 100-30, 100-30);

                        gc.drawImage(fxImage,100*i + 15, 100*j + 15 ,70,70);

                    }
                }
            }
        }

    }

    public void setData(Board board) {

        this.boardData = board;
        updateCanvas();
    }

    public void setAppController(GameAppController appController) {
        this.appController = appController;
    }
}
