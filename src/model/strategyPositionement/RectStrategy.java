package model.strategyPositionement;

import model.AbstractForm;
import model.FormContainer;
import model.RectangleModel;

/**
 * Stratégie de positionnement spécifique pour les rectangles.
 * Cette classe étend {@link AbstractStrategy} et concrétise la méthode {@code createForm}
 * pour créer et positionner des instances de {@link RectangleModel}.
 */
public class RectStrategy extends AbstractStrategy {

    /**
     * Constructeur pour la stratégie de positionnement des rectangles.
     * Initialise la stratégie avec le nombre de formes à créer, les dimensions du conteneur
     * et le conteneur de formes lui-même.
     *
     * @param formNumber Le nombre de rectangles à créer et à positionner.
     * @param w La largeur du conteneur dans lequel les rectangles seront positionnés.
     * @param h La hauteur du conteneur dans lequel les rectangles seront positionnés.
     * @param formContainer Le conteneur dans lequel les rectangles créés seront stockés.
     */
    public RectStrategy(int formNumber, int w, int h, FormContainer formContainer) {
        super(formNumber, w, h, formContainer);
    }

    /**
     * Crée une nouvelle instance de {@link RectangleModel} à la position spécifiée.
     * Les dimensions du rectangle sont déterminées par les valeurs fixées dans {@link AbstractStrategy}
     * pour la largeur et la hauteur des formes.
     *
     * @param x La coordonnée horizontale où le rectangle doit être créé.
     * @param y La coordonnée verticale où le rectangle doit être créé.
     * @return Une nouvelle instance de {@link RectangleModel} représentant le rectangle créé à la position spécifiée.
     */
    @Override
    public AbstractForm createForm(int x, int y) {
        return new RectangleModel(x, y, formWidth, formHeight); // Crée un rectangle avec les positions et dimensions spécifiées.
    }
}
