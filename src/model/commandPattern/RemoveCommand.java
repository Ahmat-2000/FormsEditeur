package model.commandPattern;

import model.AbstractForm;
import model.FormContainer;

/**
 * La classe {@code RemoveCommand} implémente l'interface {@code ICommand} pour gérer la suppression d'une forme
 * au sein d'un conteneur de formes. Cette commande supporte les opérations d'exécution, d'annulation et de rétablissement
 * pour offrir une gestion flexible des actions sur les formes.
 */
public class RemoveCommand implements ICommand {

    /** La forme spécifique à supprimer. */
    private AbstractForm form;
    
    /** Le conteneur de formes d'où la forme sera supprimée. */
    private FormContainer formContainer;

    /**
     * Construit une commande de suppression avec la forme spécifique et le conteneur de formes concerné.
     * 
     * @param form La forme à supprimer du conteneur.
     * @param formContainer Le conteneur de formes qui contient la forme à supprimer.
     */
    public RemoveCommand(AbstractForm form, FormContainer formContainer) {
        this.form = form;
        this.formContainer = formContainer;
    }

    /**
     * Exécute l'action de suppression en retirant la forme du conteneur de formes.
     * L'action est enregistrée dans l'historique des commandes pour permettre son annulation.
     */
    @Override
    public void executeCommand() {
        this.formContainer.removeForm(form);
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule l'action de suppression précédemment exécutée en réajoutant la forme au conteneur de formes.
     * L'action est enregistrée dans l'historique des commandes pour permettre son rétablissement.
     */
    @Override
    public void undo() {
        this.formContainer.addForm(form);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Rétablit l'action de suppression après une annulation, en retirant de nouveau la forme du conteneur.
     * L'action est à nouveau enregistrée dans l'historique des commandes pour permettre d'autres annulations.
     */
    @Override
    public void redo() {
        this.formContainer.removeForm(form);
        CommandHistory.getUndoList().push(this);
    }
}
