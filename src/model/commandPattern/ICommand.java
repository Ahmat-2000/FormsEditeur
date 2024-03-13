package model.commandPattern;

/**
 * Interface définissant le contrat pour les commandes dans le modèle de conception Command.
 * Fournit les méthodes nécessaires pour exécuter, annuler (undo) et rétablir (redo) des actions.
 */
public interface ICommand {
    /**
     * Exécute l'action de la commande.
     */
    void executeCommand();

    /**
     * Annule l'action précédemment exécutée par cette commande.
     */
    void undo();

    /**
     * Rétablit l'action précédemment annulée par cette commande.
     */
    void redo();
}
