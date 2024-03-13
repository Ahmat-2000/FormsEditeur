package model.commandPattern;

import model.AbstractForm;

/**
 * La classe ResizeCommand implémente l'interface ICommand pour gérer le redimensionnement d'un formulaire.
 * Cette commande permet de redimensionner un formulaire spécifique et de supporter les fonctionnalités d'annulation
 * et de rétablissement associées à cette action.
 */
public class ResizeCommand implements ICommand {
    // Le formulaire à redimensionner.
    public AbstractForm form;

    // Les dimensions originales du formulaire avant le redimensionnement.
    private int width, height;

    // Les nouvelles dimensions souhaitées pour le redimensionnement.
    private int x, y;

    /**
     * Constructeur qui initialise la commande avec le formulaire à redimensionner et les nouvelles dimensions.
     *
     * @param form Le formulaire à redimensionner.
     * @param x La nouvelle largeur souhaitée.
     * @param y La nouvelle hauteur souhaitée.
     */
    public ResizeCommand(AbstractForm form, int x, int y) {
        this.form = form;
        this.width = form.getWidth();
        this.height = form.getHeight();
        this.x = x;
        this.y = y;
    }

    /**
     * Exécute la commande de redimensionnement. Applique les nouvelles dimensions au formulaire
     * et enregistre cette commande dans l'historique pour permettre l'annulation.
     */
    @Override
    public void executeCommand() {
        form.resize(x, y);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule le redimensionnement en rétablissant les dimensions originales du formulaire.
     * Cette action permet de revenir à l'état précédent l'exécution de la commande.
     */
    @Override
    public void undo() {
        form.setHeight(height);
        form.setWidth(width);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Réexécute la commande de redimensionnement après une annulation, appliquant à nouveau
     * les nouvelles dimensions au formulaire. Cela permet de rétablir l'action de redimensionnement.
     */
    @Override
    public void redo() {
        form.resize(x, y);
        CommandHistory.getUndoList().push(this);
    }

}
