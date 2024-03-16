package view.factory;

import java.util.HashMap;
import java.util.Map;

import model.AbstractForm;
import view.IView;

/**
 * La classe AbstractViewFactory est une usine abstraite pour créer des instances de vues (IView) en fonction du type de forme (IForm).
 * Les sous-classes de cette classe doivent fournir une implémentation de la méthode newInstance() pour créer de nouvelles instances de vue.
 */
public abstract class AbstractViewFactory {
    private final Map<String , IView> map = new HashMap<>(); // Map pour stocker les vues créées.

    /**
     * Méthode abstraite à implémenter par les sous-classes pour créer de nouvelles instances de vue.
     * 
     * @param form La forme pour laquelle créer une nouvelle instance de vue.
     * @return Une nouvelle instance de vue associée à la forme spécifiée.
     */
    public abstract IView newInstance(AbstractForm form);

    /**
     * Obtient une instance de vue pour une forme spécifique. Si une instance existe déjà pour cette forme,
     * elle est récupérée à partir de la map. Sinon, une nouvelle instance est créée en appelant newInstance(),
     * puis ajoutée à la map pour une utilisation ultérieure.
     * 
     * @param form La forme pour laquelle obtenir une instance de vue.
     * @return Une instance de vue associée à la forme spécifiée.
     */
    public IView getInstance(AbstractForm form) {
        IView instance = map.get(form.getName()); // Récupère une instance de vue associée à la forme.
        if (instance == null) { 
            instance = newInstance(form); 
            map.put(form.getName(), instance);
        } else{
            instance.setForm(form);
        }
        return instance; // Renvoie l'instance de vue associée à la forme.
    }
}
