package model.commandPattern;

import java.util.ArrayList;
import model.AbstractForm;
import model.FormContainer;

/**
 * La classe <b>ResetCommand</b> implémente l'interface <b>ICommand</b> pour gérer la réinitialisation d'un conteneur
 * de formes <b>FormContainer</b> dans une application de gestion de formes.<br/> Elle permet de réinitialiser le conteneur de formes
 * à son état vide initial et de supporter les opérations d'annulation et de rétablissement, conformément au modèle de conception Commande.
 * 
 * <p>Cette commande est utile dans les contextes où une remise à zéro ou une réinitialisation complète du conteneur de formes est nécessaire,
 * tout en offrant la flexibilité de revenir aux états précédents grâce aux fonctionnalités d'annulation et de rétablissement.</p>
 */
public class ResetCommand implements ICommand {

    /**
     * Capture instantanée de l'état du conteneur de formes avant l'exécution de la commande de réinitialisation.
     * Cette liste est utilisée pour restaurer l'état du conteneur lors de l'opération d'annulation.
     */
    private ArrayList<AbstractForm> formList;

    /**
     * Référence au conteneur de formes qui doit être réinitialisé. Cette référence est utilisée pour accéder
     * au conteneur et effectuer l'opération de réinitialisation, ainsi que pour les opérations d'annulation et de rétablissement.
     */
    private FormContainer oldFormContainer;

    /**
     * Construit une nouvelle commande de réinitialisation en associant la commande à un conteneur de formes spécifique.
     * Le conteneur de formes passé en paramètre est celui qui sera réinitialisé par cette commande.
     * 
     * @param oldFormContainer Le conteneur de formes qui doit être réinitialisé par cette commande.
     */
    public ResetCommand(FormContainer oldFormContainer) {
        this.oldFormContainer = oldFormContainer;
    }

    /**
     * Exécute l'opération de réinitialisation du conteneur de formes. Cette méthode sauvegarde l'état actuel du conteneur,
     * réinitialise le conteneur à un état vide, et enregistre la commande dans l'historique des commandes pour permettre l'annulation.
     */
    @Override
    public void executeCommand() {
        this.formList = this.oldFormContainer.copyOfList();
        this.oldFormContainer.clearContainer();
        CommandHistory.getUndoList().push(this);
        CommandHistory.getRedoList().clear();
    }

    /**
     * Annule l'opération de réinitialisation et restaure le conteneur de formes à son état précédent.
     * Cette méthode est utilisée pour annuler l'effet de la commande de réinitialisation et revenir à l'état du conteneur
     * tel qu'il était avant l'exécution de la commande.
     */
    @Override
    public void undo() {
        this.oldFormContainer.setMainContainerList(this.formList);
        CommandHistory.getRedoList().push(this);
    }

    /**
     * Rétablit l'opération de réinitialisation après une annulation. Cette méthode réexécute l'opération de réinitialisation
     * et efface à nouveau le conteneur de formes, permettant ainsi de revenir à l'état réinitialisé du conteneur après une annulation.
     */
    @Override
    public void redo() {
        this.formList = this.oldFormContainer.copyOfList();
        this.oldFormContainer.clearContainer();
        CommandHistory.getUndoList().push(this);
    }
    
}
