package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.MoveCommand;

/**
 * La classe MoveState représente l'état de déplacement d'une forme dans l'application.
 * Elle réagit aux événements de souris pour déplacer une forme présente dans le conteneur des formes.
 */
public class MoveState extends MouseAdapter {
    /** Le conteneur des formes où ajouter le cercle. */
    private FormContainer formContainer; 
    /** Les coordonnées de la souris pour le début et la fin du dessin.*/
    private int startX, startY, endX, endY;
    /** La forme en cours de déplacement. */
    private AbstractForm form; 

    /**
     * Constructeur de MoveState qui prend en paramètre le conteneur des formes.
     * 
     * @param formContainer Le conteneur des formes où se trouve la forme à déplacer.
     */
    public MoveState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant.
     * Récupère la forme sous la souris pour démarrer le déplacement.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY()) && f.isEditable()) {
                form = f;
                startX = form.getX(); 
                startY = form.getY();
                break;
            }
        }
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant et que la souris est ensuite déplacée.
     * Déplace la forme en cours de déplacement en fonction de la position actuelle de la souris.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        endX = e.getX(); 
        endY = e.getY();
        if (form != null) { 
            form.moveForm(endX, endY); 
        }
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le déplacement de la forme et exécute la commande de déplacement si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean collision = false;
        if (form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collision(fo)) { 
                    form.moveForm(startX, startY); 
                    collision = true;
                    break; 
                }  
            }
        }
        if (form != null && !collision) {
            form.moveForm(startX, startY); 
            MoveCommand command = new MoveCommand(form, endX, endY); 
            command.executeCommand();
        }
    }
}
