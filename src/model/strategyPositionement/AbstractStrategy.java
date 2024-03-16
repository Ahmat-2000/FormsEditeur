package model.strategyPositionement;

import java.util.Random;

import model.AbstractForm;
import model.FormContainer;

/**
 * Classe abstraite définissant le cadre pour les stratégies de positionnement des formes.
 * Cette classe fournit une structure commune pour placer un certain nombre de formes dans un conteneur
 * en évitant les collisions, en utilisant une approche aléatoire pour déterminer les positions.
 */
public abstract class AbstractStrategy implements IStrategy{
    /** Nombre de formes à positionner dans le conteneur.*/
    protected int formNumber;
    /** Générateur de nombres aléatoires pour déterminer les positions des formes. */
    protected Random random;
    /** Référence au conteneur dans lequel les formes doivent être placées.*/
    protected FormContainer formContainer;
    /** Largeur de l'espace disponible pour le positionnement des formes.*/
    protected int width;
    /** Hauteur de l'espace disponible pour le positionnement des formes.*/
    protected int height;
    /** Largeur fixe attribuée à chaque forme. Utilisée pour vérifier les collisions et positionner correctement les formes.*/
    protected final int formWidth = 160;
    /** Hauteur fixe attribuée à chaque forme. Utilisée pour vérifier les collisions et positionner correctement les formes. */
    protected final int formHeight = 150;
    /** Nombre maximal d'essais pour placer une forme avant d'abandonner, afin d'éviter une boucle infinie si l'espace est trop encombré.*/
    protected final int maxAttempts = 1000;
    
    /**
     * Constructeur pour initialiser une stratégie de positionnement avec les dimensions du conteneur.
     *
     * @param formNumber Le nombre de formes à placer.
     * @param w Largeur du conteneur.
     * @param h Hauteur du conteneur.
     */
    public AbstractStrategy(int formNumber, int w, int h) {
        this.formNumber = formNumber;
        random = new Random();
        width = w;
        height = h;
    }

    /**
     * Constructeur pour initialiser une stratégie de positionnement avec un conteneur de formes.
     *
     * @param formNumber Le nombre de formes à placer.
     * @param w Largeur du conteneur.
     * @param h Hauteur du conteneur.
     * @param formContainer Le conteneur dans lequel les formes seront placées.
     */
    public AbstractStrategy(int formNumber, int w, int h, FormContainer formContainer) {
        this(formNumber, w, h);
        this.formContainer = formContainer;
    }

    /**
     * Renvoie le nombre de formes à placer.
     *
     * @return Le nombre de formes.
     */
    public int getFormNumber() {
        return formNumber;
    }

    /**
     * Définit le nombre de formes à placer.
     *
     * @param formNumber Le nouveau nombre de formes.
     */
    public void setFormNumber(int formNumber) {
        this.formNumber = formNumber;
    }

    /**
     * Renvoie le générateur de nombres aléatoires utilisé pour le positionnement des formes.
     *
     * @return Le générateur de nombres aléatoires.
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Méthode pour positionner les formes dans le conteneur en évitant les collisions.
     * Tente de placer chaque forme dans une position aléatoire et vérifie les collisions avec les formes existantes.
     * Si une collision est détectée ou si le nombre maximal d'essais est atteint, la méthode arrête de tenter de placer d'autres formes.
     */
    
    public void posForm() {
        int randomX, randomY, attempts;
        AbstractForm c;
        boolean collision, placed;
        int i = 0;
        while (i < formNumber) {
            attempts = 0; // Compteur d'essais pour la forme actuelle.
            placed = false; // Indicateur si la forme a été placée avec succès.
            while (!placed && attempts < maxAttempts) {
                randomX = this.random.nextInt(this.width - formWidth);
                randomY = this.random.nextInt(this.height - formHeight);
                c = createForm(randomX, randomY); // Méthode abstraite pour créer une forme.
                collision = false; // Réinitialisé pour chaque nouvelle position testée.
                for (AbstractForm form : formContainer.getMainContainerList()) {
                    if (form.collision(c)) {
                        collision = true;
                        break; // Sort de la boucle dès qu'une collision est détectée.
                    }
                }
                if (!collision) {
                    formContainer.addForm(c);
                    placed = true; // Marque la forme comme placée avec succès.
                    i++; // Incrémente seulement si une forme est placée avec succès.
                } else {
                    attempts++; // Incrémente le compteur d'essais si une collision est détectée.
                }
            }
            if (attempts >= maxAttempts) {
                System.out.println("Impossible de placer la forme après " + maxAttempts + " essais.");
                break; // Sort de la boucle principale si trop d'essais ont échoué.
            }
        }
    }

    /**
     * Méthode abstraite pour créer une forme spécifique. Doit être implémentée par les sous-classes.
     *
     * @param x La position horizontale où la forme doit être créée.
     * @param y La position verticale où la forme doit être créée.
     * @return L'instance de la forme créée.
     */
    @Override
    public abstract AbstractForm createForm(int x, int y);
}
    