package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.commandPattern.CommandHistory;
import model.commandPattern.ICommand;

/**
 * Contrôleur gérant l'action du bouton "Redo" (Refaire).
 * Il écoute les événements déclenchés par le bouton "redo" et exécute la commande de rétablissement.
 */
public class RedoBtnController implements ActionListener {
    /**
     * Méthode appelée lorsqu'une action est effectuée, c'est-à-dire lorsque l'utilisateur clique sur le bouton "redo".
     * Cette méthode vérifie si la pile de commandes redo n'est pas vide et, si c'est le cas, exécute la dernière commande.
     * 
     * @param e L'événement d'action qui a été déclenché.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Vérifier si la liste de commandes redo n'est pas vide
        if (!CommandHistory.getRedoList().empty()) {
            // Récupérer et retirer la dernière commande de la pile redo
            ICommand command = CommandHistory.getRedoList().pop();
            // Exécuter la commande de redo
            command.redo();
        }
    }
}
