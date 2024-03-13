package view;

import java.awt.Color;
import java.awt.Graphics;

import model.RectangleModel;

/**
 * La classe RectangleView est une implémentation de l'interface IView pour dessiner un rectangle.
 */
public class RectangleView implements IView {
    private RectangleModel rectangleModel;

    /**
     * Constructeur de la classe RectangleView.
     * 
     * @param r Le modèle de rectangle associé à cette vue.
     */
    public RectangleView(RectangleModel r) {
        this.rectangleModel = r;
    }
    
    @Override
    /**
     * Méthode de dessin du rectangle sur un contexte graphique spécifié.
     * 
     * @param g Le contexte graphique sur lequel dessiner le rectangle.
     */
    public void dessiner(Graphics g) {
        g.setColor(Color.BLACK); // Définit la couleur du trait du rectangle en noir.
        g.drawRect(rectangleModel.getX(), rectangleModel.getY(), rectangleModel.getWidth(), rectangleModel.getHeight()); // Dessine un rectangle vide aux coordonnées spécifiées avec la largeur et la hauteur spécifiées.
        // g.fillRect(rectangleModel.getX(), rectangleModel.getY(), rectangleModel.getWith(), rectangleModel.getHeight()); // (Optionnel) Dessine un rectangle plein aux coordonnées spécifiées avec la largeur et la hauteur spécifiées.
    }
}
