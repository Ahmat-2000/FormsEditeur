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
    private int x, y;
    /**  Le rectangle en cours de dessin.*/
    private RectangleModel rectangle; 
    /** Permet de savoir si la souris est glissée */
    private boolean dragged = false;

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
        rectangle = null; 
        x = e.getX();
        y = e.getY();
        rectangle = new RectangleModel(x,y, 0,0);
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
        int width = Math.abs(x -  e.getX()); 
        int height = Math.abs(y -  e.getY()); 
        rectangle.setWidth(width); 
        rectangle.setHeight(height); 
        dragged = true;
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
        if(rectangle != null) {
            this.formContainer.removeForm(rectangle);
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != rectangle && rectangle.collision(fo)) {
                    colision = true;
                    break; 
                }  
            }
            // Vérifie les conditions pour ajouter le rectangle au conteneur des formes.
            if(dragged && !colision  && rectangle.computeDistance(x, y, e.getX(), e.getY()) >= 20 ) {
                CreateCommand command = new CreateCommand(rectangle, formContainer); 
                command.executeCommand(); 
            }
        }
        dragged = false;
    }
}
