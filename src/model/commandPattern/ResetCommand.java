package model.commandPattern;

import java.util.ArrayList;
import model.AbstractForm;
import model.FormContainer;

/**
 * La classe ResetCommand implémente l'interface ICommand pour supporter la fonctionnalité de réinitialisation
 * dans un contexte de gestion de formulaires. Elle fournit des mécanismes pour réinitialiser l'état d'un conteneur de formulaires
 * à son état initial et supporte les opérations d'annulation et de rétablissement dans le cadre du patron de conception de commande.
 */
public class ResetCommand implements ICommand {

    // Conserve une capture instantanée de la liste des formulaires avant l'opération de réinitialisation.
    private ArrayList<AbstractForm> formList;

    // Référence au conteneur de formulaires original qui sera réinitialisé.
    private FormContainer oldFormContainer;

    /**
     * Construit une nouvelle instance de ResetCommand avec une référence au conteneur de formulaires
     * qui doit être réinitialisé. Ce conteneur est sauvegardé pour permettre les opérations d'annulation et de rétablissement.
     *
     * @param oldFormContainer Le conteneur de formulaires à réinitialiser.
     */
    public ResetCommand(FormContainer oldFormContainer) {
        this.oldFormContainer = oldFormContainer;
    }

    /**
     * Exécute la commande de réinitialisation. Elle sauvegarde l'état actuel du conteneur de formulaires,
     * efface le conteneur principal, et enregistre cette commande pour une fonctionnalité d'annulation.
     */
    @Override
    public void executeCommand() {
        // Crée une copie de la liste actuelle des formulaires pour l'opération d'annulation.
        this.formList = this.oldFormContainer.copyOfList();
        
        // Efface le conteneur principal, réinitialisant efficacement son état.
        this.oldFormContainer.clearMainContainer();
        
        // Enregistre cette commande dans la liste des annulations et efface l'historique des rétablissements pour maintenir l'intégrité du patron de conception de commande.
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Rétablit le conteneur de formulaires à son état précédent avant que la commande de réinitialisation ait été exécutée.
     * Cela fait partie de la fonctionnalité d'annulation dans le cadre du patron de conception de commande.
     */
    @Override
    public void undo() {
        // Restaure l'état du conteneur de formulaires à partir de la liste de formulaires sauvegardée.
        this.oldFormContainer.setMainContainerList(this.formList);
        
        // Enregistre cette opération dans la liste de rétablissement pour des actions de rétablissement potentielles.
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Ré-exécute la commande de réinitialisation après une annulation. Cela réinstaure l'état réinitialisé du conteneur de formulaires.
     * Cela fait partie de la fonctionnalité de rétablissement dans le cadre du patron de conception de commande.
     */
    @Override
    public void redo() {
        // Effectue les mêmes opérations que dans executeCommand pour rétablir la réinitialisation.
        this.formList = this.oldFormContainer.copyOfList();
        this.oldFormContainer.clearMainContainer();
        CommandHistory.getUndoList().push(this);
    }
    
}
