package model;

import java.util.ArrayList;
import model.observerPattern.AbstractListenableModel;
import model.observerPattern.ModelListener;

/**
 * FormContainer sert de conteneur pour stocker et gérer un ensemble de formes géométriques.
 * Il étend AbstractListenableModel pour pouvoir notifier les écouteurs de tout changement dans le conteneur,
 * et implémente ModelListener pour réagir aux changements dans les formes individuelles qu'il contient.
 */
public class FormContainer extends AbstractListenableModel implements ModelListener {
    private ArrayList<AbstractForm> mainContainerList; // La liste principale des formes stockées.

    /**
     * Constructeur de FormContainer. Initialise la liste des formes.
     */
    public FormContainer() {
        super(); // Appelle le constructeur de la superclasse pour initialiser les écouteurs.
        this.mainContainerList = new ArrayList<>();
    }

    /**
     * Ajoute une forme au conteneur principal et s'abonne aux notifications de changement pour cette forme.
     * 
     * @param f La forme à ajouter au conteneur.
     */
    public void addFormToMainContainer(AbstractForm f) {
        f.addModelListener(this); // S'abonne aux changements de la forme.
        this.mainContainerList.add(f); // Ajoute la forme à la liste.
        this.fireChange(); // Notifie les écouteurs du changement dans le conteneur.
    }

    /**
     * Supprime une forme du conteneur principal.
     * 
     * @param f La forme à supprimer.
     */
    public void removeFormFromMainContainer(IForm f) {
        this.mainContainerList.remove(f); // Supprime la forme de la liste.
        this.fireChange(); // Notifie les écouteurs du changement.
    }

    /**
     * Vide le conteneur principal de toutes ses formes.
     */
    public void clearMainContainer() {
        this.mainContainerList.clear(); // Vide la liste des formes.
        this.fireChange(); // Notifie les écouteurs du changement.
    }

    /**
     * Définit la liste des formes du conteneur principal.
     * 
     * @param l La nouvelle liste des formes.
     */
    public void setMainContainerList(ArrayList<AbstractForm> l) {
        this.mainContainerList = l; // Remplace la liste actuelle par la nouvelle liste.
        this.fireChange(); // Notifie les écouteurs du changement.
    }

    /**
     * Crée et retourne une copie de la liste des formes du conteneur.
     * 
     * @return Une copie de la liste des formes.
     */
    public ArrayList<AbstractForm> copyOfList() {
        ArrayList<AbstractForm> f = new ArrayList<>();
        this.mainContainerList.forEach(el -> f.add(el)); // Copie chaque élément dans une nouvelle liste.
        return f;
    }

    /**
     * Récupère la liste actuelle des formes dans le conteneur.
     * 
     * @return La liste des formes.
     */
    public ArrayList<AbstractForm> getMainContainerList() {
        return this.mainContainerList;
    }

    /**
     * Réagit aux changements dans n'importe quelle forme du conteneur en notifiant à son tour les écouteurs
     * du conteneur de ces changements.
     * 
     * @param source L'objet source du changement.
     */
    @Override
    public void somethingHasChanged(Object source) {
        this.fireChange(); // Notifie les écouteurs du changement dans le conteneur.
    }
}
