package model.commandPattern;

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
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    @Override
    public void undo() {
        this.formContainer.addFormToMainContainer(form);
        CommandHistory.getRedoList().push(this);
    }

    @Override
    public void redo() {
        this.formContainer.removeFormFromMainContainer(form);
        CommandHistory.getUndoList().push(this);
    }

}