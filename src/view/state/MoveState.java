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
    /** Les coordonnées de la souris lors d'un click.*/
    private int startX, startY;
    /** La forme en cours de déplacement. */
    private AbstractForm form; 
    /** Permet de savoir si la souris est glissée */
    private boolean dragged = false;
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
        if (form != null) { 
            form.moveForm(e.getX(), e.getY()); 
            dragged = true;
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
        if (dragged == true && form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collision(fo)) { 
                    form.moveForm(startX, startY); 
                    collision = true;
                    break; 
                }  
            }
            if ( !collision) {
                form.moveForm(startX, startY); 
                MoveCommand command = new MoveCommand(form, e.getX(), e.getY()); 
                command.executeCommand();
            }
        }
        dragged = false;
    }
}
