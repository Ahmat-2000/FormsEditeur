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
    private FormContainer formContainer; // Le conteneur des formes où se trouve la forme à déplacer.
    private int startX, startY, endX, endY; // Les coordonnées de départ et d'arrivée du déplacement.
    private AbstractForm form; // La forme en cours de déplacement.

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
            if (f.onSurface(e.getX(), e.getY())) { // Vérifie si la souris est sur une forme.
                form = f; // Stocke la forme sous la souris.
                startX = form.getX(); // Stocke la position de départ du déplacement.
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
        endX = e.getX(); // Met à jour la position actuelle de la souris.
        endY = e.getY();
        if (form != null) { // Si une forme est en cours de déplacement.
            form.moveForm(endX, endY); // Déplace la forme à la nouvelle position de la souris.
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
        boolean collision = false; // Indicateur de collision avec d'autres formes.
        if (form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collusion(fo)) { // Vérifie la collision avec chaque autre forme.
                    form.moveForm(startX, startY); // Reviens à la position de départ du déplacement.
                    collision = true;
                    break; // Quitte la boucle dès qu'une collision est détectée.
                }  
            }
        }
        if (form != null && !collision) { // Si la forme n'a pas de collision avec d'autres formes.
            form.moveForm(startX, startY); // Reviens à la position de départ du déplacement.
            MoveCommand command = new MoveCommand(form, endX, endY); // Crée la commande de déplacement.
            command.executeCommand(); // Exécute la commande pour déplacer la forme à la nouvelle position.
        }
    }
}
