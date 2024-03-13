package model.commandPattern;

import model.AbstractForm;
import model.FormContainer;

/**
 * Commande pour créer et gérer une nouvelle forme dans l'application.
 * Implémente l'interface ICommand pour l'exécution, l'annulation et le rétablissement de la création d'une forme.
 */
public class CreateCommand implements ICommand {
    private AbstractForm form; // La forme à gérer.
    private FormContainer formContainer; // Le conteneur de formes.

    /**
     * Constructeur de la commande de création.
     *
     * @param form          La forme à créer.
     * @param formContainer Le conteneur où la forme sera ajoutée et gérée.
     */
    public CreateCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    /**
     * Exécute la commande de création en ajoutant la forme au conteneur principal.
     * Ajoute également cette commande à la pile "undo" et nettoie la pile "redo".
     */
    @Override
    public void executeCommand() {
        this.formContainer.addFormToMainContainer(form);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule la commande de création en retirant la forme du conteneur principal.
     * Ajoute cette commande à la pile "redo".
     */
    @Override
    public void undo() {
        this.formContainer.removeFormFromMainContainer(form);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Rétablit la commande de création annulée en ajoutant à nouveau la forme au conteneur principal.
     * Ajoute cette commande à la pile "undo".
     */
    @Override
    public void redo() {
        this.formContainer.addFormToMainContainer(form);
        CommandHistory.getUndoList().push(this);
    }
}
