package model.strategyPositionement;

import model.AbstractForm;
import model.FormContainer;
import model.RectangleModel;

public class RectStrategy extends AbstractStrategy{

    public RectStrategy(int formNumbe, int w, int h, FormContainer formContainer) {
        super(formNumbe, w, h, formContainer);
    }
    @Override
    public void posForm() {
        int randomX;
        int randomY;
        AbstractForm c;
        int i = 0;    
        while (i < formNumber) {
            int attempts = 0; // Compteur d'essais pour la forme actuelle
            boolean placed = false; // Indicateur si la forme a été placée avec succès
            boolean collision;
            while (!placed && attempts < maxAttempts) {
                randomX = this.random.nextInt(this.width - formWidth);
                randomY = this.random.nextInt(this.height - formHeight);
                c = new RectangleModel(randomX, randomY, formWidth, formHeight,"red");
                collision = false; // Réinitialisé pour chaque nouvelle position testée
    
                for (AbstractForm form : formContainer.getMainContainerList()) {
                    if (form.collusion(c)) {
                        collision = true;
                        break; // Sort de la boucle dès qu'une collision est détectée
                    }
                }
    
                if (!collision) {
                    formContainer.addFormToMainContainer(c);
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
    
}
