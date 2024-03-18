package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;
import model.commandPattern.CreateCommand;

/**
 * La classe DrawCercleState représente l'état de dessin d'un cercle dans l'application.
 * Elle réagit aux événements de souris pour créer et dessiner un cercle.
 */
public class DrawCercleState extends MouseAdapter {
    /** Le conteneur des formes où ajouter le cercle. */
    private FormContainer formesContainer; 
    /** Les coordonnées de la souris pour le début et la fin du dessin.*/
    private int centerX, centerY;
    /** Le cercle en cours de dessin. */
    private CercleModel cercle; 
    /** Permet de savoir si la souris est glissée */
    private boolean dragged = false;

    /**
     * Constructeur de DrawCercleState qui prend en paramètre le conteneur des formes.
     * 
     * @param formesContainer Le conteneur des formes où ajouter le cercle.
     */
    public DrawCercleState(FormContainer formesContainer) {
        this.formesContainer = formesContainer;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant.
     * Crée un nouveau cercle avec le point de départ du dessin.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        centerX = e.getX();
        centerY = e.getY();
        cercle = new CercleModel(centerX,centerY, 0);
        cercle.setEditable(true);
        cercle.setDashed(true);
        this.formesContainer.addForm(cercle);
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant et que la souris est ensuite déplacée.
     * Redimensionne le cercle en fonction de la position actuelle de la souris pour afficher le dessin en cours.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        int radius = cercle.computeDistance(centerX, centerY, e.getX(), e.getY());
        int baseX = centerX - radius;
        int baseY = centerY - radius; 
        if (baseX > 0 && baseY > 0 && baseX + 2*radius < e.getComponent().getWidth() && baseY + 2*radius < e.getComponent().getHeight()) {
            cercle.setX(baseX); cercle.setY(baseY);
            cercle.setWidth(2*radius);
            dragged = true;
        }
    }
    
    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le dessin du cercle et l'ajoute au conteneur des formes si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean colision = false; 
        
        // Vérifie si le cercle est valide et s'il n'y a pas de collision avec d'autres formes.
        if (cercle != null) {
            for (AbstractForm fo : this.formesContainer.getMainContainerList()) {
                if (fo != cercle && cercle.collision(fo)) {
                    this.formesContainer.removeForm(cercle);
                    colision = true;
                    break; 
                }  
            }
            // Vérifie les conditions pour ajouter le cercle au conteneur des formes.
            if (dragged && !colision && cercle.computeDistance(cercle.getX(), cercle.getY(), e.getX(), e.getY()) >= 20) {
                CreateCommand command = new CreateCommand(cercle, formesContainer); 
                command.executeCommand(); 
            }
        }
        cercle.setDashed(false);
        dragged = false;
    }
}
