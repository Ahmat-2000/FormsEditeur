package model.commandPattern;

import java.util.Stack;

public class CommandHistory {
    private static final Stack<ICommand> UNDOLIST = new Stack<>();
    private static final Stack<ICommand> REDOLIST = new Stack<>();

    private CommandHistory(){};
    public static Stack<ICommand> getUndoList(){
        return UNDOLIST;
    }
    public static Stack<ICommand> getRedoList(){
        return REDOLIST;
    }
}
