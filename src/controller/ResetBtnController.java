package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FormContainer;
import model.commandPattern.ResetCommand;
import view.ViewFormContainer;

/**
 * Contrôleur pour le bouton de réinitialisation.
 * Lorsqu'actionné, il remet à zéro l'état du conteneur de formes et de la vue associée.
 */
public class ResetBtnController implements ActionListener {
    private ViewFormContainer viewContainer; // La vue contenant les formes.
    private FormContainer formContainer; // Le conteneur de formes.

    /**
     * Constructeur du contrôleur de réinitialisation.
     * 
     * @param viewContainer La vue qui affiche les formes.
     * @param formContainer Le conteneur qui gère les formes.
     */
    public ResetBtnController(ViewFormContainer viewContainer, FormContainer formContainer) {
        this.viewContainer = viewContainer;
        this.formContainer = formContainer;
    }

    /**
     * Répond à l'action de bouton pressé pour réinitialiser la vue et le modèle.
     * 
     * @param e L'événement d'action de bouton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Vérifier si le conteneur principal n'est pas vide avant la réinitialisation
        if (!this.formContainer.getMainContainerList().isEmpty()) {
            // Créer et exécuter la commande de réinitialisation
            ResetCommand command = new ResetCommand(this.formContainer);
            command.executeCommand();
            // Retirer les écouteurs d'état actuels de la vue
            this.viewContainer.removeListeners(this.viewContainer.getState());
            // Réinitialiser l'état de la vue à null
            this.viewContainer.setState(null);
        }
    }
}
