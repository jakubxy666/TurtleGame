package game.model;

import game.model.command.ITurtleCommand;

import java.util.LinkedList;

public class CommandSequence {
    private LinkedList<ITurtleCommand> commands = new LinkedList<>();

    public void addCommand(ITurtleCommand command) {
        commands.push(command);
    }

    public void removeLastCommand() {
        commands.pop();
    }

    public void clear() {
        commands.clear();
    }

    public void execute() {
        for (ITurtleCommand com : commands) {
            com.execute();
        }
    }
}
