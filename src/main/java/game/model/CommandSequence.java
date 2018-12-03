package game.model;

import game.model.command.ITurtleCommand;

import java.util.LinkedList;

public class CommandSequence {
    private LinkedList<ITurtleCommand> commands = new LinkedList<>();
    private BoardField[][] fields;

    public CommandSequence(BoardField[][] f) {
        this.fields = f;
    }

    public void addCommand(ITurtleCommand command) {
        commands.push(command);
    }

    public void removeLastCommand() {
        commands.pop();
    }

    public int getSize() {
        return commands.size();
    }

    public void clear() {
        commands.clear();
    }

    public String execute() {
        boolean allCommandsOk = true;
        for (ITurtleCommand com : commands) {
            if (!com.execute()) allCommandsOk = false;
            // update view here!
        }
        if (!allCommandsOk)
            return "Fail :( \n You tried to make impossible move. (There is no way)";
        else {
            //check if all visible are also visited
            System.out.println("Nie ma bledow");
            boolean allVisibleAreVisited = true;
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    if (fields[i][j].isVisible() && !fields[i][j].isVisited())
                        allVisibleAreVisited = false;
                }
            }
            if (allVisibleAreVisited) return "Great! :)";
            else return "You didn't visited all fields :(";
        }
    }
}