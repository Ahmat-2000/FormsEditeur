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
    private int x1, x2, y1, y2;
    /** Le cercle en cours de dessin. */
    private CercleModel cercle; 

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
        x1 = e.getX();
        y1 = e.getY();
        cercle = new CercleModel(x1,y1, 0);
        cercle.setEditable(true);
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
        x2 = e.getX();
        y2 = e.getY();
        int diameter = cercle.computeDistance(x1, y1, x2, y2); 
        cercle.setWidth(diameter); 
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le dessin du cercle et l'ajoute au conteneur des formes si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean colision = false; // Indicateur de collision avec d'autres formes.
        
        // Vérifie si le cercle est valide et s'il n'y a pas de collision avec d'autres formes.
        if (cercle != null) {
            this.formesContainer.removeForm(cercle);
            for (AbstractForm fo : this.formesContainer.getMainContainerList()) {
                if (fo != cercle && cercle.collision(fo)) {
                    colision = true;
                    break; // Quitte la boucle dès qu'une collision est détectée.
                }  
            }
        }

        // Vérifie les conditions pour ajouter le cercle au conteneur des formes.
        if (cercle != null && !colision && cercle.computeDistance(x1, y1, e.getX(), e.getY()) >= 20) {
            CreateCommand command = new CreateCommand(cercle, formesContainer); 
            command.executeCommand(); 
        }
    }
}
