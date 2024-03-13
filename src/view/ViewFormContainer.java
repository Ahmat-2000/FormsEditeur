package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;
import model.RectangleModel;
import model.observerPattern.ModelListener;

/**
 * La classe ViewFormContainer représente le conteneur de la vue principale de l'application.
 */
public class ViewFormContainer extends JPanel implements ModelListener {
    private MouseAdapter state = null; // Le gestionnaire d'état actuel pour interagir avec les formes.
    private FormContainer formesContainer; // Le conteneur de formes.

    /**
     * Constructeur de la classe ViewFormContainer.
     * 
     * @param formesContainer Le conteneur de formes à afficher.
     */
    public ViewFormContainer(FormContainer formesContainer) {
        this.formesContainer = formesContainer; // Initialise le conteneur de formes.
        this.formesContainer.addModelListener(this); // Ajoute cette instance comme écouteur du conteneur de formes.
        this.setLayout(null); // Définit un layout null pour ce panneau.
    }

    /**
     * Méthode pour obtenir le gestionnaire d'état actuel.
     * 
     * @return Le gestionnaire d'état actuel.
     */
    public MouseAdapter getState() {
        return state;
    }

    /**
     * Méthode pour définir le gestionnaire d'état actuel.
     * 
     * @param state Le gestionnaire d'état à définir.
     */
    public void setState(MouseAdapter state) {
        this.state = state;
    }

    /**
     * Méthode pour ajouter les écouteurs d'événements à ce panneau.
     * 
     * @param m Le gestionnaire d'événements à ajouter.
     */
    public void addListeners(MouseAdapter m) {
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
    }

    /**
     * Méthode pour supprimer les écouteurs d'événements de ce panneau.
     * 
     * @param m Le gestionnaire d'événements à supprimer.
     */
    public void removeListeners(MouseAdapter m) {
        this.removeMouseListener(m);
        this.removeMouseMotionListener(m);
        this.removeMouseWheelListener(m);
    }

    @Override
    /**
     * Méthode appelée lorsqu'un changement est observé dans le modèle de données.
     * Elle redessine et revalide ce panneau.
     */
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }

    @Override
    /**
     * Méthode de rendu graphique de ce panneau.
     * Elle dessine toutes les formes contenues dans le conteneur de formes sur ce panneau.
     * 
     * @param g Le contexte graphique sur lequel dessiner.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Appelle la méthode paintComponent de la classe parente.
        for (AbstractForm forme : formesContainer.getMainContainerList()) { // Pour chaque forme dans le conteneur de formes.
            IView c = null; // Initialise la vue de la forme.
            if (forme instanceof CercleModel) { // Si la forme est un cercle.
                c = new CercleView((CercleModel) forme); // Initialise la vue du cercle.
            } else { // Sinon, si la forme est un rectangle.
                c = new RectangleView((RectangleModel) forme); // Initialise la vue du rectangle.
            }
            c.dessiner(g); // Dessine la forme sur le contexte graphique.
        }
    }
}
