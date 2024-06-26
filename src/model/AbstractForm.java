package model;

import model.observerPattern.AbstractListenableModel;

/**
 * Classe abstraite représentant une forme géométrique de base. Cette classe est écoutable et peut notifier
 * des écouteurs de changements grâce à l'héritage d'AbstractListenableModel. Elle implémente  IForm
 * pour définir des comportements spécifiques aux formes géométriques.
 */
public abstract class AbstractForm extends AbstractListenableModel implements IForm {
    
    /** La position x de la forme. */
    protected int x;
    
    /** La position y de la forme. */
    protected int y;
    
    /** La largeur de la forme. */
    protected int width;
    
    /** La hauteur de la forme. */
    protected int height;
    
    /** Indicateur permettant de savoir si la forme est modifiable. */
    protected boolean editable = false;

    /** Indicateur permettant de savoir si la forme est en création */
    protected boolean dashed = false;

    /** Indicateur permettant de savoir si la forme est en collision */
    protected boolean collision = false;
    /** Indicateur permettant de savoir si la forme est en mode resize */
    protected boolean showResize = false;
    
    
    /**
     * Constructeur d'AbstractForm.
     * 
     * @param x La position x initiale de la forme.
     * @param y La position y initiale de la forme.
     * @param width La largeur initiale de la forme.
     * @param height La hauteur initiale de la forme.
     */
    public AbstractForm(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /**
     * Vérifie si un point donné est sur la surface de la forme.
     * 
     * @param x La position x du point à vérifier.
     * @param y La position y du point à vérifier.
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
        this.x += deltaX;
        this.y += deltaY;
        this.fireChange(); 
    }

    /**
     * Vérifie s'il y a une collision entre cette forme et une autre forme spécifiée.
     * 
     * @param f L'autre forme à vérifier pour une collision.
     * @return  true si une collision est détectée, sinon  false.
     */
    @Override
    public boolean collision(AbstractForm f) {
        return this.x + this.width >= f.getX() && this.x <= f.getX() + f.getWidth() &&
               this.y + this.height >= f.getY() && this.y <= f.getY() + f.getHeight();
    }

    /**
     * Calcule la distance entre deux points spécifiés.
     * 
     * @param x1 La position x du premier point.
     * @param y1 La position y du premier point.
     * @param x2 La position x du deuxième point.
     * @param y2 La position y du deuxième point.
     * @return La distance entre les deux points.
     */
    public int computeDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    /**
     * Récupère la position x de la forme.
     * 
     * @return La position x de la forme.
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère la position y de la forme.
     * 
     * @return La position y de la forme.
     */
    public int getY() {
        return y;
    }

    /**
     * Récupère la largeur de la forme.
     * 
     * @return La largeur de la forme.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Définit la largeur de la forme et notifie les écouteurs du changement.
     * 
     * @param width La nouvelle largeur de la forme.
     */
    public void setWidth(int width) {
        this.width = width;
        this.fireChange();
    }

    /**
     * Récupère la hauteur de la forme.
     * 
     * @return La hauteur de la forme.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Définit la hauteur de la forme et notifie les écouteurs du changement.
     * 
     * @param height La nouvelle hauteur de la forme.
     */
    public void setHeight(int height) {
        this.height = height;
        this.fireChange(); 
    }

    /**
     * Vérifie si la forme est modifiable.
     * 
     * @return true si la forme est modifiable, sinon  false.
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Définit si la forme doit être modifiable ou non.
     * 
     * @param editable  true} pour rendre la forme modifiable, sinon  false}.
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Méthode abstraite pour obtenir le nom de la forme.
     * Chaque forme concrète doit implémenter cette méthode.
     * 
     * @return Le nom de la forme.
     */
    @Override
    public abstract String getName();

    /**
     * Méthode abstraite pour redimensionner la forme.
     * Chaque forme concrète doit implémenter cette méthode.
     * 
     * @param x Le nouveau x pour le redimensionnement.
     * @param y Le nouveau y pour le redimensionnement.
     */
    @Override
    public abstract void resize(int x, int y);
    
    /**
     * Modifie la valeur de x.
     * 
     * @param x La valeur de x.
     */
    @Override
    public void setX(int x){
        this.x = x;
        this.fireChange();
    }

    /**
     * Modifie la valeur de y.
     * 
     * @param y La valeur de y.
     */
    public void setY(int y){
        this.y = y;
        this.fireChange();
    }
    public boolean isDashed() {
        return dashed;
    }
    public void setDashed(boolean dashed) {
        this.dashed = dashed;
        this.fireChange();
    }

    public boolean isCollision() {
        return collision;
    }
    public void setCollision(boolean collision) {
        this.collision = collision;
        this.fireChange();
    }
    public boolean isShowResize() {
        return showResize;
    }
    public void setShowResize(boolean showResize) {
        this.showResize = showResize;
        this.fireChange();
    }
}
