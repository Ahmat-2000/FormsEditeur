package model.command;

public interface ICommand {
    public void executeCommand();
    public void undo();
    public void redo();
}
