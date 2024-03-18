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
    /** Les coordonnées iniatiaux de la forme*/
    private int initialX, initialY;
    /** Les coordonnées de la souris lors du premier click.*/
    private int predX,predY;
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
        predX = e.getX();
        predY = e.getY();
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(predX,predY) && f.isEditable()) {
                form = f;
                initialX = form.getX(); 
                initialY = form.getY();
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
        int dx = e.getX() - predX;
        int dy = e.getY() - predY;
        int width = dx + form.getX() + form.getWidth();
        int height = dy + form.getY() + form.getHeight();
        if(form != null &&  dx + form.getX() > 2 && width < e.getComponent().getWidth()-2 && dy + form.getY() > 2 && height < e.getComponent().getHeight() -2) {
            form.moveForm(dx,dy); 
            predX = e.getX();
            predY = e.getY();
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
                    form.setX(initialX);
                    form.setY(initialY);
                    collision = true;
                    break; 
                }  
            }
            if (!collision) {
                MoveCommand command = new MoveCommand(form, initialX,initialY); 
                command.executeCommand();
            }
        }
        dragged = false;
    }
}
