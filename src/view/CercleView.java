package view;

import java.awt.Color;
import java.awt.Graphics;

import model.CercleModel;

/**
 * La classe CercleView est responsable de l'affichage graphique d'un cercle dans l'interface utilisateur.
 * Elle implémente l'interface IView pour définir la méthode de dessin.
 */
public class CercleView implements IView {
    private CercleModel cercleModel; // Le modèle de cercle associé à cette vue.

    /**
     * Constructeur de la classe CercleView qui prend en paramètre le modèle de cercle.
     * 
     * @param c Le modèle de cercle associé à cette vue.
     */
    public CercleView(CercleModel c) {
        this.cercleModel = c;
    }

    /**
     * Méthode permettant d'obtenir le modèle de cercle associé à cette vue.
     * 
     * @return Le modèle de cercle associé à cette vue.
     */
    public CercleModel getCercleModel() {
        return cercleModel;
    }

    /**
     * Méthode permettant de définir le modèle de cercle associé à cette vue.
     * 
     * @param cercleModel Le modèle de cercle à associer à cette vue.
     */
    public void setCercleModel(CercleModel cercleModel) {
        this.cercleModel = cercleModel;
    }

    /**
     * Méthode de dessin permettant d'afficher graphiquement le cercle.
     * 
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    @Override
    public void dessiner(Graphics g) {
        g.setColor(Color.RED); // Définit la couleur de dessin en rouge.
        g.drawRect(cercleModel.getX(), cercleModel.getY(), cercleModel.getWidth(), cercleModel.getWidth()); // Dessine un rectangle autour du cercle.
        g.setColor(Color.BLACK); // Réinitialise la couleur de dessin en noir.
        g.drawOval(cercleModel.getX(), cercleModel.getY(), cercleModel.getWidth(), cercleModel.getWidth()); // Dessine le cercle.
        // g.fillOval(cercleModel.getX(), cercleModel.getY(), cercleModel.getRayon(), cercleModel.getRayon());  // Dessine le cercle rempli (non utilisé ici).
    }    
}
