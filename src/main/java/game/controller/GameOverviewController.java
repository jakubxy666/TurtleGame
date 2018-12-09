package game.controller;

import game.model.Board;
import game.model.CommandSequence;
import game.model.MoveType;
import game.model.Turtle;
import game.model.command.StepForwardCommand;

import game.model.command.TurnLeftCommand;
import game.model.command.TurnRightCommand;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import game.model.generator.DataGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class GameOverviewController {

    private GameAppController appController;
    private Board boardData;
    private CommandSequence commandSequence;
    @FXML
    private Canvas boardCanvas;
    private GraphicsContext gc;
    private ImageView fxImage;

    @FXML
    private Text commandSeq;
    @FXML
    private Text info;
    @FXML
    private Button nextLevelButton;

    @FXML
    private void initialize() {
        gc = boardCanvas.getGraphicsContext2D();
        try {
            fxImage = new ImageView(new Image(new FileInputStream("./src/main/resources/images/turtle.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        info.setText(GameAppController.lvl + "/5");
        nextLevelButton.setVisible(false);
    }

    @FXML
    private void handleAddStepForwardAction(ActionEvent event) {
        commandSequence.addCommand(new StepForwardCommand(boardData));
        commandSeq.setText(commandSeq.getText() + "F\n");
        System.out.println("Step forward event fired.");
    }

    @FXML
    private void handleAddTurnLeftAction(ActionEvent event) {
        commandSequence.addCommand(new TurnLeftCommand(boardData));
        commandSeq.setText(commandSeq.getText() + "L\n");
        System.out.println("Turn left event fired.");
    }

    @FXML
    private void handleAddTurnRightAction(ActionEvent event) {
        commandSequence.addCommand(new TurnRightCommand(boardData));
        commandSeq.setText(commandSeq.getText() + "R\n");
        System.out.println("Turn right event fired.");
    }

    @FXML
    private void handleRemoveLastCommandAction(ActionEvent event) {
        if (commandSequence.getSize() > 0) {
            commandSequence.removeLastCommand();
            commandSeq.setText(commandSeq.getText().substring(0, commandSeq.getText().length() - 2));
        }
        System.out.println("Remove last command event fired.");
    }

    @FXML
    private void handleClearCommandSequenceAction(ActionEvent event) {
        commandSequence.clear();
        commandSeq.setText("");
        System.out.println("Clear sequence event fired.");
    }

    @FXML
    private void handleExecuteCommandSequenceAction(ActionEvent event) {
        int startX = boardData.getTurtle().getX();
        int startY = boardData.getTurtle().getY();
        info.setText(commandSequence.execute());
        System.out.println("Execute event fired.");
        animate(boardData.getTurtle().getMemory(),startX,startY);
        if (info.getText().equals("Great! :)"))
            nextLevelButton.setVisible(true);
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        System.out.println("Reset event fired.");
        setData(DataGenerator.generateGameData(GameAppController.lvl));
        commandSeq.setText("");
        info.setText(GameAppController.lvl + "/5");
    }

    @FXML
    private void handleNextLevelAction(ActionEvent event) {
        System.out.println("Next level event fired.");
        if (GameAppController.lvl < 5) GameAppController.lvl++;
        setData(DataGenerator.generateGameData(GameAppController.lvl));
        commandSeq.setText("");
        info.setText(GameAppController.lvl + "/5");
        nextLevelButton.setVisible(false);
    }


    public void updateCanvas() {
        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,boardCanvas.getHeight(),boardCanvas.getWidth());
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

//                    if(t.getX()==i && t.getY()==j) {
//                        SnapshotParameters params = new SnapshotParameters();
//                        params.setFill(Color.TRANSPARENT);
//                        fxImage.setRotate(90);
//                        gc.drawImage(fxImage.snapshot(params,null), 100 * i + 15, 100 * j + 15, 70, 70);
//                    }
                }
            }
        }
    }

    public void animate(LinkedList<MoveType> steps, int startX, int startY){

        DoubleProperty x  = new SimpleDoubleProperty(startX*100 + 15);
        DoubleProperty y  = new SimpleDoubleProperty(startY*100 + 15);
        DoubleProperty rotation = new SimpleDoubleProperty(0);
        SequentialTransition s = new SequentialTransition();


        int xEnd=x.intValue(), yEnd = y.intValue(), rEnd = rotation.intValue();

        for(MoveType step : steps){
            switch (step){
                case Up:
                    yEnd-=100;
                    break;
                case Down:
                    yEnd+=100;
                    break;
                case Left:
                    xEnd-=100;
                    break;
                case Right:
                    xEnd+=100;
                    break;
                case RLeft:
                    rEnd-=90;
                    break;
                case RRight:
                    rEnd+=90;
                    break;
            }

            KeyValue px = new KeyValue(x,xEnd);
            KeyValue py = new KeyValue(y,yEnd);
            KeyValue pr = new KeyValue(rotation,rEnd);
            KeyFrame kf = new KeyFrame(Duration.seconds(1),px,py,pr);
            Timeline t = new Timeline(kf);

            s.getChildren().add(t);


        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateCanvas();
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);
                fxImage.setRotate(rotation.doubleValue());
                gc.drawImage(fxImage.snapshot(params,null),x.intValue(),y.intValue(),70,70);
            }
        };

        timer.start();
        s.play();

    }

    public void setData(Board board) {
        this.boardData = board;

        ChangeListener listener = new ChangeListener(){
            @Override public void changed(ObservableValue o, Object oldVal,
                                          Object newVal){
                updateCanvas();
            }
        };

        this.boardData.getTurtle().getXProperty().addListener(listener);
        this.boardData.getTurtle().getYProperty().addListener(listener);
        this.boardData.getTurtle().getOrientationProperty().addListener(listener);

        this.commandSequence = new CommandSequence(board);

        updateCanvas();
    }

    public void setAppController(GameAppController appController) {
        this.appController = appController;
    }
}