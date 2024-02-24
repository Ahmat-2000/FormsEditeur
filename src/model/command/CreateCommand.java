package model.command;

import model.AbstractForm;
import model.FormContainer;

public class CreateCommand implements ICommand{
    public AbstractForm form;
    private FormContainer formContainer;
    public CreateCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    @Override
    public void executeCommand() {
        this.formContainer.addFormToMainContainer(form);
        CommandHistory.getCommandsList().push(this);
    }

    @Override
    public void undo() {
        this.formContainer.removeFormFromMainContainer(form);
    }

    @Override
    public void redo() {
       
    }
}
