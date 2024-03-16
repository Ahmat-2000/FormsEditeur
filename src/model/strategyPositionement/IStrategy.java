package model.strategyPositionement;

import model.AbstractForm;

/**
 * Interface définissant la stratégie de création des formes.
 * Cette interface spécifie une méthode pour créer une nouvelle forme à une position donnée.
 */
public interface IStrategy {
    /**
     * Crée une nouvelle forme à la position spécifiée.
     * Cette méthode est destinée à être implémentée par des classes concrètes qui définissent
     * la manière spécifique dont une forme doit être créée et positionnée dans un conteneur
     * ou un espace de dessin.
     *
     * @param x La coordonnée horizontale où la forme doit être créée.
     * @param y La coordonnée verticale où la forme doit être créée.
     * @return Une instance de {@link AbstractForm} représentant la forme nouvellement créée à la position spécifiée.
     */
    public AbstractForm createForm(int x, int y);
}
