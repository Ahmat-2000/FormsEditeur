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

public class Header extends JPanel{
    protected JButton cercle, rectangle, reset,remove,move,redo,undo,resize;
    public Header(ViewFormContainer viewContainer, FormContainer formContainer){
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.setLayout(new FlowLayout(FlowLayout.LEADING,5 ,10));
        cercle = this.createStyledButton("Cercle","images"+File.separator+"addCercle.png",new BtnController(viewContainer,new DrawCercleState(formContainer)));
        rectangle = this.createStyledButton("Rect","images"+File.separator+"addRect.png",new BtnController(viewContainer,new DrawRectState(formContainer)));
        move = this.createStyledButton("Move","images"+File.separator+"hand.png",new BtnController(viewContainer,new MoveState(formContainer)));
        remove = this.createStyledButton("Remove","images"+File.separator+"remove.png",new BtnController(viewContainer,new RemoveState(formContainer)));
        resize = this.createStyledButton("Resize","images"+File.separator+"resize.png",new BtnController(viewContainer,new ResizeState(formContainer)));
        undo = this.createStyledButton("Undo","images"+File.separator+"undo.png",new UndoBtnController());
        redo = this.createStyledButton("Redo","images"+File.separator+"redo.png",new RedoBtnController());
        reset = this.createStyledButton("Reset","images"+File.separator+"reset.png",new ResetBtnController(viewContainer,formContainer));

    }
    private JButton createStyledButton(String text, String fileName, ActionListener action) {
        ImageIcon Icon = new ImageIcon(fileName);
        Image img = Icon.getImage() ;  
        Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
        Icon = new ImageIcon( newimg );
        
        JButton button = new JButton(Icon);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false); // Remove the focus border
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
