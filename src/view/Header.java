package view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.BtnController;
import controller.ResetBtnController;
import view.state.DrawCercleState;
import view.state.DrawRectState;
import view.state.MoveState;
import view.state.RemoveState;

public class Header extends JPanel{
    protected JButton cercle, rectangle, reset,remove,move;
    public Header(ViewFormContainer viewContainer){
        this.setBorder(BorderFactory.createLineBorder(new Color(89, 88, 87)));
        this.setLayout(new FlowLayout(FlowLayout.CENTER,80 ,10));

        cercle = this.createStyledButton("Cercle", "images/addCercle.png",new BtnController(viewContainer,new DrawCercleState(viewContainer)));
        rectangle = this.createStyledButton("Rect", "images/addRect.png",new BtnController(viewContainer,new DrawRectState(viewContainer)));
        move = this.createStyledButton("Move", "images/hand.png",new BtnController(viewContainer,new MoveState(viewContainer)));
        remove = this.createStyledButton("Remove", "images/remove.png",new BtnController(viewContainer,new RemoveState(viewContainer)));
        reset = this.createStyledButton("Reset", "images/annuler.png",new ResetBtnController(viewContainer));
    }
    private JButton createStyledButton(String text, String fileName, ActionListener action) {
        ImageIcon Icon = new ImageIcon(fileName);
        Image img = Icon.getImage() ;  
        Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
        Icon = new ImageIcon( newimg );
        
        JButton button = new JButton(text,Icon);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false); // Remove the focus border
        button.setBackground(Color.WHITE);
        button.setIconTextGap(5);
        Border padding = new EmptyBorder(2,1,2,4);
        Border margin = new EmptyBorder(0,0,0,0);
        Border compound = new CompoundBorder(padding, margin);
        button.setBorder(compound);
        button.addActionListener(action);
        this.add(button);
        return button;
    }
}
