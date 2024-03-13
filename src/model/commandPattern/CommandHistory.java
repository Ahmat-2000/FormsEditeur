package model.commandPattern;

import java.util.Stack;

/**
 * Classe utilitaire gérant l'historique des commandes pour les actions "undo" et "redo".
 * Elle utilise deux piles pour stocker les commandes exécutées et celles annulées.
 */
public class CommandHistory {
    private static final Stack<ICommand> UNDOLIST = new Stack<>(); // Pile pour les commandes annulables.
    private static final Stack<ICommand> REDOLIST = new Stack<>(); // Pile pour les commandes réexécutables.

    // Constructeur privé pour empêcher l'instanciation.
    private CommandHistory(){};

    /**
     * Obtient la pile des commandes annulables.
     *
     * @return La pile des commandes "undo".
     */
    public static Stack<ICommand> getUndoList(){
        return UNDOLIST;
    }

    /**
     * Obtient la pile des commandes réexécutables.
     *
     * @return La pile des commandes "redo".
     */
    public static Stack<ICommand> getRedoList(){
        return REDOLIST;
    }
}
