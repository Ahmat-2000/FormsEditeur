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
    private FormContainer formesContainer; // Le conteneur des formes où ajouter le cercle.
    private int x1, x2, y1, y2; // Les coordonnées de la souris pour le début et la fin du dessin.
    private CercleModel cercle; // Le cercle en cours de dessin.

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
        cercle = new CercleModel(x1, y1, 0); // Crée un nouveau cercle avec un rayon initial de 0.
        this.formesContainer.addFormToMainContainer(cercle); // Ajoute le cercle au conteneur des formes.
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
        int diameter = cercle.computeDistance(x1, y1, x2, y2); // Calcule le diamètre du cercle.
        cercle.setWidth(diameter); // Redimensionne le cercle en fonction du diamètre calculé.
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
            this.formesContainer.removeFormFromMainContainer(cercle); // Supprime temporairement le cercle du conteneur.

            // Vérifie s'il y a une collision entre le cercle et d'autres formes.
            for (AbstractForm fo : this.formesContainer.getMainContainerList()) {
                if (fo != cercle && cercle.collusion(fo)) { // Vérifie la collision avec chaque forme différente du cercle.
                    colision = true;
                    break; // Quitte la boucle dès qu'une collision est détectée.
                }  
            }
        }

        // Vérifie les conditions pour ajouter le cercle au conteneur des formes.
        if (cercle != null && !colision && cercle.computeDistance(x1, y1, e.getX(), e.getY()) >= 20) {
            CreateCommand command = new CreateCommand(cercle, formesContainer); // Crée une commande pour ajouter le cercle.
            command.executeCommand(); // Exécute la commande pour ajouter le cercle au conteneur.
        }
    }
}
