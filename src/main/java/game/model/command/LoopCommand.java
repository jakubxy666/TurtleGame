package game.model.command;

import java.util.List;

public class LoopCommand implements ITurtleCommand {
    private int iterations;
    private List<ITurtleCommand> commands;

    public LoopCommand(int i, List<ITurtleCommand> commands) {
        this.iterations = i;
        this.commands = commands;
    }

    @Override
    public boolean execute() {
        for (int i = 0; i < iterations; i++) {
            for (ITurtleCommand command : commands) {
                if (!command.execute()) return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        String result = "Loop: [" + this.iterations + "]:(";
        for(ITurtleCommand command: commands){
            result += command.getName() + ", ";
        }
        return result + ")";
    }


}
