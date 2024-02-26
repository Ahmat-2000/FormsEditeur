package model.commandPattern;

import model.AbstractForm;

public class ResizeCommand implements ICommand{
    public AbstractForm form;
    private int width, height,x,y;
    public ResizeCommand(AbstractForm form, int x, int y) {
        this.form = form;
        this.width  = form.getWidth();
        this.height = form.getHeight();
        this.x = x;
        this.y = y;
    }

    @Override
    public void executeCommand() {
        form.resize(x,y);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    @Override
    public void undo() {
        form.setHeight(height);
        form.setWidth(width);
        CommandHistory.getRedoList().push(this);
    }

    @Override
    public void redo() {
        form.resize(x,y);
        CommandHistory.getUndoList().push(this);
    }

}
