package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * La classe Screen représente la fenêtre principale de l'application.
 */
public class Screen extends JFrame {
    
    /**
     * Constructeur de la classe Screen.
     * 
     * @param viewContainer Le conteneur de la vue principale de l'application.
     * @param header Le panneau d'en-tête de l'application.
     */
    public Screen(ViewFormContainer viewContainer, Header header) {
        setTitle("Projet annuel"); // Définit le titre de la fenêtre.
        setIconImage(new ImageIcon("images" + File.separator + "icon.png").getImage()); // Définit l'icône de la fenêtre.
        setSize(800, 800); // Définit la taille de la fenêtre.
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Définit le comportement par défaut lors de la fermeture de la fenêtre.
        setLayout(new BorderLayout()); // Définit un gestionnaire de disposition BorderLayout pour le contenu de la fenêtre.

        // Crée un JScrollPane avec le panneau d'en-tête, autorisant le défilement horizontal si nécessaire.
        JScrollPane scroll = new JScrollPane(header, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Récupère le panneau de contenu de la fenêtre et ajoute le JScrollPane en haut (nord) de la fenêtre.
        JPanel frame = (JPanel) this.getContentPane();
        frame.add(scroll, BorderLayout.NORTH);

        // Ajoute le conteneur de la vue principale au centre de la fenêtre.
        frame.add(viewContainer, BorderLayout.CENTER);
    }
}
