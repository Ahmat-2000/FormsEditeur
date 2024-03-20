package view.state;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.ResizeCommand;

/**
 * La classe ResizeState représente l'état de redimensionnement d'une forme dans l'application.
 * Elle réagit aux événements de souris pour redimensionner une forme présente dans le conteneur des formes.
 */
public class ResizeState extends MouseAdapter {
    /** Le conteneur des formes où se trouve la forme à redimensionner. */
    private FormContainer formContainer; 
    /** Les dimensions initiales de la forme avant redimensionnement. */
    private int width, height; 
    /** La forme en cours de redimensionnement. */
    private AbstractForm form;

    private boolean resizable = false;

    /**
     * Constructeur de ResizeState qui prend en paramètre le conteneur des formes.
     * 
     * @param formContainer Le conteneur des formes où se trouve la forme à redimensionner.
     */
    public ResizeState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant.
     * Récupère la forme sous la souris pour démarrer le redimensionnement.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (form != null) {
            this.width = form.getWidth(); 
            this.height = form.getHeight();
            form.setDashed(true);
            if (form.getWidth() + form.getX() <=  e.getX() + 20 && form.getWidth() + form.getX() >=  e.getX() - 20 &&
                form.getHeight() + form.getY() <=  e.getY() + 20 && form.getHeight() + form.getY() >=  e.getY() - 20
            ) {
                resizable = true;
                e.getComponent().setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            }
        }
    }
    @Override 
    public void mouseMoved(MouseEvent e){
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY()) && f.isEditable()) {
                f.setShowResize(true);
                form = f;
                break;
            }
            else {
                f.setShowResize(false);    
            }
        }
    }
    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant et que la souris est ensuite déplacée.
     * Redimensionne la forme en fonction de la position actuelle de la souris pour afficher le redimensionnement en cours.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(resizable);
        if (form != null && resizable && e.getX() < e.getComponent().getWidth() - 2 && e.getY() < e.getComponent().getHeight() - 2) 
        { 
            form.resize(e.getX(), e.getY()); 
            this.formContainer.collisionDetection(form);
        }
    }
    
    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le redimensionnement de la forme et exécute la commande de redimensionnement si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(form != null) {
            form.setWidth(width); 
            form.setHeight(height);
            if (resizable && !form.isCollision() && e.getX() - form.getX() >= 10 && e.getY() - form.getY() >= 10){
                ResizeCommand command = new ResizeCommand(form, e.getX(), e.getY()); 
                command.executeCommand(); 
            }
            form.setDashed(false);
            form.setCollision(false);
        }
        e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        resizable = false;
    }
}
