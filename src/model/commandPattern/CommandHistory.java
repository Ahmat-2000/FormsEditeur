package model.commandPattern;

import java.util.Stack;

/**
 * Classe utilitaire conçue pour gérer l'historique des commandes dans le cadre
 * des fonctionnalités "annuler" (undo) et "rétablir" (redo) au sein de l'application.
 * Elle encapsule deux piles distinctes : une pour stocker les commandes qui peuvent être
 * annulées (UNDOLIST) et une autre pour celles qui peuvent être rétablies après une annulation (REDOLIST).
 */
public class CommandHistory {
    /**
     * Pile statique privée pour stocker les commandes qui peuvent être annulées.
     * Chaque commande ajoutée à cette pile représente une action exécutée par l'utilisateur
     * et qui peut être inversée par une opération d'annulation.
     */
    private static final Stack<ICommand> UNDOLIST = new Stack<>();

    /**
     * Pile statique privée pour stocker les commandes qui peuvent être réexécutées.
     * Cette pile est utilisée pour rétablir les actions précédemment annulées par l'utilisateur,
     * permettant ainsi une gestion fluide des commandes redo.
     */
    private static final Stack<ICommand> REDOLIST = new Stack<>();

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     * CommandHistory est conçue comme une classe utilitaire statique et n'a donc pas besoin
     * d'être instanciée pour être utilisée.
     */
    private CommandHistory() {}

    /**
     * Fournit un accès public à la pile des commandes annulables (undo).
     * Cette méthode permet d'accéder à la pile des commandes undo, offrant ainsi la possibilité
     * de parcourir les commandes stockées, de les annuler ou de les manipuler selon les besoins.
     *
     * @return La pile statique des commandes annulables.
     */
    public static Stack<ICommand> getUndoList() {
        return UNDOLIST;
    }

    /**
     * Fournit un accès public à la pile des commandes réexécutables (redo).
     * Grâce à cette méthode, il est possible d'interagir avec la pile des commandes redo,
     * permettant de rétablir les actions annulées par l'utilisateur en fonction des interactions de ce dernier.
     *
     * @return La pile statique des commandes réexécutables.
     */
    public static Stack<ICommand> getRedoList() {
        return REDOLIST;
    }
}
