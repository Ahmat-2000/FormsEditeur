package model.commandPattern;

import model.AbstractForm;
import model.FormContainer;

/**
 * Classe représentant une commande pour créer et gérer une nouvelle forme dans l'application.
 * Elle implémente l'interface {@code ICommand} et permet d'exécuter, d'annuler et de rétablir
 * la création d'une forme au sein d'un conteneur spécifique.
 */
public class CreateCommand implements ICommand {
    /**
     * La forme à créer et à gérer.
     */
    private AbstractForm form;

    /**
     * Le conteneur dans lequel la forme sera ajoutée et gérée.
     */
    private FormContainer formContainer;

    /**
     * Constructeur de la commande de création. Initialise la commande avec la forme
     * à créer et le conteneur dans lequel elle sera ajoutée.
     *
     * @param form La forme à créer.
     * @param formContainer Le conteneur où la forme sera ajoutée et gérée.
     */
    public CreateCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    /**
     * Exécute la commande de création en ajoutant la forme au conteneur spécifié.
     * Cette action est enregistrée dans l'historique des commandes pour permettre
     * une éventuelle annulation.
     */
    @Override
    public void executeCommand() {
        this.formContainer.addForm(form);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear(); 
    }

    /**
     * Annule la création de la forme en la retirant du conteneur.
     * Cette action est enregistrée dans l'historique des commandes pour permettre
     * un éventuel rétablissement.
     */
    @Override
    public void undo() {
        this.formContainer.removeForm(form); 
        CommandHistory.getRedoList().push(this); 
    }

    /**
     * Rétablit la création de la forme après une annulation en la rajoutant au conteneur.
     * Cette action est à nouveau enregistrée dans l'historique des commandes pour
     * permettre d'autres annulations si nécessaire.
     */
    @Override
    public void redo() {
        this.formContainer.addForm(form);
        CommandHistory.getUndoList().push(this); 
    }
}
