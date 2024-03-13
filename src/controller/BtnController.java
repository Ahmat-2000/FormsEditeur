package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import view.ViewFormContainer;

/**
 * Le contrôleur des boutons qui réagit aux événements de clic.
 */
public class BtnController implements ActionListener {
    private ViewFormContainer viewContainer; // La vue principale de l'application.
    private MouseAdapter viewState; // L'état d'interaction de la vue.

    /**
     * Constructeur du contrôleur des boutons.
     * 
     * @param viewContainer La vue principale de l'application.
     * @param viewState L'état d'interaction de la vue.
     */
    public BtnController(ViewFormContainer viewContainer, MouseAdapter viewState) {
        this.viewContainer = viewContainer; // Initialise la vue principale de l'application.
        this.viewState = viewState; // Initialise l'état d'interaction de la vue.
    }

    @Override
    /**
     * Méthode appelée lorsqu'un événement de clic est détecté sur un bouton.
     * Elle change l'état d'interaction de la vue pour celui associé à ce contrôleur.
     */
    public void actionPerformed(ActionEvent e) {
        // Supprime les écouteurs d'événements de l'état d'interaction actuel de la vue.
        this.viewContainer.removeListeners(this.viewContainer.getState());
        // Définit le nouvel état d'interaction de la vue avec celui associé à ce contrôleur.
        this.viewContainer.setState(viewState);
        // Ajoute les écouteurs d'événements du nouvel état d'interaction à la vue.
        this.viewContainer.addListeners(viewState);
    }
}
