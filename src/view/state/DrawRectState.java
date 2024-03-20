package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private int initialX, initialY;
    /**  Le rectangle en cours de dessin.*/
    private RectangleModel rectangle; 
    /** Permet de savoir si la souris est glissée */
    // private boolean dragged = false;

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
        initialX = e.getX();
        initialY = e.getY();
        rectangle = new RectangleModel(initialX,initialY, 0,0);
        rectangle.setEditable(true);
        rectangle.setDashed(true);
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
        int width = Math.abs(initialX -  e.getX()); 
        int height = Math.abs(initialY -  e.getY()); 
        if (rectangle.getX() > 0 && rectangle.getY() > 0 && width + rectangle.getX() < e.getComponent().getWidth() && height + rectangle.getY() < e.getComponent().getHeight()) {
            rectangle.setWidth(width); 
            rectangle.setHeight(height); 
            this.formContainer.collisionDetection(rectangle);
        }
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est relâché sur un composant.
     * Finalise le dessin du rectangle et l'ajoute au conteneur des formes si les conditions sont remplies.
     * 
     * @param e L'événement de souris associé.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(rectangle != null) {
            this.formContainer.removeForm(rectangle);
            // On ajoute le rectangle au conteneur des formes si son width est >= 10. et qu'il n'y a pas des collisions
            if(!rectangle.isCollision() && rectangle.getHeight() >= 10 && rectangle.getWidth() >= 10 ) {
                CreateCommand command = new CreateCommand(rectangle, formContainer); 
                command.executeCommand();
            }
        }
        rectangle.setDashed(false);
    }
}
