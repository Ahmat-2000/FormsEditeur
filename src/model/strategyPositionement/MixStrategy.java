package model.strategyPositionement;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;
import model.RectangleModel;

/**
 * Stratégie de positionnement mixte pour les formes géométriques.
 * Cette classe hérite de {@link AbstractStrategy} et implémente la méthode {@code createForm}
 * pour créer et positionner aléatoirement des instances de {@link RectangleModel} ou de {@link CercleModel}.
 */
public class MixStrategy extends AbstractStrategy {

    /**
     * Constructeur pour la stratégie de positionnement mixte.
     * Initialise la stratégie avec le nombre de formes à créer, les dimensions du conteneur
     * et le conteneur de formes lui-même.
     *
     * @param formNumber Le nombre de formes (rectangles et cercles) à créer et à positionner.
     * @param w La largeur du conteneur dans lequel les formes seront positionnées.
     * @param h La hauteur du conteneur dans lequel les formes seront positionnées.
     * @param formContainer Le conteneur dans lequel les formes créées seront stockées.
     */
    public MixStrategy(int formNumber, int w, int h, FormContainer formContainer) {
        super(formNumber, w, h, formContainer);
    }

    /**
     * Crée une nouvelle forme à la position spécifiée, choisissant aléatoirement entre un rectangle
     * et un cercle. La décision est prise à l'aide d'un nombre aléatoire.
     *
     * @param x La coordonnée horizontale où la forme doit être créée.
     * @param y La coordonnée verticale où la forme doit être créée.
     * @return Une instance de {@link AbstractForm} représentant la forme nouvellement créée à la position spécifiée,
     * soit un {@link RectangleModel} soit un {@link CercleModel}, en fonction du tirage aléatoire.
     */
    @Override
    public AbstractForm createForm(int x, int y) {
        int rand = this.random.nextInt(3); 
        // Crée un rectangle si le nombre aléatoire est 0.
        if (rand == 0) {
            return new RectangleModel(x, y, formWidth, formHeight);
        } else { // Crée un cercle sinon
            return new CercleModel(x, y, formWidth);
        }
    }
    
}
