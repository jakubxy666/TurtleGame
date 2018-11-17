package game.model.command;

import game.model.Turtle;
import game.model.command.ITurtleCommand;

public class StepForwardCommand implements ITurtleCommand {

    Turtle turtle;
    int xOffset;
    int yOffset;

    public StepForwardCommand(Turtle t) {
        this.turtle = t;

        switch (turtle.getOrientation()){
            case E:
                xOffset=1;
                yOffset=0;
            case N:
                xOffset=0;
                yOffset=1;
            case S:
                xOffset=0;
                yOffset=-1;
            case W:
                xOffset=-1;
                yOffset=0;
        }
    }

    @Override
    public void execute() {
        turtle.setX(turtle.getX()+xOffset);
        turtle.setY(turtle.getY()+yOffset);
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
