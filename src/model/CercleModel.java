package model;


/**
 * CercleModel est une classe qui étend AbstractForm pour représenter spécifiquement un cercle.
 * Elle hérite des propriétés et méthodes de AbstractForm pour manipuler les cercles, y compris le déplacement,
 * le redimensionnement, et la notification des écouteurs en cas de modifications.
 */
public class CercleModel extends AbstractForm {

    /**
     * Constructeur de CercleModel qui définit un cercle avec un diamètre et une couleur spécifiés.
     * 
     * @param x La position x du centre du cercle.
     * @param y La position y du centre du cercle.
     * @param diameter Le diamètre du cercle.
     */
    public CercleModel(int x, int y, int diameter) {
        super(x, y, diameter, diameter);
    }

    /**
     * Constructeur de CercleModel qui définit un cercle basé sur deux points. Ce cercle est initialisé
     * avec un diamètre calculé comme la distance entre ces deux points.
     * 
     * @param x1 La position x du premier point.
     * @param y1 La position y du premier point.
     * @param x2 La position x du second point.
     * @param y2 La position y du second point.
     */
    public CercleModel(int x1, int y1, int x2, int y2) {
        this(x1, y1, 0);
        this.width = 2*this.computeDistance(x1, y1, x2, y2);
        this.height = width;
    }

    /**
     * Définit la largeur (et la hauteur, étant donné que pour un cercle elles sont identiques) du cercle.
     * Ceci entraîne la notification des écouteurs du changement.
     * 
     * @param width La nouvelle largeur du cercle.
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; 
        this.fireChange();
    }

    /**
     * Retourne le nom de la forme, dans ce cas "cercle".
     * 
     * @return Le nom de la forme.
     */
    @Override
    public String getName() {
        return "cercle";
    }

    /**
     * Redimensionne le cercle basé sur un nouveau point. La largeur (et la hauteur) est ajustée
     * en fonction de la distance entre le centre du cercle et ce nouveau point.
     * 
     * @param x La position x du point pour le redimensionnement.
     * @param y La position y du point pour le redimensionnement.
     */
    @Override
    public void resize(int x, int y) {
        this.width = Math.abs(this.x - x); 
        this.height = this.width;
        this.fireChange();
    }
}
