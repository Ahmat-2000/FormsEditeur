package model.commandPattern;

import java.util.ArrayList;

import model.AbstractForm;
import model.FormContainer;

public class ResetCommand implements ICommand{

    private ArrayList<AbstractForm> formList;
    private FormContainer oldFormContainer;
    public ResetCommand(FormContainer oldFormContainer) {
        this.oldFormContainer = oldFormContainer;
    }

    @Override
    public void executeCommand() {
        this.formList = this.oldFormContainer.copyOfList();
        this.oldFormContainer.clearMainContainer();
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    @Override
    public void undo() {
        this.oldFormContainer.setMainContainerList(this.formList);
        CommandHistory.getRedoList().push(this);
    }

    @Override
    public void redo() {
        this.formList = this.oldFormContainer.copyOfList();
        this.oldFormContainer.clearMainContainer();
        CommandHistory.getUndoList().push(this);
    }
    
}
