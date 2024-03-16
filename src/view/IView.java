package view;

import java.awt.Graphics;

import model.AbstractForm;

/**
 * Interface définissant la capacité d'une vue à être dessinée graphiquement.
 * Les classes implémentant cette interface sont tenues de fournir une implémentation
 * de la méthode {@code dessiner}, permettant de rendre visuellement l'élément sur un contexte graphique.
 */
public interface IView {
    /**
     * Dessine l'élément graphique sur un contexte graphique fourni.
     * Cette méthode est appelée pour rendre l'élément dans l'environnement graphique de l'application,
     * en utilisant les fonctionnalités de dessin fournies par l'objet {@link Graphics}.
     *
     * @param g Le contexte graphique ({@link Graphics}) sur lequel l'élément doit être dessiné.
     *          Cela peut inclure le dessin de formes, le remplissage de zones, la gestion des couleurs et des polices, etc.
     */
    public void dessiner(Graphics g);

    /**
     * Définit ou met à jour le modèle de forme géométrique associé à cette vue.
     * Cette méthode permet de changer la forme associée à la vue après sa création initiale.
     *
     * @param f Le nouveau modèle de forme géométrique à associer à cette vue.
     */
    public void setForm(AbstractForm f);

}
