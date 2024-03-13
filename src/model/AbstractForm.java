package model;

import java.awt.Color;
import model.observerPattern.AbstractListenableModel;

/**
 * Classe abstraite représentant une forme géométrique de base. Cette classe est écoutable et peut notifier
 * des écouteurs de changements grâce à l'héritage de AbstractListenableModel. Elle implémente IForm
 * pour définir des comportements spécifiques aux formes.
 */
public abstract class AbstractForm extends AbstractListenableModel implements IForm {
    protected int x, y, width, height; // Coordonnées et dimensions de la forme
    protected Color color; // Couleur de la forme

    /**
     * Constructeur de la classe AbstractForm.
     * 
     * @param x La position x de la forme.
     * @param y La position y de la forme.
     * @param width La largeur de la forme.
     * @param height La hauteur de la forme.
     * @param color La couleur de la forme.
     */
    public AbstractForm(int x, int y, int width, int height, Color color) {
        super(); // Initialise les écouteurs
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Déplace la forme en modifiant sa position en x.
     * 
     * @param deltaX La nouvelle position x de la forme.
     */
    @Override
    public void moveFormX(int deltaX) {
        this.x = deltaX;
        this.fireChange(); // Notifie les écouteurs du changement
    }

    /**
     * Déplace la forme en modifiant sa position en y.
     * 
     * @param deltaY La nouvelle position y de la forme.
     */
    @Override
    public void moveFormY(int deltaY) {
        this.y = deltaY;
        this.fireChange(); // Notifie les écouteurs du changement
    }

    /**
     * Vérifie si un point est sur la surface de la forme.
     * 
     * @param x La position x du point.
     * @param y La position y du point.
     * @return true si le point est sur la forme, sinon false.
     */
    @Override
    public boolean onSurface(int x, int y) {
        return x >= this.x && y >= this.y && x <= this.x + this.width && y <= this.y + this.height;
    }

    /**
     * Déplace la forme en modifiant ses positions en x et y.
     * 
     * @param deltaX La nouvelle position x de la forme.
     * @param deltaY La nouvelle position y de la forme.
     */
    @Override
    public void moveForm(int deltaX, int deltaY) {
        this.x = deltaX;
        this.y = deltaY;
        this.fireChange(); // Notifie les écouteurs du changement
    }

    /**
     * Vérifie s'il y a une collision entre cette forme et une autre.
     * 
     * @param f L'autre forme avec laquelle vérifier la collision.
     * @return true si une collision est détectée, sinon false.
     */
    @Override
    public boolean collusion(AbstractForm f) {
        if (this.x + this.width >= f.getX() && this.x <= f.getX() + f.getWidth() &&
            this.y + this.height >= f.getY() && this.y <= f.getY() + f.getHeight()) {
            return true;
        }
        return false;
    }

    /**
     * Calcule la distance entre deux points.
     * 
     * @param x1 La position x du premier point.
     * @param y1 La position y du premier point.
     * @param x2 La position x du second point.
     * @param y2 La position y du second point.
     * @return La distance calculée.
     */
    public int computeDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    // Getters et setters pour x, y, width, et height, avec notification des écouteurs
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
        this.fireChange();
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
        this.fireChange();
    }
   public abstract String getName();
   public abstract void resize(int x, int y);
}