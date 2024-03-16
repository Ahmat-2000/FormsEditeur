package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

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
 * La classe {@code Header} étend {@code JPanel} pour créer un panneau personnalisé contenant divers boutons de contrôle.
 * Elle inclut des boutons pour dessiner des formes telles que des cercles et des rectangles, ainsi que des boutons pour des actions telles que déplacer, supprimer, redimensionner, annuler, rétablir et réinitialiser.
 */
public class Header extends JPanel {

    /** Bouton pour dessiner des cercles. */
    protected JButton cercle;

    /** Bouton pour dessiner des rectangles. */
    protected JButton rectangle;

    /** Bouton pour réinitialiser le dessin. */
    protected JButton reset;

    /** Bouton pour supprimer une forme sélectionnée. */
    protected JButton remove;

    /** Bouton pour déplacer une forme. */
    protected JButton move;

    /** Bouton pour rétablir une action annulée. */
    protected JButton redo;

    /** Bouton pour annuler la dernière action. */
    protected JButton undo;

    /** Bouton pour redimensionner une forme. */
    protected JButton resize;

    /**
     * Construit un panneau {@code Header} avec des contrôles spécifiques pour dessiner et manipuler des formes.
     * 
     * @param viewContainer   Le conteneur responsable de l'aspect vue dans l'architecture MVC.
     * @param formContainer   Le conteneur qui détient l'aspect modèle, spécifiquement les formes et leurs propriétés.
     */
    public Header(ViewFormContainer viewContainer, FormContainer formContainer){
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.setLayout(new FlowLayout(FlowLayout.LEADING,5 ,10));
        cercle = this.createStyledButton("Cercle","/images/addCercle.png",new BtnController(viewContainer,new DrawCercleState(formContainer)));
        rectangle = this.createStyledButton("Rect","/images/addRect.png",new BtnController(viewContainer,new DrawRectState(formContainer)));
        move = this.createStyledButton("Move","/images/hand.png",new BtnController(viewContainer,new MoveState(formContainer)));
        remove = this.createStyledButton("Remove","/images/remove.png",new BtnController(viewContainer,new RemoveState(formContainer)));
        resize = this.createStyledButton("Resize","/images/resize.png",new BtnController(viewContainer,new ResizeState(formContainer)));
        undo = this.createStyledButton("Undo","/images/undo.png",new UndoBtnController());
        redo = this.createStyledButton("Redo","/images/redo.png",new RedoBtnController());
        reset = this.createStyledButton("Reset","/images/reset.png",new ResetBtnController(viewContainer,formContainer));

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
        ImageIcon Icon = new ImageIcon(getClass().getResource(fileName));
        Image img = Icon.getImage() ;  
        Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
        Icon = new ImageIcon( newimg );
        
        JButton button = new JButton(Icon);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false); // Supprime la bordure de mise au point du bouton.
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(90,40));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        button.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE,1, true), text));
        button.addActionListener(action);
        this.add(button);
        return button;
    }
}
