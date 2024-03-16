package view;

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
}
