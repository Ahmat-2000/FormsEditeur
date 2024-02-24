package model.commandPattern;

public interface ICommand {
    public void executeCommand();
    public void undo();
    public void redo();
}
