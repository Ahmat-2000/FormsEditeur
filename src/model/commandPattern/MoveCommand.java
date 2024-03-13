package model.commandPattern;

import model.AbstractForm;

/**
 * Commande pour déplacer une forme dans l'application.
 * Permet d'exécuter, annuler et rétablir le déplacement d'une forme.
 */
public class MoveCommand implements ICommand{
    private AbstractForm form; // La forme à déplacer.
    private int oldX, oldY; // Positions initiales de la forme.
    private int x, y; // Nouvelles positions après le déplacement.

    /**
     * Constructeur initialisant la commande avec la forme et ses nouvelles positions.
     * 
     * @param form La forme à déplacer.
     * @param x La nouvelle position X de la forme.
     * @param y La nouvelle position Y de la forme.
     */
    public MoveCommand(AbstractForm form, int x, int y) {
        this.form = form;
        this.x = x;
        this.y = y;
        this.oldX = form.getX();
        this.oldY = form.getY();
    }

    /**
     * Exécute le déplacement de la forme et met à jour l'historique des commandes.
     */
    @Override
    public void executeCommand() {
        form.moveForm(x, y);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule le dernier déplacement de la forme et met à jour l'historique des commandes.
     */
    @Override
    public void undo() {
        form.moveForm(oldX, oldY);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Rétablit le déplacement de la forme après une annulation.
     */
    @Override
    public void redo() {
        form.moveForm(x, y);
        CommandHistory.getUndoList().push(this);
    }
}
