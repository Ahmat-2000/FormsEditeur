package model.command;

import java.util.Stack;

public class CommandHistory {
    private static final Stack<ICommand> commandList = new Stack<>();

    private CommandHistory(){};
    public static Stack<ICommand> getCommandsList(){
        return commandList;
    }
}
