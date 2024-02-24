package model.command;

import java.util.ArrayList;

import model.AbstractForm;
import model.FormContainer;

public class ResetCommand implements ICommand{

    private ArrayList<AbstractForm> formList;
    private FormContainer oldFormContainer;
    public ResetCommand(FormContainer oldFormContainer) {
        this.oldFormContainer = oldFormContainer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void executeCommand() {
        this.formList = (ArrayList<AbstractForm>) this.oldFormContainer.getMainContainerList().clone();
        this.oldFormContainer.clearMainContainer();
        CommandHistory.getCommandsList().push(this);
    }

    @Override
    public void undo() {
        this.oldFormContainer.setMainContainerList(this.formList);
    }

    @Override
    public void redo() {
       
    }
    
}
