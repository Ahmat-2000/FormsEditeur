package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.BtnController;
import controller.RedoBtnController;
import controller.ResetBtnController;
import controller.UndoBtnController;
import model.FormContainer;
import view.state.DrawCercleState;
import view.state.DrawRectState;
import view.state.MoveState;
import view.state.RemoveState;
import view.state.ResizeState;

/**
 * La classe Header représente la barre d'en-tête de l'application.
 * Elle contient les boutons pour les différentes actions disponibles dans l'application.
 */
public class Header extends JPanel {
    protected JButton cercle, rectangle, reset, remove, move, redo, undo, resize;

    /**
     * Constructeur de la classe Header qui prend en paramètre le conteneur de vue et le conteneur de formes.
     * 
     * @param viewContainer Le conteneur de vue associé à l'application.
     * @param formContainer Le conteneur de formes où sont stockées les formes de l'application.
     */
    public Header(ViewFormContainer viewContainer, FormContainer formContainer) {
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Définit une bordure vide en bas de la barre d'en-tête.
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 10)); // Définit un gestionnaire de mise en page avec un alignement à gauche et un espacement horizontal de 5 et vertical de 10.

        // Crée et ajoute les boutons stylisés pour chaque action de l'application.
        cercle = this.createStyledButton("Cercle", "images" + File.separator + "addCercle.png", new BtnController(viewContainer, new DrawCercleState(formContainer)));
        rectangle = this.createStyledButton("Rect", "images" + File.separator + "addRect.png", new BtnController(viewContainer, new DrawRectState(formContainer)));
        move = this.createStyledButton("Move", "images" + File.separator + "hand.png", new BtnController(viewContainer, new MoveState(formContainer)));
        remove = this.createStyledButton("Remove", "images" + File.separator + "remove.png", new BtnController(viewContainer, new RemoveState(formContainer)));
        resize = this.createStyledButton("Resize", "images" + File.separator + "resize.png", new BtnController(viewContainer, new ResizeState(formContainer)));
        undo = this.createStyledButton("Undo", "images" + File.separator + "undo.png", new UndoBtnController());
        redo = this.createStyledButton("Redo", "images" + File.separator + "redo.png", new RedoBtnController());
        reset = this.createStyledButton("Reset", "images" + File.separator + "reset.png", new ResetBtnController(viewContainer, formContainer));
    }

    /**
     * Méthode privée permettant de créer un bouton stylisé pour une action donnée.
     * 
     * @param text Le texte affiché sur le bouton.
     * @param fileName Le nom du fichier d'image utilisé pour l'icône du bouton.
     * @param action L'action à effectuer lorsque le bouton est cliqué.
     * @return Le bouton créé et stylisé.
     */
    private JButton createStyledButton(String text, String fileName, ActionListener action) {
        // Crée une icône à partir du fichier d'image spécifié.
        ImageIcon icon = new ImageIcon(fileName);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);

        // Crée un bouton avec l'icône et le texte spécifiés.
        JButton button = new JButton(icon);
        button.setForeground(Color.BLACK); // Définit la couleur du texte du bouton.
        button.setFocusPainted(false); // Supprime la bordure de mise au point du bouton.
        button.setBackground(Color.WHITE); // Définit la couleur de fond du bouton.
        button.setPreferredSize(new Dimension(90, 40)); // Définit la taille préférée du bouton.
        button.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement dans le bouton.
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12)); // Définit la police de caractères du texte du bouton.
        button.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true), text)); // Définit une bordure de titre autour du bouton avec un texte et un style spécifiques.
        button.addActionListener(action); // Ajoute l'action spécifiée comme écouteur de clic sur le bouton.
        this.add(button); // Ajoute le bouton au panneau d'en-tête.
        return button; // Retourne le bouton créé.
    }
}
