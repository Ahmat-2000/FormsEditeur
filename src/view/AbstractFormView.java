package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.AbstractForm;

/**
 * Classe abstraite définissant une vue pour un modèle de forme géométrique.
 * Cette classe implémente l'interface {@code IView}, ce qui nécessite la mise en œuvre
 * d'une méthode de dessin, et fournit une base pour associer un modèle de forme à une vue.
 */
public abstract class AbstractFormView implements IView {
    /**
     * Le modèle de forme géométrique associé à cette vue.
     */
    protected AbstractForm forme;

    /**
     * Constructeur pour créer une vue associée à un modèle de forme spécifique.
     *
     * @param forme Le modèle de forme géométrique à associer à cette vue.
     */
    public AbstractFormView(AbstractForm forme) {
        this.forme = forme;
    }

    /**
     * Définit ou met à jour le modèle de forme géométrique associé à cette vue.
     * Cette méthode permet de changer la forme associée à la vue après sa création initiale.
     *
     * @param f Le nouveau modèle de forme géométrique à associer à cette vue.
     */
    @Override
    public void setForm(AbstractForm f) {
        this.forme = f;
    }
    
    /**
     * Modifie l'objet graphics
     * 
     * @param graphics L'objet Graphics utilisé pour dessiner.
     */
    public Graphics2D getStyleGraphics(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics.create(); 

        float[] dashPattern = {5, 5}; 
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashPattern, 0);

        if (forme.isEditable() ) {
            g.setColor(Color.BLACK);
            if (forme.isDashed()) {
                g.setStroke(dashed); 
            }
            if (forme.isShowResize()) {
                g.setColor(new Color(63,165,243));
                g.fillOval(forme.getWidth() + forme.getX() - 5 , forme.getHeight() + forme.getY() - 5, 10, 10);
            }
            if(forme.isCollision()) {
                g.setColor(Color.RED);
            }
        } else{
            g.setColor(new Color(140, 192, 132));
        }
        return g;
    }    
}
