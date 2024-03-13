package model.commandPattern;

import model.AbstractForm;
import model.FormContainer;

/**
 * Commande pour supprimer une forme du conteneur de formes.
 * Permet d'exécuter, annuler et rétablir la suppression d'une forme.
 */
public class RemoveCommand implements ICommand {

    private AbstractForm form; // La forme à supprimer.
    private FormContainer formContainer; // Le conteneur de formes.

    /**
     * Constructeur de la commande de suppression.
     * 
     * @param form La forme à supprimer.
     * @param formContainer Le conteneur où la forme sera supprimée.
     */
    public RemoveCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    /**
     * Exécute la suppression de la forme et met à jour l'historique des commandes.
     */
    @Override
    public void executeCommand() {
        formContainer.removeFormFromMainContainer(form);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule la suppression de la forme, la réajoute au conteneur, et met à jour l'historique.
     */
    @Override
    public void undo() {
        formContainer.addFormToMainContainer(form);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Rétablit la suppression de la forme après une annulation.
     */
    @Override
    public void redo() {
        formContainer.removeFormFromMainContainer(form);
        CommandHistory.getUndoList().push(this);
    }
}
