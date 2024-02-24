package model.command;

import model.AbstractForm;
import model.FormContainer;

public class RemoveCommand implements ICommand{

    public AbstractForm form;
    private FormContainer formContainer;
    public RemoveCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    @Override
    public void executeCommand() {
        this.formContainer.removeFormFromMainContainer(form);
        CommandHistory.getCommandsList().push(this);
    }

    @Override
    public void undo() {
        this.formContainer.addFormToMainContainer(form);
    }

    @Override
    public void redo() {
       
    }
    
}
