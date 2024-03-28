package view.state;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.MoveCommand;
import view.ViewFormContainer;

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
    private AbstractForm form, formCollision; 
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
        formCollision = null;
        predX = e.getX();
        predY = e.getY();
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(predX,predY) && f.isEditable()) {
                form = f;
                initialX = form.getX(); 
                initialY = form.getY();
                form.setDashed(true);
                break;
            }
        }
    }
    @Override 
    public void mouseMoved(MouseEvent e){
        ViewFormContainer v =  (ViewFormContainer) e.getComponent();
        v.setCursor(e.getX(),e.getY(),new Cursor(Cursor.HAND_CURSOR));
    }
    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant et que la souris est ensuite déplacée.
     * Déplace la forme en cours de déplacement en fonction de la position actuelle de la souris.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if(form != null ){
            int dx = e.getX() - predX;
            int dy = e.getY() - predY;
            int width = dx + form.getX() + form.getWidth();
            int height = dy + form.getY() + form.getHeight();
            if( dx + form.getX() > 2 && width < e.getComponent().getWidth()-2 && dy + form.getY() > 2 && height < e.getComponent().getHeight() -2) {
                form.moveForm(dx,dy); 
                predX = e.getX();
                predY = e.getY();
                formCollision = this.formContainer.collisionDetection(form);
            }
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
        if (form != null) {
            if (form.isCollision()) { 
                form.setX(initialX);
                form.setY(initialY);
            }  
            else {
                MoveCommand command = new MoveCommand(form, initialX,initialY); 
                command.executeCommand();
            }
            form.setDashed(false);
            form.setCollision(false);
            if(formCollision != null){
                formCollision.setCollision(false);
            }
        }
        
    }
}
