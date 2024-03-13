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
    private FormContainer formContainer; // Le conteneur des formes où se trouve la forme à redimensionner.
    private int width, height; // Les dimensions initiales de la forme avant redimensionnement.
    private AbstractForm form; // La forme en cours de redimensionnement.

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
            if (f.onSurface(e.getX(), e.getY())) { // Vérifie si la souris est sur une forme.
                form = f; // Stocke la forme sous la souris.
                this.width = f.getWidth(); // Stocke les dimensions initiales de la forme.
                this.height = f.getHeight();
                break;
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
        if (form != null) { // Si une forme est en cours de redimensionnement.
            form.resize(e.getX(), e.getY()); // Redimensionne la forme en fonction de la position actuelle de la souris.
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
        boolean collision = false; // Indicateur de collision avec d'autres formes.
        if (form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collusion(fo)) { // Vérifie la collision avec chaque autre forme.
                    form.setWidth(width); // Reviens aux dimensions initiales de la forme.
                    form.setHeight(height);
                    collision = true;
                    break; // Quitte la boucle dès qu'une collision est détectée.
                }  
            }
        }
        if (form != null && !collision) { // Si la forme n'a pas de collision avec d'autres formes.
            form.setWidth(width); // Reviens aux dimensions initiales de la forme.
            form.setHeight(height);
            ResizeCommand command = new ResizeCommand(form, e.getX(), e.getY()); // Crée la commande de redimensionnement.
            command.executeCommand(); // Exécute la commande pour redimensionner la forme à la nouvelle taille.
        }
    }
}
