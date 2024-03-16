package model.commandPattern;

import model.AbstractForm;

/**
 * Classe représentant une commande pour déplacer une forme dans l'application.
 * Cette classe implémente l'interface {@code ICommand} et permet d'exécuter, d'annuler
 * et de rétablir le déplacement d'une forme.
 */
public class MoveCommand implements ICommand {
    /**
     * La forme à déplacer.
     */
    private AbstractForm form;

    /**
     * Positions initiales (X, Y) de la forme avant le déplacement.
     */
    private int oldX, oldY;

    /**
     * Nouvelles positions (X, Y) de la forme après le déplacement.
     */
    private int x, y;

    /**
     * Constructeur de la commande de déplacement.
     * Initialise la commande avec la forme spécifiée et ses nouvelles positions.
     *
     * @param form La forme à déplacer.
     * @param x La nouvelle position horizontale (X) de la forme.
     * @param y La nouvelle position verticale (Y) de la forme.
     */
    public MoveCommand(AbstractForm form, int x, int y) {
        this.form = form;
        this.x = x;
        this.y = y;
        // Sauvegarde les positions initiales de la forme pour une éventuelle annulation.
        this.oldX = form.getX();
        this.oldY = form.getY();
    }

    /**
     * Exécute le déplacement de la forme vers les nouvelles positions spécifiées
     * et met à jour l'historique des commandes pour permettre l'annulation.
     */
    @Override
    public void executeCommand() {
        form.moveForm(x, y); 
        CommandHistory.getUndoList().push(this); 
        CommandHistory.getRedoList().clear(); 
    }

    /**
     * Annule le dernier déplacement de la forme en la repositionnant à ses
     * coordonnées initiales et met à jour l'historique pour permettre un rétablissement.
     */
    @Override
    public void undo() {
        form.moveForm(oldX, oldY); 
        CommandHistory.getRedoList().push(this); 
    }

    /**
     * Rétablit le déplacement de la forme après une annulation, la ramenant
     * à ses nouvelles coordonnées et met à jour l'historique d'annulation.
     */
    @Override
    public void redo() {
        form.moveForm(x, y); 
        CommandHistory.getUndoList().push(this); 
    }
}
