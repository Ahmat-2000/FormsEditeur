/*
 * Cette interface définit le contrat pour les vues qui sont capables de se dessiner graphiquement.
 * Toutes les classes implémentant cette interface doivent fournir une méthode pour dessiner sur un contexte graphique (Graphics).
 */
package view;

import java.awt.Graphics;

public interface IView {
    /**
     * Méthode permettant de dessiner l'élément graphique sur un contexte graphique spécifié.
     * 
     * @param g Le contexte graphique sur lequel l'élément graphique doit être dessiné.
     */
    public void dessiner(Graphics g);
}
