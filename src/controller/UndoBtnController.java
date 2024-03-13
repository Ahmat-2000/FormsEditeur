package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.commandPattern.CommandHistory;
import model.commandPattern.ICommand;

/**
 * Contrôleur gérant les actions d'annulation (undo) dans l'interface utilisateur.
 * Écoute et traite les actions sur le bouton "Undo".
 */
public class UndoBtnController implements ActionListener{
    
    /**
     * Méthode appelée lorsque l'utilisateur clique sur le bouton "Undo".
     * Vérifie si la pile de commandes d'annulation n'est pas vide et, si nécessaire,
     * annule la dernière commande effectuée.
     *
     * @param e L'événement d'action qui a été déclenché.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Vérifier si la pile de commandes d'annulation n'est pas vide
        if (!CommandHistory.getUndoList().empty()) {
            // Récupérer et retirer la dernière commande de la pile undo
            ICommand command = CommandHistory.getUndoList().pop();
            // Annuler la commande
            command.undo();
        }
    }
}
