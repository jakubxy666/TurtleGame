package game.model.command;

import game.model.Board;
import game.model.BoardField;
import game.model.Turtle;
import game.model.command.ITurtleCommand;

public class StepForwardCommand implements ITurtleCommand {

    private Board board;
    private Turtle turtle;

    public StepForwardCommand(Board b) {
        this.board = b;
        this.turtle = b.getTurtle();
    }

    @Override
    public boolean execute() {
        int xOffset = 0;
        int yOffset = 0;

        switch (turtle.getOrientation()) {
            case E:
                xOffset = 1;
                yOffset = 0;
                break;
            case N:
                xOffset = 0;
                yOffset = -1;
                break;
            case S:
                xOffset = 0;
                yOffset = 1;
                break;
            case W:
                xOffset = -1;
                yOffset = 0;
                break;
        }

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
    public String getName() {
        return "Forward";
    }
}