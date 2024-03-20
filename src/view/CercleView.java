package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.CercleModel;

/**
 * La classe CercleView est responsable de l'affichage graphique d'un cercle dans l'interface utilisateur.
 * Elle implémente l'interface IView pour définir la méthode de dessin.
 */
public class CercleView extends AbstractFormView {

    /**
     * Constructeur de la classe CercleView qui prend en paramètre le modèle de cercle.
     * 
     * @param c Le modèle de cercle associé à cette vue.
     */
    public CercleView(CercleModel c) {
        super(c);
    }

    /**
     * Méthode de dessin permettant d'afficher graphiquement le cercle.
     * 
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    @Override
    public void dessiner(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics.create(); // Create a Graphics2D object from g

        float[] dashPattern = {5, 5}; // Define the dash pattern (10 pixels filled, 10 pixels empty)
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0);

        g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
        if (forme.isEditable() ) {
            g.setColor(new Color(0, 0, 26));
            if (forme.isDashed()) {
                g.setStroke(dashed); // Set the stroke of the Graphics2D object to the dashed pattern
            }
            if(forme.isCollision()) {
                g.setColor(Color.RED);
            }
            g.drawOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
            g.fillOval(forme.getWidth()/2 + forme.getX(), forme.getWidth()/2 + forme.getY(), 2, 2);
        } else{
            g.setColor(new Color(140, 192, 132));
            g.fillOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());  
        }
    }    
}
