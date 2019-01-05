package game.controller;

import game.model.Board;
import game.model.command.CommandSequence;
import game.model.MoveType;
import game.model.command.ITurtleCommand;
import game.model.command.StepForwardCommand;
import game.model.command.TurnLeftCommand;
import game.model.command.TurnRightCommand;
import game.model.generator.DataGenerator;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import static java.lang.Math.*;

public class GameOverviewController {

    private GameAppController appController;
    private Board boardData;
    private CommandSequence commandSequence;
    @FXML
    private Pane boardPane;
    @FXML
    private HBox commandBox;

    @FXML
    private Canvas boardCanvas;
    @FXML
    private Canvas turtleCanvas;
    private GraphicsContext gc_board, gc_turtle;
    private ImageView fxImage;

    @FXML
    private Text commandSeq;
    @FXML
    private Text info;
    @FXML
    private ImageView forwardImage;
    @FXML
    private ImageView leftImage;
    @FXML
    private ImageView rightImage;
    @FXML
    private ImageView loopImage;
    @FXML
    private ImageView nextLevelImage;
    @FXML
    private ImageView executeImage;
    @FXML
    private ChoiceBox levelBox;

    @FXML
    private void initialize() {
        gc_board = boardCanvas.getGraphicsContext2D();
        gc_turtle = turtleCanvas.getGraphicsContext2D();
        turtleCanvas.toFront();
        try {
            fxImage = new ImageView(new Image(new FileInputStream("./src/main/resources/images/turtle.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        info.setText(GameAppController.lvl + "/5");
        nextLevelImage.setVisible(false);

        for (int i=0; i<5; i++)
            levelBox.getItems().add("level " + String.format("%d", i+1));
        levelBox.getSelectionModel().select(GameAppController.lvl-1);

        levelBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            GameAppController.lvl = t1.intValue()+1;
            setData(DataGenerator.generateGameData(GameAppController.lvl));
            commandSeq.setText("");
            info.setText(GameAppController.lvl + "/5");
            nextLevelImage.setVisible(false);
        });
        // int selectedLvl = levelBox.getSelectionModel().getSelectedIndex();

    }

    public void addCommand(ITurtleCommand command){
        commandSequence.addCommand(command);
        commandSeq.setText(commandSeq.getText() + command.getName());
    }

    public Board getBoardData(){
        return this.boardData;
    }

    private void addCommandToBox(Image image){
        ImageView imageToAdd = new ImageView();
        imageToAdd.setFitHeight(50);
        imageToAdd.setFitWidth(50);
        imageToAdd.setImage(image);
        imageToAdd.setVisible(true);
        HBox container = new HBox();
        container.paddingProperty().setValue(new Insets(0,5,5,0));
        container.getChildren().add(imageToAdd);
        commandBox.getChildren().addAll(container);
    }

    @FXML
    private void handleAddStepForwardAction(Event event) {
        commandSequence.addCommand(new StepForwardCommand(boardData));
//        commandSeq.setText(commandSeq.getText() + "F\n");
        System.out.println("Step forward event fired.");
        addCommandToBox(forwardImage.getImage());
    }

    @FXML
    private void handleAddTurnLeftAction(Event event) {
        commandSequence.addCommand(new TurnLeftCommand(boardData));
//        commandSeq.setText(commandSeq.getText() + "L\n");
        System.out.println("Turn left event fired.");
        addCommandToBox(leftImage.getImage());
    }

    @FXML
    private void handleAddTurnRightAction(Event event) {
        commandSequence.addCommand(new TurnRightCommand(boardData));
//        commandSeq.setText(commandSeq.getText() + "R\n");
        System.out.println("Turn right event fired.");
        addCommandToBox(rightImage.getImage());
    }

    @FXML
    private void handleRemoveLastCommandAction(Event event) {
        if (commandSequence.getSize() > 0) {
            commandSequence.removeLastCommand();
//            commandSeq.setText(commandSeq.getText().substring(0, commandSeq.getText().length() - 2));
            commandBox.getChildren().remove(commandSequence.getSize());
        }
        System.out.println("Remove last command event fired.");

    }

    @FXML
    private void handleClearCommandSequenceAction(Event event) {
        commandBox.getChildren().remove(0,commandSequence.getSize());
        commandSequence.clear();

//        commandSeq.setText("");
        System.out.println("Clear sequence event fired.");
    }

    @FXML
    private void handleExecuteCommandSequenceAction(Event event) {
        executeImage.setOnMouseClicked(null);
        executeImage.setOpacity(0);
        int startX = boardData.getTurtle().getX();
        int startY = boardData.getTurtle().getY();
        info.setText(commandSequence.execute());
        System.out.println("Execute event fired.");
        gc_turtle.setFill(Color.TRANSPARENT);
        gc_turtle.fillRect(0, 0, boardCanvas.getHeight(), boardCanvas.getWidth());
        animate(boardData.getTurtle().getMemory(), startX, startY);
        boardData.getTurtle().wipeMemory();
        if (info.getText().equals("Great! :)")) {
            nextLevelImage.setVisible(true);
        }
    }

    @FXML
    private void handleResetAction(Event event) {
        executeImage.setOnMouseClicked(this::handleExecuteCommandSequenceAction);
        executeImage.setOpacity(100);
        System.out.println("Reset event fired.");
        setData(DataGenerator.generateGameData(GameAppController.lvl));
//        commandSeq.setText("");
        info.setText(GameAppController.lvl + "/5");
        boardData.getTurtle().wipeMemory();
    }

    @FXML
    private void handleNextLevelAction(Event event) {
        executeImage.setOnMouseClicked(this::handleExecuteCommandSequenceAction);
        executeImage.setOpacity(100);
        System.out.println("Next level event fired.");
        if (GameAppController.lvl < 5) GameAppController.lvl++;
        setData(DataGenerator.generateGameData(GameAppController.lvl));
//        commandSeq.setText("");
        info.setText(GameAppController.lvl + "/5");
        nextLevelImage.setVisible(false);
        levelBox.getSelectionModel().select(GameAppController.lvl-1);
    }

    @FXML
    private void handleLoopAction(Event event) {
        String loopseq = "";
        appController.showLoopDialog();

    }

    public void visitField(int x, int y) {
        gc_board.setFill(Color.BLUE);
        gc_board.fillRect(100 * x + 5, 100 * y + 5, 100 - 10, 100 - 10);
    }

    public void drawBoard() {
        gc_turtle.clearRect(0, 0, boardCanvas.getHeight(), boardCanvas.getWidth());


        for (int i = 0; i < boardData.getFields().length; i++) {
            for (int j = 0; j < boardData.getFields().length; j++) {
                if (boardData.getFields()[j][i].isVisible()) {
                    gc_board.setEffect(new DropShadow(20, 2, 2, Color.BLACK));

                    gc_board.setFill(Color.BROWN);
                    gc_board.fillRect(100 * i + 5, 100 * j + 5, 100 - 10, 100 - 10);
                    gc_board.setEffect(null);
                }
            }
        }

    }

    public void animate(LinkedList<MoveType> steps, int startX, int startY) {

        DoubleProperty x = new SimpleDoubleProperty(startX * 100 + 15);
        DoubleProperty y = new SimpleDoubleProperty(startY * 100 + 15);
        DoubleProperty r = new SimpleDoubleProperty(0);
        SequentialTransition s = new SequentialTransition();

        int xEnd = x.intValue(), yEnd = y.intValue(), rEnd = r.intValue();

        for (MoveType step : steps) {
            switch (step) {
                case Up:
                    yEnd -= 100;
                    break;
                case Down:
                    yEnd += 100;
                    break;
                case Left:
                    xEnd -= 100;
                    break;
                case Right:
                    xEnd += 100;
                    break;
                case RLeft:
                    rEnd -= 90;
                    break;
                case RRight:
                    rEnd += 90;
                    break;
            }

            KeyValue px = new KeyValue(x, xEnd);
            KeyValue py = new KeyValue(y, yEnd);
            KeyValue pr = new KeyValue(r, rEnd);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.5), px, py, pr);
            Timeline t = new Timeline(kf);
            Timeline pause = new Timeline(new KeyFrame(Duration.seconds(0.2)));

            s.getChildren().addAll(t,pause);

        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);

                gc_turtle.clearRect(0, 0, turtleCanvas.getWidth(), turtleCanvas.getHeight());

                visitField(x.intValue() / 100, y.intValue() / 100);

                fxImage.setRotate(r.doubleValue());
                double width = sin(toRadians(abs(r.doubleValue()) % 90)) + cos(toRadians(abs(r.doubleValue()) % 90));
                double margin = (70 * width - 70) / 2;
                gc_turtle.setEffect(new DropShadow(20, 2, 2, Color.BLACK));
                gc_turtle.drawImage(fxImage.snapshot(params, null), x.intValue() - margin, y.intValue() - margin, 70 * width, 70 * width);
                gc_turtle.setEffect(null);
            }
        };

        s.setOnFinished(event -> {
            timer.stop();
            //what to do after animation ends
        });
        timer.start();
        s.play();
    }

    public void setData(Board board) {
        this.boardData = board;
        this.commandSequence = new CommandSequence(board);

        fxImage.setRotate(0);

        gc_turtle.clearRect(0,0,boardCanvas.getWidth(),boardCanvas.getHeight());
        gc_board.clearRect(0,0,boardCanvas.getWidth(),boardCanvas.getHeight());
        drawBoard();
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        gc_turtle.setEffect(new DropShadow(20, 2, 2, Color.BLACK));
        gc_turtle.drawImage(fxImage.snapshot(params, null), 100 * boardData.getTurtle().getX() + 15, 100 * boardData.getTurtle().getY() + 15, 70, 70);
    }

    public void setAppController(GameAppController appController) {
        this.appController = appController;
    }
}