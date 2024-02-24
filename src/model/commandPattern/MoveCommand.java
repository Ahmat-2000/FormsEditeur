package model.commandPattern;

import model.AbstractForm;

public class MoveCommand implements ICommand{
    public AbstractForm form;
    private int oldX, oldY, x,y;
    public MoveCommand(AbstractForm form, int x , int y) {
        this.form = form;
        this.x = x;
        this.y = y;
        this.oldX = form.getX(); 
        this.oldY = form.getY();
    }

    @Override
    public void executeCommand() {
        form.moveForm(x,y);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    @Override
    public void undo() {
        form.moveForm(oldX, oldY);
        CommandHistory.getRedoList().push(this);
    }

    @Override
    public void redo() {
        form.moveForm(x,y);
        CommandHistory.getUndoList().push(this);
    }
}