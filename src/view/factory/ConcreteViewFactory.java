package view.factory;

import model.CercleModel;
import model.IForm;
import model.RectangleModel;
import view.CercleView;
import view.IView;
import view.RectangleView;

/**
 * La classe ConcreteViewFactory est une implémentation concrète de l'usine abstraite abstractFactory.
 * Elle crée des instances de vues (IView) spécifiques aux types de formes (IForm).
 */
public class ConcreteViewFactory extends abstractFactory {

    /**
     * Méthode héritée pour créer une nouvelle instance de vue en fonction du type de forme spécifié.
     * 
     * @param form La forme pour laquelle créer une nouvelle instance de vue.
     * @return Une nouvelle instance de vue associée à la forme spécifiée.
     */
    protected IView newInstance(IForm form) {
        String name = form.getName(); // Obtient le nom de la forme.

        // Sélectionne le type de vue à créer en fonction du nom de la forme.
        switch (name) {
            case "cercle":
                return new CercleView((CercleModel) form); // Crée une vue pour un cercle.
            case "rectangle":
                return new RectangleView((RectangleModel) form); // Crée une vue pour un rectangle.
            default:
                return null; // Retourne null si le type de forme n'est pas reconnu.
        }
    }
}
