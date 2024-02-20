package view;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CercleBtnController;
import controller.ClearBtnController;
import controller.RectangleBtnController;

public class Header extends JPanel{
    protected JButton cercle, rectangle, clear;
    public Header(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.CENTER,40 ,10));

        ImageIcon addIcon = new ImageIcon("deplacer20.png");
        cercle = new JButton("Create Cercle",addIcon);
        cercle.setFocusPainted(false);
        rectangle = new JButton("Create Rectangle");
        clear = new JButton("Clear");
        clear.addActionListener(new ClearBtnController());
        cercle.addActionListener(new CercleBtnController());
        rectangle.addActionListener(new RectangleBtnController());
        this.add(cercle);
        this.add(rectangle);
        this.add(clear);
    }
}
