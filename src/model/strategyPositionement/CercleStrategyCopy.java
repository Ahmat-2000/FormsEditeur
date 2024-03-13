package model.strategyPositionement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;

@SuppressWarnings("unused")
public class CercleStrategyCopy extends AbstractStrategy{
    private int diameter;

    public CercleStrategyCopy(int formNumbe, int w, int h, FormContainer formContainer) {
        super(formNumbe, w, h, formContainer);
        diameter = 200;
    }
    public AbstractForm createForm(String name, int x, int y, int width, int height) throws Exception{
        // Obtient l'objet Class pour CercleModel
        Class<?> clazz = Class.forName(name); // Utilisez le nom complet, y compris le package si nécessaire
        // Obtient le constructeur spécifique qui prend trois paramètres int
        Constructor<?> constructor = clazz.getConstructor(int.class, int.class, int.class);
        // Crée une nouvelle instance de CercleModel en utilisant le constructeur avec des valeurs spécifiques
        Object instance = constructor.newInstance(10, 20, 30); // Remplacez 10, 20, 30 par les valeurs souhaitées
        // Cast l'objet en CercleModel si nécessaire
        return (CercleModel) instance;
    }
    public void posFormLogic() throws Exception{
        int randomX;
        int randomY;
        AbstractForm c;
        int i = 0;    
        while (i < formNumber) {
            int attempts = 0; // Compteur d'essais pour la forme actuelle
            boolean placed = false; // Indicateur si la forme a été placée avec succès
            boolean collision;
            while (!placed && attempts < maxAttempts) {
                randomX = this.random.nextInt(this.width - diameter);
                randomY = this.random.nextInt(this.height - diameter);
                c = createForm("CercleModel",randomX, randomY, diameter,diameter);
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
                randomX = this.random.nextInt(this.width - diameter);
                randomY = this.random.nextInt(this.height - diameter);
                c = new CercleModel(randomX, randomY, diameter);
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
    
    
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
