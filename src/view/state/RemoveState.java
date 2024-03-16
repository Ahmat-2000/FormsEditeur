package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.RemoveCommand;

/**
 * La classe RemoveState représente l'état de suppression d'une forme dans l'application.
 * Elle réagit à l'événement de clic de souris pour supprimer une forme du conteneur des formes.
 */
public class RemoveState extends MouseAdapter {
    /** Le conteneur des formes où se trouve la forme à supprimer. */
    private FormContainer formContainer; 

    /**
     * Constructeur de RemoveState qui prend en paramètre le conteneur des formes.
     * 
     * @param formContainer Le conteneur des formes où se trouve la forme à supprimer.
     */
    public RemoveState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est cliqué (pressé et relâché) sur un composant.
     * Supprime la forme sous la souris du conteneur des formes, si elle existe.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        AbstractForm tmp = null; 
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY()) && f.isEditable()) {
                tmp = f;
                break;
            }
        }
        if (tmp != null) { 
            RemoveCommand command = new RemoveCommand(tmp, this.formContainer);
            command.executeCommand(); 
        }
    }
}
