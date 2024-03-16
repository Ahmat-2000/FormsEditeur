package model.strategyPositionement;

import java.util.Random;

import model.AbstractForm;
import model.FormContainer;

public abstract class AbstractStrategy implements IStrategy{
    protected int formNumber;
    protected Random random;
    protected FormContainer formContainer;
    protected int width, height;
    protected final int formWidth = 160;
    protected final int formHeight = 150;
    protected final int maxAttempts = 1000; // Limite le nombre d'essais pour placer une forme

    public AbstractStrategy(int formNumber, int w, int h){
        this.formNumber = formNumber;
        random = new Random();
        width = w;
        height = h;
    }
    public AbstractStrategy(int formNumbe,int w, int h, FormContainer formContainer){
        this(formNumbe, w, h);
        this.formContainer = formContainer;
    }
    public int getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(int formNumber) {
        this.formNumber = formNumber;
    }

    public Random getRandom() {
        return random;
    }
    public void posForm() {
        int randomX,randomY,attempts;
        AbstractForm c;
        boolean collision,placed;
        int i = 0;    
        while (i < formNumber) {
            attempts = 0; // Compteur d'essais pour la forme actuelle
            placed = false; // Indicateur si la forme a été placée avec succès
            while (!placed && attempts < maxAttempts) {
                randomX = this.random.nextInt(this.width - formWidth);
                randomY = this.random.nextInt(this.height - formWidth);
                c = creatForm(randomX, randomY);
                collision = false; // Réinitialisé pour chaque nouvelle position testée
                for (AbstractForm form : formContainer.getMainContainerList()) {
                    if (form.collusion(c)) {
                        collision = true;
                        break; // Sort de la boucle dès qu'une collision est détectée
                    }
                }
                if (!collision) {
                    formContainer.addForm(c);
                    placed = true; // Marque la forme comme placée avec succès
                    i++; // Incrémente seulement si une forme est placée avec succès
                } else {
                    attempts++; // Incrémente le compteur d'essais si une collision est détectée
                }
            }
            if (attempts >= maxAttempts) {
                System.out.println("Impossible de placer la forme après " + maxAttempts + " essais.");
                break; // Sort de la boucle principale si trop d'essais ont échoué
            }
        }
    }
    @Override
    public abstract AbstractForm creatForm(int x,int y);
}
