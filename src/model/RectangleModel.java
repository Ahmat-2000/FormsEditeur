package model;

/**
 * La classe RectangleModel étend AbstractForm pour représenter un modèle de rectangle.
 * Elle hérite des fonctionnalités de manipulation de formes de base définies dans AbstractForm.
 */
public class RectangleModel extends AbstractForm {
    
    /**
     * Constructeur de RectangleModel pour créer un rectangle avec une couleur spécifiée.
     * 
     * @param x La position x du coin supérieur gauche du rectangle.
     * @param y La position y du coin supérieur gauche du rectangle.
     * @param width La largeur du rectangle.
     * @param height La hauteur du rectangle.
     */
    public RectangleModel(int x, int y, int width, int height) {
        super(x, y, width, height); 
    }

    /**
     * Retourne le nom de la forme, dans ce cas "rectangle".
     * 
     * @return Le nom de la forme.
     */
    @Override
    public String getName(){
        return "rectangle";
    }

    /**
     * Redimensionne le rectangle en fonction des nouvelles coordonnées.
     * Les nouvelles dimensions sont calculées à partir des coordonnées du coin supérieur gauche
     * et du coin inférieur droit.
     * 
     * @param x La position x du coin inférieur droit du rectangle.
     * @param y La position y du coin inférieur droit du rectangle.
     */
    @Override
    public void resize(int x, int y){
        this.width  = Math.abs(this.x - x);
        this.height = Math.abs(this.y - y);
        this.fireChange(); 
    }
}
