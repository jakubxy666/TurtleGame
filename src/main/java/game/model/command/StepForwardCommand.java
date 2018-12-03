package game.model.command;

import game.model.Board;
import game.model.BoardField;
import game.model.Turtle;
import game.model.command.ITurtleCommand;

public class StepForwardCommand implements ITurtleCommand {

    private Board board;
    private Turtle turtle;

    private int xOffset;
    private int yOffset;

    public StepForwardCommand(Board b) {
        this.board = b;
        this.turtle = b.getTurtle();

        switch (turtle.getOrientation()) {
            case E:
                xOffset = 1;
                yOffset = 0;
                break;
            case N:
                xOffset = 0;
                yOffset = 1;
                break;
            case S:
                xOffset = 0;
                yOffset = -1;
                break;
            case W:
                xOffset = -1;
                yOffset = 0;
                break;
        }
    }

    @Override
    public boolean execute() {
        int newX = turtle.getX()+ xOffset;
        int newY = turtle.getY()+ yOffset;

        if (board.canMoveTo(newX,newY)) {
            board.visitField(newX,newY);
            turtle.moveTo(newX,newY);
            return true;
        }
        return false;
    }

    @Override
    public void undo() {
        turtle.setX(turtle.getX()+xOffset);
        turtle.setY(turtle.getY()+yOffset);
    }

    @Override
    public String getName() {
        return "Forward";
    }
}