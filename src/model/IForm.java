package model;

/**
 * L'interface IForm définit les méthodes communes que toutes les formes géométriques doivent implémenter.
 */
public interface IForm {
    /**
     * Vérifie si un point se trouve sur la surface de la forme.
     * 
     * @param x La position x du point.
     * @param y La position y du point.
     * @return true si le point est sur la surface de la forme, sinon false.
     */
    public boolean onSurface(int x, int y);

    /**
     * Déplace la forme selon les valeurs spécifiées pour le décalage en x et en y.
     * 
     * @param deltaX La valeur du décalage en x.
     * @param deltaY La valeur du décalage en y.
     */
    public void moveForm(int deltaX, int deltaY);

    /**
     * Déplace la forme horizontalement selon la valeur spécifiée pour le décalage en x.
     * 
     * @param deltaX La valeur du décalage en x.
     */
    public void moveFormX(int deltaX);

    /**
     * Déplace la forme verticalement selon la valeur spécifiée pour le décalage en y.
     * 
     * @param deltaY La valeur du décalage en y.
     */
    public void moveFormY(int deltaY);

    /**
     * Redimensionne la forme en fonction des coordonnées spécifiées.
     * 
     * @param x La position x de la coordonnée pour le redimensionnement.
     * @param y La position y de la coordonnée pour le redimensionnement.
     */
    public void resize(int x, int y);

    /**
     * Récupère le nom de la forme.
     * 
     * @return Le nom de la forme.
     */
    public String getName();

    /**
     * Vérifie s'il y a une collision entre cette forme et une autre.
     * 
     * @param f L'autre forme avec laquelle vérifier la collision.
     * @return true si une collision est détectée, sinon false.
     */
    public boolean collusion(AbstractForm f);
}
