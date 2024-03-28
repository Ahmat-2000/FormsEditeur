package view;

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
        g = this.getStyleGraphics(g);
        if (forme.isEditable()) {
            g.drawOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
            g.fillOval(forme.getWidth()/2 + forme.getX(), forme.getWidth()/2 + forme.getY(), 2, 2);
            if (forme.isShowResize() || forme.isCollision()) {
                g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
            }
        }else{
            // g.drawRect(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());
            g.fillOval(forme.getX(),forme.getY(),forme.getWidth(),forme.getWidth());  
        }

    }    
    
}
