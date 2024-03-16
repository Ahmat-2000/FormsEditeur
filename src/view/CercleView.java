package view;

import java.awt.Color;
import java.awt.Graphics;

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
    public void dessiner(Graphics g) {
        g.setColor(new Color(0, 0, 26));
        g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
        if (forme.isEditable()) {
            g.drawOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
        } else{
            g.setColor(new Color(140, 192, 132));
            g.fillOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());  
        }
    }    
}
