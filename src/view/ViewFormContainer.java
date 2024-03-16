package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import model.AbstractForm;
import model.FormContainer;
import model.observerPattern.ModelListener;
import view.factory.AbstractViewFactory;

/**
 * La classe ViewFormContainer représente le conteneur de la vue principale de l'application.
 */
public class ViewFormContainer extends JPanel implements ModelListener {
    /** Le gestionnaire d'état actuel pour interagir avec les formes.*/
    private MouseAdapter state = null; 
    /**  Le conteneur de formes.*/
    private FormContainer formesContainer; 
    /** L'usine de fabrication de vues. */
    private AbstractViewFactory viewFactory;

    /**
     * Constructeur de la classe ViewFormContainer.
     * 
     * @param formesContainer Le conteneur de formes à afficher.
     * @param viewFactory L'usine de fabrication de vues.
     */
    public ViewFormContainer(FormContainer formesContainer, AbstractViewFactory viewFactory) {
        this.formesContainer = formesContainer; 
        this.viewFactory = viewFactory;
        this.formesContainer.addModelListener(this); 
        this.setLayout(null);
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
        super.paintComponent(g); 
        for (AbstractForm forme : formesContainer.getMainContainerList()) {
            IView c = viewFactory.getInstance(forme); 
            if (c != null) {
                c.dessiner(g);
            }
        }
    }
}
