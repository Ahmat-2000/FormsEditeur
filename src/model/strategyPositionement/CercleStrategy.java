package model.strategyPositionement;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;

/**
 * Stratégie de positionnement spécifique pour les cercles.
 * Cette classe hérite de {@link AbstractStrategy} et implémente la méthode {@code createForm}
 * pour créer et positionner sur le frame des instances de {@link CercleModel}.
 */
public class CercleStrategy extends AbstractStrategy {

    /**
     * Constructeur pour la stratégie de positionnement des cercles.
     * Initialise la stratégie avec le nombre de formes à créer, les dimensions du conteneur
     * et le conteneur de formes lui-même.
     *
     * @param formNumber Le nombre de cercles à créer et à positionner.
     * @param w La largeur du conteneur dans lequel les cercles seront positionnés.
     * @param h La hauteur du conteneur dans lequel les cercles seront positionnés.
     * @param formContainer Le conteneur dans lequel les cercles créés seront stockés.
     */
    public CercleStrategy(int formNumber, int w, int h, FormContainer formContainer) {
        super(formNumber, w, h, formContainer);
    }

    /**
     * Crée une nouvelle instance de {@link CercleModel} à la position spécifiée.
     * La taille du cercle est déterminée par la largeur fixe définie dans {@link AbstractStrategy}.
     *
     * @param x La coordonnée horizontale où le cercle doit être créé.
     * @param y La coordonnée verticale où le cercle doit être créé.
     * @return Une nouvelle instance de {@link CercleModel} représentant le cercle créé à la position spécifiée.
     */
    @Override
    public AbstractForm createForm(int x, int y) {
        return new CercleModel(x, y, formWidth); // Crée un cercle avec la position et la taille spécifiées.
    }
    
}
