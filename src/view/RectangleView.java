package view;

import java.awt.Graphics;

import model.RectangleModel;

/**
 * La classe RectangleView est une implémentation de l'interface IView pour dessiner un rectangle.
 */
public class RectangleView extends AbstractFormView{
    /**
     * Constructeur de la classe RectangleView.
     * 
     * @param r Le modèle de rectangle associé à cette vue.
     */
    public RectangleView(RectangleModel r) {
        super(r);
    }

    @Override
    /**
     * Méthode de dessin du rectangle sur un contexte graphique spécifié.
     * 
     * @param g Le contexte graphique sur lequel dessiner le rectangle.
     */
    public void dessiner(Graphics g) {
        g = this.getStyleGraphics(g);
        if (forme.isEditable() ) {
            g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getHeight());  
        }else{
            g.fillRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getHeight());
        }
    }
    
}
