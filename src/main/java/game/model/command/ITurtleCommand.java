package game.model.command;

public interface ITurtleCommand {
    boolean execute();
    void undo();
    String getName();
//    String getHelp();

}
