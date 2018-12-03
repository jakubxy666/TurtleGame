package game.model.command;

import game.model.Orientation;
import game.model.Turtle;

public class TurnLeftCommand implements ITurtleCommand {

    Turtle turtle;
    Orientation oldOrientation;

    public TurnLeftCommand(Turtle t) {
        this.turtle = t;
        oldOrientation = turtle.getOrientation();
    }

    @Override
    public boolean execute() {
        turtle.setOrientation(Orientation.values()[oldOrientation.ordinal()+1]);
        return true;
    }

    @Override
    public void undo() {
        turtle.setOrientation(Orientation.values()[oldOrientation.ordinal()-1]);
    }

    @Override
    public String getName() {
        return "Turn Left";
    }
}