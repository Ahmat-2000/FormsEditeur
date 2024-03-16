package model;

import java.util.ArrayList;
import model.observerPattern.AbstractListenableModel;
import model.observerPattern.ModelListener;

/**
 * La classe {@code FormContainer} sert de conteneur pour stocker et gérer une collection de formes géométriques.<br/>
 * Elle étend {@code AbstractListenableModel} afin de pouvoir notifier les écouteurs de tout changement survenant dans le conteneur.<br/>
 * De plus, elle implémente {@code ModelListener} pour pouvoir réagir aux modifications des formes individuelles contenues.<br/>
 */
public class FormContainer extends AbstractListenableModel implements ModelListener {

    /** Liste principale contenant les formes géométriques. */
    private ArrayList<AbstractForm> mainContainerList;

    /**
     * Constructeur de {@code FormContainer}. Initialise la liste des formes.
     */
    public FormContainer() {
        super();
        this.mainContainerList = new ArrayList<>();
    }

    /**
     * Ajoute une forme au conteneur et s'inscrit comme écouteur des modifications de cette forme.
     * Notifie tous les écouteurs de {@code FormContainer} qu'une forme a été ajoutée.
     * 
     * @param f La forme à ajouter au conteneur.
     */
    public void addForm(AbstractForm f){
        f.addModelListener(this);
        this.mainContainerList.add(f);
        this.fireChange();
    }

    /**
     * Supprime une forme du conteneur si elle est modifiable. Notifie tous les écouteurs de {@code FormContainer}
     * qu'une forme a été supprimée.
     * 
     * @param f La forme à supprimer du conteneur.
     */
    public void removeForm(AbstractForm f){
        if (f.isEditable()) {
            this.mainContainerList.remove(f);
            this.fireChange();
        }
    }

    /**
     * Vide le conteneur de toutes ses formes, en supprimant chaque forme individuellement.
     */
    public void clearContainer(){
        ArrayList<AbstractForm> tmp = this.copyOfList();
        for (AbstractForm form : tmp) {
            this.removeForm(form);
        }
    }

    /**
     * Définit la nouvelle liste des formes pour le conteneur principal et notifie les écouteurs du changement.
     * 
     * @param l La nouvelle liste des formes à définir pour le conteneur.
     */
    public void setMainContainerList(ArrayList<AbstractForm> l) {
        this.mainContainerList = l; 
        this.fireChange(); 
    }

    /**
     * Crée et retourne une copie de la liste actuelle des formes dans le conteneur.
     * 
     * @return Une nouvelle {@code ArrayList} contenant toutes les formes du conteneur.
     */
    public ArrayList<AbstractForm> copyOfList() {
        return new ArrayList<>(this.mainContainerList);
    }

    /**
     * Récupère la liste actuelle des formes contenues dans le conteneur.
     * 
     * @return La liste actuelle des formes géométriques contenues dans {@code FormContainer}.
     */
    public ArrayList<AbstractForm> getMainContainerList() {
        return this.mainContainerList;
    }

    /**
     * Réagit aux changements signalés par une forme spécifique contenue dans le conteneur.
     * Cette méthode permet de notifier les écouteurs de {@code FormContainer} que l'un de ses éléments a changé.
     * 
     * @param source L'objet source du changement, typiquement une forme géométrique contenue dans le conteneur.
     */
    @Override
    public void somethingHasChanged(Object source) {
        this.fireChange(); 
    }
}
