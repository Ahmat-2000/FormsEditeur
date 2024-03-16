package view;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * La classe Screen représente la fenêtre principale de l'application.
 */
public class Screen extends JFrame {
    
    /**
     * Constructeur de la classe Screen. Il initialise la fenêtre principale avec un titre, une icône, 
     * une taille fixe, un emplacement centralisé, un comportement à la fermeture, et ajoute les composants d'interface utilisateur.
     * 
     * @param viewContainer Le conteneur principal qui gère la vue de l'application.
     * @param header Le panneau d'en-tête contenant les boutons et contrôles de l'application.
     */
    public Screen(ViewFormContainer viewContainer, Header header){
        // Définit le titre de la fenêtre
        setTitle("Projet annuel");

        // Charge et redimensionne une icône à partir des ressources pour l'utiliser comme icône de la fenêtre
        ImageIcon Icon = new ImageIcon(getClass().getResource("/images/icon.png"));
        Image newimg = Icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);  
        Icon = new ImageIcon(newimg);
        setIconImage(Icon.getImage());

        // Définit la taille de la fenêtre et la rend non redimensionnable
        setSize(800, 800);
        setResizable(false);

        // Centre la fenêtre sur l'écran
        setLocationRelativeTo(null);

        // Définit le comportement de la fenêtre lorsqu'on la ferme (terminer l'application)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définit le gestionnaire de disposition de la fenêtre à BorderLayout
        setLayout(new BorderLayout());

        // Crée un JScrollPane qui contiendra le panneau d'en-tête, sans barre de défilement verticale
        // et avec une barre de défilement horizontale selon les besoins
        JScrollPane scroll = new JScrollPane(header, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Récupère le panneau de contenu de la fenêtre et y ajoute le JScrollPane en haut (nord) de la fenêtre
        JPanel frame = (JPanel) this.getContentPane();
        frame.add(scroll, BorderLayout.NORTH);

        // Ajoute le conteneur de la vue principale (viewContainer) au centre de la fenêtre
        frame.add(viewContainer, BorderLayout.CENTER);
    }
}

