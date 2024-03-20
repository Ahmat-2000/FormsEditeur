package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

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
    public void dessiner(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics.create();

        float[] dashPattern = {5, 5}; 
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0);

        if (forme.isEditable() ) {
            g.setColor(new Color(0, 0, 26));
            if (forme.isDashed()) {
                g.setStroke(dashed); 
            }
            if(forme.isCollision()) {
                g.setColor(Color.RED);
            }
            g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getHeight());  
        }else{
            g.setColor(new Color(140, 192, 132));
            g.fillRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getHeight());
        }
    }
    
}
