package view;

import model.FormContainer;
import model.strategyPositionement.AbstractStrategy;
import model.strategyPositionement.MixStrategy;
import view.factory.AbstractViewFactory;
import view.factory.ConcreteViewFactory;

/**
 * Classe principale de l'application graphique.
 * Initialise l'environnement de l'application, crée et affiche la fenêtre principale,
 * et applique une stratégie de positionnement des formes dans un conteneur.
 */
public class Main {
    /**
     * Point d'entrée principal de l'application.
     * Configure le conteneur de formes, la vue associée, l'en-tête et la fenêtre principale.
     * Applique ensuite une stratégie de positionnement mixte pour placer des formes dans le conteneur.
     * 
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // Crée un conteneur pour stocker et gérer les formes géométriques.
        FormContainer formesContainer = new FormContainer();
        
        AbstractViewFactory viewFactory = new ConcreteViewFactory();

        // Initialise la vue du conteneur, responsable de dessiner les formes contenues.
        ViewFormContainer viewContainer = new ViewFormContainer(formesContainer,viewFactory);
        
        // Crée un en-tête pour l'interface utilisateur, contenant des contrôles ou informations.
        Header header = new Header(viewContainer, formesContainer);
        
        // Configure et affiche la fenêtre principale de l'application avec les composants créés.
        Screen window = new Screen(viewContainer, header);
        // Rend la fenêtre visible à l'utilisateur.
        window.setVisible(true); 
        
        // Applique une stratégie de positionnement mixte pour placer aléatoirement des formes.
        AbstractStrategy mix = new MixStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        // Positionne les formes dans le conteneur en utilisant la stratégie.
        mix.posForm();

        // AbstractStrategy strategy = new RectStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        // strategy.posForm();

        // AbstractStrategy s2 = new CercleStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        // s2.posForm();
    }
}
