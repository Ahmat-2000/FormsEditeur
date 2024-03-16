package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.RectangleModel;
import model.commandPattern.CreateCommand;

/**
 * La classe DrawRectState représente l'état de dessin d'un rectangle dans l'application.
 * Elle réagit aux événements de souris pour créer et dessiner un rectangle.
 */
public class DrawRectState extends MouseAdapter {
    /** Le conteneur des formes où ajouter le cercle. */
    private FormContainer formContainer; 
    /** Les coordonnées de la souris pour le début et la fin du dessin.*/
    private int x1, x2, y1, y2;
    /**  Le rectangle en cours de dessin.*/
    private RectangleModel rectangle; 

    /**
     * Constructeur de DrawRectState qui prend en paramètre le conteneur des formes.
     * 
     * @param formContainer Le conteneur des formes où ajouter le rectangle.
     */
    public DrawRectState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant.
     * Crée un nouveau rectangle avec le point de départ du dessin.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        rectangle = new RectangleModel(x1,y1, 0,0);
        rectangle.setEditable(true);
        this.formContainer.addForm(rectangle);
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est pressé sur un composant et que la souris est ensuite déplacée.
     * Redimensionne le rectangle en fonction de la position actuelle de la souris pour afficher le dessin en cours.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        int width = Math.abs(x1 - x2); 
        int height = Math.abs(y1 - y2); 
        rectangle.setWidth(width); 
        rectangle.setHeight(height); 
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le dessin du rectangle et l'ajoute au conteneur des formes si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean colision = false; 
        // Vérifie si le rectangle est valide et s'il n'y a pas de collision avec d'autres formes.
        if (rectangle != null) {
            this.formContainer.removeForm(rectangle);
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != rectangle && rectangle.collision(fo)) {
                    colision = true;
                    break; 
                }  
            }
        }
        // Vérifie les conditions pour ajouter le rectangle au conteneur des formes.
        if (rectangle != null && !colision && rectangle.computeDistance(x1, y1, e.getX(), e.getY()) >= 20) {
            CreateCommand command = new CreateCommand(rectangle, formContainer); 
            command.executeCommand(); 
        }
        rectangle = null; 
    }
}
