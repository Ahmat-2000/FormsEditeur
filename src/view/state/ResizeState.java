package view.state;

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
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {            
            if (f.onSurface(e.getX(),e.getY()) && f.isEditable()) {
                form = f;
                this.width = f.getWidth(); 
                this.height = f.getHeight();
                form.setDashed(true);
                break;
            }
        }
    }
    @Override
    public void mouseMoved(MouseEvent e){
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {            
            if (!f.onSurface(e.getX(),e.getY()) && f.isEditable()) {
                form = f;
                form.setDashed(false);
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
        if (form != null) { 
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
            if (!form.isCollision()){
                ResizeCommand command = new ResizeCommand(form, e.getX(), e.getY()); 
                command.executeCommand(); 
            }
            form.setDashed(false);
            form.setCollision(false);
        }
    }
}
