package model.commandPattern;

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
        this.formContainer.addForm(form);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    @Override
    public void undo() {
        this.formContainer.removeForm(form);
        CommandHistory.getRedoList().push(this);
    }

    @Override
    public void redo() {
        this.formContainer.addForm(form);
        CommandHistory.getUndoList().push(this);
    }
}
