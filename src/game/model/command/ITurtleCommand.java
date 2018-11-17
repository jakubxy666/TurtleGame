package game.model.command;

public interface ITurtleCommand {
    void execute();
    void undo();
    String getName();
//    String getHelp();

}
